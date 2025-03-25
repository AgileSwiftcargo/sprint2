package tests.US023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC23_3 extends CrossTestBaseRapor {

    @Test
    public void stripePayoutSayfasiKrediKartiBilgileriTesti() {

        extentTest = extentReports.createTest("Stripe Payout Kredi Kartı Bilgileri Sayfası Erişim Testi",
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

        WebElement amountTextBox = driver.findElement(By.id("stripe_amount"));
        amountTextBox.sendKeys("150");
        extentTest.info("Amount Tex Box'a -150- Girer");

        WebElement payNowButton = driver.findElement(By.xpath("//*[@Class='btn btn-primary btn-block']"));
        payNowButton.click();
        extentTest.info("Pay Now Buton'una Tıklar");

        ReusableMethods.bekle(1);

        WebElement iFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrame);

        WebElement krediKartiEmailBox = driver.findElement(By.id("email"));
        krediKartiEmailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Email Girer");

        for (int i = 0; i < 4; i++) {
            WebElement krediKartiNoBox = driver.findElement(By.id("card_number"));
            krediKartiNoBox.sendKeys("4242");
        }
        extentTest.info("Card Number Text Box'a Card Number Girer");

        WebElement krediKartiAyBox = driver.findElement(By.id("cc-exp"));
        krediKartiAyBox.sendKeys("12");
        extentTest.info("Ay Text Box'a Ay  Girer");

        WebElement krediKartiYılBox = driver.findElement(By.id("cc-exp"));
        krediKartiYılBox.sendKeys("30");
        extentTest.info("Yıl Text Box'a Yıl  Girer");

        WebElement cvcBox = driver.findElement(By.id("cc-csc"));
        cvcBox.sendKeys("242");
        extentTest.info("CVC Text Box'a CVC Girer");

        WebElement krediKartiPayButon = driver.findElement(By.xpath("//*[@*='iconTick']"));
        String payButonYazisi = krediKartiPayButon.getText();

        String expectedYaziIcerik = "Pay $150";
        Assert.assertTrue(payButonYazisi.contains(expectedYaziIcerik));
        extentTest.pass("Pay Butonunda Girilen Tutarın Yazılı Olduğunu Kontrol Eder");

        ReusableMethods.bekle(1);

        krediKartiPayButon.click();
        extentTest.info("Pay Buton'una Tıklar");

        ReusableMethods.bekle(1);

        extentTest.info("Sayfayı Kapatır");


    }
}