package tests.US004;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import java.io.IOException;
import java.util.List;

public class TC4_6 extends CrossTestBaseRapor {

    @Test
    public void kargoDurumuSorgulama() throws IOException {

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Eksik Kargo Takip",
                "Eksik kargo takip numarası ile arama yapıldığında tamamlanacak adımların kontrolü");

    //1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

    //2_Enter tracking id" textboxuna tıklar.
        locator.enterTrackingIdTextbox.click();
        extentTest.info("\"Enter tracking id\" textboxuna tıklar");
    //3_Eksik tracking id'yi girer.
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("EksikTrackId"));
        extentTest.info("Eksik tracking id girilir.");

    //4_Track Now butonuna tıklar.
        locator.tracknowButton.click();
        extentTest.info("TrackNow butonuna tıklar");

    //5_Tamamlanması gereken adımları ve tahminen ne zaman tamamlanacağının var olduğunu doğrular.
        List<WebElement> cargoStepsList =
                driver.findElements(By.xpath("//div[@class='cd-timeline__block js-cd-block']"));
        int expectedCargoSteps = 7;
        int actualCargoSteps = cargoStepsList.size();

        softAssert.assertEquals(actualCargoSteps, expectedCargoSteps);
        extentTest.pass("Tüm kargo adımları bulunmaktadır.");
        extentTest.fail("Kargo adımları bulunmamaktadır.");

    //6_Sayfayı kapatır.

        extentTest.info("Sayfayi Kapatir");
        softAssert.assertAll();

    }

}
