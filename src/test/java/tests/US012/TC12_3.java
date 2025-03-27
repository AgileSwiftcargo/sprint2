package tests.US012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC12_3 extends CrossTestBaseRapor {

    @Test
    public void contactFirmaBilgileri(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Contact Us Firma Bilgileri Testi",
                "Firmanın adres bilgileri ve map konumu olmalıdır");

    //1_https://qa.agileswiftcargo.com/contact-send adresine gider.
        driver.get("https://qa.agileswiftcargo.com/contact-send");
    //2_Firmanın Email adresinin görünür ve doğru olduğunu doğrular.
        Assert.assertTrue(driver.findElement(By.xpath("//h3[.='  Address:']")).isDisplayed());

        WebElement mailAdres = driver.findElement(By.xpath("//*[.='Email : info@agileswiftcargo.com']"));
        Assert.assertTrue(mailAdres.isDisplayed());

        String expectedMailAdres = "Email : info@agileswiftcargo.com";
        Assert.assertEquals(mailAdres.getText(),expectedMailAdres);

    //3_Firmanın telefon numarasının görünür ve doğru olduğunu doğrular.

        WebElement phoneNumber = driver.findElement(By.xpath("//*[.='Phone : +13143383298']"));
        Assert.assertTrue(phoneNumber.isDisplayed());

        String expectedPhoneNumber = "Phone : +13143383298";
        Assert.assertEquals(phoneNumber.getText(),expectedPhoneNumber);
    //4_Firmanın adresinin görünür ve doğru olduğunu doğrular.
        WebElement address = driver.findElement(By.xpath("//*[.='Address: 491 Cottekill Rd Stone Ridge NY 12484 USA']"));
        Assert.assertTrue(address.isDisplayed());

        String expectedAddress = "Address: 491 Cottekill Rd Stone Ridge NY 12484 USA";
        Assert.assertEquals(address.getText(),expectedAddress);


    //5_Google map haritasının var olduğunu doğrular.


        WebElement googleMap = driver.findElement(By.xpath("//section[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(googleMap).perform();

        Assert.assertTrue(googleMap.isDisplayed());


    //6_Sayfayı kapatır.

    }

}
