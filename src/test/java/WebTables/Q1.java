package WebTables;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Q1 extends TestBase {
    @Test
    public void test01() {
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();

        //○ Username : manager
        //○ Password : Manager1!
        WebElement username = driver.findElement(By.xpath("//input[@id='UserName']"));
        Actions actions = new Actions(driver);
        actions
                .click(username)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .perform();
        actions.click(driver.findElement(By.id("btnSubmit"))).perform();

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun sayisi : "+sutunBasliklariListesi.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        sutunBasliklariListesi.stream().forEach(t-> System.out.println(t.getText()+"    "));
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());


        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> bodyListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : "+bodyListesi.size());

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        bodyListesi.stream().forEach(t-> System.out.println(t.getText()));

        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> dorduncuSatirListesi = driver.findElements(By.xpath("//tbody//tr[4]//td"));
        dorduncuSatirListesi.stream().forEach(t-> System.out.println(t.getText()));

        //○ Email basligindaki tum elementleri(sutun) konsola yazdirin
        List<WebElement> emailListesi = driver.findElements(By.xpath("//tbody//tr[3]//td"));
        emailListesi.stream().forEach(t-> System.out.println(t.getText()));

    }


}
