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
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Kullanici contact sayfasına gider");

    //2_Submit butonuna tıklar.

        locator.submitButton.click();
        extentTest.info("Submit butonuna tıklar.");
        //Formdaki ilgili alanlardan herhangi biri eksik doldurulduğunda, alanlar için aşağıdaki uyarılar çıkmalıdır;
        // Name : "The Name field is required."
        Assert.assertTrue(driver.findElement(By.xpath("//p[.='The Name field is required.']")).isDisplayed());
        extentTest.pass("Name : \"The Name field is required.\" uyarısı çıkmıştır");
        // Email : "The Email field is required."

        Assert.assertTrue(driver.findElement(By.xpath("(//p[.='The Email field is required.'])[1]")).isDisplayed());
        extentTest.pass("Email : \"The Email field is required.\"uyarısı çıkmıştır.");
        // Subject : "The subject field is required."

        Assert.assertTrue(driver.findElement(By.xpath("//p[.='The subject field is required.']")).isDisplayed());
        extentTest.pass("Subject : \"The subject field is required.\" uyarısı çıkmıştır.");
        // Message: "The message field is required."

        Assert.assertTrue(driver.findElement(By.xpath("//p[.='The message field is required.']")).isDisplayed());
        extentTest.pass("Message: \"The message field is required.\" uyarısı çıkmıştır.");
    //3_Sayfayı kapatır.
        extentTest.info("Sayfayi Kapatir");


    }
}
