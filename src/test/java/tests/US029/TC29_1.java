package tests.US029;

import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC29_1 extends CrossTestBaseRapor {
Locator locator;
@Test
public void ucretlendirmeSayfasındaBaslıkGorebilmeTesti(){

    extentTest = extentReports.createTest("Ücretlendirme sayfasını görüntüleyebilme testi",
            "Kullanıcı ücretlendirme sayfasını görüntüleyebilmelidir");

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











}











}
