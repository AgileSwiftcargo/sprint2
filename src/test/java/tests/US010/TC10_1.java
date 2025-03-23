package tests.US010;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC10_1 extends CrossTestBaseRapor {

    @Test
    public void TestNavBlogs() {

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Anasayfa Blogs Basligi ",
                "Navigasyon menusunde blogs menu basligi olmalidir");

        driver.get(ConfigReader.getProperty("Url"));
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Anasayfaya gider");

        locator.navBlogs.isDisplayed();
        extentTest.pass("Blogs basliginin oldugunu gorur");

        locator.navBlogs.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs basligina tiklar");

        ReusableMethods.bekle(1);

        extentTest.info("Sayfayi Kapatir");

        softAssert.assertAll();


    }
}
