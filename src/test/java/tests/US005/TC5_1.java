package tests.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Kerem;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.CrossTestBaseRapor;


public class TC5_1 extends TestBaseRapor {

    Kerem kerem ;

    @Test
    public void servisYazisiKontrolTesti (){

        extentTest = extentReports.createTest("Servislerimiz Yazisi Kontrol Testi" +
                "Kullanici ana sayfada servislerimiz alanını görüntülemeli");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");

        // Ana sayfada "Our Services" yazısının bulunduğunu kontrol eder
        kerem = new Kerem();
        String expectedYazi = "Our Services";
        String actualYazi = kerem.ourServicesYaziElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi);
        extentTest.pass("Servis alanının doğru bir şekilde görüntülendiğini doğrular");


        // sayfayi kapatir
        extentTest.info("sayfayi kapatir");




    }
}
