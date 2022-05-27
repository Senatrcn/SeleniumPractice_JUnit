package IFrame_WindowHandle;

import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Q4 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        Thread.sleep(3000);

        //2."Login Portal" a kadar asagi inin
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement loginPortalElement = driver.findElement(By.id("login-portal"));
        executor.executeScript("arguments[0].scrollIntoView(true);",loginPortalElement);
        Thread.sleep(3000);

        //3."Login Portal" a tiklayin
        String anasayfaWH = driver.getWindowHandle();
        loginPortalElement.click();

        //4.Diger window'a gecin
        Set<String> handles = driver.getWindowHandles();
        String loginWH = "";
        for (String each:handles){
            if (!each.equals(anasayfaWH)){
                loginWH = each;
            }
        }
        driver.switchTo().window(loginWH);

        //5."username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(faker.harryPotter().character());
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(faker.internet().password());

        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPopUpText = "validation failed";
        String actualPopUpText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedPopUpText,actualPopUpText);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(loginWH);

        //10.Ilk sayfaya donuldugunu test edin
        String actualWH = driver.getWindowHandle();
        Assert.assertEquals(loginWH,actualWH);
    }
}
