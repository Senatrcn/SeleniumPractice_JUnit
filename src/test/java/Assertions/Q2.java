package Assertions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q2 extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String ilkUrunIsmi = ilkUrun.getText();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.cssSelector("a[class='shopping_cart_link']")).click();
        Thread.sleep(2000);
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        List<WebElement> sepettekiUrunler = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertTrue(sepettekiUrunler.stream().anyMatch(item -> item.getText().equals(ilkUrunIsmi)));

        //9. Sayfayi kapatin

    }
}
