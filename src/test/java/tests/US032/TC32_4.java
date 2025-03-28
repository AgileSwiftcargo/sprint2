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
//4_Mail adresi bilgisini girer.
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
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
        extentTest.info("Profile tuşuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");
//10_Açılan pencerede edit butonuna tıklar.
        locator.adminProfileEditButton.click();
        extentTest.info("Edit butonuna tıklar.");
        Assert.assertTrue(driver.findElement(By.xpath("h2[.='Update Profile']"))
                .isDisplayed());
        extentTest.pass("Update Profile sayfasına ulaşır.");
//11_Açılan pencerede Name başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='name']")).click();
        extentTest.info("Name textboxına tıklar.");

//12_Önceki bilgileri siler ve yeni isim bilgilerini girer.
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        extentTest.info("Name textboxı temilenir.");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Kanuni");
        extentTest.info("Name textboxına Kanuni girilir.");
//13_Açılan pencerede Address başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='address']")).click();
        extentTest.info("Address textboxına tıklar.");
//14_Önceki bilgileri siler ve yeni adres bilgisini girer.
        driver.findElement(By.xpath("//input[@id='address']")).clear();
        extentTest.info("Name textboxı temizlenir.");
        driver.findElement(By.xpath("//input[@id='address']"))
                .sendKeys("İstanbul");
        extentTest.info("Address textboxına İstanbul girilir.");
//15_Dosya seç butonuna tıklar.
        locator.adminProfileFileButton.click();
        extentTest.info("Profile File buton tıklanır.");
//16_Fotoğraf/resim formatında bir fotoğraf yükler.

//17_Save change butonuna tıklar.
        locator.saveChangeButton.click();
        extentTest.info("Save change butonuna tıklanır.");
//18_.Bilgilerin değiştiğini doğrular.
        String actualName = driver.findElement(By.xpath("(//*[.='Kanuni'])[5]")).getText();
        String expectedName = "Kanuni";
        Assert.assertEquals(actualName,expectedName);
        extentTest.pass("Name'İn Kanuni olarak değiştiği doğrulanır.");

        String actualCountry = driver.findElement(By.xpath("(//*[.='İstanbul'])[1]")).getText();
        String expectedCountry = "İstanbul";
        Assert.assertEquals(actualCountry,expectedCountry);
        extentTest.pass("Address bilgisinin İstanbul olarak değiştiği doğrulanır.");

//19_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

//20_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//21_Admin yeniden login olur.
        locator.loginButonu.click();
        extentTest.info("Login butonuna tıklanır.");
        locator.emailInput.click();
        extentTest.info("Email textboxına tıklanır.");
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
        extentTest.info("Email textboxına \"lutfi.admin@agileswiftcargo.com\" mail adresi girilir");
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");
        locator.signInButton.click();
        extentTest.info("Signin butonuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
        extentTest.pass("Agile Swift Cargo Dashboard sayfasına erişilir.");
//22_Profile sayfasına gider.
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
        locator.adminProfileMenu.click();
        extentTest.info("Profile tuşuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");
//23_Son yaptığı değişikliklerin korunduğunu doğrular.
        String actualNameRev = driver.findElement(By.xpath("(//*[.='Kanuni'])[5]")).getText();
        String expectedNameRev = "Kanuni";
        Assert.assertEquals(actualNameRev,expectedNameRev);
        extentTest.pass("Name kısmının Kanuni olduğu doğrulanır.");

        String actualCountryRev = driver.findElement(By.xpath("(//*[.='USA'])[1]")).getText();
        String expectedCountryRev = "USA";
        Assert.assertEquals(actualCountryRev,expectedCountryRev);
        extentTest.pass("USA olduğu doğrulanır.");

//24_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

//25_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//26_Heaaderdaki Login tuşuna basılır.
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//28_Farklı bir admin hesabıyla login olunur.
        locator.loginButonu.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");
        locator.emailInput.click();
        extentTest.pass("Email textbox'ına tıklar.");
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminKeremGecerliMail"));
        extentTest.info("Email textboxına \"kerem.admin@agileswiftcargo.com\" mail adresi girilir");
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminKeremGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");
        String actualPasswordKerem = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPasswordKerem = "password";

        Assert.assertEquals(actualPasswordKerem,expectedPasswordKerem);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");

        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
        extentTest.pass("Agile Swift Cargo Dashboard sayfasına erişilir.");
//29_Kullanıcı headerdaki profile resmine tıklar

        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

//30_Açılan menüden "Profile" seçeneğine tıklar.

        locator.adminProfileMenu.click();
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");

//31_Diğer adminden gerçekleştirilen değişikliklerin (Name, Address, profil resmi) bu userı etkileyip etkilemediği doğrulanır.
        String actualNameKerem = driver.findElement(By.xpath("(//*[.='Kerem Ceylan'])[5]")).getText();
        String expectedNameKerem = "Kerem Ceylan";
        Assert.assertEquals(actualNameKerem,expectedNameKerem);
        extentTest.pass("Name kısmının Kerem Ceylan olduğu doğrulanır.");

        String actualCountryKerem = driver.findElement(By.xpath("(//*[.='İstanbul'])[1]")).getText();
        String expectedCountryKerem = "USA";
        Assert.assertEquals(actualCountryKerem,expectedCountryKerem);
        extentTest.pass("USA olduğu doğrulanır.");

//32_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

//33_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//34_Admin yeniden login olur.
        locator.loginButonu.click();
        extentTest.pass("Login butonuna tıklar.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");
        locator.emailInput.click();
        extentTest.pass("Email textbox'ına tıklar.");
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
        extentTest.info("Email textboxına \"lutfi.admin@agileswiftcargo.com\" mail adresi girilir");
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");

        String actualPasswordLutfi = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPasswordLutfi = "password";

        Assert.assertEquals(actualPasswordLutfi,expectedPasswordLutfi);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");
        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
        extentTest.pass("Agile Swift Cargo Dashboard sayfasına erişilir.");
//35_Profile sayfasına gider.
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
        locator.adminProfileMenu.click();
        extentTest.info("Profile tuşuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");

//36_Edit tuşuna tıklar.
        locator.adminProfileEditButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");
//37_Profil bilgilerini ilk haline geri getirir.
        driver.findElement(By.xpath("//input[@id='name']")).click();
        extentTest.info("Name textboxına tıklanır.");
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        extentTest.info("Name textboxı bilgileri silinir.");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Lutfi");
        extentTest.info("Name textboxına \"Lutfi\" girilir.");
        driver.findElement(By.xpath("//input[@id='address']")).click();
        extentTest.info("Address textboxına tıklanır.");
        driver.findElement(By.xpath("//input[@id='address']")).clear();
        extentTest.info("Address textboxı bilgileri silinir.");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("USA");
        extentTest.info("Name textboxına \"USA\" girilir.");
//38_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//39_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//40_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");


    }
}
