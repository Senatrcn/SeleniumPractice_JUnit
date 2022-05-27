package FileDownloadUpload;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q2 extends TestBase {

    @Test
    public void fileUploadTest(){
        //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        WebElement dosyaSecButonu = driver.findElement(By.xpath("//input[@id='file-upload']"));

        //4. Yuklemek istediginiz dosyayi secelim.
        String yuklenecekDosya = System.getProperty("user.home") + "\\Downloads\\2.txt";
        dosyaSecButonu.sendKeys(yuklenecekDosya);
        //5. Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        //6. “File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
}
