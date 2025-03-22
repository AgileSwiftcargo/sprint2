package tests.US023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC23_1 extends CrossTestBaseRapor {
    @Test
    public void payoutSayfasinaErisimTesti(){

        extentTest = extentReports.createTest("Payout Sayfasına Erişim Testi",
                "Login olunabilmeli ve Dasboard Menü Başlıkları Görüntülenebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Header Menü de Login Linkine Tıklar");

        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        emailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Password girer");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        Driver.getDriver().findElement(By.xpath("(//*[@*='collapse'])[1]")).click();
        extentTest.info("Menü'den Accounts'a Tıklar");

        Driver.getDriver().findElement(By.xpath("//li[*=' Payout']")).click();
        extentTest.info("Açılan Menü'de Payout'a Tıklar");

        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/online-payment";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Online Payment Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
