package Actions;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Q3_MouseActions extends TestBase {
    @Test
    public void test() throws InterruptedException {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"))).perform();
        Thread.sleep(2000);

        //3- Link 1" e tiklayin
        actions.click(driver.findElement(By.xpath("(//*[text()='Link 1'])[1]"))).perform();

        //4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.xpath("//div[@id='click-box']"))).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//div[@id='click-box']")).getText());

        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//div[@id='double-click']"))).perform();
    }
}
