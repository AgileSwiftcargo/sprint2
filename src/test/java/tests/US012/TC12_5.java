package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_5 extends CrossTestBaseRapor {

    @Test
    public void zorunluAlanlar(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Zorunlu Alan Testi",
                "İletişim formunda Name, Email, Subject, Message textboxları ile gönderimi sağlayan submit butonu bulunmalıdır.");

        //1_https://qa.agileswiftcargo.com/contact-send adresine gider.

    driver.get(ConfigReader.getProperty("ContactUrl"));

    //2_ Textbox başlıklarında * ile belirtme yapıldığını doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-danger'][1]")).isDisplayed());
        String actualDanger = driver.findElement(By.xpath("//span[@class='text-danger'][1]")).getText();
        String expectedDanger = "*";

        Assert.assertEquals(actualDanger,expectedDanger);


    //3_ * alanlarının zorunlu alan olduğunu belirten bir yazı yazar.

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-danger'][1]")).isDisplayed());
        String actualZorunluALan = driver.findElement(By.xpath("//span[@class='text-danger'][1]")).getText();
        String expectedZorunluAlan = "* Girilmesi Zorunludur";

        Assert.assertEquals(actualZorunluALan,expectedZorunluAlan);


    //4_Sayfayı kapatır.


    }
}
