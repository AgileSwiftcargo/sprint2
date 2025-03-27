package tests.US015;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Busra;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC15_3 extends CrossTestBaseRapor {


       @Test
    public void sıkSorulanSorularTesti(){


        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("İlgili başlığa tıklama testi",
                "Başlıklara tıklandığında doğru sayfa açılmalı");


        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Anasayfaya gider");


           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView(true);", locator.FAQButonu);
           ReusableMethods.bekle(1);


           softAssert.assertEquals(driver.getCurrentUrl(),"(//*[contains(@class,'list-ite')])[5]");
           extentTest.pass("ilgili sayfa açılır");

           locator.FAQButonu.click();
           ReusableMethods.bekle(1);










       }
    }