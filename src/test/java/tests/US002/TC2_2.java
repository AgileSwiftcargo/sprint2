package tests.US002;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.util.List;

public class TC2_2 extends CrossTestBaseRapor {

    @Test
    public void AnasayfaMenuBasliklari(){

        Locator locator = new Locator();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        extentTest = extentReports.createTest("Anasayfa Menu Basliklari UI Testi",
                "Menü başlıkları mantıklı bir sırada olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        String[] navBarTexts = {"Home", "Pricing", "Tracking", "Blogs", "About", "FAQ", "Contact", "Login"};

        // Locate all nav-links
        List<WebElement> navLinks = driver.findElements(By.xpath("//*[contains(@class, 'nav-link')]"));

        // Validate each nav-link text
        for (int i = 0; i < navBarTexts.length; i++) {
            Assert.assertEquals(navLinks.get(i).getText(), navBarTexts[i],
                    "Text mismatch at index " + (i + 1));
        }
        extentTest.pass("Basliklarin sirali olup olmadigini kontrol eder");

        locator.navHome.click();

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Home basligina tiklar ve URL'yi kontrol eder");

        locator.navPricing.click();

        ReusableMethods.bekle(2);
        locator.NextDayButonu.click();
        ReusableMethods.bekle(2);
        locator.SubCityButonu.click();
        ReusableMethods.bekle(2);
        locator.OutsideCityButonu.click();
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/#pricing");
        extentTest.pass("Pricing basligina tiklar ve URL'yi kontrol eder");

        locator.navTracking.click();

        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking");
        extentTest.pass("Tracking basligina tiklar ve URL'yi kontrol eder");

        locator.navBlogs.click();

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs basligina tiklar ve URL'yi kontrol eder");

        locator.blogsYaziGirisi.click();

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        locator.navAbout.click();

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/about-us");
        extentTest.pass("About basligina tiklar ve URL'yi kontrol eder");

        locator.navFAQ.click();

        ReusableMethods.bekle(2);
        locator.faqBirinciSoru.click();
        ReusableMethods.bekle(2);
        locator.faqikinciSoru.click();
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
        extentTest.pass("FAQ basligina tiklar ve URL'yi kontrol eder");

        locator.navContact.click();

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Contact basligina tiklar ve URL'yi kontrol eder");

        locator.loginButonu.click();
        ReusableMethods.bekle(2);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
        extentTest.pass("Login basligina tiklar ve URL'yi kontrol eder");

        driver.navigate().back();
        locator.registerButonu.click();
        ReusableMethods.bekle(3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/merchant/sign-up");
        extentTest.pass("Register basligina tiklar ve URL'yi kontrol eder");

        extentTest.info("Sayfayi Kapatir");

    }
}
