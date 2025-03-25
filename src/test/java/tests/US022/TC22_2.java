package tests.US022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import java.util.List;

public class TC22_2 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void gelirButonlarinaErisimTesti (){
        extentTest = extentReports.createTest("Merchant Gelir Verileri Sayfasina Erisim Testi",
                "Merchant, menüde gelir bağlantılarını görüntülemeli ve tıklandığında doğru bağlantı açılmalı");

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
        //Assert.assertTrue(locator.reportsMenuInput.isDisplayed());
        //extentTest.pass("Menüde gelir verileri bağlantısı görüntülenir");
        locator.reportsMenuInput.click();

        List<WebElement> navLinks = driver.findElements(By.xpath("//*[@id='reports']/ul/li"));

        for (WebElement button : navLinks) {
            WebElement aTag = button.findElement(By.tagName("a"));
            System.out.println(aTag.getText());
        }



        //Merchant logout olur
        locator.profilResmi.click();
        locator.loguotButonu.click();
        extentTest.info("Logout olur");

        extentTest.info("sayfayi kapatir");






    }

}
