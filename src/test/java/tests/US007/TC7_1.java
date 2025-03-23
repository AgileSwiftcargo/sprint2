package tests.US007;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC7_1  extends CrossTestBaseRapor {



    @Test
    public void kargoFiyatlandirmalari () {

  Locator locator = new Locator();
  SoftAssert softAssert = new SoftAssert();


        extentTest = extentReports.createTest("Kargo Fiyatlandırmaları Testi",
                "Menü Başlığına Tıklayarak Kargo Fiyatlandırmalarını Görüntüleyebilmeli");

       // kullanıcı anasayfaya gider
         driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanıcı anasayfaya gider");

       //kullanıcı menü başlığına tıklar

        locator.navPricing.click();
        softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class, 'nav-link')])[2]");
        extentTest.pass("Pricing başlığına tıklar");


       extentTest.info("Sayfayı kapatır");








    }



}









