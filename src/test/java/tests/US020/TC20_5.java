package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_5 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardParcelGraph(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Parcel Graph",
                "Parcel sayıları parcels kısmında çizgi ve pasta grafiğiyle görülmelidir.");

    //1_Login sayfaası açılır.

        driver.get(ConfigReader.getProperty("LoginUrl"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");

//2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        extentTest.info("Email textboxına \"merchant.lutfi@agileswiftcargo.com\" mail adresi girilir");
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");

        String actualPassword = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPassword = "password";

        Assert.assertEquals(actualPassword,expectedPassword);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");

//3_Sign in butonuna tıklanır.

        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");

//4_Sayfada parcels çizgi grafiği olduğu doğrulanır.


        Assert.assertTrue(driver.findElement(By.id("apexparcels")).isDisplayed());
        extentTest.pass("Parcel çizgi grafik alanının olduğu doğrulanmıştır.");


//5_Sayfada parcels pasta grafiğinin olduğu doğrulanır.


        Assert.assertTrue(driver.findElement(By.id("apexparcelspiechart")).isDisplayed());
        extentTest.pass("Parcel pasta grafik alanının olduğu doğrulanmıştır.");


        //6_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

        //7_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
        //8_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");

    }
}
