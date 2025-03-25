package tests.US001;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.time.LocalTime;

public class TC1_2 extends CrossTestBaseRapor {
    @Test
    public void anasayfaGoruntulenmeSureTesti (){

        extentTest = extentReports.createTest("Anasayfa Görüntülenme Süre Testi",
                "Anasayfanın 4 saniye'nin altında görüntülenmeli");

        LocalTime start = LocalTime.now();

        driver.get(ConfigReader.getProperty("Url"));

        LocalTime finish = LocalTime.now();
        int millis = (int) Duration.between(start, finish).toSeconds();
        System.out.println("Anasayfa yuklenme suresi " + millis + " seconds");

        Assert.assertTrue(millis < 4);
        extentTest.pass("Anasayfanın 4 saniye'nin altında görüntülendiğini doğrular");

        extentTest.info("sayfayı kapatır");
    }
}