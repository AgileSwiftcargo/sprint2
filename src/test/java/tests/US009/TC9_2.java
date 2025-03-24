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

public class TC9_2 extends CrossTestBaseRapor {

    @Test
    public void referansFirmlariTesti() {

        extentTest = extentReports.createTest("Anasayfadaki Referans Firmalarını Görüntüleme Testi",
                "Anasayfa Firmaları Erişilebilir ve Görüntülenebilir olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");
        String agileSwiftHandle = Driver.getDriver().getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2400)");
        extentTest.info("Kullanıcı Anasayfayı Referans Firmaları Menüsüne Kaydırır");

        ReusableMethods.bekle(1);

        WebElement elementEbay = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[3]"));
        extentTest.info("Ebay İkonuna Tıklar ve Ebay Anasayfasına Gider");

        js.executeScript("arguments[0].click();", elementEbay);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }

        String expectedEbayUrl = "www.ebay.com";
        String ebayHandle = Driver.getDriver().getWindowHandle();
        String actualEbayUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualEbayUrl.contains(expectedEbayUrl));
        extentTest.pass("Ebay Sayfasının Görüntülendiğini Doğrular");

        Driver.getDriver().switchTo().window(ebayHandle).close();
        extentTest.info("Ebay Window'unu Kapatır");

        Driver.getDriver().switchTo().window(agileSwiftHandle);
        extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementZulily = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[4]"));
        extentTest.info("Zulily İkonuna Tıklar ve Zulily Anasayfasına Gider");
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", elementZulily);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }


        String expectedZulilyUrl = "www.zulily.com";
        String zulilyHandle = Driver.getDriver().getWindowHandle();
        String actualUrlZulily = Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(actualUrlZulily.contains(expectedZulilyUrl));
        extentTest.pass("Zulily Sayfasının Görüntülendiğini Doğrular");


        Driver.getDriver().switchTo().window(zulilyHandle).close();
        extentTest.info("Zulily Window'unu Kapatır");

        Driver.getDriver().switchTo().window(agileSwiftHandle);
        extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementEtsy = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[5]"));
        extentTest.info("Etsy İkonuna Tıklar ve Etsy Anasayfasına Gider");
        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", elementEtsy);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }


        String expectedEtsyUrl = "www.etsy.com";
        String actualEtsyUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualEtsyUrl.contains(expectedEtsyUrl));
        extentTest.pass("Etsy Sayfasının Görüntülendiğini Doğrular");


        extentTest.info("Sayfayı Kapatır");

    }
}
