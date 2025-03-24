package tests.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Kerem;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;



public class TC5_1 extends CrossTestBaseRapor {

    Locator locator ;

    @Test
    public void servisYazisiKontrolTesti (){

        extentTest = extentReports.createTest("Servislerimiz Yazisi Kontrol Testi",
                "Kullanici ana sayfada servislerimiz alanını görüntülemeli");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");

        // Ana sayfada "Our Services" yazısının bulunduğunu kontrol eder
        locator = new Locator();
        String expectedYazi = "Our Services";
        String actualYazi = locator.ourServicesYaziElementi.getText();

        Assert.assertEquals(actualYazi,expectedYazi);
        extentTest.pass("Servis alanının doğru bir şekilde görüntülendiğini doğrular");


        // sayfayi kapatir
        extentTest.info("sayfayi kapatirrr");





    }
}
