package tests.US001;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.time.LocalTime;

public class TC1_2 extends TestBaseRapor {
    @Test
    public void anasayfaGoruntulenmeSureTesti (){

        LocalTime start = LocalTime.now();

        Driver.getDriver().get("https://qa.agileswiftcargo.com/");

        LocalTime finish = LocalTime.now();
        int millis = (int) Duration.between(start, finish).toSeconds();
        System.out.println("Anasayfa yuklenme suresi " + millis + " seconds");

        Assert.assertTrue(millis < 4);
    }
}
