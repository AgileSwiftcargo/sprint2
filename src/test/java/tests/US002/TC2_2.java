package tests.US002;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC2_2 extends CrossTestBaseRapor {

    @Test
    public void AnasayfaMenuBasliklari(){

        extentTest = extentReports.createTest("Anasayfa Menu Basliklari UI Testi",
                "Menü başlıkları mantıklı bir sırada olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[1]")).getText(), "Home");
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[2]")).getText(), "Pricing");
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[3]")).getText(), "Tracking");
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[4]")).getText(), "Blogs");
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[5]")).getText(), "About");
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[6]")).getText(), "FAQ");
        Assert.assertEquals(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[7]")).getText(), "Contact");
        extentTest.pass("Basliklarin sirali olup olmadigini kontrol eder");

        driver.findElement(By.xpath("//a[.='Home']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        driver.findElement(By.xpath("//a[.='Pricing']")).click();
        ReusableMethods.bekle(1);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).perform(); // Scroll to the top
        ReusableMethods.bekle(1);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/#pricing");
        driver.findElement(By.xpath("//a[.='Tracking']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking");
        driver.findElement(By.xpath("//a[.='Blogs']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        driver.findElement(By.xpath("//a[.='About']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/about-us");
        driver.findElement(By.xpath("//a[.='FAQ']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
        driver.findElement(By.xpath("//a[.='Contact']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/contact-send");

        extentTest.pass("Her basliga tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(1);

        extentTest.info("Sayfayi Kapatir");

    }
}
