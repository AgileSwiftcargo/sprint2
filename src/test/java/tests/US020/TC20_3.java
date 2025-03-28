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

        //4_Total cash collection kısmının olduğu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total cash collection ']"))
                .isDisplayed());

        extentTest.pass("Total cash collection alanının olduğu doğrulanmıştır.");

        //5_Total selling price kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total selling price']"))
                .isDisplayed());
        extentTest.pass("Total selling price alanının olduğu doğrulanmıştır.");
        //6_Net profit amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.=' Net profit amount']"))
                .isDisplayed());

        extentTest.pass("Net profit amount alanının olduğu doğrulanmıştır.");


        //7_Total liquid fragile amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total liquid fragile amount']"))
                .isDisplayed());

        extentTest.pass("Total liquid fragile alanının olduğu doğrulanmıştır.");

        //8_Total packaging amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total packaging amount']"))
                .isDisplayed());
        extentTest.pass("Total packaging amount alanının olduğu doğrulanmıştır.");

        //9_Total vat amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total vat amount']"))
                .isDisplayed());
        extentTest.pass("Total vat amount alanının olduğu doğrulanmıştır.");

        //10_Total delivery charge kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total delivery charge']"))
                .isDisplayed());
        extentTest.pass("Total delivery charge alanının olduğu doğrulanmıştır.");

        //11_Total cod amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total cod amount']"))
                .isDisplayed());
        extentTest.pass("Total cod amount alanının olduğu doğrulanmıştır.");

        //12_Total delivery amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver
                .findElement(By.xpath("//span[.='Total delivery amount']"))
                .isDisplayed());
        extentTest.pass("Total delivery amount alanının olduğu doğrulanmıştır.");

        //13_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
        //14_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
        //15_Sayfa kapatılır.


    }

}
