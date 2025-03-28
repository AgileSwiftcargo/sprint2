package tests.US015;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Busra;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC15_6 extends CrossTestBaseRapor {

 Locator locator;

    @Test
    public void ilgiliBaslıgatıklama() {
        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("İlgili başlığa tıklama testi",
                "Başlıklara tıklandığında doğru sayfa açılmalı");

        // kullanıcı anasayfaya gider
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");

        //"E-Commerce delivery","Pick & Drop","Packageing",
        //"Warehousing" başlıklarına tıklar

        locator.ECommerceDeliveryButonu.click();

        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/service-details/1");
        extentTest.pass("E-Commerce delivery sayfası açılır");

        locator.PickDropButonu.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/service-details/2");
        extentTest.pass("Pick & Drop sayfası açılır");

        locator.PackageinButonu.click();

        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/service-details/3");
        extentTest.pass("Packageing sayfası açılır");

        locator.WarehousinButonu.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/service-details/4");
        extentTest.pass("Warehousing sayfası açılır");


        extentTest.info("Sayfayı kapatır");


    }
}




