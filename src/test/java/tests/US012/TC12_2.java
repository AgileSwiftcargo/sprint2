package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import pages.Lutfi;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_2 extends CrossTestBaseRapor {

    @Test
    public void contactPageErisim (){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Contact Us Sayfasına erişim",
                "Contact Us sayfasına erişebilir olmalıdır.");

    //1_https://qa.agileswiftcargo.com/ adresine gider.

        driver.get(ConfigReader.getProperty("Url"));

    //2_Header'daki "Contact" yazısına tıklar. Contact sayfasına erişebildiğini test eder.
        locator.navContact.click();
        String expectedUrl = "https://qa.agileswiftcargo.com/contact-send";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);

        //Contact us isDisplayed,

        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='  Contact Us ']")).isDisplayed());

    //3_Sayfayı kapatır.


    }
}
