package Assertions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class Q5_YoutubeAssertions extends TestBase {
    //1) Bir class oluşturun: YoutubeAssertions

    @Before
    public void beforeTest(){
        //2) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin

    @Test
    public void titleTest(){
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        Assert.assertEquals("YouTube", driver.getTitle());
    }
    @Test
    public void imageTest(){
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]")).isDisplayed());
    }
    @Test
    public void SearchBoxTest(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        Assert.assertFalse(driver.getTitle().equals("youtube"));
    }
}
