package tests.US002;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;


public class TC2_5 extends CrossTestBaseRapor {


    @Test
    public void FarkliEkranBoyutuTesti(){

        Locator locator = new Locator();

        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(driver);

        extentTest = extentReports.createTest("Menu Basliklari Farkli Ekran Boyutu Testi",
                "Menü başlıkları farkli ekran boyutlarinda da düzgün çalışmalı.");

        driver.get(ConfigReader.getProperty("Url"));
        softAssert.assertEquals(driver.getCurrentUrl(), ConfigReader.getProperty("Url"));
        extentTest.pass("Anasayfaya gider");

        driver.manage().window().setSize(new Dimension(500, 800));
        softAssert.assertEquals(driver.manage().window().getSize().height, 800);
        extentTest.pass("Pencere boyutunu degistirir");

        locator.navToggler.click();
        extentTest.pass("Navigation Bar Toggler tiklar");

        locator.navHome.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");

        locator.navToggler.click();
        locator.navPricing.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.HOME).perform(); // Scroll to the top
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/#pricing");
        extentTest.pass("Pricing basligina tiklar");

        locator.navToggler.click();
        locator.navTracking.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking");
        extentTest.pass("Tracking basligina tiklar");

        locator.navToggler.click();
        locator.navBlogs.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs basligina tiklar");

        locator.navToggler.click();
        locator.navAbout.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/about-us");
        extentTest.pass("About Us basligina tiklar");

        locator.navToggler.click();
        locator.navFAQ.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
        extentTest.pass("FAQ basligina tiklar");

        locator.navToggler.click();
        locator.navContact.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Contact basligina tiklar");

        ReusableMethods.bekle(1);

        extentTest.info("Sayfayi Kapatir");

        softAssert.assertAll();

    }
}
