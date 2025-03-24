package tests.US017;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.Driver;

public class TC17_9 extends CrossTestBaseRapor {
    @Test
    public void loginSignUpHereLinkTesti() {

        extentTest = extentReports.createTest("Sıgn Up Here Link Testi",
                "Login Paneli Görüntülenebilir ve Erişilebilir Olmalı");

        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanıcı Anasayfaya Gider");

        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        extentTest.info("Login Butonuna Tıklar");

        Driver.getDriver().findElement(By.xpath("//*[.='Sign up here']")).click();
        extentTest.info("Sıgn In Here Linkine Tıklar");


        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/sign-up";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Sıgn Up Sayfasının Görüntülendiğini Doğrular");

        extentTest.info("Sayfayı Kapatır");

    }
}
