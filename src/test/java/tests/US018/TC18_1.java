package tests.US018;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC18_1 extends CrossTestBaseRapor {

    @Test
    public void MerchantProfili() throws IOException {

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Merchant Profil Goruntuleme Testi",
                "Merchant, profiline tiklayip, mevcut profil bilgilerini goruntuler");

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

        try {
            locator.profilResmi.click();
            extentTest.info("Headerdaki Profil resmine tiklar");

            locator.profilButonu.click();
            extentTest.info("Profil secenegine tiklar");
            extentTest.info( "Profil durumunun active oldugunu dogrular");

            boolean isInActive = driver.findElement(By.xpath("//*[contains(@class, 'badge')]"))
                    .getText().contains("Inactive");
            if (isInActive) {
                throw new AssertionError( "Status durumu active degil");
            }
            extentTest.pass( "Profil durumunun active oldugunu dogrular");
        }
        catch (AssertionError e) {
            captureFailure("Status Durumu Inactive");
            softAssert.fail(e.getMessage());
        }

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

        softAssert.assertAll();

    }
}