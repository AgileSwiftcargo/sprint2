package tests.US012;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_8 extends CrossTestBaseRapor {

    @Test
    public void adminMessage(){

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Admin'e Kullanıcı Mesajı",
                "Kullanıcı tarafından iletilen mesaj, admin tarafından görülmelidir.");

    //1_Login sayfaası açılır.
        driver.get(ConfigReader.getProperty("LoginUrl"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");
    //2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.

        locator.emailTextbox.sendKeys("lutfi.admin@agileswiftcargo.com");
        extentTest.info("Email textboxına \"lutfi.admin@agileswiftcargo.com\" mail adresi girilir");
        locator.passwordTextbox.sendKeys("Agile.0924");
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");

        String actualPassword = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPassword = "password";

        Assert.assertEquals(actualPassword,expectedPassword);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");


    //3_Sign in butonuna tıklanır.

        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");

    //4_Mesajların alanının olup olmadığı kontrol edilir.

        String actualMessageBox = driver.findElement(By.xpath("//a[.='Delivery Man']")).getText();
        String expectedMessageBox = "Messages";
        softAssert.assertEquals(actualMessageBox,expectedMessageBox);
        extentTest.pass("Messagebox bulunmaktadır");
        extentTest.fail("Messagebox alanı bulunmamaktadır!");


    //5_Sayfayı kapatır.
        extentTest.info("Sayfayi Kapatir");
        softAssert.assertAll();


    }
}
