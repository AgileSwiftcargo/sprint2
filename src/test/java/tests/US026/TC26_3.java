package tests.US026;

import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC26_3 extends CrossTestBaseRapor{
Locator locator;
@Test
    public  void bankaLogosuGoruntuleme(){

    extentTest = extentReports.createTest("banka logoso görüntüleme testi" ,
            "banka logosu görünür olmalı");

    driver.get(ConfigReader.getProperty("Url"));
    extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");

    locator = new Locator();
    locator.loginButonu.click();
    extentTest.info("Merchant login butonuna tıkalar");

    locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantBusraGecerliMail"));
    extentTest.info("Geçerli bir email girer");

    locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantBusraGecerliPassword"));
    extentTest.info("Geçerli bir password girer");

    locator.signInButton.click();
    extentTest.info("Sing in butonuna tiklar");


    //menüde Accounts butonuna tıklar
    locator.accountLinki.click();
    locator.payOutLinki.click();
    extentTest.info("banka logosunu  görür");








}









}
