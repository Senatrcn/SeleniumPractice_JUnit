package WebTables;

import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class Q2 extends TestBase {
    @Test
    public void test01() {
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan department isimlerini yazdirin
        System.out.println("2. Task");
        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));
        int departmentIndex=-1;
        for (int i = 0; i < basliklarListesi.size(); i++){
            if (basliklarListesi.get(i).getText().equals("Department")){
                departmentIndex = i;
            }
        }
        List<WebElement> departmenList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']["+(departmentIndex+1)+"]"));
        departmenList.stream().forEach(t-> System.out.println(t.getText()));

        //3. sutunun basligini yazdirin
        System.out.println("3. Task");
        System.out.println(basliklarListesi.get(2).getText());

        //4. Tablodaki tum datalari yazdirin
        System.out.println("4. Task");
        WebElement tumData = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println(tumData.getText());

        System.out.println("=======");

        List<WebElement> tumDataList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        tumDataList.stream().forEach(t-> System.out.println(t.getText()));


        //5. Tabloda kac cell (data) oldugunu yazdirin
        System.out.println("5. Task");
        List<WebElement> tumCell = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@role='row']//div[@role='gridcell']"));
        System.out.println(tumCell.size());

        //6. Tablodaki satir sayisini yazdirin
        System.out.println("6. Task");
        List<WebElement> tumSatir = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@role='row']"));
        System.out.println(tumSatir.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("7. Task");
        System.out.println(basliklarListesi.size());

        //8. Tablodaki 3.kolonu yazdirin
        System.out.println("8. Task");
        List<WebElement> ucuncuKolon = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][3]"));
        ucuncuKolon.stream().forEach(t-> System.out.println(t.getText()));

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        System.out.println("9. Task");
        int index=-1;
        for (int i = 0; i <tumDataList.size(); i++){
            if (tumDataList.get(i).getText().contains("Kierra")){
                index=i;
            }
        }
        List<WebElement> istenenSatirElement = driver.findElements(By.xpath("//div[@class='rt-tr-group']["+(index+1)+"]//div[@class='rt-td']"));
        System.out.println(istenenSatirElement.get(4).getText());

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini
        //girdigimde bana datayi yazdirsin
        System.out.println("10. Task");
        hucreYazdir(2,2);

    }

    public void hucreYazdir(int satir, int sutun){
        WebElement hucre = driver.findElement(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']["+satir+"]//div[@class='rt-td']["+sutun+"]"));
        System.out.println(hucre.getText());
    }

}
