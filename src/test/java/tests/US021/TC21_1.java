package tests.US021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC21_1 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void ticketSayfasinaErisimTesti (){
        extentTest = extentReports.createTest("Merchant Ticket Sayfasina Erisim Testi",
                "Merchant, menüde ticket bağlantısını görüntülemeli ve tıklandığında doğru bağlantı açılmalı");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        //Merchant gecerli bir e'mail ve geçerli bir password ile login olur
        locator = new Locator();

        locator.loginButonu.click();
        extentTest.info("Merchant login butonuna tiklar gider");

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantKeremGecerliMail"));
        extentTest.info("Geçerli bir email girer");

        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantKeremGecerliPassword"));
        extentTest.info("Geçerli bir password girer");

        locator.signInButton.click();
        extentTest.info("Sing in butonuna tiklar");


        //Menüde ticket bağlantısına görüntüler ve tıklar.
        Assert.assertTrue(locator.ticketLinki.isDisplayed());
        extentTest.pass("Menüde ticket bağlantısı görüntülenir");

        locator.ticketLinki.click();
        WebElement ticketTitleYaziElementi = driver.findElement(By.className("h3"));
        String expectedtTitle = "Ticket";
        String actualTitle = ticketTitleYaziElementi.getText();
        Assert.assertEquals(actualTitle,expectedtTitle);
        extentTest.pass("Merchant basarili bir sekilde ticket baglantisina yönlendilir");


        //Merchant logout olur
        locator.profilResmi.click();
        locator.loguotButonu.click();
        extentTest.info("Logout olur");

        extentTest.info("sayfayi kapatir");






    }

}
