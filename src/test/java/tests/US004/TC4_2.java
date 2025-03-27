package tests.US004;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC4_2 extends CrossTestBaseRapor {

    @Test
    public void GecerliKargoTakipTrackNowButonu(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Tracknow butonu ile Gecerli Kargo Takibi",
                "Gecerli kargo takip numarasiyla kargo takip islemi yapılabilmelidir");


        //1_https://qa.agileswiftcargo.com/ adresine gider.

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        //2_Enter tracking id" textboxuna tıklar.
        locator.enterTrackingIdTextbox.click();
        extentTest.info("\"Enter tracking id\" textboxuna tıklar");

        //3_Doğru tracking id'yi girer.
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("GecerliTrackId"));
        extentTest.info("Doğru tracking id'yi girer.");

        //4_Track Now butonuna tıklar ve kargo takip sayfasının açıldığını doğrular..
        locator.tracknowButton.click();
        extentTest.info("TrackNow butonuna tıklar");
        String expectedGecerliTrackingKontrol = "# AS741017851C507";
        String actualGecerliTrackKontrol = driver
                        .findElement(By.xpath("//span[.='# AS741017851C507']"))
                                                .getText();
        Assert.assertEquals(actualGecerliTrackKontrol, expectedGecerliTrackingKontrol);
        extentTest.pass("AS741017851C507 nolu kargonun kargo takibi sağlanır.");

    //5_Sayfayı kapatınır.
        extentTest.info("Sayfayi Kapatir");

    }
}
