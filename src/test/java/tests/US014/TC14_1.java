package tests.US014;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Furkan;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Arrays;
import java.util.List;

public class TC14_1 extends TestBaseRapor {
    Furkan furkan;

    @Test
    public void sosyalMedyaLinkKontrolü() {

        // Sosyal medya linklerinin kontrolü
        extentTest = extentReports.createTest("Sosyal Medya Link Kontrolü",
                "Bir kullanıcı olarak firmaya ait sosyal medya hesaplarına kolay erişim sağlamak için ana sayfada linkler olmalıdır.");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici Agile Swift Cargo ana sayfasina gider");

        furkan = new Furkan();

        List<WebElement> socialMediaButtons = Arrays.asList(
                furkan.AgileSwiftCargoLinkedIn,
                furkan.AgileSwiftCargoFacebook,
                furkan.AgileSwiftCargoInstagram,
                furkan.AgileSwiftCargoYoutube,
                furkan.AgileSwiftCargoSkype
        );

        for (WebElement button : socialMediaButtons) {
            Assert.assertTrue(button.isDisplayed(), "Sosyal medya butonu görüntülenemedi: " + button.getAttribute("title"));
            Assert.assertTrue(button.getAttribute("href") != null && !button.getAttribute("href").isEmpty(),
                    "Sosyal medya butonunda geçerli bir link bulunamadı: " + button.getAttribute("title"));
            extentTest.pass("Sosyal medya butonu ve linki mevcut: " + button.getAttribute("title"));
        }

        // Test bittiğinde sayfayı kapatır
        extentTest.info("Sayfa kapatıldı");
    }
}
