package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_9 extends CrossTestBaseRapor {

    @Test
    public void zorunluEmailField (){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Yanlış email uyarısı",
                "Formdaki Email textboxında mail formatı girilmediğinde The Email field is required uyarısı vermeli, uygun olan format girişi yapıldığında uyarı vermemelidir.");

    //1_https://qa.agileswiftcargo.com/contact-send adresine gider.
        driver.get(ConfigReader.getProperty("ContactUrl"));

    //2_Enter email textboxına tıklar.
        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).click();
    //3_Klavye ile yazı yazar.

        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("lutfi@");

    //4_Submit butonuna tıklar, uyarı yazısı çıktığını doğrular.
        locator.submitButton.click();


    //5_Email başlıklı textboxa tıklar.

    //6_Klavye ile yazı yazar.
    //7_Submit butonuna tıklar.
    //8_Enter email textboxına tıklar.
    //5_Klavye ile yazı yazar.
    //2_Submit butonuna tıklar.
    //7_Sayfayı kapatır.
    }

}
