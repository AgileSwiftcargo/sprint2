package tests.US004;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC4_3 extends CrossTestBaseRapor {

    @Test
    public void GecerliKargoTakipEnterButonu() {

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Enter butonu ile Gecerli Kargo Takibi",
                "Gecerli kargo takip numarasiyla kargo takip islemi yapılabilmelidir");


        //1_https://qa.agileswiftcargo.com/ adresine gider.

        driver.get(ConfigReader.getProperty("Url"));

        //2_Enter tracking id" textboxuna tıklar.
        locator.enterTrackingIdTextbox.click();

        //3_Doğru tracking id'yi girer ve enter butonuna tıklar.
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("GecerliTrackId") + Keys.ENTER);


        //4_Kargo takip sayfasının açıldığını doğrular..

        String expectedGecerliTrackingKontrol = "# AS741017851C507";
        String actualGecerliTrackingKontrol = driver
                .findElement(By.xpath("//span[.='# AS741017851C507']"))
                .getText();
        Assert.assertEquals(actualGecerliTrackingKontrol, expectedGecerliTrackingKontrol);

        //5_Sayfayı kapatır.

    }

}
