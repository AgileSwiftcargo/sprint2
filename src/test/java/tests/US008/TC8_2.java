package tests.US008;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.time.LocalTime;

import static utilities.Driver.driver;

public class TC8_2 extends CrossTestBaseRapor {

    @Test
    public void memnuniyetVerileriGoruntulemeSureTesti(){
        extentTest = extentReports.createTest("Memnuniyet Verileri Görüntülenme Süre Testi",
                "Memnuniyet verileri 4 saniye'nin altında görüntülenmeli");
        LocalTime start = LocalTime.now();

        driver.get("https://qa.agileswiftcargo.com/");
        driver.findElement(By.xpath(("//*[.='Happy Achievement']"))).isDisplayed();


        LocalTime finish = LocalTime.now();
        int millis = (int) Duration.between(start, finish).toSeconds();
        System.out.println("Memnuniyet verileri yuklenme suresi " + millis + " seconds");

        Assert.assertTrue(millis < 4);
        extentTest.pass("Anasayfanın 4 saniye'nin altında görüntülendiğini doğrular");
    }


}
