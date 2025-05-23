package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC17_4 extends CrossTestBaseRapor {

    @Test
    public void negatifLoginTesti2() {

        extentTest = extentReports.createTest("Yanlış Email ve Doğru Password İle Login Olamama Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        emailBox.sendKeys("alican.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Yanlış Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Doğru Password Girer");

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        ReusableMethods.bekle(1);

        WebElement uyariYazisiIcerik = driver.findElement(By.xpath("//*[@Class='invalid-feedback']"));

        ReusableMethods.bekle(1);

        Assert.assertTrue(uyariYazisiIcerik.isDisplayed());
        extentTest.pass("Giriş Yapılamadığını ve Uyarı Yazısının Çıktığı Doğrular");

        extentTest.info("Sayfayı Kapatır");
    }
}
