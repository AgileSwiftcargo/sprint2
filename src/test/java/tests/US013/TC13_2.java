package tests.US013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC13_2 extends CrossTestBaseRapor {

    @Test
    public void googlePlayButonuBaglantiTesti (){

        extentTest = extentReports.createTest("Google Play Butonu Bulunması ve Bağlantı Testi",
                "Kullanici google play butonunu görüntülemeli ve tıkladığında doğru bağlantı açılmalı");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        // Google Play butonu görünürlüğü testi ve bağlantı doğrulama
        WebElement googlePlayButonu = driver.findElement(By.xpath("//div[@class='me-4']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(googlePlayButonu).perform();

        Assert.assertTrue(googlePlayButonu.isDisplayed());
        extentTest.pass("Kullanıcı google play butonunu görüntüler");

        googlePlayButonu.click();
        String expectedUrl = "https://play.google.com/store/games?device=windows";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Kullanıcı google play sayfasına yönlendirilir");

        extentTest.info("sayfayi kapatir");


    }
}
