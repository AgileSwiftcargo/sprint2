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

        //2_Enter tracking id" textboxuna tıklar.
        locator.enterTrackingIdTextbox.click();

        //3_Doğru tracking id'yi girer.
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("GecerliTrackId"));

        //4_Track Now butonuna tıklar ve kargo takip sayfasının açıldığını doğrular..
        locator.tracknowButton.click();
        String expectedGecerliTrackingKontrol = "# AS741017851C507";
        String actualGecerliTrackKontrol = driver
                        .findElement(By.xpath("//span[.='# AS741017851C507']"))
                                                .getText();
        Assert.assertEquals(actualGecerliTrackKontrol, expectedGecerliTrackingKontrol);


    //5_Sayfayı kapatınır.

    }
}
