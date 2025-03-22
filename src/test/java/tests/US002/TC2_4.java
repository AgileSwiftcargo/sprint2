package tests.US002;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC2_4 extends CrossTestBaseRapor {

    @Test
    public void MenuBasliklariTiklama(){

        Locator locator = new Locator();

        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Menu Basliklari Tiklama Testi",
                "Kullanıcı bir menü başlığına tıkladığında, ilgili sayfaya yönlendirilmeli.");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.pass("Anasayfaya gider");

        locator.navHome.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");

        locator.navPricing.click();
        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).perform(); // Scroll to the top
        ReusableMethods.bekle(1);
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/#pricing");
        extentTest.pass("Pricing basligina tiklar");

        locator.navTracking.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking");
        extentTest.pass("Tracking basligina tiklar");

        locator.navBlogs.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs basligina tiklar");

        locator.navAbout.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/about-us");
        extentTest.pass("About Us basligina tiklar");

        locator.navFAQ.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
        extentTest.pass("FAQ basligina tiklar");

        locator.navContact.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Contact basligina tiklar");

        ReusableMethods.bekle(1);

        extentTest.info("Sayfayi Kapatir");

        softAssert.assertAll();
    }
}
