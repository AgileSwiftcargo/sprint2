package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC17_3 extends CrossTestBaseRapor {

    @Test
    public void negatifLoginTesti(){

        extentTest = extentReports.createTest("Doğru Email ve Yanlış Password İle Login Olamama Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Login Butonuna Tıklar");

        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        emailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Doğru Email Girer");

        passwordBox.sendKeys("Gagile.0924");
        extentTest.info("Password Text Box'a Yanlış Password Girer");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");


        WebElement uyariYazisiIcerik = Driver.getDriver().findElement(By.xpath("//*[@Class='invalid-feedback']"));

        Assert.assertTrue(uyariYazisiIcerik.isDisplayed());
        extentTest.pass("Giriş Yapılamadığını ve Uyarı Yazısının Çıktığı Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
