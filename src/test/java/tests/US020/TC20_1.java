package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_1 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboard(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Merchant Dashboard",
                "Merchant Dashboard'a erişildiğinin testi");


    //1_Login sayfası açılır.
        driver.get(ConfigReader.getProperty("LoginUrl"));

    //2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.
        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));
    //3_Sign in butonuna tıklanır. Merchant Dashboard'a eriştiğini doğrular.
        locator.signInButton.click();
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);

    //4_Kullanıcı headerdaki profile resmine tıklar
        locator.merchantProfileMenu.click();

    //5_Açılan menüden logout butonuna tıkla
        locator.merchantLogoutButton.click();
    //6_Sayfa kapatılır.
    }
}
