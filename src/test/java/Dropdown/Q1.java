package Dropdown;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q1 extends TestBase {
    //● Bir class oluşturun: DropDown



    @Before
    public void beforeTest(){
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void optionsTest() throws InterruptedException {
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        Thread.sleep(2000);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        Thread.sleep(2000);

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        Thread.sleep(2000);

        //4.Tüm dropdown değerleri(value) yazdırın
        select.getOptions().forEach(t-> System.out.println(t.getText()));

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        if (select.getOptions().size()==4) System.out.println("true");
        else System.out.println("false");

    }
}
