package Alerts;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Q1 extends TestBase {
    //● Bir class olusturun: Alerts

    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        acceptAlert();

        //“You successfully clicked an alert” oldugunu test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());

        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        dismissAlert();
        Assert.assertNotEquals("successfuly",driver.findElement(By.xpath("//p[@id='result']")).getText());

        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        sendKeysAlert();
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("sena"));
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
