package tests.US031;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC31_1 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void adminGirisiTesti() {
        extentTest = extentReports.createTest("Admin Girişi Testi",
                "Kullanıcı ana sayfaya gidip admin olarak giriş yapabilmeli");

        // Kullanıcı, ana sayfaya gider
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Agile Swift Cargo ana sayfasına gider");

        // Locator sınıfını başlat
        locator = new Locator();

        // Login butonuna tıkla
        locator.loginButonu.click();
        extentTest.info("Login butonuna tıklandı");

        // Admin giriş bilgilerini gir
        locator.emailTextbox.sendKeys("furkan.admin@agileswiftcargo.com");
        extentTest.info("Admin email adresi girildi");

        locator.passwordTextbox.sendKeys("Agile.0924");
        extentTest.info("Admin şifresi girildi");

        // Giriş yap butonuna tıkla
        locator.signInButton.click();
        extentTest.info("Sign in butonuna tıklandı");

        // Admin paneline başarıyla giriş yapıldığını doğrula
        try {
            Thread.sleep(2000); // Sayfanın yüklenmesi için kısa bir bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Admin dashboard'ının görüntülendiğini doğrula
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),
                "Admin paneline giriş yapılamadı");
        extentTest.pass("Admin paneline başarıyla giriş yapıldı");

        // Admin bilgilerinin görüntülendiğini doğrula
        Assert.assertTrue(locator.profilResmi.isDisplayed(), "Admin profil resmi görüntülenmiyor");
        extentTest.pass("Admin profil resmi görüntülendi");

        // Çıkış yap
        locator.profilResmi.click();
        locator.loguotButonu.click();
        extentTest.info("Admin başarıyla çıkış yaptı");
    }
}
