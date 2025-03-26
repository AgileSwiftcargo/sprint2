package tests.US016;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC16_1 extends CrossTestBaseRapor {

    @Test
    public void SubscribeUsAlaniGoruntulemeTesti(){

        extentTest = extentReports.createTest("SubscribeUs Alanı Görüntüleme Testi",
                "Footer Kismi  Olmali");

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        // Sayfanın footer kısmına kadar kaydır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = driver.findElement(By.xpath("/html/body/footer[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);

        // Bekleme süresi
        try {
            Thread.sleep(1000); // Scroll işleminin tamamlanması için bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Footer menüsündeki Subscribe bölümünü kontrolet
        WebElement subsribe = driver.findElement(By.xpath("//*[.='Subscribe Us']"));
        if (subsribe.isDisplayed()) {
            System.out.println("Subscribe Us  başarıyla görüntülendi.");
        } else {
            System.out.println("Subscribe Us görüntülenemedi.");
        }

        Assert.assertTrue(driver.findElement(By.xpath(("/html/body/footer[1]"))).isDisplayed());
        extentTest.pass("Footer kisminin oldugunu dogrular");

        driver.findElement(By.xpath(("//*[.='Subscribe Us']"))).isDisplayed();
        extentTest.pass("Subsribe alanının  gorundugunu dogrular");

        extentTest.info("Sayfayi Kapatir");

    }
}

