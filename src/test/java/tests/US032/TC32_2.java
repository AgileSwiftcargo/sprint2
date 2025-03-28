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
//2_Login butonuna tıklar
        locator.loginButonu.click();
//3_Enter Email or Mobile textboxına tıklar.
        locator.emailInput.click();
//4_Telefon bilgisini adresi bilgisini girer.
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
//5_Password textboxına tıklar.
        locator.passwordInput.click();
//6_Şifre bilgilerini girer.
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
//7_Sign in butonuna tıklar.
        locator.signInButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
//8_Kullanıcı headerdaki profile resmine tıklar
        driver.findElement(By.xpath("(//*[@id='navbarDropdownMenuLink2'])[1]")).click();
//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
//10_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//11_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//12_Sayfa kapatılır.
    }
}
