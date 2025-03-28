package tests.US020;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC20_4 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardKPITsaTdfpTvaNpaCbObVPpPaTsTpbiTpr() {

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Merchant Dashboard KPI Bilgileri Tp&Td&Tr&Tt",
                "Merchant dashboard sayfasında, Merchanta ait finansal KPI verilerin All Reports kısmında görünür olması gerekmektedir. " +
                        "(Total sales amount, Total delivery fees paid, Total Vat Amount, Net profit amount, Current Balance, Opening Balance, Vat, Payment processing, Paid amount, Total shop, Total parcel bank items, Total payment request)");

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

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        ReusableMethods.bekle(2);

//4_Total sales amount kısmının olduğu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total sales amount ']")).isDisplayed());
        extentTest.pass("Total sales amount alanının olduğu doğrulanmıştır.");
//5_Total delivery fees paid kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total delivery fees paid']")).isDisplayed());
        extentTest.pass("Total delivery fees alanının olduğu doğrulanmıştır.");
//6_Total Vat Amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total Vat Amount']")).isDisplayed());
        extentTest.pass("Total Vat amount alanının olduğu doğrulanmıştır.");
//7_ Net profit amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Net profit amount']")).isDisplayed());
        extentTest.pass("Net profit amount alanının olduğu doğrulanmıştır.");
//8_Current Balance kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Current Balance']")).isDisplayed());
        extentTest.pass("Current balance alanının olduğu doğrulanmıştır.");
//9_Opening Balance kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Opening Balance']")).isDisplayed());
        extentTest.pass("Opening balance alanının olduğu doğrulanmıştır.");
//10_Vat kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Vat']")).isDisplayed());
        extentTest.pass("Vat alanının olduğu doğrulanmıştır.");
//11_Payment processing kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Payment processing']")).isDisplayed());
        extentTest.pass("Payment processing alanının olduğu doğrulanmıştır.");
//12_Paid amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Paid amount']")).isDisplayed());
        extentTest.pass("Paid amount alanının olduğu doğrulanmıştır.");
//13_Total shop kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total shop']")).isDisplayed());
        extentTest.pass("Total shop alanının olduğu doğrulanmıştır.");
//14_Total parcel bank items kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total parcel bank items']")).isDisplayed());
        extentTest.pass("Total parcel bank item alanının olduğu doğrulanmıştır.");
//15_Total payment request kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total payment request']")).isDisplayed());
        extentTest.pass("Total payment request alanının olduğu doğrulanmıştır.");
        //16_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

        //17_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
        //18_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");
    }
}
