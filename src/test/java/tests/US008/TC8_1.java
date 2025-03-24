package tests.US008;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC8_1 extends CrossTestBaseRapor {

    @Test
    public void TestMemnuniyetVerileri(){

        extentTest = extentReports.createTest("Yoneticinin memnuniyet verilerini goruntuleme testi",
                "Ana sayfaya ulaşılmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici Anasayfaya gider");

        // Sayfanın Happy Achievement kısmına kadar kaydır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement happyachivement = driver.findElement(By.xpath("//*[.='Happy Achievement']"));
        js.executeScript("arguments[0].scrollIntoView(true);", happyachivement);

        // Bekleme süresi
        try {
            Thread.sleep(3000); // Scroll işleminin tamamlanması için bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath(("//*[.='Happy Achievement']"))).isDisplayed();
        extentTest.pass("Happy Achievement basliginin oldugunu dogrular");

        driver.findElement(By.xpath(("//*[.='Branches']"))).isDisplayed();
        extentTest.pass("Branches alanini goruntuler");

        driver.findElement(By.xpath(("//*[.='Parcel Delivered']"))).isDisplayed();
        extentTest.pass("Parcel Delivered alanini goruntuler");

        driver.findElement(By.xpath(("//*[.='Happy Merchant']"))).isDisplayed();
        extentTest.pass("Happy Merchant alanini goruntuler");

        driver.findElement(By.xpath(("//*[.='Positive Reviews']"))).isDisplayed();
        extentTest.pass("Positive Reviews alanini goruntuler");



        extentTest.info("Sayfayi Kapatir");

    }

    }
