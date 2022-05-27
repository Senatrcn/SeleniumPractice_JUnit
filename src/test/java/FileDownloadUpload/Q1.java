package FileDownloadUpload;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Q1 extends TestBase {

    @Test
    public void fileDownloadTest() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //3. 2.txt dosyasını indirelim
        WebElement indirilecekDosya = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='2.txt']")));
        indirilecekDosya.click();
        Thread.sleep(5000);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String arananDosyaYolu = System.getProperty("user.home") + "\\Downloads\\2.txt";

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
    }
}
