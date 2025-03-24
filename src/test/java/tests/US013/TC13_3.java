package tests.US013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC13_3 extends CrossTestBaseRapor {

    @Test
    public void appStoreButonuBaglantiTesti (){

        extentTest = extentReports.createTest("App Store Butonu Bulunması ve Bağlantı Testi",
                "Kullanici app store butonunu görüntülemeli ve tıkladığında doğru bağlantı açılmalı");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        // Google Play butonu görünürlüğü testi ve bağlantı doğrulama
        WebElement appStoreButonu =
                driver.findElement(By.xpath("//*[@class='fa-brands fa-app-store-ios']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(appStoreButonu).perform();

        Assert.assertTrue(appStoreButonu.isDisplayed());
        extentTest.pass("Kullanıcı app store butonunu görüntüler");

        appStoreButonu.click();
        String expectedUrl = "https://www.apple.com/app-store/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Kullanıcı app sotre sayfasına yönlendirilir");

        extentTest.info("sayfayi kapatir");


    }
}
