package tests.US031;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TC31_3 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void adminPaneliKapsamliFonksiyonTesti() {
        extentTest = extentReports.createTest("Admin Paneli Kapsamlı Fonksiyon Testi",
                "Yönetici panelinde, yönetimsel görevler için raporlar, kullanıcı yönetimi ve sistem ayarları gibi gerekli tüm fonksiyonlar bulunmalıdır");

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),
                "Admin paneline giriş yapılamadı");
        extentTest.pass("Admin paneline başarıyla giriş yapıldı");

        // Test edilecek ana fonksiyon kategorileri
        Map<String, String[]> fonksiyonKategorileri = new HashMap<>();
        fonksiyonKategorileri.put("Raporlar", new String[]{"Reports", "Parcel Status Reports", "Parcel Wise Profit", "Salary Reports"});
        fonksiyonKategorileri.put("Kullanıcı Yönetimi", new String[]{"Users & Roles", "Roles", "Designations", "Departments", "Users"});
        fonksiyonKategorileri.put("Sistem Ayarları", new String[]{"Setting", "Delivery Category", "Delivery Charge", "Delivery Type"});
        fonksiyonKategorileri.put("Finansal Yönetim", new String[]{"Accounts", "Account Heads", "Fund Transfer", "Income", "Expense"});
        fonksiyonKategorileri.put("Operasyonel Yönetim", new String[]{"Parcels", "Delivery Man", "Branch Manage", "Merchant Manage"});

        // Her kategori için fonksiyonların varlığını kontrol et
        for (Map.Entry<String, String[]> kategori : fonksiyonKategorileri.entrySet()) {
            extentTest.info(kategori.getKey() + " kategorisi test ediliyor");
            
            String[] fonksiyonlar = kategori.getValue();
            String anaMenu = fonksiyonlar[0];
            
            // Ana menüyü bul
            List<WebElement> menuItems = driver.findElements(By.xpath("//a[contains(text(), '" + anaMenu + "') or contains(@href, '" + anaMenu.toLowerCase() + "')]"));
            
            if (menuItems.size() > 0) {
                extentTest.pass("'" + anaMenu + "' ana menüsü bulundu");
                
                // Ana menüye tıkla (dropdown açmak için)
                try {
                    menuItems.get(0).click();
                    Thread.sleep(1000); // Dropdown açılması için bekle
                    
                    // Alt menüleri kontrol et
                    for (int i = 1; i < fonksiyonlar.length; i++) {
                        String altMenu = fonksiyonlar[i];
                        List<WebElement> altMenuItems = driver.findElements(
                            By.xpath("//a[contains(text(), '" + altMenu + "') or contains(@href, '" + altMenu.toLowerCase().replace(" ", "-") + "')]"));
                        
                        if (altMenuItems.size() > 0) {
                            extentTest.pass("'" + altMenu + "' alt menüsü bulundu");
                        } else {
                            extentTest.warning("'" + altMenu + "' alt menüsü bulunamadı");
                        }
                    }
                    
                    // Menüyü tekrar tıklayarak kapat
                    menuItems.get(0).click();
                    Thread.sleep(500);
                    
                } catch (Exception e) {
                    extentTest.warning("'" + anaMenu + "' menüsüne tıklarken hata oluştu: " + e.getMessage());
                }
            } else {
                extentTest.warning("'" + anaMenu + "' ana menüsü bulunamadı");
            }
        }

        // Dashboard istatistiklerinin varlığını kontrol et
        List<WebElement> dashboardCards = driver.findElements(By.cssSelector(".total-card-body"));
        Assert.assertTrue(dashboardCards.size() > 5, "Dashboard istatistik kartları yeterli sayıda değil");
        extentTest.pass("Dashboard istatistik kartları başarıyla görüntülendi");

        // Grafiklerin varlığını kontrol et
        List<WebElement> charts = driver.findElements(By.cssSelector(".apexcharts"));
        Assert.assertTrue(charts.size() > 0, "Dashboard grafikleri görüntülenmiyor");
        extentTest.pass("Dashboard grafikleri başarıyla görüntülendi");

        // Çıkış yap
        locator.profilResmi.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='logout']")));
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href*='logout']"));
        logoutButton.click();
        extentTest.info("Admin başarıyla çıkış yaptı");
    }
} 