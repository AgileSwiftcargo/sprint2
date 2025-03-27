package tests.US015;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC15_5 extends CrossTestBaseRapor {
@Test
    public void sayfaylailgilibilgialma(){

    Locator locator = new Locator();
    SoftAssert softAssert = new SoftAssert();


    extentTest = extentReports.createTest("sayfayla ilgili bilgi alma testi",
            "Kullanıcı siteyle ilgili misyonu,vizyonuyla ilgili" +
                    "bilgi alabilmesli");

    driver.get(ConfigReader.getProperty("Url"));
    extentTest.info("Anasayfaya gider");


    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", locator.AboutUsButonu);
    ReusableMethods.bekle(1);

    softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class,'list-ite')])[6]");
    extentTest.info("ilgili sayfa açılır");

    locator.AboutUsButonu.click();
    ReusableMethods.bekle(1);







}








}
