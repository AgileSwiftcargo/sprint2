package tests.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Furkan;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.util.Scanner;

public class TC6_1 extends CrossTestBaseRapor {

    @Test
    public void servisYazisiKontrolTesti (){

        extentTest = extentReports.createTest("Neden Agile Swift Cargo Yazısı Kontrol Testi" +
                "Kullanici ana sayfada neden agile swift cargo alanını görüntülemeli");
        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");
        // Ana sayfada "Why Agile Swift Cargo" yazısının bulunduğunu kontrol eder
        String expectedYazi = "Why Agile Swift Cargo";
        Locator locator = new Locator();
        String actualYazi = locator.WhyAgileSwiftCargoText.getText();
        Assert.assertEquals(actualYazi,expectedYazi);
        extentTest.pass("Servis alanının doğru bir şekilde görüntülendiğini doğrular");
        // sayfayi kapatir
        extentTest.info("sayfayi kapatir");

    }
}
