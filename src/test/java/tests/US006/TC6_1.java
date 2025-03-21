package tests.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Furkan;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC6_1 extends TestBaseRapor {
    Furkan furkan ;

    @Test
    public void servisYazisiKontrolTesti (){

        extentTest = extentReports.createTest("Neden Agile Swift Cargo Yazısı Kontrol Testi" +
                "Kullanici ana sayfada neden agile swift cargo alanını görüntülemeli");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");

        // Ana sayfada "Why Agile Swift Cargo" yazısının bulunduğunu kontrol eder
        furkan = new Furkan();
        String expectedYazi = "Why Agile Swift Cargo";
        String actualYazi = furkan.WhyAgileSwiftCargoText.getText();

        Assert.assertEquals(actualYazi,expectedYazi);
        extentTest.pass("Servis alanının doğru bir şekilde görüntülendiğini doğrular");


        // sayfayi kapatir
        extentTest.info("sayfayi kapatir");




    }
}
