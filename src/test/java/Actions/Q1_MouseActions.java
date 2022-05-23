package Actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Q1_MouseActions extends TestBase {
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //test edelim.
        Actions actions = new Actions(driver);

        actions.contextClick(driver.findElement(By.xpath("//div[@id='hot-spot']"))).perform();
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWH = driver.getWindowHandle();
        actions.click(driver.findElement(By.xpath("//a[@target='_blank']"))).perform();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String ikinciSayfaWH="";
        for (String handles: driver.getWindowHandles()){
            if (!handles.equals(ilkSayfaWH)){
                ikinciSayfaWH = handles;
            }
        }
        driver.switchTo().window(ikinciSayfaWH);
        String actualH = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals("Elemental Selenium",actualH);
    }
}
