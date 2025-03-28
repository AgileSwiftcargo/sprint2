package tests.US012;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.time.Duration;

public class TC12_9 extends CrossTestBaseRapor {

    @Test
    public void zorunluEmailField (){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Yanlış email uyarısı",
                "Formdaki Email textboxında mail formatı girilmediğinde The Email field is required uyarısı vermeli, uygun olan format girişi yapıldığında uyarı vermemelidir.");

    //1_https://qa.agileswiftcargo.com/contact-send adresine gider.
        driver.get(ConfigReader.getProperty("ContactUrl"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Kullanici contact sayfasına gider");
    //2_Enter email textboxına tıklar.
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).click();
        extentTest.info("Enter email textbox'ına tıklar");
    //3_Klavye ile yazı yazar.

        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("lutfi@");
        extentTest.info("Email textbox'ına \"lutfi@\" girişi sağlar.");
    //4_Submit butonuna tıklar, uyarı yazısı çıktığını doğrular.
        locator.submitButton.click();
        extentTest.info("Submit butonuna tıklar");
        //ReusableMethods.bekle(1);


        //Alert alert= driver.switchTo().alert();
        //String alertText = alert.getText();
        //System.out.println("Alert metni: " + alertText);



        //5_Email başlıklı textboxa tıklar.

    //6_Klavye ile yazı yazar.
    //7_Submit butonuna tıklar.
    //8_Enter email textboxına tıklar.
    //5_Klavye ile yazı yazar.
    //2_Submit butonuna tıklar.
    //7_Sayfayı kapatır.
        extentTest.info("Sayfayi Kapatir");


    }

}
