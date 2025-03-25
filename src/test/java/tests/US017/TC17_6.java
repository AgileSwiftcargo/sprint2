package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC17_6 extends CrossTestBaseRapor {

    @Test
    public void negatifLoginTesti4() {

        extentTest = extentReports.createTest("Boş Email ve Doğru Password İle Login Olamama Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Doğru Password Girer");

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        ReusableMethods.bekle(1);

        String expectedUrl = "https://qa.agileswiftcargo.com/login";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Login olamadığını Doğrular");

        extentTest.info("Sayfayı Kapatır");
    }
}
