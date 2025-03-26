package tests.US012;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC12_8 extends CrossTestBaseRapor {

    @Test
    public void adminMessage(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Admin'e Kullanıcı Mesajı",
                "Kullanıcı tarafından iletilen mesaj, admin tarafından görülmelidir.");

    //1_Login sayfaası açılır.
        driver.get(ConfigReader.getProperty("LoginUrl"));

    //2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.

        locator.emailTextbox.sendKeys("lutfi.admin@agileswiftcargo.com");
        locator.passwordTextbox.sendKeys("Agile.0924");

        String actualPassword = locator.passwordTextbox.getText();
        System.out.println(actualPassword);

        String expectedPassword = "**********";

        Assert.assertEquals(actualPassword,expectedPassword);


    //3_Sign in butonuna tıklanır.

        locator.signInButton.click();



    //4_Mesajların okunduğu, cevaplandığı message box kutusu aranır.

    //5_ Message box'a tıklanır.
    //6_TC_12.7'deki mesaja tıklanır.
    //7_Sayfayı kapatır.


    }
}
