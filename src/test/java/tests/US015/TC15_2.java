package tests.US015;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Busra;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC15_2 extends CrossTestBaseRapor {
Locator locator;
   @Test
   public void ilgiliBaslıgIGorunulemek() {
     Locator locator = new Locator();
     SoftAssert softAssert = new SoftAssert();

     extentTest = extentReports.createTest("İlgili başlığa tıklama testi",
         "Başlıklara tıklandığında doğru sayfa açılmalı");

       // kullanıcı anasayfaya gider
       driver.get(ConfigReader.getProperty("Url"));
       extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", locator.AvailableServicesBaşlığı);
       ReusableMethods.bekle(1);



       //kullanıcı "Available services" başlığını görür
      softAssert.assertTrue(locator.AvailableServicesBaşlığı.isDisplayed());
      extentTest.info("AvailableServices Başlığı Görünür");



       extentTest.info("Sayfayı kapatır");





   }
















}
