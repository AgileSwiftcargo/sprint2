package tests.US025;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC25_4 extends CrossTestBaseRapor {

    @Test
    public void ParcelEditTesti () throws IOException {

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Mevcut Parsel Edit Testi",
                "Merchant, bir kargo kaydının yanındaki edit düğmesine tıklayarak kargo bilgilerini güncelleyebilmeli.");

        try {
            driver.get(ConfigReader.getProperty("LoginUrl"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
            extentTest.pass("Kullanici Login Sayfasina gider");
        }
        catch (AssertionError e) {
            captureFailure("Login Sayfasina Ulasilamiyor");
            Assert.fail("Login Sayfasina Ulasilamiyor, " + e.getMessage());
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
            Assert.fail("Merchant Dashboard Sayfasina Ulasilamiyor. " + e.getMessage());
        }

        try {
            Assert.assertTrue(locator.parcelMenusu.isDisplayed());
            extentTest.pass("Parcel Menusunu Gorur");
        }
        catch (AssertionError e) {
            captureFailure("Parcel Menusu Bulunamadi");
            Assert.fail("Parcel Menusu Bulunamadi. " + e.getMessage());
        }

        try {
            locator.parcelMenusu.click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/merchant/parcel/index");
            extentTest.pass("Parcel Menusune Tiklar ve Parcel Listesine Ulasir");
        }
        catch (AssertionError e) {
            captureFailure("Parcel Listesine Ulasamadi");
            Assert.fail("Parcel Listesine Ulasamadi. " + e.getMessage());
        }

        try {
            Assert.assertEquals(locator.parcelListActionsBasligi.getText(),"Actions");
            extentTest.pass("Kargo listesinin actions basligini locate eder");
        }
        catch (AssertionError e) {
            captureFailure("Actions Basligi Gorunmuyor");
            softAssert.fail("Actions Basligi Gorunmuyor. " + e.getMessage());
        }

        locator.parcelListActionsButonu.click();
        locator.parcelListEditButonu.click();
        extentTest.info("Actions'a tiklar ve edit'i secer");

        ReusableMethods.bekle(1);

        try {
            locator.createParcelCustomerName.clear();
            ReusableMethods.bekle(1);
            locator.createParcelCustomerName.sendKeys("John Doe");
            ReusableMethods.bekle(1);

            extentTest.info("Guncellemeleri yapar ve save butonuna tiklar");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", locator.parcelListSaveChangeButonu);

            Assert.assertTrue(locator.createParcelSuccessMesaji.isDisplayed());
            extentTest.pass("Parcel Editlenip Save olur");
        }
        catch (AssertionError e) {
            captureFailure("Parcel edit kayit olmadi");
            Assert.fail("Parcel edit kayit olmadi. " + e.getMessage());
        }

        ReusableMethods.bekle(1);
        locator.profilResmi.click();
        extentTest.info("Headerdaki Profil resmine tiklar");

        try {
            ReusableMethods.bekle(1);
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
        softAssert.assertAll();

    }
}