package tests.US023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC23_1 extends CrossTestBaseRapor {
    @Test
    public void payoutSayfasinaErisimTesti(){

        extentTest = extentReports.createTest("Payout Sayfasına Erişim Testi",
                "Login olunabilmeli ve Dasboard Menü Başlıkları Görüntülenebilmeli");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        driver.findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Header Menü de Login Linkine Tıklar");

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        emailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Password girer");

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        driver.findElement(By.xpath("(//*[@*='collapse'])[1]")).click();
        extentTest.info("Menü'den Accounts'a Tıklar");

        driver.findElement(By.xpath("//li[*=' Payout']")).click();
        extentTest.info("Açılan Menü'de Payout'a Tıklar");

        ReusableMethods.bekle(1);

        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/online-payment";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Online Payment Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
