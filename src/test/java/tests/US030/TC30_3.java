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

public class TC30_3 extends CrossTestBaseRapor {

    private JavascriptExecutor js;

    @Test
    public void PickupPointEklemeTestiNegatif() {

        extentTest = extentReports.createTest("Pickup Point Ekleme  Testi Pozitif  ",
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

        Driver.getDriver().findElement(By.xpath("(//*[.=\" Setting\"])[2]")).click();
        extentTest.info("Menü'den Settings'a Tıklar");

        Driver.getDriver().findElement(By.xpath("(//*[.=' Pickup Points'])[3]")).click();
        extentTest.info("Açılan Menü'de PickUp Points 'a Tıklar");

        Driver.getDriver().findElement(By.xpath("(//i[@class='fa fa-plus'])[3]")).click();
        extentTest.info("Açılan sayfada PickUp Points Ekle(+) 'a Tıklar");


        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/shops/create";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);
        extentTest.pass("Pickup Points Creat Sayfasının Görüntülendiğini Doğrular");


        WebElement nameBox = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Enter name']"));
        WebElement phoneBox = Driver.getDriver().findElement(By.xpath("//input[@placeholder='Enter phone']"));
        WebElement adresBox = Driver.getDriver().findElement(By.xpath("//*[@id=\"address\"]"));




        nameBox.sendKeys("");
        extentTest.info("Name Text Box'ı Boş Bırakı");

        phoneBox.sendKeys("");
        extentTest.info("phone Text Boxı Boş Bırakır");

        adresBox.sendKeys("");
        extentTest.info("Adres Text Box'ı Boş Bırakır");


        // Kayıt tuşunu bul ve tıkla
        Driver.getDriver().findElement(By.xpath("//*[.='Save']")).click();
        extentTest.info("Save Butonuna Tıklar");


        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.xpath(("(//*[@class='nav-link nav-user-img'])[1]"))).click();;
        extentTest.info("Profil resmine tıklar");

        Driver.getDriver().findElement(By.xpath("(//*[contains(@href, 'logout')])[1]")).click();
        extentTest.info("LogOut Butonuna Tıklar");

        extentTest.info("Sayfayı Kapatır");
    }
}
