package tests.US017;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC17_10 extends CrossTestBaseRapor {
    @Test
    public void loginForgotPasswordLinkTesti() {

        extentTest = extentReports.createTest("Sıgn Up Here Link Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        driver.findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Login Butonuna Tıklar");

        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("//*[.='Forgot Password']")).click();
        extentTest.info("Forgot Password Linkine Tıklar");

        ReusableMethods.bekle(1);

        String expectedUrl = "https://qa.agileswiftcargo.com/password/reset";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Reset Password Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
