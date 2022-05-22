package Assertions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q6_YanlisEmailTesti extends TestBase {
    //1. Bir Class olusturalim YanlisEmailTesti

    @Before
    public void beforeTest(){
        //2. http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void mailTesti(){
        //3. Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //4. Email kutusuna @isareti olmayan bir mail yazip enter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("senasena#gmail.com");
        driver.findElement(By.xpath("//button[@name='SubmitCreate']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
    }
}
