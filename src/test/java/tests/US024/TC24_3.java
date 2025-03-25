package tests.US024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC24_3 extends CrossTestBaseRapor {

    @Test
    public void invoiceFaturaIndirmeTesti() {

        extentTest = extentReports.createTest("Görüntülenen Faturayı Bilgisayara İnfirme Testi",
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

        driver.findElement(By.xpath("(//*[@*='collapse'])[1]")).click();
        extentTest.info("Menü'den Accounts'a Tıklar");

        driver.findElement(By.xpath("(//*[.='Invoice'])[3]")).click();
        extentTest.info("Açılan Menü'de Invoice'a Tıklar");


        driver.findElement(By.xpath("//*[.=' View']")).click();
        extentTest.info("View Butonuna  Tıklar");

        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/invoice/AS-4904";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("AS-4904 fatura Fayfasının Görüntülendiğini Doğrular");

        driver.findElement(By.xpath("//*[.=' CSV']")).click();
        extentTest.info("CSV Butonuna  Tıklar, indirme işlemini başlatır");

        ReusableMethods.bekle(2);


        driver.findElement(By.xpath(("(//*[@class='nav-link nav-user-img'])[1]"))).click();;
        extentTest.info("Profil resmine tıklar");

        driver.findElement(By.xpath("(//*[contains(@href, 'logout')])[1]")).click();
        extentTest.info("LogOut Butonuna Tıklar");


        extentTest.info("Sayfayı Kapatır");
    }
}
