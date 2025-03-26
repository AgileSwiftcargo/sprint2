package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC17_1 extends CrossTestBaseRapor {
    @Test
    public void LoginSayfasinaErisimTesti() {

        extentTest = extentReports.createTest("Login Sayfası Erişim Testi",
                "Login sayfasına erişilebilmeli");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        driver.findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Login butonuna tıklar");

        ReusableMethods.bekle(1);

        WebElement emailBox = driver.findElement(By.id("email"));
        Assert.assertTrue(emailBox.isDisplayed());
        extentTest.pass("Login Sayfasının Görüntülendiğini Test Eder");

        extentTest.info("Sayfayı Kapatır");

    }
    }
