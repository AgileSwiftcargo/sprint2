package tests.US032;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC32_2 extends CrossTestBaseRapor {

    @Test
    public void adminLoginTesti() {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Admin Login Profil Sayfası Testi",
                "Profil sayfasına erişebilmelidir.");

//1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici anasayfaya gider gider");
//2_Login butonuna tıklar
        locator.loginButonu.click();
        extentTest.pass("Login butonuna tıklar.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");
//3_Enter Email or Mobile textboxına tıklar.
        locator.emailInput.click();
        extentTest.pass("Email textbox'ına tıklar.");
//4_Telefon bilgisini adresi bilgisini girer.
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
        extentTest.info("Email textboxına \"lutfi.admin@agileswiftcargo.com\" mail adresi girilir");
//5_Password textboxına tıklar.
        locator.passwordInput.click();
        extentTest.pass("Password textbox'ına tıklar.");
//6_Şifre bilgilerini girer.
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");

        String actualPassword = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPassword = "password";

        Assert.assertEquals(actualPassword,expectedPassword);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");

//7_Sign in butonuna tıklar.
        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
        extentTest.pass("Agile Swift Cargo Dashboard sayfasına erişilir.");
//8_Kullanıcı headerdaki profile resmine tıklar
        driver.findElement(By.xpath("(//*[@id='navbarDropdownMenuLink2'])[1]")).click();
        extentTest.info("Profile menu butonuna tıklanır.");
//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
        extentTest.info("Profile tuşuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");
//10_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

//11_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//12_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");
    }
}
