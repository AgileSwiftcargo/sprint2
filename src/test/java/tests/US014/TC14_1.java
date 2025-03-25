package tests.US014;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import java.util.Arrays;
import java.util.List;

public class TC14_1 extends CrossTestBaseRapor {
    Locator locator;
    @Test
    public void sosyalMedyaLinkKontrolü() {

        // Sosyal medya linklerinin kontrolü
        extentTest = extentReports.createTest("Sosyal Medya Link Kontrolü",
                "Bir kullanıcı olarak firmaya ait sosyal medya hesaplarına kolay erişim sağlamak için ana sayfada linkler olmalıdır.");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici Agile Swift Cargo ana sayfasina gider");

        locator = new Locator();
        Actions actions = new Actions(driver);
        actions.moveToElement(locator.AgileSwiftCargoLinkedIn).perform();

        List<WebElement> navLinks = driver.findElements(By.xpath("//div[@class='col-2 mt-3 text-start']"));

        for (WebElement button : navLinks) {
            WebElement aTag = button.findElement(By.tagName("a"));
            Assert.assertTrue(aTag.isDisplayed(), "Sosyal medya butonu görüntülenemedi: " + aTag.getAttribute("title"));
            Assert.assertTrue(aTag.getAttribute("href") != null && !aTag.getAttribute("href").isEmpty(),
                    "Sosyal medya butonunda geçerli bir link bulunamadı: " + aTag.getAttribute("title"));
            extentTest.pass("Sosyal medya butonu ve linki mevcut: " + aTag.getAttribute("title"));
        }

        // Test bittiğinde sayfayı kapatır
        extentTest.info("Sayfa kapatıldı");
    }
}
