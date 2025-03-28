package tests.US015;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC15_4 extends CrossTestBaseRapor {


@Test
public void iletisimBilgileri(){

    Locator locator = new Locator();
    SoftAssert softAssert = new SoftAssert();

    extentTest = extentReports.createTest("iletişim bilgileri testi",
            "kullanıcı iletişim bilgilerine ulaşmalı");


    driver.get(ConfigReader.getProperty("Url"));
    extentTest.info("Anasayfaya gider");


    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", locator.ContactUsButonu);
    ReusableMethods.bekle(1);


    softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class,'list-ite')])[7]");
    extentTest.info("ilgili sayfa açılır");

    locator.ContactUsButonu.click();
    ReusableMethods.bekle(1);






}












}
