package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_8 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardFilter(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Merchant Dashboard Filter Testi",
                "Filtre fonksiyonlarının çalıştığı test edilir.");


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
//4_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
//5_Today butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Today']")).click();

//6_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();

//7_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();

//8_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
//9_Yesterday butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Yesterday']")).click();

//10_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
//11_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
//12_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
//13_Last 7 Days butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Last 7 Days']")).click();

//14_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
//15_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
//16_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
//17_Last 30 Days butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Last 30 Days']")).click();

//18_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
//19_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
//20_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
//21_This Month Days butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='This Month']")).click();
//22_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
//23_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
//24_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
//25_Last Month butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Last Month']")).click();
//26_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
//27_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
//28_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
//29_Custom Range butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Custom Range']")).click();
//30_Takvimden tarih aralığı seçilir.
//31_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
//32_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        //33_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //34_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //35_Sayfa kapatılır.


    }
}
