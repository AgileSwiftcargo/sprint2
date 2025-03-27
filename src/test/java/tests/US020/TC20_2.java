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

        //2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));

        //3_Sign in butonuna tıklanır.

        locator.signInButton.click();
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);

        //4_Total Parcel kısmının olduğu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total Parcel']")).isDisplayed());

        //5_Total deliverd kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total deliverd']")).isDisplayed());

        //6_Total return kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total return']")).isDisplayed());

        //7_Total transit kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total transit']")).isDisplayed());

        //8_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //9_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //10_Sayfa kapatılır.
    }
}
