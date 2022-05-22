package Assertions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Q1 extends TestBase {

    @Test
    public void test01(){
        //        1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //        2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id]")).click();

        //        3. Login alanine “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //        4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");

        //        5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        driver.navigate().back();

        //        6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();

        //        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("1004");

        //        8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.cssSelector("input[id='sp_date']")).sendKeys("2020-09-10");

        //        9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@value='Pay']")).click();

        //        10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement odemeBasariliYazisi = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        Assert.assertTrue(odemeBasariliYazisi.isDisplayed());

    }
}
