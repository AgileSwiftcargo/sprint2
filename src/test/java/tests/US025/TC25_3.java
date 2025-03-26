package tests.US025;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC25_3 extends CrossTestBaseRapor {

    @Test
    public void ParcelEklemeTesti() throws IOException {

        Locator locator = new Locator();
        Faker faker = new Faker();

        extentTest = extentReports.createTest("Yeni Parcel Ekleme Testi",
                "Merchant, Kargo Ekle düğmesine tıklayabilmeli. Kargo ekleme formu doldurulduktan sonra, yeni kargo kaydedilmeli ve kargo listesinde görüntülenmeli.");

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


        locator.parcelEkle.click();
        ReusableMethods.bekle(1);
        //locator.createParcelDropdown.click();
       // locator.createParcelTextBox.sendKeys("Merchant Alpay");
        locator.createParcelPickupAddress.clear();
        locator.createParcelPickupAddress.sendKeys("Greenwich, London, UK");
        locator.createParcelSellingPrice.sendKeys("100");

        locator.createParcelCategoryDropdown.click();
        ReusableMethods.bekle(1);
        locator.createParcelCategoryTextBox.click();

        locator.createParcelDeliveryDropdown.click();
        ReusableMethods.bekle(1);
        locator.createParcelDeliveryTextBox.click();

        locator.createParcelCustomerPhone.sendKeys("012458785455");
        locator.createParcelCustomerAddress.sendKeys("Manhattan, New York, USA");
        locator.createParcelPickupPhone.clear();
        locator.createParcelPickupPhone.sendKeys("01254887566");
        locator.createParcelCashCollection.sendKeys("50");

        //locator.createParcelWeightDropdown.click();
        ReusableMethods.bekle(1);
        //locator.createParcelWeightTextBox.click();

        String customerName = faker.name().fullName();
        locator.createParcelCustomerName.sendKeys(customerName);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", locator.createParcelLiquid);
        js.executeScript("arguments[0].click();", locator.createParcelParcelBank);

        ReusableMethods.bekle(1);

        try {
            locator.createParcelSaveButton.click();
            ReusableMethods.bekle(1);
            Assert.assertTrue(locator.createParcelSuccessMesaji.isDisplayed());
            extentTest.pass("Parcel Basarili bir sekilde kayit edilir");
        }
        catch (AssertionError e) {
            captureFailure("Parcel Kayit olmadi");
            Assert.fail("Parcel Kayit olmadi. " + e.getMessage());
        }

        try {
            ReusableMethods.bekle(1);
            Assert.assertEquals(locator.parcelListRecipientName.getText(), customerName );
            extentTest.pass("Yeni Parcelin olusturuldugu goruldu");
        }
        catch (AssertionError e) {
            captureFailure("Yeni Parcel listede gorulmedi");
            Assert.fail("Yeni Parcel listede gorulmedi. " + e.getMessage());
        }


        ReusableMethods.bekle(5);
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
