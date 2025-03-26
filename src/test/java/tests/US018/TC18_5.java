package tests.US018;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC18_5 extends CrossTestBaseRapor {

    @Test
    public void SaveChangeTesti() throws IOException {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Profil Edit Save Change Testi",
                "Bilgilerin başarılı bir şekilde kaydedildiğini gösteren bir onay mesajı görüntülenmeli.");

        try {
            driver.get(ConfigReader.getProperty("LoginUrl"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
            extentTest.pass("Kullanici Login Sayfasina gider");
        }
        catch (AssertionError e) {
            captureFailure("Login Sayfasina Ulasilamiyor");
            Assert.fail("Login Sayfasina Ulasilamiyor, " + e.getMessage());
        }

        locator.emailInput.sendKeys(ConfigReader.getProperty("MerchantAlpayGecerliMail"));
        extentTest.info("Email yada tel no kismina gecerli emailini girer");

        locator.passwordInput.sendKeys(ConfigReader.getProperty("MerchantAlpayGecerliPassword"));
        extentTest.info("Password kismina gecerli passwordunu girer");

        try {
            locator.signInButton.click();
            extentTest.info("Sign in butonuna tiklar");
            ReusableMethods.bekle(1);

            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/dashboard");
            extentTest.pass("Kullanici Merchant Dashboard Sayfasina ulasir");
        }
        catch (AssertionError e) {
            captureFailure("Merchant Dashboard Sayfasina Ulasilamiyor");
            Assert.fail("Merchant Dashboard Sayfasina Ulasilamiyor. " + e.getMessage());
        }

        locator.profilResmi.click();
        extentTest.info("Headerdaki Profil resmine tiklar");

        locator.profilButonu.click();
        extentTest.info("Profil secenegine tiklar");

        locator.profilEditButonu.click();
        extentTest.info("Edit Butonuna tiklar");

        ReusableMethods.bekle(1);

        try {
            locator.profileUpdateSaveChange.click();
            extentTest.info("Save Change Butonuna Tiklar");

            Assert.assertTrue(locator.updateSuccess.isDisplayed());
            extentTest.pass("Success Mesajini Goruntuler");
        }
        catch (AssertionError e) {
            captureFailure("Success Mesaji Goruntulenmedi");
            Assert.fail("Success Mesaji Goruntulenmedi. " + e.getMessage());
        }

        ReusableMethods.bekle(1);
        locator.profilResmi.click();
        extentTest.info("Headerdaki Profil resmine tiklar");

        try {
            locator.loguotButonu.click();
            extentTest.info("Logout'a tiklar");

            ReusableMethods.bekle(1);
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
            extentTest.pass("Logout Olur");
        }
        catch (AssertionError e) {
            captureFailure("Logout Olamadi");
            Assert.fail("Logout Olamadi. " + e.getMessage());
        }
        extentTest.info("Sayfayi Kapatir");

    }
}
