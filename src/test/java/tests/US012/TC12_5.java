package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_5 extends CrossTestBaseRapor {

    @Test
    public void zorunluAlanlar(){

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Zorunlu Alan Testi",
                "İletişim formunda Name, Email, Subject, Message textboxları ile gönderimi sağlayan submit butonu bulunmalıdır.");

        //1_https://qa.agileswiftcargo.com/contact-send adresine gider.

    driver.get(ConfigReader.getProperty("ContactUrl"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Kullanici contact sayfasına gider");
    //2_ Textbox başlıklarında * ile belirtme yapıldığını doğrular.

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-danger'][1]")).isDisplayed());
        extentTest.pass("Zorunlu alanları belirtmek için \"*\" işareti kullanılmıştır.");
        String actualDanger = driver.findElement(By.xpath("//span[@class='text-danger'][1]")).getText();
        String expectedDanger = "*";

        Assert.assertEquals(actualDanger,expectedDanger);
        extentTest.pass("Zorunlu alanları belirtmek için \"*\" işareti kullanılmıştır.");

    //3_ * alanlarının zorunlu alan olduğunu belirten bir yazı yazar.

        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='text-danger'][1]")).isDisplayed());
        String actualZorunluALan = driver.findElement(By.xpath("//span[@class='text-danger'][1]")).getText();
        String expectedZorunluAlan = "* Girilmesi Zorunludur";

        softAssert.assertEquals(actualZorunluALan,expectedZorunluAlan);
        extentTest.pass("\"*\" işaretinin zorunlu alan olduğu belirtilmiştir.");

        extentTest.fail("\"*\" işaretinin zorunlu alan olduğu belirtilmemiştir.");
    //4_Sayfayı kapatır.
        extentTest.info("Sayfayi Kapatir");
        softAssert.assertAll();


    }
}
