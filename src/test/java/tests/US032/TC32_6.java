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
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici anasayfaya gider gider");

//2_Login butonuna tıklar
        locator.loginButonu.click();
        extentTest.pass("Login butonuna tıklar.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");

//3_Enter Email or Mobile textboxına tıklar.
        locator.emailInput.click();
        extentTest.pass("Email textbox'ına tıklar.");
//4_Mail adresi bilgisini girer.
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
        extentTest.info("Email textboxına \"lutfi.admin@agileswiftcargo.com\" mail adresi girilir");
//5_Password textboxına tıklar.
        locator.passwordInput.click();
        extentTest.pass("Password textbox'ına tıklar.");
//6_Şifre bilgilerini girer.
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");

        String actualPassword = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPassword = "password";

        Assert.assertEquals(actualPassword,expectedPassword);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");
//7_Sign in butonuna tıklar.
        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
        extentTest.pass("Agile Swift Cargo Dashboard sayfasına erişilir.");
//8_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
        extentTest.info("Profile tuşuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");
//10_Açılan pencerede edit butonuna tıklar.
        locator.adminProfileEditButton.click();
        extentTest.info("Edit butonuna tıklar.");
        Assert.assertTrue(driver.findElement(By.xpath("h2[.='Update Profile']"))
                .isDisplayed());
        extentTest.pass("Update Profile sayfasına ulaşır.");
//15_Dosya seç butonuna tıklar.
        locator.adminProfileFileButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");
//16_Fotoğraf/resim formatında bir fotoğraf yükler.
//17_Save change butonuna tıklar.
        locator.saveChangeButton.click();
        extentTest.info("Save change butonuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The Name field is required.']")).isDisplayed());
//18_Save change butonuna tıklar.
        locator.saveChangeButton.click();
        extentTest.info("Save change butonuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("//small[.='The Name field is required.']")).isDisplayed());
//19_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//20_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//21_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");

    }

}
