package tests.US001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;


public class TC1_1 extends CrossTestBaseRapor {
    @Test
    public void anasayfaTesti() {

        extentTest = extentReports.createTest("Anasayfa Görüntülenme Testi",
                "Anasayfa Görüntülenmeli");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı anasayfaya gider");

        WebElement anasayfaAgileSwiftCargoLogo = Driver.getDriver().findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(anasayfaAgileSwiftCargoLogo.isDisplayed());
        extentTest.pass("Anasayfadaki Agile Swift Cargo İkonunun görüntülendiğini doğrular");

        extentTest.info("Sayfayı kapatır");

    }
}