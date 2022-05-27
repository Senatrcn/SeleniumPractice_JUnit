package Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q1_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        int satir =1;
        int sutun =2;
        System.out.println(workbook.getSheet("Sayfa1").getRow(satir-1).getCell(sutun-1));

        //- 2.satir 4.cell’in Afganistan’in baskenti oldugunu test edelim
        satir=2;
        sutun=4;
        String expectedData = "Kabil";
        Assert.assertEquals(expectedData,workbook.getSheet("Sayfa1").getRow(satir-1).getCell(sutun-1).toString());

        //- Satir sayisini bulalim
        int toplamSatirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(toplamSatirSayisi);

        //- Fiziki olarak kullanilan satir sayisini bulun
        workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        Map<String,String> ingilizceUlkeSehirMap = new HashMap<>();

        for (int i = 0; i < toplamSatirSayisi; i++){
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ingilizceUlkeSehirMap.put(key, value);
        }
        System.out.println(ingilizceUlkeSehirMap);

    }


}
