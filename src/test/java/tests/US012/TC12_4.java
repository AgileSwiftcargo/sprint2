package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_4 extends CrossTestBaseRapor {

    @Test
    public void iletisimFormu(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("İletişim formu testi",
                "İletişim formunda Name, Email, Subject, Message textboxları ile gönderimi sağlayan submit butonu bulunmalıdır.");

    //1_https://qa.agileswiftcargo.com/contact-send adresine gider.

        driver.get(ConfigReader.getProperty("ContactUrl"));

    //2_Sayfada Contact Us yazısının olduğunu doğrular

        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='  Contact Us ']")).isDisplayed());

    //3_Name textboxının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter name']")).isDisplayed());

    //4_Email textboxının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter email']")).isDisplayed());

    //5_Subject textboxının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='Enter subject']")).isDisplayed());

    //6_Message textboxının olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).isDisplayed());

    //7_Submit butonunun olduğunu doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//textarea[@placeholder='Enter your message']")).isDisplayed());

    //8_Sayfayı kapatır.

    }


}
