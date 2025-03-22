package tests.US003;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC3_1 extends CrossTestBaseRapor{

  @Test

    public void AnasayfaHeader( ){

      extentTest = extentReports.createTest("Anasayfa Header testi",
              "Kaydol sekmesi");
      driver.get(ConfigReader.getProperty("Url"));
      Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
      extentTest.pass("kullanıcı ana sayfaya gider");

      extentTest.info("sayfayı kapatır");

  }




}
