package tests.US008;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.time.LocalTime;

import static utilities.Driver.driver;

public class TC8_2 extends TestBaseRapor {

    @Test
    public void memnuniyetVerileriGoruntulemeSureTesti(){
        LocalTime start = LocalTime.now();

        Driver.getDriver().get("https://qa.agileswiftcargo.com/");
        driver.findElement(By.xpath(("//*[.='Happy Achievement']"))).isDisplayed();


        LocalTime finish = LocalTime.now();
        int millis = (int) Duration.between(start, finish).toSeconds();
        System.out.println("Memnuniyet verileri yuklenme suresi " + millis + " seconds");

        Assert.assertTrue(millis < 4);
    }


}
