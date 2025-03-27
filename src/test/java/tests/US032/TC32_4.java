package tests.US032;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC32_4 extends CrossTestBaseRapor {

    @Test
    public void adminProfileInformationsTest() {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Admin Profile Revizyon Testi",
                "Admin profilindeki name, address ve profil fotoğrafı bilgilerini doğru bilgilerle güncelleyebilmeli ve yapılan değişiklikler diğer adminleri etkilememelidir.");


//1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
//2_Login butonuna tıklar
        locator.loginButonu.click();
//3_Enter Email or Mobile textboxına tıklar.
        locator.emailInput.click();
//4_Mail adresi bilgisini girer.
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
//5_Password textboxına tıklar.
        locator.passwordInput.click();
//6_Şifre bilgilerini girer.
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
//7_Sign in butonuna tıklar.
        locator.signInButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
//8_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
//10_Açılan pencerede edit butonuna tıklar.
        locator.adminProfileEditButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("h2[.='Update Profile']")).isDisplayed());
//11_Açılan pencerede Name başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='name']")).click();

//12_Önceki bilgileri siler ve yeni isim bilgilerini girer.
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Kanuni");
//13_Açılan pencerede Address başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='address']")).click();
//14_Önceki bilgileri siler ve yeni adres bilgisini girer.
        driver.findElement(By.xpath("//input[@id='address']")).clear();
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("İstanbul");
//15_Dosya seç butonuna tıklar.
        locator.adminProfileFileButton.click();
//16_Fotoğraf/resim formatında bir fotoğraf yükler.

//17_Save change butonuna tıklar.
        locator.saveChangeButton.click();
//18_.Bilgilerin değiştiğini doğrular.
        String actualName = driver.findElement(By.xpath("(//*[.='Kanuni'])[5]")).getText();
        String expectedName = "Kanuni";
        Assert.assertEquals(actualName,expectedName);

        String actualCountry = driver.findElement(By.xpath("(//*[.='İstanbul'])[1]")).getText();
        String expectedCountry = "İstanbul";
        Assert.assertEquals(actualCountry,expectedCountry);

//19_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

//20_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//21_Admin yeniden login olur.
        locator.loginButonu.click();
        locator.emailInput.click();
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
        locator.signInButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
//22_Profile sayfasına gider.
        locator.profilResmi.click();
        locator.adminProfileMenu.click();
//23_Son yaptığı değişikliklerin korunduğunu doğrular.
        String actualNameRev = driver.findElement(By.xpath("(//*[.='Kanuni'])[5]")).getText();
        String expectedNameRev = "Kanuni";
        Assert.assertEquals(actualNameRev,expectedNameRev);

        String actualCountryRev = driver.findElement(By.xpath("(//*[.='USA'])[1]")).getText();
        String expectedCountryRev = "USA";
        Assert.assertEquals(actualCountryRev,expectedCountryRev);

//24_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

//25_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//26_Heaaderdaki Login tuşuna basılır.
        locator.profilResmi.click();
//28_Farklı bir admin hesabıyla login olunur.
        locator.loguotButonu.click();
//29_Kullanıcı headerdaki profile resmine tıklar
        locator.loginButonu.click();
        locator.emailInput.click();
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminKeremGecerliMail"));
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminKeremGecerliPassword"));
        locator.signInButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
//30_Açılan menüden "Profile" seçeneğine tıklar.
        locator.profilResmi.click();
        locator.adminProfileMenu.click();

//31_Diğer adminden gerçekleştirilen değişikliklerin (Name, Address, profil resmi) bu userı etkileyip etkilemediği doğrulanır.
        String actualNameKerem = driver.findElement(By.xpath("(//*[.='Kerem Ceylan'])[5]")).getText();
        String expectedNameKerem = "Kerem Ceylan";
        Assert.assertEquals(actualNameKerem,expectedNameKerem);

        String actualCountryKerem = driver.findElement(By.xpath("(//*[.='İstanbul'])[1]")).getText();
        String expectedCountryKerem = "USA";
        Assert.assertEquals(actualCountryKerem,expectedCountryKerem);
//32_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();

//33_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//34_Admin yeniden login olur.
        locator.loginButonu.click();
        locator.emailInput.click();
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
        locator.signInButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
//35_Profile sayfasına gider.
        locator.profilResmi.click();
        locator.adminProfileMenu.click();

//36_Edit tuşuna tıklar.
        locator.adminProfileEditButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("h2[.='Update Profile']")).isDisplayed());
//37_Profil bilgilerini ilk haline geri getirir.
        driver.findElement(By.xpath("//input[@id='name']")).click();
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Lutfi");
        driver.findElement(By.xpath("//input[@id='address']")).click();
        driver.findElement(By.xpath("//input[@id='address']")).clear();
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Lutfi");
//38_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//39_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//40_Sayfa kapatılır.


    }
}
