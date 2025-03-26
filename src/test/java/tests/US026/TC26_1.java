package tests.US026;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC26_1 extends CrossTestBaseRapor {
Locator locator ;
@Test
public void bankalarıGorutulemek(){

    extentTest = extentReports.createTest("kullanılan bankaları görüntüleyebilme testi," ,
            "kullanıcı bankalbilgilerine ulaşabilmeli ");

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
    extentTest.info("banka bilgilerini görür");








}













}
