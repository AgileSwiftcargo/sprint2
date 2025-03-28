package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_1 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboard(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Dashboard",
                "Merchant Dashboard'a erişildiğinin testi");


    //1_Login sayfası açılır.
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

    //3_Sign in butonuna tıklanır. Merchant Dashboard'a eriştiğini doğrular.
        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");

    //4_Kullanıcı headerdaki profile resmine tıklar
        driver.findElement(By.xpath("(//a[@class='nav-link nav-user-img'])[1]")).click();
        extentTest.info("Profile menu butonuna tıklanır.");

    //5_Açılan menüden logout butonuna tıkla
        locator.merchantLogoutButton.click();
        extentTest.info("Logout butonuna tıklanır.");
    //6_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");

    }
}
