package tests.US012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class TC12_1 extends CrossTestBaseRapor {

    @Test
    public void contactMenuKontrol(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Anasayfa Header Testi",
                "Header Kismi ve Navigasyon Bari Olmali");

        //1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

    //2_Sayfanın header kısmında "Contact" menü başlığı olduğunu doğrular.

        String expectedName = "Contact";
        String actualName = locator.navContact.getText();
        Assert.assertEquals(actualName,expectedName);
        extentTest.pass("Header'da contact butonu bulunmaktadır.");

        // Header kısmında Contact bölümünün olduğunu doğrulama

        String expectedButton = "Contact";
        ArrayList<String> navList = new ArrayList<>();

        List<WebElement> buttons = driver.findElements(By.xpath("//ul[@class='navbar-nav']"));
        for (int i= 0; i< buttons.size(); i++){
            Assert.assertTrue(buttons.get(i).getText().contains(expectedButton));
            navList.add(buttons.get(i).getText());
        }
        extentTest.pass("Header'da contact butonu bulunmaktadır.(Test2)");

    //3_Sayfayı kapatır.
        extentTest.info("Sayfayi Kapatir");


    }
}
