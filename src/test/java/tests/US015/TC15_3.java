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

public class TC15_3 extends CrossTestBaseRapor {
    Busra busra ;
    @Test
    public void sıkSorulanSorularTesti(){

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("İlgili başlığa tıklama testi",
                "Başlıklara tıklandığında doğru sayfa açılmalı");


        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Anasayfaya gider");

     locator.FAQButonu.click();









    }










}
