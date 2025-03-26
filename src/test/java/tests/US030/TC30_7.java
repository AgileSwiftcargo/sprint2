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

public class TC30_7 extends CrossTestBaseRapor {

    private JavascriptExecutor js;

    @Test
    public void PickupPointSilmeTestiPozitif() {

        extentTest = extentReports.createTest("Pickup Point Silme  Testi Pozitif ",
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

        driver.findElement(By.xpath("//*[.=' Delete'][1]")).click();
        extentTest.info("Açılan sayfada PickUp Points Delete'a Tıklar");




        ReusableMethods.bekle(2);




        // YES tuşunu bul ve tıkla
        driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]")).click();
        extentTest.info("Yes Butonuna Tıklar");

        js = (JavascriptExecutor) driver;
        String toastrMessage = (String) js.executeScript(
                "return (document.querySelector('.toast-message') ? document.querySelector('.toast-message').textContent : '');"
        );

        Assert.assertEquals(toastrMessage, "Pickup Point successfully deleted.", "Silme işlemi başarılı");
        extentTest.pass("Silme işleminin Gerçekleştiğini Doğrular");

        ReusableMethods.bekle(2);

        driver.findElement(By.xpath(("(//*[@class='nav-link nav-user-img'])[1]"))).click();;
        extentTest.info("Profil resmine tıklar");

        driver.findElement(By.xpath("(//*[contains(@href, 'logout')])[1]")).click();
        extentTest.info("LogOut Butonuna Tıklar");

        extentTest.info("Sayfayı Kapatır");
    }
}
