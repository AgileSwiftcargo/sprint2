package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_7 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardFilter(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Merchant Dashboard Filter Testi",
                "Filtre fonksiyonlarının çalıştığı test edilir.");

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
//4_Enter date textboxının olduğu doğrulanır.

        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());

//5_Filter butonunun olduğu doğrulanır.

        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());

        //10_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

        //11_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        //12_Sayfa kapatılır.

    }

}
