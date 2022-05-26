package Alerts;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q2_Deneme extends TestBase {
    @Test
    public void test01(){
        System.out.println("deneme");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        System.out.println("deneme");
        Assert.assertNotEquals("successfuly",driver.findElement(By.xpath("//p[@id='result']")).getText());
    }
    public void acceptAlert(){
        //● Bir metod olusturun: acceptAlert
        driver.switchTo().alert().accept();
    }
    public void dismissAlert(){
        //● Bir metod olusturun: dismissAlert
        driver.switchTo().alert().dismiss();
    }
    public void sendKeysAlert(){
        //● Bir metod olusturun: sendKeysAlert
        driver.switchTo().alert().sendKeys("sena");
        driver.switchTo().alert().accept();
    }
}
