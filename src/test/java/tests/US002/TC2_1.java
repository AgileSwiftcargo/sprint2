package tests.US002;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC2_1 extends CrossTestBaseRapor {

    @Test
    public void AnasayfaHeader(){

    extentTest = extentReports.createTest("Anasayfa Header Testi",
            "Header Kismi ve Navigasyon Bari Olmali");

    driver.get(ConfigReader.getProperty("Url"));
    Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
    extentTest.pass("Kullanici Anasayfaya gider");

    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'navbar')])[1]")).isDisplayed());
    extentTest.pass("Header kisminin oldugunu dogrular");

    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[1]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[2]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[3]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[4]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[5]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[6]")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[7]")).isDisplayed());
    extentTest.pass("Menu basliklarinin gorundugunu dogrular");

    ReusableMethods.bekle(1);
    extentTest.info("Sayfayi Kapatir");

}
}
