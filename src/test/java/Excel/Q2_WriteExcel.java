package Excel;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Q2_WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        Faker faker = new Faker();
        String dosyaYolu = "src/resources/menu.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        int satirSayisi = 10;
        int sutunSayisi = 3;


        for (int i = 0; i<satirSayisi; i++){
            workbook.getSheet("Sayfa1").createRow(i);
            for (int j = 0; j<sutunSayisi;j++){
                workbook.getSheet("Sayfa1").getRow(i).createCell(j).setCellValue(faker.food().dish());
            }
        }

        workbook.write(fos);

        System.out.println("Onerilen yemek : "+workbook.getSheet("Sayfa1").getRow(8).getCell(2));
    }
}
