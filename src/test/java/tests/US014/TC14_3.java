package tests.US014;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Furkan;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.TestBaseRapor;
import java.util.List;

import static utilities.DriverCross.driver;

public class TC14_3 extends CrossTestBaseRapor {
    Locator locator;
    @Test
    public void testSocialMediaLinksInNewWindowTest() {
        extentTest = extentReports.createTest("Sosyal Medya Linklerinin Yeni Sayfada Açılma Kontrolü",
                "Sosyal medya butonları doğru ve güncel sayfalara yeni sekmelerde yönlendirilmelidir.");

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
        extentTest.info("Kullanici Agile Swift Cargo ana sayfasinin ilgi bölümüne kaydırır.");


        // Hata mesajlarını toplamak için bir liste oluştur
        StringBuilder errorMessages = new StringBuilder();

        // Her linki kontrol et ve hataları topla
        try {
            checkSocialMediaLinkInNewWindow(locator.AgileSwiftCargoLinkedIn, expectedLinkedIn, "LinkedIn", errorMessages);
            checkSocialMediaLinkInNewWindow(locator.AgileSwiftCargoFacebook, expectedFacebook, "Facebook", errorMessages);
            checkSocialMediaLinkInNewWindow(locator.AgileSwiftCargoInstagram, expectedInstagram, "Instagram", errorMessages);
            checkSocialMediaLinkInNewWindow(locator.AgileSwiftCargoYoutube, expectedYoutube, "YouTube", errorMessages);
            checkSocialMediaLinkInNewWindow(locator.AgileSwiftCargoSkype, expectedSkype, "Skype", errorMessages);
        } finally {
            // Test sonunda tüm hataları raporla
            if (errorMessages.length() > 0) {
                extentTest.fail("Aşağıdaki sosyal medya linkleri aynı pencerede açılmakta:\n" + errorMessages);
                //Assert.fail("Aşağıdaki sosyal medya linkleri aynı pencerede açılmakta:\n" + errorMessages);
            } else {
                extentTest.pass("Tüm sosyal medya bağlantıları doğru ve yeni pencerede açılmaktadır.");
            }
        }
    }

    private void checkSocialMediaLinkInNewWindow(WebElement element, String expectedUrl, String platformName, StringBuilder errorMessages) {
        try {
            Assert.assertTrue(element.isDisplayed(), platformName + " butonu görüntülenemedi!");

            String mainWindow = driver.getWindowHandle();
            String currentWindow;
            element.click();

            extentTest.info(platformName + " bağlantısına tıklanır.");

            Thread.sleep(2000);

            boolean newWindowOpened = driver.getWindowHandles().size() > 1;
            currentWindow = driver.getWindowHandle();
            errorMessages.append("\n").append(platformName)
                    .append(" - Main Window Handle: ").append(mainWindow)
                    .append(", New Window Handle: ").append(currentWindow);
            if(newWindowOpened){
                driver.close();
                driver.switchTo().window(mainWindow);
            } else {
                driver.navigate().back();
            }


        } catch (Exception e) {
            errorMessages.append("\n").append(platformName).append(" - Kontrol sırasında hata: ").append(e.getMessage());
        }
    }
}
