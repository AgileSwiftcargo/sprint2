package tests.US011;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;


public class TC11_2 extends CrossTestBaseRapor {

    @Test

    public void AnasayfaHeader() {

        extentTest = extentReports.createTest("Anasayfa FQA testi",
                "FQA sekmesi");
        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("kullanıcı ana sayfaya gider");
        Locator locator = new Locator();
        extentTest = extentReports.createTest("FQA tıklama testi," +
                "sıkça  sorulan sorular görülür");
        ReusableMethods.bekle(3);

     locator.navFAQ.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
        extentTest.pass("FAQ basligina tiklar soruların acıldıgını kontrol eder");
        WebElement webElement = driver.findElement(By.xpath("//*[text()='  Have Question ']"));

        Assert.assertTrue(locator.navFAQ.isDisplayed());

        extentTest.pass("soruların acılır oldugunu dogrular");

        extentTest.info("sayfayı kapatır");


    }
}
