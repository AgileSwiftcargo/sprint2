package tests.US032;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC32_7 extends CrossTestBaseRapor {

    @Test
    public void adminProfileCancelEdit() {
        Locator locator = new Locator();

        extentTest = extentReports.createTest("Cancel edit kontrolü",
                "Admin profil güncelleme sayfasında name ve address bilgisini girdikten sonracancel butonuna basarsa değişiklik yapmadan profile sayfasına gitmelidir.");


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
//13_Açılan pencerede Address başlığı altındaki textboxa tıklar.
        driver.findElement(By.xpath("//input[@id='address']")).click();
//14_Önceki bilgileri siler ve yeni adres bilgisini girer.
        driver.findElement(By.xpath("//input[@id='address']")).clear();
//17_Cancel butonuna tıklar.
        driver.findElement(By.xpath("//a[.='Cancel']")).click();
//18_.Bilgilerin değişmediğini doğrular.
        String actualNameInform = driver.findElement(By.xpath("//span[.='Name : ']")).getText();
        String expectedNameInform = "Name :";
        Assert.assertEquals(actualNameInform, expectedNameInform);

        String actualAddressInform = driver.findElement(By.xpath("//span[.='Address : ']")).getText();
        String expectedAddressInform = "Address :";
        Assert.assertEquals(actualAddressInform, expectedAddressInform);

//19_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//20_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//21_Sayfa kapatılır.
    }
}
