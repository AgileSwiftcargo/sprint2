package tests.US024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC24_1 extends CrossTestBaseRapor {

    @Test
    public void merchantParcelListesineErisimTesti() {

        extentTest = extentReports.createTest("SParcel Listesine  Erişim Testi",
                "Login olunabilmeli ve Dasboard Menü Başlıkları Görüntülenebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Header Menü de Login Linkine Tıklar");

        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        emailBox.sendKeys("cihat.merchant@agileswiftcargo.com");
        extentTest.info("Email Text Box'a Email Girer");

        passwordBox.sendKeys("Agile.0924");
        extentTest.info("Password Text Box'a Password girer");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        extentTest.info("Sıgn In Butonuna Tıklar");

        Driver.getDriver().findElement(By.xpath("(//*[@*='collapse'])[1]")).click();
        extentTest.info("Menü'den Accounts'a Tıklar");

        Driver.getDriver().findElement(By.xpath("(//*[.='Invoice'])[3]")).click();
        extentTest.info("Açılan Menü'de Invoice'a Tıklar");

        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/invoice";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Invoice Sayfasının Görüntülendiğini Doğrular");


        Driver.getDriver().findElement(By.xpath(("(//*[@class='nav-link nav-user-img'])[1]"))).click();;
        extentTest.info("Profil resmine tıklar");

        Driver.getDriver().findElement(By.xpath("(//*[contains(@href, 'logout')])[1]")).click();
        extentTest.info("LogOut Butonuna Tıklar");

        extentTest.info("Sayfayı Kapatır");
    }
}
