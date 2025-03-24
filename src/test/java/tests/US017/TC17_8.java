package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC17_8 extends CrossTestBaseRapor {

    @Test(priority = 8)
    public void loginRememberTesti(){

        extentTest = extentReports.createTest("Remember Buton Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Login Butonuna Tıklar");

        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        emailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Doğru Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Doğru Password Girer");

        Driver.getDriver().findElement(By.id("remember")).click();
        extentTest.info("Remember Buton'a Tıklar");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.xpath("(//*[@Class='nav-link nav-user-img'])[1]")).click();
        extentTest.info("Header Menü de Profil Resmine tıklar");

        Driver.getDriver().findElement(By.xpath("(//*[@Class='fas fa-power-off mr-2'])[1]")).click();
        extentTest.info("Açılan Menü de Logout Butona Tıklar");

        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Anasayfa Header Menü de Login Butonuna Tıklar");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Açılan Login Panelde Direkt Sıgn In Butona Tıklar");

        String expectedUrl = "https://qa.agileswiftcargo.com/dashboard";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Merchant Dashboard Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
