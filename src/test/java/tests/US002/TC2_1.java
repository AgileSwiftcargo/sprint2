package tests.US002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.util.List;

public class TC2_1 extends CrossTestBaseRapor {

    @Test
    public void AnasayfaHeader(){

        Locator locator = new Locator();

    extentTest = extentReports.createTest("Anasayfa Header Testi",
            "Header Kismi ve Navigasyon Bari Olmali");

    driver.get(ConfigReader.getProperty("Url"));
    Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
    extentTest.pass("Kullanici Anasayfaya gider");

    Assert.assertTrue(locator.navBar.isDisplayed());
    extentTest.pass("Header kisminin oldugunu dogrular");

        List<WebElement> navLinks = driver.findElements(By.xpath("//*[contains(@class, 'nav-link')]"));

// Loop through all the nav-link elements and verify if each is displayed
        for (int i = 0; i < navLinks.size(); i++) {
            Assert.assertTrue(navLinks.get(i).isDisplayed(), "Nav link at index " + (i + 1) + " is not displayed.");
        }
    extentTest.pass("Menu basliklarinin gorundugunu dogrular");

    ReusableMethods.bekle(1);
    extentTest.info("Sayfayi Kapatir");

}
}
