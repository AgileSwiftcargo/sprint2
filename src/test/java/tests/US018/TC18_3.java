package tests.US018;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC18_3 extends CrossTestBaseRapor {

    @Test
    public void MerchantProfilUpdate() throws IOException {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Profil Update Testi",
                "Merchant Profil'ini yeni bilgilerle düzenleyebilmelidir.");

        try {
            driver.get(ConfigReader.getProperty("LoginUrl"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
            extentTest.pass("Kullanici Login Sayfasina gider");
        }
        catch (AssertionError e) {
            captureFailure("Login Sayfasina Ulasilamiyor");
            Assert.fail(e.getMessage());
        }

        locator.emailInput.sendKeys("merchant.alpay@agileswiftcargo.com");
        extentTest.info("Email yada tel no kismina gecerli emailini girer");

        locator.passwordInput.sendKeys("Agile.0924");
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

        locator.profileUpdateName.clear();
        locator.profileUpdateName.sendKeys("Alpay");
        extentTest.info("Name Girer");

        locator.profileUpdateEmail.clear();
        locator.profileUpdateEmail.sendKeys("merchant.alpay@agileswiftcargo.com");
        extentTest.info("Email Adresi Girer");

        locator.profileUpdateMobile.clear();
        locator.profileUpdateMobile.sendKeys("8997989956523");
        extentTest.info("Mobile Girer");

        locator.profileUpdateBusinessName.clear();
        locator.profileUpdateBusinessName.sendKeys("Merchant Alpay");
        extentTest.info("Business Name Girer");

        locator.profileUpdateAddress.clear();
        locator.profileUpdateAddress.sendKeys("Greenwich, London, UK");
        extentTest.info("Address Girer");

        ReusableMethods.bekle(2);

        locator.profileUpdateSaveChange.click();
        extentTest.info("Save Change Butonuna Tiklar");

        ReusableMethods.bekle(2);
        Assert.assertTrue(locator.updateSuccess.isDisplayed());
        extentTest.pass("Success Mesajini Goruntuler");

        locator.profilResmi.click();
        extentTest.info("Headerdaki Profil resmine tiklar");

        try {
            locator.loguotButonu.click();
            extentTest.info("Logout'a tiklar");

            ReusableMethods.bekle(2);
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
