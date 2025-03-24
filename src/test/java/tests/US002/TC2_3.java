package tests.US002;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TC2_3 extends CrossTestBaseRapor {

    @Test
    public void MenuBasliklariSecimi() throws IOException {

        Locator locator = new Locator();

        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Menu Basliklari Secimi Testi",
                "Menu basliklari tiklandiginda secili ve vurgulu gozukmeli");

        driver.get(ConfigReader.getProperty("Url"));
        softAssert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        List<WebElement> navLinks = driver.findElements(By.xpath("//*[contains(@class, 'nav-link')]"));

// Loop through all the nav-link elements and verify if each is displayed
        for (int i = 0; i < navLinks.size(); i++) {
            softAssert.assertTrue(navLinks.get(i).isDisplayed(), "Nav link at index " + (i + 1) + " is not displayed.");
        }
        extentTest.pass("Menu basliklarinin gorundugunu dogrular");

        List<String> menus = Arrays.asList("Home", "Pricing", "Tracking", "Blogs", "About", "FAQ", "Contact");
        for (String menu : menus) {
            WebElement link = driver.findElement(By.xpath("//a[.='" + menu + "']"));
            softAssert.assertEquals(link.getCssValue("cursor"), "pointer");
            extentTest.pass(menu + " tiklanabilir ");
        }

        for (String menu : menus) {

            try {
                driver.findElement(By.xpath("//a[.='"+ menu +"']")).click();

                // Sayfayi en Yukari kaldirir
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, 0);");


                boolean isActive = driver.findElement(By.xpath("//a[.='"+ menu +"']"))
                        .getAttribute("class").contains("active");
                if (!isActive) {
                    throw new AssertionError(menu + " Linki Secili gozukmuyor");
                }
                extentTest.pass(menu + " tiklar, secili ve vurgulanmis oldugunu gozlemler");
            } catch (AssertionError e) {
                captureFailure(menu +  " Linki Secili gozukmuyor");
                softAssert.fail(e.getMessage());

            }

        }

        softAssert.assertAll();
    }
}
