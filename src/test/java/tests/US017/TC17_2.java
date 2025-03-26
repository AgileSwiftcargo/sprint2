package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC17_2 extends CrossTestBaseRapor {
    @Test
    public void pozitifLoginTesti(){

        extentTest = extentReports.createTest("Doğru Email ve Password İle Login Olabilme Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        driver.findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Login Butonuna Tıklar");

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        emailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Doğru Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Doğru Password Girer");

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        ReusableMethods.bekle(1);

        String expectedUrl = "https://qa.agileswiftcargo.com/dashboard";
        String actualUrl = driver.getCurrentUrl();

        ReusableMethods.bekle(1);

        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Başarıyla Giriş Yapılabildiğini ve Merchant Dasboard Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");
    }
}
