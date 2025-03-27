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

//2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));

//3_Sign in butonuna tıklanır.

        locator.signInButton.click();
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);

//4_Sayfada parcels çizgi grafiği olduğu doğrulanır.


        Assert.assertTrue(driver.findElement(By.id("apexparcels")).isDisplayed());


//5_Sayfada parcels pasta grafiğinin olduğu doğrulanır.


        Assert.assertTrue(driver.findElement(By.id("apexparcelspiechart")).isDisplayed());


        //6_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //7_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //8_Sayfa kapatılır.

    }
}
