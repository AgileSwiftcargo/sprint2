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

//2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));

//3_Sign in butonuna tıklanır.

        locator.signInButton.click();
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);

//4_Parsels çizgi grafiğinin menü tuşuna basılır. (Üst üste 3 çizgi ile gösterilmektedir.

        driver.findElement(By.xpath("//div[@class='apexcharts-menu-icon']")).click();

//5_Download SVG tuşuna basılır.

        driver.findElement(By.xpath("//div[.='Download SVG']")).click();

//6_Parsels çizgi grafiğinin menü tuşuna basılır. (Üst üste 3 çizgi ile gösterilmektedir.

        driver.findElement(By.xpath("//div[@class='apexcharts-menu-icon']")).click();

//7_Download PNG tuşuna basılır.

        driver.findElement(By.xpath("//div[.='Download PNG']")).click();

//8_Parsels çizgi grafiğinin menü tuşuna basılır. (Üst üste 3 çizgi ile gösterilmektedir.

        driver.findElement(By.xpath("//div[@class='apexcharts-menu-icon']")).click();

//9_Download CSV tuşuna basılır.

        driver.findElement(By.xpath("//div[.='Download CSV']")).click();

        //10_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //11_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //12_Sayfa kapatılır.

    }
}
