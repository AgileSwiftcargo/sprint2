package tests.US032;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC32_7 extends CrossTestBaseRapor {

    @Test
    public void adminProfileCancelEdit() {
        Locator locator = new Locator();

        extentTest = extentReports.createTest("Cancel edit kontrolü",
                "Admin profil güncelleme sayfasında name ve address bilgisini girdikten sonracancel butonuna basarsa değişiklik yapmadan profile sayfasına gitmelidir.");


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
        ReusableMethods.bekle(1);
        driver.findElement(By.xpath("//*[.=' Edit']")).click();
        extentTest.info("Edit butonuna tıklar.");
        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Update Profile']"))
                .isDisplayed());
        extentTest.pass("Update Profile sayfasına ulaşır.");
//11_Açılan pencerede Name başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='name']")).click();
        extentTest.info("Name textboxına tıklar.");
//12_Önceki bilgileri siler ve yeni isim bilgilerini girer.
        driver.findElement(By.xpath("//input[@id='name']")).clear();
        extentTest.info("Name textboxı temilenir.");
//13_Açılan pencerede Address başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='address']")).click();
        extentTest.info("Address textboxına tıklar.");
//14_Önceki bilgileri siler ve yeni adres bilgisini girer.
        driver.findElement(By.xpath("//input[@id='address']")).clear();
        extentTest.info("Address textboxı temilenir.");
//17_Cancel butonuna tıklar.
        driver.findElement(By.xpath("//a[.='Cancel']")).click();
        extentTest.info("Cancel butonuna tıklar.");
//18_.Bilgilerin değişmediğini doğrular.
        String actualNameInform = driver.findElement(By.xpath("//span[text()='Lütfi']")).getText();
        String expectedNameInform = "Lütfi";
        Assert.assertEquals(actualNameInform, expectedNameInform);
        extentTest.info("İsim bilgisi değişmemiştir.");

        String actualAddressInform = driver.findElement(By.xpath("//p[text()='USA']")).getText();
        String expectedAddressInform = "USA";
        Assert.assertEquals(actualAddressInform, expectedAddressInform);
        extentTest.info("Adres bilgisi değişmemiştir.");

//19_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//20_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//21_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");
    }
}
