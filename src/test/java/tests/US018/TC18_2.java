package tests.US018;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC18_2 extends CrossTestBaseRapor {

    @Test
    public void MerchantProfilEdit() throws IOException {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Profil Edit Sayfasi Testi",
                "Merchant, profil bilgilerini güncellemek için Edit düğmesine tıklayabilmeli ve Update Profile sayfasina ulasmali");

        try {
            driver.get(ConfigReader.getProperty("LoginUrl"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
            extentTest.pass("Kullanici Login Sayfasina gider");
        }
        catch (AssertionError e) {
            captureFailure("Login Sayfasina Ulasilamiyor");
            Assert.fail(e.getMessage());
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
            Assert.fail(e.getMessage());
        }

        locator.profilResmi.click();
        extentTest.info("Headerdaki Profil resmine tiklar");

        locator.profilButonu.click();
        extentTest.info("Profil secenegine tiklar");

        locator.profilEditButonu.click();
        extentTest.info("Edit Butonuna tiklar");

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
            Assert.fail(e.getMessage());
        }
        extentTest.info("Sayfayi Kapatir");


    }
}
