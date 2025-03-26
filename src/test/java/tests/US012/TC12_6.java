package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_6 extends CrossTestBaseRapor {

    @Test
    public void zorunluAlanUyarıları (){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Zorunlu Alan Uyarısı",
                "Formdaki ilgili alanlardan herhangi biri eksik doldurulduğunda, alanlar için aşağıdaki uyarılar çıkmalıdırhe Name field is required Email :The Email field is required.");

    //1_https://qa.agileswiftcargo.com/contact-send adresine gider.

        driver.get(ConfigReader.getProperty("ContactUrl"));

    //2_Submit butonuna tıklar.

        locator.submitButton.click();
        //Formdaki ilgili alanlardan herhangi biri eksik doldurulduğunda, alanlar için aşağıdaki uyarılar çıkmalıdır;
        // Name : "The Name field is required."
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='The Name field is required.']")).isDisplayed());

        // Email : "The Email field is required."

        Assert.assertTrue(driver.findElement(By.xpath("(//p[.='The Email field is required.'])[1]")).isDisplayed());

        // Subject : "The subject field is required."

        Assert.assertTrue(driver.findElement(By.xpath("//p[.='The subject field is required.']")).isDisplayed());

        // Message: "The message field is required."

        Assert.assertTrue(driver.findElement(By.xpath("//p[.='The subject field is required.']")).isDisplayed());

    //3_Sayfayı kapatır.


    }
}
