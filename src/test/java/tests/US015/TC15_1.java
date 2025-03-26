package tests.US015;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Busra;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC15_1 extends CrossTestBaseRapor {
  Busra busra ;


    @Test
    public void firmaBilgileriTesti(){

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

       extentTest = extentReports.createTest("Firma Bilgileri Testi",
        "Kargo bilgilerine yönlendiren başlıklar ve linkler olmalı");


        // kullanıcı anasayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        // kullanıcı "Available Services" ve "About" başlıklarını görmeli

     busra = new Busra();

     String expectedYazi = "Available Services";
     String actualYazi= busra.AvailableServicesBaşlığı.getText();

     Assert.assertEquals(actualYazi,expectedYazi);
     extentTest.pass("Başlığı görüntüler");






     extentTest.info("Sayfayı kapatır");








    }













}
