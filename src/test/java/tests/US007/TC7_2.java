package tests.US007;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC7_2 extends CrossTestBaseRapor {

    @Test
    public void farkliKargoSecenekleriniGoruntuleme(){

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Farklı Kargo Seçenekleri Görüntüleme Testi",
                "Kullanıcı ilgili menünün olduğu sayda farklı kargo seçeneklerini görüntüleyebilmeli.");

        // kullanıcı anasayfaya gider
        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanıcı anasayfaya gider");

        //kullanıcı menü başlığına tıklar

        locator.navPricing.click();
        softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class, 'nav-link')])[2]");
        extentTest.pass("Pricing başlığına tıklar");


        //kullanıcı farklı karo seçenekleri için ilgili başlıklara tıklar

        locator.navLinks.click();
        softAssert.assertEquals(driver.getCurrentUrl(),"//*[.='Same Day']");
        extentTest.pass("Same Day butonuna tıklar");

        locator.navLinks.click();
        softAssert.assertEquals(driver.getCurrentUrl(),"//*[.='Next Day']");
        extentTest.pass("Next Day butonuna tıklar");

        locator.navLinks.click();
        softAssert.assertEquals(driver.getCurrentUrl(),"//*[.='Sub City']");
        extentTest.pass("Sub City butonuna tıklar");

        locator.navLinks.click();
        softAssert.assertEquals(driver.getCurrentUrl(),"//*[.='Outside City']");
        extentTest.pass("Outside City butonuna tıklar");


        extentTest.info("Sayfayı kapatır");












    }







}
