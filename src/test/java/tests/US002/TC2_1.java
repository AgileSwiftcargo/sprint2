package tests.US002;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC2_1 extends CrossTestBaseRapor {

    @Test
    public void AnasayfaHeader(){

    extentTest = extentReports.createTest("Anasayfa Header Testi",
            "Header Kismi ve Navigasyon Bari Olmali");

    driver.get(ConfigReader.getProperty("Url"));
    Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
    extentTest.pass("Kullanici Anasayfaya gider");

    Assert.assertTrue(driver.findElement(By.xpath(("(//*[contains(@class, 'navbar')])[1]"))).isDisplayed());
    extentTest.pass("Header kisminin oldugunu dogrular");

    driver.findElement(By.xpath(("(//*[contains(@class, 'nav-link')])[1]"))).isDisplayed();
    extentTest.pass("Menu basliklarinin gorundugunu dogrular");

    extentTest.info("Sayfayi Kapatir");

}
}
