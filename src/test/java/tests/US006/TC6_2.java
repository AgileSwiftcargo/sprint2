package tests.US006;

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

public class TC6_2 extends CrossTestBaseRapor {
    @Test
    public void testLinksInCourierBoxes() {

        extentTest = extentReports.createTest("Why Agile Swift Cargo Boxlarının Link Kontrolü",
                "Kullanıcılar, bu alanda sunulan bilgilerle ilgili daha fazla detay almak için uygun bağlantılara yönlendirilmelidir.");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici Agile Swift Cargo ana sayfasina gider");

        Locator locator = new Locator();
        Actions actions = new Actions(driver);
        actions.moveToElement(locator.WhyAgileSwiftCargoText).perform();
        // Tüm Why Courier Boxlarını seçer
        List<WebElement> courierBoxes = driver.findElements(By.cssSelector(".why-courier-col"));

        for (WebElement box : courierBoxes) {
            // Her bir kutunun içinde <a> etiketi olup olmadığını kontrol eder
            List<WebElement> links = box.findElements(By.tagName("a"));

            if (links.isEmpty()) {
                extentTest.fail("Kutuda link bulunamadı: " + box.getText());
            } else {
                extentTest.pass("Kutuda en az bir link bulundu: " + box.getText());
            }

            // Her kutuda en az bir link olması gerektiğini doğrular
            Assert.assertFalse(links.isEmpty(), "Link bulunamadı: " + box.getText());
        }

        // Test bittiğinde sayfayı kapatır
        extentTest.info("Sayfa kapatıldı");
    }
}
