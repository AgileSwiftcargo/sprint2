package tests.US004;

import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC4_6 extends CrossTestBaseRapor {

    @Test
    public void kargoDurumuSorgulama(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Eksik Kargo Takip",
                "Eksik kargo takip numarası ile arama yapıldığında tamamlanacak adımların kontrolü");

    //1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));

    //2_Enter tracking id" textboxuna tıklar.
        locator.enterTrackingIdTextbox.click();
    //3_Eksik tracking id'yi girer.
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("EksikTrackId"));

    //4_Track Now butonuna tıklar.
        locator.tracknowButton.click();
    //5_Tamamlanması gereken adımları ve tahminen ne zaman tamamlanacağının var olduğunu doğrular.
    //6_Sayfayı kapatır.

    }

}
