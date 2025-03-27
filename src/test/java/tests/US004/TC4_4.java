package tests.US004;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC4_4 extends CrossTestBaseRapor {

    @Test
    public void ParcelNotFound(){

    Locator locator = new Locator();
    extentTest = extentReports.createTest("Parcel Not Found Uyarısı",
            "Gecersiz kargo takip numarasiyla kargo takip islemi yapıldığında parcel not found uyarısı çıkmalıdır");

    //1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));


    //2_Enter tracking id" textboxuna tıklar.
        locator.enterTrackingIdTextbox.click();
    //3_Yanlış tracking id'yi girer.
        locator.enterTrackingIdTextbox.sendKeys(ConfigReader.getProperty("GecersizTrackId"));
    //4_Track Now butonuna tıklar.
        String firstWindow = driver.getWindowHandle();
        locator.tracknowButton.click();
        String secondWindow = driver.getWindowHandle();
        Assert.assertEquals(secondWindow,firstWindow);

    //5_ Açılan sayfada textbox'ta AS741017851C olduğunu doğrular.
        String expectedGecersizTrackingKontrol = "# AS741017851C";
        String actualGecersizTrackingKontrol = driver
                .findElement(By.xpath("//span[.='# AS741017851C']"))
                .getText();
        Assert.assertEquals(actualGecersizTrackingKontrol, expectedGecersizTrackingKontrol);
    //6_ Parcel Not Found yazısının gözüktüğünü doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//img[@src='https://qa.agileswiftcargo.com/public/frontend/images/parcel-was-not-found.png']")).isDisplayed());

    //7_Sayfayı kapatır.

    }

}
