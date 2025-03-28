package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_7 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardFilter(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Merchant Dashboard Filter Testi",
                "Filtre fonksiyonlarının çalıştığı test edilir.");

//    1_Login sayfaası açılır.
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
//4_Enter date textboxının olduğu doğrulanır.

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//5_Filter butonunun olduğu doğrulanır.

        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        extentTest.pass("Filter butonunun olduğu doğrulanmıştır.");
        //10_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

        //11_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
        //12_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");

    }

}
