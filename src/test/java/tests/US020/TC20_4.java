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

//2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));

//3_Sign in butonuna tıklanır.

        locator.signInButton.click();
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);

        ReusableMethods.bekle(2);

//4_Total sales amount kısmının olduğu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total sales amount ']")).isDisplayed());

//5_Total delivery fees paid kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total delivery fees paid']")).isDisplayed());

//6_Total Vat Amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total Vat Amount']")).isDisplayed());

//7_ Net profit amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Net profit amount']")).isDisplayed());

//8_Current Balance kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Current Balance']")).isDisplayed());

//9_Opening Balance kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Opening Balance']")).isDisplayed());

//10_Vat kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Vat']")).isDisplayed());

//11_Payment processing kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Payment processing']")).isDisplayed());

//12_Paid amount kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Paid amount']")).isDisplayed());

//13_Total shop kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total shop']")).isDisplayed());

//14_Total parcel bank items kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total parcel bank items']")).isDisplayed());

//15_Total payment request kısmının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//h5[.='Total payment request']")).isDisplayed());

        //16_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //17_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //18_Sayfa kapatılır.

    }
}
