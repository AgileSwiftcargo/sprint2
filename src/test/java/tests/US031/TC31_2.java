package tests.US031;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import java.util.List;

public class TC31_2 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void adminPaneliIslevsellikTesti() {
        extentTest = extentReports.createTest("Admin Paneli İşlevsellik Testi",
                "Yönetici paneli, yönetim görevlerinin yapılabilmesi için gerekli araçlar ve menülerle donatılmış olmalıdır");

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

        // Ana menü öğelerinin varlığını kontrol et
        List<WebElement> menuItems = driver.findElements(By.cssSelector(".navbar-nav .nav-item"));
        Assert.assertTrue(menuItems.size() > 10, "Menü öğeleri yeterli sayıda değil");
        extentTest.pass("Yönetici panelinde yeterli sayıda menü öğesi bulunuyor");

        // Önemli menü başlıklarının varlığını kontrol et
        String[] menuBasliklari = {"Dashboard", "Delivery Man", "Branch Manage", "Merchant Manage", 
                                  "Parcels", "Reports", "Setting"};
        
        for (String menuBasligi : menuBasliklari) {
            boolean menuBulundu = false;
            for (WebElement menuItem : menuItems) {
                if (menuItem.getText().contains(menuBasligi)) {
                    menuBulundu = true;
                    break;
                }
            }
            Assert.assertTrue(menuBulundu, "'" + menuBasligi + "' menüsü bulunamadı");
            extentTest.pass("'" + menuBasligi + "' menüsü başarıyla görüntülendi");
        }

        // Dashboard istatistiklerinin görüntülendiğini kontrol et
        List<WebElement> dashboardCards = driver.findElements(By.cssSelector(".total-card-body"));
        Assert.assertTrue(dashboardCards.size() > 5, "Dashboard istatistik kartları yeterli sayıda değil");
        extentTest.pass("Dashboard istatistik kartları başarıyla görüntülendi");

        // Profil menüsünün çalıştığını kontrol et
        locator.profilResmi.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href*='logout']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Çıkış butonu görüntülenmiyor");
        extentTest.pass("Profil menüsü başarıyla çalışıyor");

        // Çıkış yap
        logoutButton.click();
        extentTest.info("Admin başarıyla çıkış yaptı");
    }
} 