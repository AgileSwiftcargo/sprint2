package tests.US010;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC10_2 extends CrossTestBaseRapor {


    @Test
    public void BlogsSayfasi (){

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Blogs Sayfasi Goruntuleme Testi",
                "Blog sayfasında blog yazıları görünmeli ve kullanıcı bir blog yazısının başlığına tıkladığında, tam içeriği görüntülenmeli");

        driver.get("https://qa.agileswiftcargo.com/get-blogs");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs sayfasina gider");
        ReusableMethods.bekle(3);

        softAssert.assertTrue(locator.blogsYazisi.isDisplayed());
        extentTest.pass("Sayfada Blogs yazisinin oldugunu dogrular");

        softAssert.assertTrue(locator.blogsYaziGirisi.isDisplayed());
        extentTest.pass("Mevcut bir blog yazi girisi oldugunu gorur");

        locator.blogsYaziGirisi.click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/blog-details/1");
        extentTest.pass("Blog yazisin ilkine tiklar");

        softAssert.assertTrue(locator.blogsYaziBasligi.isDisplayed());
        extentTest.pass("Sayfada yazi basligi oldugunu dogrular");

        extentTest.info("Sayfayi Kapatir");
        ReusableMethods.bekle(5);

        softAssert.assertAll();
    }
}
