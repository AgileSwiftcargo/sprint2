package tests.US001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;


public class TC1_1 extends CrossTestBaseRapor {
    @Test
    public void anasayfaTesti() {

        extentTest = extentReports.createTest("Anasayfa Görüntülenme Testi",
                "Anasayfa Görüntülenmeli");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı anasayfaya gider");

        ReusableMethods.bekle(1);

        WebElement anasayfaAgileSwiftCargoLogo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(anasayfaAgileSwiftCargoLogo.isDisplayed());
        extentTest.pass("Anasayfadaki Agile Swift Cargo İkonunun görüntülendiğini doğrular");

        extentTest.info("Sayfayı kapatır");

    }
}