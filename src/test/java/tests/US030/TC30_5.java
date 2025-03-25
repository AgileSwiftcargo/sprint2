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

public class TC30_5 extends CrossTestBaseRapor {

    private JavascriptExecutor js;

    @Test
    public void PickupPointGuncellemeTestiPozitif() {

        extentTest = extentReports.createTest("Pickup Point Güncelleme  Testi pozitif ",
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



        driver.findElement(By.xpath("//button[.='Toggle Dropdown'][1]")).click();
        extentTest.info("Açılan sayfada Action'a Tıklar");

        driver.findElement(By.xpath("//*[.=' Edit'][1]")).click();
        extentTest.info("Açılan sayfada PickUp Points Edit'a Tıklar");


        String baseURL = "https://qa.agileswiftcargo.com/merchant/shops/edit/";
        String dynamicPart = ".*";

        String fullURLPattern = baseURL + dynamicPart;


        Assert.assertTrue(driver.getCurrentUrl().matches(fullURLPattern));
        extentTest.pass("Edit Pickup Points  Sayfasının Görüntülendiğini Doğrular");


        WebElement editnameBox = driver.findElement(By.xpath("//input[@placeholder='Enter name']"));
        WebElement editphoneBox = driver.findElement(By.xpath("//input[@placeholder='Enter phone']"));
        WebElement editadresBox = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        WebElement status = driver.findElement(By.xpath("//*[@id=\"basicform\"]/div[1]/div/div[4]/select"));
        WebElement statusActive = driver.findElement(By.xpath("//*[.='Active']"));
        WebElement statusInactive = driver.findElement(By.xpath("//*[.='Inactive']"));



        editnameBox.clear();
        editnameBox.sendKeys("agile");
        extentTest.info("Name Text Box'a uygun veri girer");

        editphoneBox.clear();
        editphoneBox.sendKeys("754812356478");
        extentTest.info("phone Text Box'a harf ve özel işeret içermeyen, kayıt için uygun veri girer");


        editadresBox.clear();
        editadresBox.sendKeys("İzmit/Türkiye");
        extentTest.info("Adres Text Box'a uygun veri girer");

        status.click();
        extentTest.info("Status e tıklar");

        statusActive.click();
        extentTest.info("Active i seçer");

        ReusableMethods.bekle(2);


        // Kayıt tuşunu bul ve tıkla
        driver.findElement(By.xpath("//*[.='Save Change']")).click();
        extentTest.info("Save Butonuna Tıklar");

       String expectedUrl1 = "https://qa.agileswiftcargo.com/merchant/shops/index";
       String actualUrl1 = driver.getCurrentUrl();
       extentTest.pass("Pickup Points Editleme işlemini gerçekleştirdiğini Doğrular");

        js = (JavascriptExecutor) driver;
        String toastrMessage = (String) js.executeScript(
                "return (document.querySelector('.toast-message') ? document.querySelector('.toast-message').textContent : '');"
        );

        Assert.assertEquals(toastrMessage, "Pickup Point successfully update.", "Güncelleme başarılı");
        extentTest.pass("Edit işleminin Gerçekleştiğini Doğrular");


        ReusableMethods.bekle(2);

        driver.findElement(By.xpath(("(//*[@class='nav-link nav-user-img'])[1]"))).click();;
        extentTest.info("Profil resmine tıklar");

        driver.findElement(By.xpath("(//*[contains(@href, 'logout')])[1]")).click();
        extentTest.info("LogOut Butonuna Tıklar");

        extentTest.info("Sayfayı Kapatır");
    }
}
