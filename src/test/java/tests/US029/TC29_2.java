package tests.US029;

import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC29_2 extends CrossTestBaseRapor {
Locator locator;
@Test
public void ucretlendirmeSayfasınıGoruntuleme(){

extentTest = extentReports.createTest("Ücretlendirme sayfasını görüntüleme teswti",
        "Kullanıcı ücretlendirme sayfasını görüntülemeli");
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

    locator.settingsLinki.click();
    locator.DeliveryChargesButonu.click();
    extentTest.info("ilgili sayfayı görür");










}










}
