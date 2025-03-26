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

    //2_Enter name textboxına tıklar.

        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).click();

    //3_Klavye ile yazı yazar.
        driver.findElement(By.xpath("//input[@placeholder='Enter name']")).sendKeys("Lutfi");

    //4_Enter email textboxına tıklar.
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).click();

    //5_Klavye ile yazı yazar.
        driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("lutfi@agileswiftcargo.com");

    //6_Enter subject textboxına tıklar.
        driver.findElement(By.xpath("//input[@placeholder='Enter subject']")).click();

    //7_Klavye ile yazı yazar.

        driver.findElement(By.xpath("//input[@placeholder='Enter subject']")).sendKeys("Kargom Nerede?");

    //8_Message textboxına tıklar.
        driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).click();

    //9_Klavye ile yazı yazar.
        driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).sendKeys("Sayın Yetkili, kargon nerede? Acil bana yazın.?");

    //10_Submit butonuna tıklar. "Succes: Message Sent successfully" mesajı çıkar.

        locator.submitButton.click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Success']")).isDisplayed());



    //11_Sayfayı kapatır.

    }
}
