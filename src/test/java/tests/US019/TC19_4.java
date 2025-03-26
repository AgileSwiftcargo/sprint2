package tests.US019;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC19_4 extends CrossTestBaseRapor {

    @Test
    public void MerchantProfilUpdate() throws IOException {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Profil Update Testi",
                "Merchant Profil'ini yeni bilgilerle düzenleyebilmelidir.");

        try {
            driver.get(ConfigReader.getProperty("LoginUrl"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
            extentTest.pass("Kullanici Login Sayfasina gider");
        } catch (AssertionError e) {
            captureFailure("Login Sayfasina Ulasilamiyor");
            Assert.fail(e.getMessage());
        }

        locator.emailInput.sendKeys("merchant.filiz@agileswiftcargo.com");
        extentTest.info("Email yada tel no kismina gecerli emailini girer");

        locator.passwordInput.sendKeys("Agile.0924");
        extentTest.info("Password kismina gecerli passwordunu girer");

        try {
            locator.signInButton.click();
            extentTest.info("Sign in butonuna tiklar");
            ReusableMethods.bekle(1);

            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/dashboard");
            extentTest.pass("Kullanici Merchant Dashboard Sayfasina ulasir");
        } catch (AssertionError e) {
            captureFailure("Merchant Dashboard Sayfasina Ulasilamiyor");
            Assert.fail(e.getMessage());
        }
        ReusableMethods.bekle(2);
        locator.profilResmi.click();
        extentTest.info("Headerdaki Profil resmine tiklar");
        ReusableMethods.bekle(3);
        locator.profilButonu.click();
        extentTest.info("Profil secenegine tiklar");
        ReusableMethods.bekle(4);
        locator.profilResmi.click();
        extentTest.info("Headerdaki Profil resmine tiklar");
        ReusableMethods.bekle(3);

        locator.sifeDegistirButonu.click();
        extentTest.info("sifre degistir e tıklar");
        ReusableMethods.bekle(2);
        locator.passwordInput.sendKeys("filiz.0924");
        extentTest.info("yeni şifre girilir");
        ReusableMethods.bekle(2);

        locator.passwordInput.sendKeys("filiz.0924");
        extentTest.info("yeni şifre tekrar girilir");
        ReusableMethods.bekle(2);
        locator.saveChangeButton.click();
        extentTest.info("sifre kaydet e tıklar");
        ReusableMethods.bekle(2);
        extentTest.info("sayfayı kapatır");



    }
}


