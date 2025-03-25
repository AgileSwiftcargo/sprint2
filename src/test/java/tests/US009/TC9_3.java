package tests.US009;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC9_3 extends CrossTestBaseRapor{

    @Test
    public void referansFirmlariTesti(){

        extentTest = extentReports.createTest("Anasayfadaki Referans Firmalarını Görüntüleme Testi",
                "Anasayfa Firmaları Erişilebilir ve Görüntülenebilir olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");
        String agileSwiftHandle = driver.getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2400)");
        extentTest.info("Kullanıcı Anasayfayı Referans Firmaları Menüsüne Kaydırır");

        ReusableMethods.bekle(1);

        WebElement elementTarget = driver.findElement(By.xpath("(//*[@Class='partner-logo'])[6]"));
        extentTest.info("Target İkonuna Tıklar ve Target Anasayfasına Gider");

        js.executeScript("arguments[0].click();", elementTarget);

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        String expectedTargetUrl = "www.target.com";
        String targetHandle = driver.getWindowHandle();
        String actualTargetUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualTargetUrl.contains(expectedTargetUrl));
        extentTest.pass("Target Sayfasının Görüntülendiğini Doğrular");

        driver.switchTo().window(targetHandle).close();
        extentTest.info("Target Window'unu Kapatır");

        driver.switchTo().window(agileSwiftHandle);
        extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementShopify = driver.findElement(By.xpath("(//*[@Class='partner-logo'])[7]"));
        extentTest.info("Shopify İkonuna Tıklar ve Shopify Anasayfasına Gider");

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementShopify);

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }


        String expectedShopifyUrl = "www.shopify.com";
        String shopifyHandle = driver.getWindowHandle();
        String actualUrlShopify = driver.getCurrentUrl();


        Assert.assertTrue(actualUrlShopify.contains(expectedShopifyUrl));
        extentTest.pass("Shopify Sayfasının Görüntülendiğini Doğrular");


        driver.switchTo().window(shopifyHandle).close();
        extentTest.info("Shopify Window'unu Kapatır");

        driver.switchTo().window(agileSwiftHandle);
        extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementHomedepot = driver.findElement(By.xpath("(//*[@Class='partner-logo'])[8]"));
        extentTest.info("Homedepot İkonuna Tıklar ve Homedepot Anasayfasına Gider");

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementHomedepot);

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }


        String expectedHomedepotUrl = "www.homedepot.com";
        String actualHomedepotUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualHomedepotUrl.contains(expectedHomedepotUrl));
        extentTest.pass("Homedopot Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
