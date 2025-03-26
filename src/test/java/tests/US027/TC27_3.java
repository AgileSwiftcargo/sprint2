package tests.US027;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.util.List;


public class TC27_3 extends CrossTestBaseRapor {

        Locator locator;

        @Test
        public void ReportsSayfasinaErisimTesti() {
            extentTest = extentReports.createTest("Merchant Reports Sayfasina Erisim Testi",
                    "Merchant, menüde raporların altında totalsummery bağlantılarını görüntülemeli");

            // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
            driver.get(ConfigReader.getProperty("Url"));
            extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");
            ReusableMethods.bekle(3);

            //Merchant gecerli bir e'mail ve geçerli bir password ile login olur
            locator = new Locator();

            locator.loginButonu.click();
            extentTest.info("Merchant login butonuna tiklar gider");

            ReusableMethods.bekle(3);

            locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantFilizGecerliMail"));
            extentTest.info("Geçerli bir email girer");

            locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantFilizGecerliPassword"));
            extentTest.info("Geçerli bir password girer");

            locator.signInButton.click();
            extentTest.info("Sing in butonuna tiklar");
            ReusableMethods.bekle(3);

            Assert.assertTrue(locator.reportsMenuInput.isDisplayed());
            extentTest.pass("Menüde report bağlantısı görüntülenir");


            ReusableMethods.bekle(3);


            locator.reportsMenuInput.click();

            List<WebElement> navLinks = driver.findElements(By.xpath("//*[@id='reports']/ul/li"));

            //Merchant logout olur
            locator.profilResmi.click();
            locator.loguotButonu.click();
            extentTest.info("Logout olur");

            extentTest.info("sayfayi kapatir");
        }
    }


