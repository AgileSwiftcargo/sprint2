package tests.US032;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC32_6 extends CrossTestBaseRapor {

    @Test
    public void adminProfileRegAreaPhotoEdit() {
        Locator locator = new Locator();

        extentTest = extentReports.createTest("Resim Yükleme Adımı Kontrolü",
                "Admin profilindeki profil resmini fotoğraf dışında bir formatta yükleme yapmaya çalıştığında uyarı vermelidir.");


//1_https://qa.agileswiftcargo.com/ adresine gider.
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
//15_Dosya seç butonuna tıklar.
        locator.adminProfileFileButton.click();
//16_Fotoğraf/resim formatında bir fotoğraf yükler.
//17_Save change butonuna tıklar.
        locator.saveChangeButton.click();
//18_Save change butonuna tıklar.
        locator.saveChangeButton.click();
//19_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//20_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//21_Sayfa kapatılır.

    }

}
