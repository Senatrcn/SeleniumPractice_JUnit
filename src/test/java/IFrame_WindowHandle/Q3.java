package IFrame_WindowHandle;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class Q3 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();

        //3. “Cameras product”i tiklayin
        String ilkSayfaWH = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        String ikinciSayfa="";
        for (String wh: windowHandles){
            if (!wh.equals(ilkSayfaWH)){
                ikinciSayfa=wh;
            }
        }
        driver.switchTo().window(ikinciSayfa);
        WebElement iframeElement2 = driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(iframeElement2);
        driver.findElement(By.id("container-product1")).click();
        Thread.sleep(5000);


        //4. Popup mesajini yazdirin
        WebElement popUpElement = driver.findElement(By.xpath("//div[@class='modal-header']"));
        System.out.println(popUpElement.getText());

        //5. “close” butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        driver.switchTo().defaultContent();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        String ilkSayfa2 = driver.getWindowHandle();
        driver.findElement(By.xpath("(//a[@id='nav-title'])[1]")).click();

        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Set<String> windowHandles2 = driver.getWindowHandles();
        String ikinciSayfa2="";
        for (String wh: windowHandles2){
            if (!wh.equals(ilkSayfa2)){
                ikinciSayfa2=wh;
            }
        }
        driver.switchTo().window(ikinciSayfa2);
        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
}
