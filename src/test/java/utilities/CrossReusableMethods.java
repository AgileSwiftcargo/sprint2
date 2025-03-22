package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static utilities.DriverCross.driver;


public class CrossReusableMethods {

    public static String raporaResimEkle(String testIsmi) throws IOException {

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("_yyMMdd_HHmmss");
        String date = localDateTime.format(format); // _241219_080623

        // 1.adim tss objesi olusturalim
        //   ve takesScreenshot objesi ile gecici resmi kaydedelim
        ReusableMethods.bekle(1);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File geciciDosya = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Asil resmi kaydedecegimiz dosya yolunu olusturup
        // bu dosya yolu ile resmi kaydedecegimiz asil dosyayi olusturalim

        String dosyaYolu = System.getProperty("user.dir") + "/test-output/Screenshots/" + testIsmi + date + ".jpg";
        File asilResimDosyasi = new File(dosyaYolu);
        // gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya, asilResimDosyasi);
        return dosyaYolu;
    }

}
