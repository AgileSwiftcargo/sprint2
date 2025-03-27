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
//2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.
        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));
//3_Sign in butonuna tıklanır.
        locator.signInButton.click();
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);
//4_Menüden ticket butonuna tıklanır.
        locator.ticketLinki.click();
//5_Menüden dashboard butonuna tıklanır.
        locator.dashBoardLinki.click();

        String actualNewMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedNewMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualNewMerchantYazisi,expectedNewMerchantYazisi);
        //6_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //7_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //8_Sayfa kapatılır.
    }
}
