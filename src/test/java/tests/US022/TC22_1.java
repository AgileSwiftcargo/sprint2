package tests.US022;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC22_1 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void gelirSayfasinaErisimTesti (){
        extentTest = extentReports.createTest("Merchant Gelir Verileri Sayfasina Erisim Testi",
                "Merchant, menüde gelir bağlantılarını görüntülemeli");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        //Merchant gecerli bir e'mail ve geçerli bir password ile login olur
        locator = new Locator();

        locator.loginButonu.click();
        extentTest.info("Merchant login butonuna tiklar gider");

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantFurkanGecerliMail"));
        extentTest.info("Geçerli bir email girer");

        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantFurkanGecerliPassword"));
        extentTest.info("Geçerli bir password girer");

        locator.signInButton.click();
        extentTest.info("Sing in butonuna tiklar");


        //Menüde gelir bağlantısını görüntüler.
        Assert.assertTrue(locator.reportsMenuInput.isDisplayed());
        extentTest.pass("Menüde gelir verileri bağlantısı görüntülenir");




        //Merchant logout olur
        locator.profilResmi.click();
        locator.loguotButonu.click();
        extentTest.info("Logout olur");

        extentTest.info("sayfayi kapatir");






    }

}
