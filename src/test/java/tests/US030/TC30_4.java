package tests.US030;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC30_4 extends CrossTestBaseRapor {

    private JavascriptExecutor js;

    @Test
    public void PickupPointEklemeTestiNegatif() {

        extentTest = extentReports.createTest("Pickup Point Ekleme  Testi Negatif ",
                "Login olunabilmeli ve Dasboard Menü Başlıkları Görüntülenebilmeli");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        driver.findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Header Menü de Login Linkine Tıklar");

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("password"));

        emailBox.sendKeys("cihat.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Password girer");

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        driver.findElement(By.xpath("(//*[.=\" Setting\"])[2]")).click();
        extentTest.info("Menü'den Settings'a Tıklar");

        driver.findElement(By.xpath("(//*[.=' Pickup Points'])[3]")).click();
        extentTest.info("Açılan Menü'de PickUp Points 'a Tıklar");

        driver.findElement(By.xpath("(//i[@class='fa fa-plus'])[3]")).click();
        extentTest.info("Açılan sayfada PickUp Points Ekle(+) 'a Tıklar");


        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/shops/create";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Pickup Points Creat Sayfasının Görüntülendiğini Doğrular");


        WebElement nameBox = driver.findElement(By.xpath("//input[@placeholder='Enter name']"));
        WebElement phoneBox = driver.findElement(By.xpath("//input[@placeholder='Enter phone']"));
        WebElement adresBox = driver.findElement(By.xpath("//*[@id=\"address\"]"));




        nameBox.sendKeys("agile");
        extentTest.info("Name Text Box'a uygun veri girer");

        phoneBox.sendKeys("54443@--aasds");
        extentTest.info("phone Text Box'a harf ve özel işeret içeren, kayıt için uygun olmayan veri girer");

        adresBox.sendKeys("Kocaeli Türkiye");
        extentTest.info("Adres Text Box'a uygun veri girer");


        // Kayıt tuşunu bul ve tıkla
        driver.findElement(By.xpath("//*[.='Save']")).click();
        extentTest.info("Save Butonuna Tıklar");

        String expectedUrl1 = "https://qa.agileswiftcargo.com/merchant/shops/create";
        String actualUrl1 = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl1,expectedUrl1);
        extentTest.pass("Pickup Points Creat Sayfasının Görüntülendiğini, Kayıt Yapılamadığını Doğrular");


        ReusableMethods.bekle(1);

        driver.findElement(By.xpath(("(//*[@class='nav-link nav-user-img'])[1]"))).click();;
        extentTest.info("Profil resmine tıklar");

        driver.findElement(By.xpath("(//*[contains(@href, 'logout')])[1]")).click();
        extentTest.info("LogOut Butonuna Tıklar");

        extentTest.info("Sayfayı Kapatır");
    }
}
