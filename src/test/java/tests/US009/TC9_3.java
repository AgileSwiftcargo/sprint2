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

public class TC9_3 {

    @Test
    public void referansFirmlariTesti(){

        //extentTest = extentReports.createTest("Anasayfadaki Referans Firmalarını Görüntüleme Testi",
              //  "Anasayfa Firmaları Erişilebilir ve Görüntülenebilir olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        //extentTest.info("Kullanıcı Anasayfaya Gider");
        String agileSwiftHandle = Driver.getDriver().getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2400)");
        //extentTest.info("Kullanıcı Anasayfayı Referans Firmaları Menüsüne Kaydırır");

        ReusableMethods.bekle(1);

        WebElement elementTarget = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[6]"));
        //extentTest.info("Target İkonuna Tıklar ve Target Anasayfasına Gider");

        js.executeScript("arguments[0].click();", elementTarget);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }

        String expectedTargetUrl = "www.target.com";
        String targetHandle = Driver.getDriver().getWindowHandle();
        String actualTargetUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualTargetUrl.contains(expectedTargetUrl));
        //extentTest.pass("Target Sayfasının Görüntülendiğini Doğrular");

        Driver.getDriver().switchTo().window(targetHandle).close();
        //extentTest.info("Target Window'unu Kapatır");

        Driver.getDriver().switchTo().window(agileSwiftHandle);
        //extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementShopify = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[7]"));
        //extentTest.info("Shopify İkonuna Tıklar ve Shopify Anasayfasına Gider");

        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", elementShopify);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }


        String expectedShopifyUrl = "www.shopify.com";
        String shopifyHandle = Driver.getDriver().getWindowHandle();
        String actualUrlShopify = Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(actualUrlShopify.contains(expectedShopifyUrl));
        //extentTest.pass("Shopify Sayfasının Görüntülendiğini Doğrular");


        Driver.getDriver().switchTo().window(shopifyHandle).close();
        //extentTest.info("Shopify Window'unu Kapatır");

        Driver.getDriver().switchTo().window(agileSwiftHandle);
        //extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementHomedepot = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[8]"));
        //extentTest.info("Homedepot İkonuna Tıklar ve Homedepot Anasayfasına Gider");

        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", elementHomedepot);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }


        String expectedHomedepotUrl = "www.homedepot.com";
        String actualHomedepotUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualHomedepotUrl.contains(expectedHomedepotUrl));
        //extentTest.pass("Homedopot Sayfasının Görüntülendiğini Doğrular");

        //extentTest.info("Sayfayı Kapatır");

    }
}
