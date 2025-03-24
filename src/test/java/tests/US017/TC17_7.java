package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC17_7 extends CrossTestBaseRapor {

    @Test
    public void negatifLoginTesti5() {

        extentTest = extentReports.createTest("Doğru Email ve Boş Password İle Login Olamama Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        emailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Doğru Email Girer");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        String expectedUrl = "https://qa.agileswiftcargo.com/login";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Login olamadığını Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
