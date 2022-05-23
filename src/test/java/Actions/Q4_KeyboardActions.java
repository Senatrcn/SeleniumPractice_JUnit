package Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Q4_KeyboardActions extends TestBase {
    @Test
    public void test(){
        //1- Bir Class olusturalim KeyboardActions1
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak
        //samsung A71 yazdirin ve Enter’a basarak arama
        //yaptirin
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).perform();
        actions.sendKeys("A71")
                .sendKeys(Keys.ENTER)
                .perform();

        //4- aramanin gerceklestigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='\"A71\"']")).isDisplayed());
    }
}
