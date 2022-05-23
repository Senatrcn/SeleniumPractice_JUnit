package Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class Q2_DragAndDrop extends TestBase {
    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(By.cssSelector("#draggable")),driver.findElement(By.xpath("(//div[@id='droppable'])[1]"))).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("(//div[@id='droppable'])[1]")).getText());
    }
}
