package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_6 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardParcelGraphDownload() {

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Parcel Graph Download Testi",
                "Parcel sayıları parcels kısmında çizgi ve pasta grafiğiyle görülmelidir.");


        //   1_Login sayfaası açılır.

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

//4_Parsels çizgi grafiğinin menü tuşuna basılır. (Üst üste 3 çizgi ile gösterilmektedir.

        driver.findElement(By.xpath("//div[@class='apexcharts-menu-icon']")).click();
        extentTest.info("Parcel çizgi grafiğinin menü butonu tıklanır.");

//5_Download SVG tuşuna basılır.

        driver.findElement(By.xpath("//div[.='Download SVG']")).click();
        extentTest.info("Download SVG tuşuna basılır.");

//6_Parsels çizgi grafiğinin menü tuşuna basılır. (Üst üste 3 çizgi ile gösterilmektedir.

        driver.findElement(By.xpath("//div[@class='apexcharts-menu-icon']")).click();
        extentTest.info("Parcel çizgi grafiğinin menü butonu tıklanır.");


//7_Download PNG tuşuna basılır.

        driver.findElement(By.xpath("//div[.='Download PNG']")).click();
        extentTest.info("Download PNG tuşuna basılır.");

//8_Parsels çizgi grafiğinin menü tuşuna basılır. (Üst üste 3 çizgi ile gösterilmektedir.

        driver.findElement(By.xpath("//div[@class='apexcharts-menu-icon']")).click();
        extentTest.info("Parcel çizgi grafiğinin menü butonu tıklanır.");

//9_Download CSV tuşuna basılır.

        driver.findElement(By.xpath("//div[.='Download CSV']")).click();
        extentTest.info("Download CSV tuşuna basılır.");

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
