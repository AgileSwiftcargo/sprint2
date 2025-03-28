package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_9 extends CrossTestBaseRapor {

    public void merchantDashboardButon() {

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Merchant Dashboard Buton Testi",
                "Açılan sayfada sol tarafta bulunan navigasyon barında bulunan dashboard butonuna tıkladığımıda yine merchant dashboard sayfasına ulaşılmalıdır");


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
//4_Menüden ticket butonuna tıklanır.
        locator.ticketLinki.click();
        extentTest.info("Ticket butonuna basılır.");

//5_Menüden dashboard butonuna tıklanır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi1 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi1 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi1,expectedMerchantYazisi1);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
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
