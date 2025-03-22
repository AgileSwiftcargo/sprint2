package tests.US002;

import org.openqa.selenium.By;
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

        extentTest = extentReports.createTest("Anasayfa Menu Basliklari UI Testi",
                "Menü başlıkları mantıklı bir sırada olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        String[] navBarTexts = {"Home", "Pricing", "Tracking", "Blogs", "About", "FAQ", "Contact"};

        // Locate all nav-links
        List<WebElement> navLinks = driver.findElements(By.xpath("//*[contains(@class, 'nav-link')]"));

        // Validate each nav-link text
        for (int i = 0; i < navBarTexts.length; i++) {
            Assert.assertEquals(navLinks.get(i).getText(), navBarTexts[i],
                    "Text mismatch at index " + (i + 1));
        }
        extentTest.pass("Basliklarin sirali olup olmadigini kontrol eder");

        locator.navHome.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");

        locator.navPricing.click();
        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).perform(); // Scroll to the top
        ReusableMethods.bekle(1);
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/#pricing");

        locator.navTracking.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking");

        locator.navBlogs.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");

        locator.navAbout.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/about-us");

        locator.navFAQ.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");

        locator.navContact.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/contact-send");

        extentTest.pass("Her basliga tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(1);

        extentTest.info("Sayfayi Kapatir");

    }
}
