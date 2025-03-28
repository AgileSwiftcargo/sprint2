package tests.US026;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC26_2 extends CrossTestBaseRapor {
Locator locator = new Locator();
@Test
    public void detaylıodemebilgisigoruntuleme(){
    SoftAssert softAssert = new SoftAssert();


    extentTest = extentReports.createTest("detaylı ödeme görüntüleyebilme testi," ,
            "kullanıcı detaylı ödeme bilgilerine  ulaşabilmeli ");

    locator = new Locator();

    locator.loginButonu.click();
    extentTest.info("login olundu");

    locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantBusraGecerliMail"));
    extentTest.info("Geçerli bir email girer");

    locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantBusraGecerliPassword"));
    extentTest.info("Geçerli bir password girer");

    locator.signInButton.click();
    extentTest.info("Sing in butonuna tiklar");

softAssert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/merchant/online-payment/stripe");
extentTest.pass("stripe logosunu görür");














}














}
