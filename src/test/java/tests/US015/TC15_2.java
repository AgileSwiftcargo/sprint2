package tests.US015;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Busra;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC15_2 extends CrossTestBaseRapor {
Busra busra ;
   @Test
   public void ilgiliBaslıgatıklama() {
     Locator locator = new Locator();
     SoftAssert softAssert = new SoftAssert();

     extentTest = extentReports.createTest("İlgili başlığa tıklama testi",


       "Başlıklara tıklandığında doğru sayfa açılmalı");

       // kullanıcı anasayfaya gider
       Driver.getDriver().get(ConfigReader.getProperty("Url"));
       extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


       //kullanıcı "Available services" başlığını görür


       String expectedYazi = "Available Services";
       String actualYazi= locator.AvailableServicesBaşlığı.getText();

     
       Assert.assertEquals(actualYazi,expectedYazi);
       extentTest.pass("Başlığı görüntüler");

      //"E-Commerce delivery","Pick & Drop","Packageing",
       //"Warehousing" başlıklarına tıklar

      softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class,'list-ite')])[1]");
      extentTest.pass("ilgili sayfa açılır");

       softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class,'list-ite')])[2]");
       extentTest.pass("ilgili sayfa açılır");

       softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class,'list-ite')])[3]");
       extentTest.pass("ilgili sayfa açılır");

       softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class,'list-ite')])[4]");
       extentTest.pass("ilgili sayfa açılır");


       extentTest.info("Sayfayı kapatır");




   }
















}
