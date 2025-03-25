package tests.US014;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Furkan;
import pages.Locator;
import utilities.*;

import java.time.Duration;

import static utilities.DriverCross.driver;

public class TC14_2 extends CrossTestBaseRapor {
    Locator locator;
    @Test
    public void testSocialMediaLinks() {
        extentTest = extentReports.createTest("Sosyal Medya Link Kontrolü",
                "Sosyal medya butonları doğru ve güncel sayfalara yönlendirilmelidir.");

        // Kullanıcı, ana sayfaya gider
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici Agile Swift Cargo ana sayfasina gider");

        // Beklenen sosyal medya linkleri
        String expectedLinkedIn = "https://www.linkedin.com/in/agileswiftcargo";
        String expectedFacebook = "https://www.facebook.com/agileswiftcargo";
        String expectedInstagram = "https://www.instagram.com/agileswiftcargo";
        String expectedYoutube = "https://www.youtube.com/@agileswiftcargo";
        String expectedSkype = "skype:agileswiftcargo?chat";


        // Sayfayı kaydırarak sosyal medya butonlarının bulunduğu alana git
        locator = new Locator();
        Actions actions = new Actions(driver);
        actions.moveToElement(locator.AgileSwiftCargoLinkedIn).perform();


        // Hata mesajlarını toplamak için bir liste oluştur
        StringBuilder errorMessages = new StringBuilder();

        // Her linki kontrol et ve hataları topla
        try {
            checkSocialMediaLink(locator.AgileSwiftCargoLinkedIn, expectedLinkedIn, "LinkedIn", errorMessages);
            checkSocialMediaLink(locator.AgileSwiftCargoFacebook, expectedFacebook, "Facebook", errorMessages);
            checkSocialMediaLink(locator.AgileSwiftCargoInstagram, expectedInstagram, "Instagram", errorMessages);
            checkSocialMediaLink(locator.AgileSwiftCargoYoutube, expectedYoutube, "YouTube", errorMessages);
            checkSocialMediaLink(locator.AgileSwiftCargoSkype, expectedSkype, "Skype", errorMessages);
        } finally {
            // Test sonunda tüm hataları raporla
            if (errorMessages.length() > 0) {
                extentTest.fail("Aşağıdaki sosyal medya linkleri hatalı:\n" + errorMessages);
            } else {
                extentTest.pass("Tüm sosyal medya bağlantıları doğru ve günceldir.");
            }
        }
    }

    private void checkSocialMediaLink(WebElement element, String expectedUrl, String platformName, StringBuilder errorMessages) {
        try {
            Assert.assertTrue(element.isDisplayed(), platformName + " butonu görüntülenemedi!");
            
            String mainWindow = driver.getWindowHandle();

            element.click();
            extentTest.info(platformName + " bağlantısına tıklanır.");
            
            Thread.sleep(2000);
            
            boolean newWindowOpened = driver.getWindowHandles().size() > 1;
            
            if (newWindowOpened) {
                // Yeni pencere açıldıysa
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!windowHandle.equals(mainWindow)) {
                        driver.switchTo().window(windowHandle);
                        break;
                    }
                }
                
                String actualUrl = driver.getCurrentUrl();
                if (!actualUrl.contains(expectedUrl)) {
                    errorMessages.append("\n").append(platformName)
                                .append(" - Beklenen: ").append(expectedUrl)
                                .append(", Bulunan: ").append(actualUrl);
                }
                
                // Yeni pencereyi kapat ve ana pencereye dön
                driver.close();
                driver.switchTo().window(mainWindow);
            } else {
                // Aynı pencerede açıldıysa
                String actualUrl = driver.getCurrentUrl();
                if (!actualUrl.contains(expectedUrl)) {
                    errorMessages.append("\n").append(platformName)
                                .append(" - Beklenen: ").append(expectedUrl)
                                .append(", Bulunan: ").append(actualUrl);
                }
                
                // Önceki sayfaya geri dön
                driver.navigate().back();
                
                // Sayfanın yüklenmesini bekle
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            errorMessages.append("\n").append(platformName).append(" - Kontrol sırasında hata: ").append(e.getMessage());
        }
    }

}
