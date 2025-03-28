package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_7 extends CrossTestBaseRapor {

    @Test
    public void successMesajı(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Success Mesajı",
                "Kulanıcı bilgileri eksiksiz doldurup, gönderim işlemini yaptığında, sayfada Succes: Message Sent successfully bildirimi çıkmalıdır.");


    //1_https://qa.agileswiftcargo.com/contact-send adresine gider.

        driver.get(ConfigReader.getProperty("ContactUrl"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Kullanici contact sayfasına gider");

    //2_Enter name textboxına tıklar.

        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).click();
        extentTest.info("Enter name textbox'ına tıklar");
    //3_Klavye ile yazı yazar.
        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("Lutfi");
        extentTest.info("Enter name textbox'ına \"Lutfi\" yazar");
    //4_Enter email textboxına tıklar.
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).click();
        extentTest.info("Enter email textbox'ına tıklar");
    //5_Klavye ile yazı yazar.
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("lutfi@agileswiftcargo.com");
        extentTest.info("Enter name textbox'ına \"lutfi@agileswiftcargo.com\" yazar");
    //6_Enter subject textboxına tıklar.
        driver.findElement(By.xpath("//input[@placeholder='Enter subject']")).click();
        extentTest.info("Enter subject textbox'ına tıklar");
    //7_Klavye ile yazı yazar.

        driver.findElement(By.xpath("//input[@placeholder='Enter subject']")).sendKeys("Kargom Nerede?");
        extentTest.info("Enter name textbox'ına \"Kargon nerede?\" yazar");
    //8_Message textboxına tıklar.
        driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).click();
        extentTest.info("Message textbox'ına tıklar");
    //9_Klavye ile yazı yazar.
        driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).sendKeys("Sayın Yetkili, kargon nerede? Acil bana yazın.?");
        extentTest.info("\"Sayın Yetkili, kargon nerede? Acil bana yazın.\" yazar");
    //10_Submit butonuna tıklar. "Succes: Message Sent successfully" mesajı çıkar.

        locator.submitButton.click();
        extentTest.info("Submit butonuna tıklar");

        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Success']")).isDisplayed());
        extentTest.pass("Başarılı şekilde gönderim sağlanır.");


    //11_Sayfayı kapatır.
        extentTest.info("Sayfayi Kapatir");
    }
}
