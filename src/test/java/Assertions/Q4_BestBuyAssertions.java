package Assertions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q4_BestBuyAssertions extends TestBase {
    // 1) Bir class oluşturun: BestBuyAssertions

    @Before
    public void beforeTest(){
        //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
        //testleri yapin
        driver.get("https://www.bestbuy.com/");
    }
    @Test
    public void urlTest(){
        //○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.bestbuy.com/");
    }
    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        Assert.assertFalse(driver.getTitle().contains("Rest"));

    }
    @Test
    public void logoTest(){
        //○ logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]")).isDisplayed());
    }
    @Test
    public void francaisLinkTest(){
        //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang=\'fr\']")).isDisplayed());
    }
}
