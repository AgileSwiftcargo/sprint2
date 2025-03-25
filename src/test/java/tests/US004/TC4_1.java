package tests.US004;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC4_1 extends CrossTestBaseRapor{



    @Test
    public void AnasayfaTrackArea(){

        Locator locator = new Locator();

    extentTest = extentReports.createTest("Anasayfa Track Butonu ve Textbox Testi",
                "Kargo takip yapabilecek, Track Butonu ve TextBox olmali");


    //1_https://qa.agileswiftcargo.com/ adresine gider.

        driver.get(ConfigReader.getProperty("Url"));

    //2_Sayfada tracking id textbox'ının ve içerisinde "Enter tracking id" yazısının var olduğunu doğrular.

    String actualPlaceholderValue = locator.enterTrackingIdTextbox.getDomAttribute("placeholder");
    String expectedPlaceholderValue = "Enter tracking id";

    Assert.assertEquals(actualPlaceholderValue,expectedPlaceholderValue);


    //3_Sayfada tracknow butonu olduğunu doğrular.

     Assert.assertTrue(locator.tracknowButton.isDisplayed());


    //4_Textbox'a tıkladığınızda veri girebildiğinizi doğrular.

     String expectedTextboxTagName = "input";

     String actualTextboxTagName = locator.enterTrackingIdTextbox.getTagName();

     Assert.assertEquals(actualTextboxTagName,expectedTextboxTagName);


    //5_Sayfayı kapatır.



    }

}
