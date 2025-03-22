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

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        String agileSwiftHandle = Driver.getDriver().getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2400)");
        extentTest.info("Kullanıcı Anasayfayı Referans Firmaları Menüsüne Kaydırır");

        ReusableMethods.bekle(1);

        WebElement elementAlibaba = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[9]"));
        extentTest.info("Dell İkonuna Tıklar ve Dell Anasayfasına Gider");

        js.executeScript("arguments[0].click();", elementAlibaba);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }

        String expectedDellUrl = "www.dell.com";
        String dellHandle = Driver.getDriver().getWindowHandle();
        String actualDellUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualDellUrl.contains(expectedDellUrl));
        extentTest.pass("Dell Sayfasının Görüntülendiğini Doğrular");

        Driver.getDriver().switchTo().window(dellHandle).close();
        extentTest.info("Dell Window'unu Kapatır");
        Driver.getDriver().switchTo().window(agileSwiftHandle);
        extentTest.info("Anasayfaya Window'una Geri Döner");

        ReusableMethods.bekle(1);

        WebElement elementAmazon = Driver.getDriver().findElement(By.xpath("(//*[@Class='partner-logo'])[10]"));
        extentTest.info("Walmart İkonuna Tıklar ve Walmart Anasayfasına Gider");
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", elementAmazon);

        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(windowHandle);
        }

        String expectedWalmartdUrl = "www.walmart.com";
        String actualUrlWalmart = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrlWalmart.contains(expectedWalmartdUrl));
        extentTest.pass("Walmart Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");
    }
}
