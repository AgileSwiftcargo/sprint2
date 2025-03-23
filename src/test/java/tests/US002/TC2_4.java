package tests.US002;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        extentTest.info("Anasayfaya gider");

        locator.navHome.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Home basligina tiklar ve URL'yi kontrol eder");

        locator.navPricing.click();
        // Sayfayi en Yukari kaldirir
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        ReusableMethods.bekle(1);
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/#pricing");
        extentTest.pass("Pricing basligina tiklar ve URL'yi kontrol eder");

        locator.navTracking.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking");
        extentTest.pass("Tracking basligina tiklar ve URL'yi kontrol eder");

        locator.navBlogs.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs basligina tiklar ve URL'yi kontrol eder");

        locator.navAbout.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/about-us");
        extentTest.pass("About Us basligina tiklar ve URL'yi kontrol eder");

        locator.navFAQ.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
        extentTest.pass("FAQ basligina tiklar ve URL'yi kontrol eder");

        locator.navContact.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Contact basligina tiklar ve URL'yi kontrol eder");

        locator.loginButonu.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
        extentTest.pass("Login basligina tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(1);

        extentTest.info("Sayfayi Kapatir");

        softAssert.assertAll();
    }
}
