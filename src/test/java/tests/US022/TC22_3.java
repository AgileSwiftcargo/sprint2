package tests.US022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import java.util.List;

public class TC22_3 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void gelirButonlarinaErisimTesti (){
        extentTest = extentReports.createTest("Merchant Gelir Verileri Sayfasina Erisim Testi",
                "Merchant, menüde gelir bağlantılarını görüntülemeli ve tıklandığında doğru bağlantı açılmalı");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        //Merchant gecerli bir e'mail ve geçerli bir password ile login olur
        locator = new Locator();

        locator.loginButonu.click();
        extentTest.info("Merchant login butonuna tiklar gider");

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantFurkanGecerliMail"));
        extentTest.info("Geçerli bir email girer");

        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantFurkanGecerliPassword"));
        extentTest.info("Geçerli bir password girer");

        locator.signInButton.click();
        extentTest.info("Sing in butonuna tiklar");

        // Reports menüsünü açalım
        locator.reportsMenuInput.click();
        extentTest.info("Reports menüsüne tıklandı");
        
        try {
            Thread.sleep(1000); // Menünün açılması için kısa bir bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Tüm alt menü linklerini bulalım
        List<WebElement> navLinks = driver.findElements(By.xpath("//div[@id='reports']//ul[@class='nav flex-column']/li/a"));
        extentTest.info("Reports menüsü altında " + navLinks.size() + " adet link bulundu");

        // Her bir link için işlem yapalım
        for (int i = 0; i < navLinks.size(); i++) {
            // Her seferinde elementleri yeniden bulmamız gerekiyor çünkü sayfa yenilendiğinde referanslar geçersiz oluyor !!! BUNA DİKKAT ET
            List<WebElement> currentLinks = driver.findElements(By.xpath("//div[@id='reports']//ul[@class='nav flex-column']/li/a"));
            WebElement currentLink = currentLinks.get(i);
            
            // Menünün açık olduğundan emin olalım
            if (!driver.findElement(By.id("reports")).getAttribute("class").contains("show")) {
                locator.reportsMenuInput.click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // Link bilgilerini alalım
            String linkText = currentLink.getText();
            Assert.assertTrue(currentLink.isDisplayed(), linkText + " linki görünür değil");
            extentTest.info(linkText + " linki görünür");
            
            String currentUrl = driver.getCurrentUrl();
            
            // Linke tıklayalım
            currentLink.click();
            extentTest.pass(linkText + " linkine tıklandı");
            
            try {
                Thread.sleep(2000); // Sayfanın yüklenmesi için bekleme
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            String newUrl = driver.getCurrentUrl();
            extentTest.pass(linkText + " linki açıldı. Yeni URL: " + newUrl);
            
            // Önceki sayfaya dönelim
            driver.navigate().back();
            
            try {
                Thread.sleep(1000); // Geri dönüş için bekleme
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Merchant logout olur
        locator.profilResmi.click();
        locator.loguotButonu.click();
        extentTest.info("Logout olur");

        extentTest.info("sayfayi kapatir");
    }

}
