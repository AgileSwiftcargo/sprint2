package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_3 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardKPITccTspNpaTlfaTpaTvaTdcTcaTda() {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Dashboard KPI Bilgileri Tp&Td&Tr&Tt",
                "Merchant dashboard sayfasında, Merchanta ait finansal KPI verilerinin görünür olması gerekmektedir." +
                        "(T.Cash Col, T.Selling price, N.Profit amount, T.liquid fragile amount, Total packaging amount, ...");

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

        //4_Total cash collection kısmının olduğu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total cash collection ']"))
                .isDisplayed());

        //5_Total selling price kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total selling price']"))
                .isDisplayed());

        //6_Net profit amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.=' Net profit amount']"))
                .isDisplayed());


        //7_Total liquid fragile amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total liquid fragile amount']"))
                .isDisplayed());

        //8_Total packaging amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total packaging amount']"))
                .isDisplayed());

        //9_Total vat amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total vat amount']"))
                .isDisplayed());

        //10_Total delivery charge kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total delivery charge']"))
                .isDisplayed());

        //11_Total cod amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total cod amount']"))
                .isDisplayed());

        //12_Total delivery amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total delivery amount']"))
                .isDisplayed());

        //13_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //14_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //15_Sayfa kapatılır.


    }

}
