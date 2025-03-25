package tests.US023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC23_2 extends CrossTestBaseRapor {

    @Test
    public void stripePayoutSayfasinaErisimTesti() {

        extentTest = extentReports.createTest("Stripe Payout Sayfasına Erişim Testi",
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

        driver.findElement(By.xpath("//*[@Class='col-lg-6  col-md-6']")).click();
        extentTest.info("Stripe İkonuna Tıklar");

        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/online-payment/stripe";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Stripe Payout Details Sayfasının Görüntülendiğini Doğrular");

        WebElement amountTextBox = driver.findElement(By.id("stripe_amount"));
        amountTextBox.sendKeys("150");
        extentTest.info("Amount Tex Box'a -150- Girer");

        ReusableMethods.bekle(1);

        WebElement payNowButton = driver.findElement(By.xpath("//*[@Class='btn btn-primary btn-block']"));
        Assert.assertTrue(payNowButton.isDisplayed());
        extentTest.info("Pay Now Buton'un Görünebilir Olduğunu Doğrular");

        extentTest.info("Sayfayı Kapatır");
    }
}
