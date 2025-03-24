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

public class TC9_1 extends CrossTestBaseRapor {

    @Test
    public void referansFirmlariTesti() {

        extentTest = extentReports.createTest("Anasayfadaki Referans Firmalarını Görüntüleme Testi",
                "Anasayfa Firmaları Erişilebilir ve Görüntülenebilir olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        String agileSwiftHandle = Driver.getDriver().getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2400)");
        extentTest.info("Kullanıcı Anasayfayı Referans Firmaları Menüsüne Kaydırır");

        ReusableMethods.bekle(1);

        WebElement elementAlibaba = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[1]"));
        extentTest.info("Alibaba İkonuna Tıklar ve Alibaba Anasayfasına Gider");

        js.executeScript("arguments[0].click();", elementAlibaba);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }

        String expectedUrl = "www.alibaba.com";
        String alibabaHandle = Driver.getDriver().getWindowHandle();
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        extentTest.pass("Alibaba Sayfasının Görüntülendiğini Doğrular");

        Driver.getDriver().switchTo().window(alibabaHandle).close();
        extentTest.info("Alibaba Window'unu Kapatır");
        Driver.getDriver().switchTo().window(agileSwiftHandle);
        extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementAmazon = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[2]"));
        extentTest.info("Amazon İkonuna Tıklar ve Amazon Anasayfasına Gider");
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", elementAmazon);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }


        String expecteAmazondUrl = "www.amazon.com";
        String actualUrlAmazon = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
        extentTest.pass("Amazon Sayfasının Görüntülendiğini Doğrular");


        extentTest.info("Sayfayı Kapatır");
    }
    }
