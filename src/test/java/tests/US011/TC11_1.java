package tests.US011;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;


    public class TC11_1 extends CrossTestBaseRapor {

        @Test

        public void AnasayfaHeader( ) {

            extentTest = extentReports.createTest("Anasayfa FQA testi",
                    "FQA sekmesi");
            driver.get(ConfigReader.getProperty("Url"));
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
            extentTest.pass("kullanıcı ana sayfaya gider");



            Locator locator = new Locator();
            extentTest = extentReports.createTest("FQA tıklama testş," +
                    "sıkça  sorulan sorular görülür");

            locator.navFAQ.click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
            extentTest.pass("FAQ basligina tiklar soruların acıldıgını kontrol eder");

            extentTest.info("sayfayı kapatır");




        }
}
