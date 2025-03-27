package tests.US032;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC32_5 extends CrossTestBaseRapor {

    @Test
    public void adminProfileEditRegAreaTest() {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Admin Edit Zorunlu Bilgi",
                "Admin profilindeki name, address bilgileri girilmeden güncelleme yapılamamalı, uyarı vermelidir.");


//    1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
//2_Login butonuna tıklar
        locator.loginButonu.click();
//3_Enter Email or Mobile textboxına tıklar.
        locator.emailInput.click();
//4_Mail adresi bilgisini girer.
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
//5_Password textboxına tıklar.
        locator.passwordInput.click();
//6_Şifre bilgilerini girer.
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
//7_Sign in butonuna tıklar.
        locator.signInButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
//8_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
//10_Açılan pencerede edit butonuna tıklar.
        locator.adminProfileEditButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("h2[.='Update Profile']")).isDisplayed());
//11_Açılan pencerede Name başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='name']")).click();
//12_Önceki bilgileri siler ve boş bırakır.
        driver.findElement(By.xpath("//input[@id='name']")).clear();
//13_Açılan pencerede Address başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='address']")).click();
//14_Önceki bilgileri siler ve boş bırakır.
        driver.findElement(By.xpath("//input[@id='address']")).clear();
//15_Save change butonuna tıklar.
        locator.saveChangeButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The Name field is required.']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The Address field is required.']")).isDisplayed());
//16_Save change butonuna tıklar.
        locator.saveChangeButton.click();
//17_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//18_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//19_Sayfa kapatılır.
    }
}
