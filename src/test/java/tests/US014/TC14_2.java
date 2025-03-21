package tests.US014;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Furkan;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class TC14_2 extends TestBaseRapor {
    Furkan furkan;

    @Test
    public void testSocialMediaLinks() {
        extentTest = extentReports.createTest("Sosyal Medya Link Kontrolü",
                "Sosyal medya butonları doğru ve güncel sayfalara yönlendirilmelidir.");

        // Furkan page object'ini başlat
        furkan = new Furkan();

        // Kullanıcı, ana sayfaya gider
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici Agile Swift Cargo ana sayfasina gider");

        // Sayfa tam olarak yüklenene kadar bekle
        waitForPageLoad();

        // Beklenen sosyal medya linkleri
        String expectedLinkedIn = "https://www.linkedin.com/in/agileswiftcargo";
        String expectedFacebook = "https://www.facebook.com/agileswiftcargo";
        String expectedInstagram = "https://www.instagram.com/agileswiftcargo";
        String expectedYoutube = "https://www.youtube.com/@agileswiftcargo";
        String expectedSkype = "skype:agileswiftcargo?chat";

        // Sayfayı kaydırarak sosyal medya butonlarının bulunduğu alana git
        scrollToSocialMediaLinks();

        // Hata mesajlarını toplamak için bir liste oluştur
        StringBuilder errorMessages = new StringBuilder();

        // Her linki kontrol et ve hataları topla
        try {
            checkSocialMediaLink(furkan.AgileSwiftCargoLinkedIn, expectedLinkedIn, "LinkedIn", errorMessages);
            checkSocialMediaLink(furkan.AgileSwiftCargoFacebook, expectedFacebook, "Facebook", errorMessages);
            checkSocialMediaLink(furkan.AgileSwiftCargoInstagram, expectedInstagram, "Instagram", errorMessages);
            checkSocialMediaLink(furkan.AgileSwiftCargoYoutube, expectedYoutube, "YouTube", errorMessages);
            checkSocialMediaLink(furkan.AgileSwiftCargoSkype, expectedSkype, "Skype", errorMessages);
        } finally {
            // Test sonunda tüm hataları raporla
            if (errorMessages.length() > 0) {
                extentTest.fail("Aşağıdaki sosyal medya linkleri hatalı:\n" + errorMessages.toString());
                Assert.fail("Hatalı sosyal medya linkleri tespit edildi:\n" + errorMessages.toString());
            } else {
                extentTest.pass("Tüm sosyal medya bağlantıları doğru ve günceldir.");
            }
        }
    }

    private void checkSocialMediaLink(WebElement element, String expectedUrl, String platformName, StringBuilder errorMessages) {
        try {
            Assert.assertTrue(element.isDisplayed(), platformName + " butonu görüntülenemedi!");
            
            String mainWindow = Driver.getDriver().getWindowHandle();
            String currentUrl = Driver.getDriver().getCurrentUrl(); // Tıklamadan önceki URL
            
            element.click();
            extentTest.info(platformName + " bağlantısına tıklanır.");
            
            Thread.sleep(2000);
            
            boolean newWindowOpened = Driver.getDriver().getWindowHandles().size() > 1;
            
            if (newWindowOpened) {
                // Yeni pencere açıldıysa
                for (String windowHandle : Driver.getDriver().getWindowHandles()) {
                    if (!windowHandle.equals(mainWindow)) {
                        Driver.getDriver().switchTo().window(windowHandle);
                        break;
                    }
                }
                
                String actualUrl = Driver.getDriver().getCurrentUrl();
                if (!actualUrl.contains(expectedUrl)) {
                    errorMessages.append("\n").append(platformName)
                                .append(" - Beklenen: ").append(expectedUrl)
                                .append(", Bulunan: ").append(actualUrl);
                }
                
                // Yeni pencereyi kapat ve ana pencereye dön
                Driver.getDriver().close();
                Driver.getDriver().switchTo().window(mainWindow);
            } else {
                // Aynı pencerede açıldıysa
                String actualUrl = Driver.getDriver().getCurrentUrl();
                if (!actualUrl.contains(expectedUrl)) {
                    errorMessages.append("\n").append(platformName)
                                .append(" - Beklenen: ").append(expectedUrl)
                                .append(", Bulunan: ").append(actualUrl);
                }
                
                // Önceki sayfaya geri dön
                Driver.getDriver().navigate().back();
                
                // Sayfanın yüklenmesini bekle
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            errorMessages.append("\n").append(platformName).append(" - Kontrol sırasında hata: ").append(e.getMessage());
        }
    }

    private void scrollToSocialMediaLinks() {
        try {
            Thread.sleep(1000); // Sayfanın yüklenmesi için kısa bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Footer elementine kadar kaydır
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", furkan.AgileSwiftCargoLinkedIn);
        
        try {
            Thread.sleep(1000); // Scroll işleminin tamamlanması için bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        extentTest.info("Sayfa sosyal medya linklerine kadar kaydırıldı.");
    }

    // Sayfa yüklenene kadar bekle
    private void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(furkan.AgileSwiftCargoLinkedIn));
        extentTest.info("Sayfa tamamen yüklendi.");
    }
}
