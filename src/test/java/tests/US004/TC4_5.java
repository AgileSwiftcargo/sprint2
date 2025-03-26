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
    //2_Testbox'a tıklar.
        locator.enterTrackingIdTextbox.click();
    //3_İçerisindeki yazıyı silip AS741017851C507 yazar.
        locator.enterTrackingIdTextbox.clear();
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("GecerliTrackId"));
    //4_Track Now butonuna tıklar.
        locator.tracknowButton.click();

    //5_ Açılan sayfada textbox'ta AS741017851C507 olduğunu doğrular.

        String expectedGecerliTrackingKontrol = "# AS741017851C507";
        String actualGecerliTrackingKontrol = driver
                .findElement(By.xpath("//span[.='# AS741017851C507']"))
                .getText();
        Assert.assertEquals(actualGecerliTrackingKontrol, expectedGecerliTrackingKontrol);

    //6_Sayfayı kapatınır.


    }

}
