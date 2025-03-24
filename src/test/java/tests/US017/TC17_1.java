package tests.US017;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC17_1 extends CrossTestBaseRapor {
    @Test
    public void LoginSayfasinaErisimTesti() {

        extentTest = extentReports.createTest("Login Sayfası Erişim Testi",
                "Login sayfasına erişilebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Login butonuna tıklar");

        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        Assert.assertTrue(emailBox.isDisplayed());
        extentTest.pass("Login Sayfasının Görüntülendiğini Test Eder");

        extentTest.info("Sayfayı Kapatır");

    }
    }
