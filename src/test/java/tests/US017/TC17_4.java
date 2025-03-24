package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC17_4 extends CrossTestBaseRapor {

    @Test
    public void negatifLoginTesti2() {

        extentTest = extentReports.createTest("Yanlış Email ve Doğru Password İle Login Olamama Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        emailBox.sendKeys("alican.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Yanlış Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Doğru Password Girer");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");


        WebElement uyariYazisiIcerik = Driver.getDriver().findElement(By.xpath("//*[@Class='invalid-feedback']"));

        Assert.assertTrue(uyariYazisiIcerik.isDisplayed());
        extentTest.pass("Giriş Yapılamadığını ve Uyarı Yazısının Çıktığı Doğrular");

        extentTest.info("Sayfayı Kapatır");
    }
}
