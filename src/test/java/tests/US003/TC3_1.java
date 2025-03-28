package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC3_1 extends CrossTestBaseRapor{

  @Test

    public void AnasayfaHeader( ){

      extentTest = extentReports.createTest("Anasayfa Header testi",
              "Kaydol sekmesi");
      driver.get(ConfigReader.getProperty("Url"));
      Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
      extentTest.pass("kullanıcı ana sayfaya gider");


    ReusableMethods.bekle(3);


    Locator locator = new Locator();
        locator.registerButonu.click();
    Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/merchant/sign-up");
    extentTest.pass("Kayit olma sayfasina gider");

      extentTest.info("sayfayı kapatır");

  }




}
