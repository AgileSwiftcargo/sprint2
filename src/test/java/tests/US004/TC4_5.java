package tests.US004;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC4_5 extends CrossTestBaseRapor {

    @Test
    public void gecersizdenGecerliyeGecis(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Gecersizden gecerliye",
                "Gecersiz kargo takip numarası ile arama yapıldıktan " +
                        "sonra açılan sayfada geçerli kargo takip numarasıyla kargo sorgulama");

    //1_'https://qa.agileswiftcargo.com/tracking?tracking_id=AS741017851C adresine gider.

        driver.get("https://qa.agileswiftcargo.com/tracking?tracking_id=AS741017851C");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking?tracking_id=AS741017851C");
        extentTest.pass("https://qa.agileswiftcargo.com/tracking?tracking_id=AS741017851C adresine ulaşılır");

    //2_Testbox'a tıklar.
        locator.enterTrackingIdTextbox.click();
        extentTest.info("\"Enter tracking id\" textboxuna tıklar");

    //3_İçerisindeki yazıyı silip AS741017851C507 yazar.
        locator.enterTrackingIdTextbox.clear();
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("GecerliTrackId"));
        extentTest.info("Doğru tracking id'yi girer.");
    //4_Track Now butonuna tıklar.
        locator.tracknowButton.click();
        extentTest.info("TrackNow butonuna tıklar");

    //5_ Açılan sayfada textbox'ta AS741017851C507 olduğunu doğrular.

        String expectedGecerliTrackingKontrol = "# AS741017851C507";
        String actualGecerliTrackingKontrol = driver
                .findElement(By.xpath("//span[.='# AS741017851C507']"))
                .getText();
        Assert.assertEquals(actualGecerliTrackingKontrol, expectedGecerliTrackingKontrol);
        extentTest.pass("AS741017851C507 nolu kargonun kargo takibi sağlanır.");

    //6_Sayfayı kapatınır.
        extentTest.info("Sayfayi Kapatir");


    }

}
