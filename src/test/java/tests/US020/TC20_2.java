package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_2 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardKPITpTdTrTt() {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Dashboard KPI Bilgileri Tp&Td&Tr&Tt",
                "Merchant dashboard sayfasında, Merchanta ait kargo KPI bilgilerinin görünür olması gerekmektedir. (Total parcel, total delivered, total return, total transit)");


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

        //4_Total Parcel kısmının olduğu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total Parcel']")).isDisplayed());
        extentTest.pass("Total Parcel alanının olduğu doğrulanmıştır.");
        //5_Total deliverd kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total deliverd']")).isDisplayed());
        extentTest.pass("Total delivered alanının olduğu doğrulanmıştır.");
        //6_Total return kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total return']")).isDisplayed());
        extentTest.pass("Total return alanının olduğu doğrulanmıştır.");
        //7_Total transit kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total transit']")).isDisplayed());
        extentTest.pass("Total transit alanının olduğu doğrulanmıştır.");
        //8_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

        //9_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
        //10_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");
    }
}
