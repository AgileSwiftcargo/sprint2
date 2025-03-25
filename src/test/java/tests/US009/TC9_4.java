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

public class TC9_4 extends CrossTestBaseRapor {

    @Test
    public void referansFirmlariTesti() {

        extentTest = extentReports.createTest("Anasayfadaki Referans Firmalarını Görüntüleme Testi",
                "Anasayfa Firmaları Erişilebilir ve Görüntülenebilir olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        String agileSwiftHandle = driver.getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2400)");
        extentTest.info("Kullanıcı Anasayfayı Referans Firmaları Menüsüne Kaydırır");

        ReusableMethods.bekle(1);

        WebElement elementAlibaba = driver.findElement(By.xpath("(//*[@Class='partner-logo'])[9]"));
        extentTest.info("Dell İkonuna Tıklar ve Dell Anasayfasına Gider");

        js.executeScript("arguments[0].click();", elementAlibaba);

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        String expectedDellUrl = "www.dell.com";
        String dellHandle = driver.getWindowHandle();
        String actualDellUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualDellUrl.contains(expectedDellUrl));
        extentTest.pass("Dell Sayfasının Görüntülendiğini Doğrular");

        driver.switchTo().window(dellHandle).close();
        extentTest.info("Dell Window'unu Kapatır");
        driver.switchTo().window(agileSwiftHandle);
        extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementAmazon = driver.findElement(By.xpath("(//*[@Class='partner-logo'])[10]"));
        extentTest.info("Walmart İkonuna Tıklar ve Walmart Anasayfasına Gider");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementAmazon);

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        String expectedWalmartdUrl = "www.walmart.com";
        String actualUrlWalmart = driver.getCurrentUrl();

        Assert.assertTrue(actualUrlWalmart.contains(expectedWalmartdUrl));
        extentTest.pass("Walmart Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");
    }
}
