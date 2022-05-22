package Assertions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Q3_CheckBoxTest extends TestBase {

    @Test
    public void test01(){
        // 1. Bir class oluşturun : CheckBoxTest
        //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        //a. Verilen web sayfasına gidin.
        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement cb1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement cb2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!cb1.isSelected()){
            cb1.click();
            Assert.assertTrue(cb1.isSelected());
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!cb2.isSelected()){
            cb2.click();
            Assert.assertTrue(cb2.isSelected());
        }
    }
}
