package tests.US002;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC2_3 extends CrossTestBaseRapor {

    @Test
    public void MenuBasliklariSecimi() throws IOException {

        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(driver);

        extentTest = extentReports.createTest("Menu Basliklari Secimi Testi",
                "Menu basliklari tiklandiginda secili ve vurgulu gozukmeli");

        driver.get(ConfigReader.getProperty("Url"));
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");


        softAssert.assertTrue(driver.findElement(By.xpath("(//*[contains(@class, 'nav-link')])[1]")).isDisplayed());
        extentTest.pass("Menu basliklarinin gorundugunu dogrular");


        List<String> menus = Arrays.asList("Home", "Pricing", "Tracking", "Blogs", "About", "FAQ", "Contact");
        for (String menu : menus) {
            WebElement link = driver.findElement(By.xpath("//a[.='" + menu + "']"));
            softAssert.assertEquals(link.getCssValue("cursor"), "pointer");
            extentTest.pass(menu + " is clickable");
        }


        softAssert.assertEquals(driver.findElement(By.xpath("//a[.='Contact']")).getCssValue("cursor"),"pointer");
        extentTest.pass("Menu basliklarinin tiklanabilir oldugunu kontrol eder");


        driver.findElement(By.xpath("//a[.='Home']")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("//a[.='Home']")).getAttribute("class").contains("active"));
        extentTest.pass("Home'a tiklar, secili ve vurgulanmis oldugunu gozlemler");




        try {
            driver.findElement(By.xpath("//a[.='Pricing']")).click();

            actions.sendKeys(Keys.HOME).perform(); // Scroll to the top
            ReusableMethods.bekle(1);
            boolean isActive = driver.findElement(By.xpath("//a[.='Pricing']"))
                    .getAttribute("class").contains("active");
            if (!isActive) {
                throw new AssertionError("Pricing Linki Secili gozukmuyor");
            }
            extentTest.info("Pricing'e tiklar, secili ve vurgulanmis oldugunu gozlemler");
        } catch (AssertionError e) {
            System.out.println("Assertion captured");
            captureFailure("Pricing Linki Secili gozukmuyor");
            softAssert.fail(e.getMessage());

        }


        driver.findElement(By.xpath("//a[.='Tracking']")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("//a[.='Tracking']")).getAttribute("class").contains("active"));
        extentTest.pass("Tracking'e tiklar, secili ve vurgulanmis oldugunu gozlemler");


        driver.findElement(By.xpath("//a[.='Blogs']")).click();
        softAssert.assertTrue(driver.findElement(By.xpath("//a[.='Blogs']")).getAttribute("class").contains("active"));
        extentTest.pass("Blogs'a tiklar, secili ve vurgulanmis oldugunu gozlemler");

        softAssert.assertAll();
    }
}
