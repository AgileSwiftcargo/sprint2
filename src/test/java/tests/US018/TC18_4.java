package tests.US018;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC18_4 extends CrossTestBaseRapor {

    @Test
    public void ProfileEksikBilgiIleUpdateEtme() throws IOException {

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Merchant Profil Eksik Bilgilerle Update Testi",
                "Merchant Profil'ini eksik bilgilerle düzenleyememelidir.");

        try {
            driver.get(ConfigReader.getProperty("LoginUrl"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
            extentTest.pass("Kullanici Login Sayfasina gider");
        }
        catch (AssertionError e) {
            captureFailure("Login Sayfasina Ulasilamiyor");
            Assert.fail("Login Sayfasina Ulasilamiyor. " + e.getMessage());
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

        locator.profileUpdateName.clear();
        extentTest.info("Name TexBox'undaki Bilgiyi Siler");

        ReusableMethods.bekle(1);
        locator.profileUpdateSaveChange.click();
        extentTest.info("Save Change Butonuna Tiklar");

        try {
            Assert.assertTrue(locator.profileUpdateNameFieldRequired.isDisplayed());
            extentTest.pass("The Name field is required. yazisini gorur");
        }
        catch (AssertionError e) {
            captureFailure("Eksik bilgi ile update yapildi");
            softAssert.fail("Eksik bilgi ile update yapildi. " + e.getMessage());
        }

        locator.profileUpdateEmail.clear();
        locator.profileUpdateEmail.sendKeys("merchant.alpay@");
        extentTest.info("Email textboxuna gecersiz bir email girer");

        ReusableMethods.bekle(1);

        try {
            locator.profileUpdateSaveChange.click();
            extentTest.info("Save Change Butonuna Tiklar");

            Assert.assertFalse(locator.updateSuccess.isDisplayed());
            extentTest.pass("Success Mesajini Goruntulemez");
        }
        catch (AssertionError e) {
            captureFailure("Eksik email ile update yapildi");
            softAssert.fail("Eksik email ile update yapildi. " + e.getMessage());
        }

        ReusableMethods.bekle(1);
        locator.profilEditButonu.click();
        extentTest.info("Edit Butonuna tiklar");

        ReusableMethods.bekle(5);
        locator.profileUpdateEmail.clear();
        locator.profileUpdateEmail.sendKeys("merchant.alpay@agileswiftcargo.com");
        extentTest.info("Email textboxuna dogru emaili girip duzeltir");


        locator.profileUpdateMobile.clear();
        locator.profileUpdateMobile.sendKeys("0125452");
        extentTest.info("Mobile numarasini eksik Girer");

        try {
            locator.profileUpdateSaveChange.click();
            extentTest.info("Save Change Butonuna Tiklar");

            Assert.assertFalse(locator.updateSuccess.isDisplayed());
            extentTest.pass("Success Mesajini Goruntulemez");
        }
        catch (AssertionError e) {
            captureFailure("Eksik mobile numarasi ile update yapildi");
            softAssert.fail("Eksik mobile numarasi ile update yapildi. " + e.getMessage());
        }

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

        softAssert.assertAll();

    }
}
