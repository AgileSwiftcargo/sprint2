package tests.US021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

public class TC21_8 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void ticketDeleteTesti () {
        extentTest = extentReports.createTest("Ticket Delete",
                "Merchant, ticket silmeyi başarılı olarak yapabilmelidir");

        // ----Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider----
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        //----Merchant gecerli bir e'mail ve geçerli bir password ile login olur----
        locator = new Locator();

        // Login butonu görünürlük
        Assert.assertTrue(locator.loginButonu.isDisplayed());
        extentTest.pass("Login butonunun görünür olduğunu test eder");

        locator.loginButonu.click();
        extentTest.info("Login butonuna tiklar");

        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantKeremGecerliMail"));
        extentTest.info("Geçerli bir email girer");

        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantKeremGecerliPassword"));
        extentTest.info("Geçerli bir password girer");

        // Singin butonu görünürlük
        Assert.assertTrue(locator.signInButton.isDisplayed());
        extentTest.pass("Singin butonunun görünür olduğunu test eder");

        locator.signInButton.click();
        extentTest.info("Sing in butonuna tiklar");


        //----Merchant Dashboard sayfasi açilmalidir----
        String expectedUrl = ConfigReader.getProperty("DashboardUrl");
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.pass("Merchant Dashboard sayfasının başarılı yüklendiği test edilir");


        //----Menüde ticket bağlantısına görüntüler ve tıklar----
        Assert.assertTrue(locator.ticketLinki.isDisplayed());
        extentTest.pass("Menüde ticket bağlantısının görüntülendiğini test eder");

        // Ticket linkine tıklanır ve sayfanın doğru yüklendiği test edilir
        locator.ticketLinki.click();
        extentTest.info("Ticket bağlantisina tiklar");

        WebElement ticketTitleYaziElementi = driver.findElement(By.className("h3"));
        String expectedtTitle = "Ticket";
        String actualTitle = ticketTitleYaziElementi.getText();
        Assert.assertEquals(actualTitle, expectedtTitle);
        extentTest.pass("Ticket sayfasının başarılı olarak yüklendiğini test eder");


        //----1. sırada kayıtlı bir ticket olduğunu doğrular----
        WebElement kayitliTicket = driver.findElement(By.xpath("(//*[.='1'])[1]"));
        Assert.assertTrue(kayitliTicket.isDisplayed());
        extentTest.pass("Kayıtlı ticket görüntülendiği test edilir");



        //----Action ve Delete butonu tıklanır----
        WebElement actionButonu =
                driver.findElement(By.xpath("(//button[@data-toggle='dropdown'])[4]"));
        Assert.assertTrue(actionButonu.isDisplayed());
        extentTest.pass("Action butonu görüntülendiği test edilir");
        actionButonu.click();
        extentTest.info("Action butona tiklar");

        WebElement deleteButonu = driver.findElement(By.xpath("//*[.=' Delete']"));
        Assert.assertTrue(deleteButonu.isDisplayed());
        extentTest.pass("Delete butonu görüntülendiği test edilir");
        deleteButonu.click();
        extentTest.info("Delete butona tiklanir");


        //----Silme işlemi sonrasi uyarı mesajı görüntülenir ve kabul edilir----
        WebElement deleteUyari =
                driver.findElement(By.xpath("//*[.='Do you want to delete the support?']"));
        Assert.assertTrue(deleteUyari.isDisplayed());
        extentTest.pass("Silme ikaz mesajı görüntülendiği test edilir");



        //----Uyarı kabul edilir ve ticket silinir----
        driver.findElement(By.xpath("//*[.='Yes']")).click();



        //----Onay mesajını okur ve silme başarilir oldugunu test eder----
        WebElement onayMesaji = driver.findElement(By.xpath("//*[.='Ticket deleted successfully!']"));
        ReusableMethods.bekle(1);
        Assert.assertTrue(onayMesaji.isDisplayed());
        extentTest.pass("Silme onay mesajı görüntülendiği test edilir");
        String expectedUrl2 = "https://qa.agileswiftcargo.com/merchant/support/index";
        String actualUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl2,expectedUrl2);
        extentTest.pass("Silme işleminin başarılı olduğu test edildi");




        //----Merchant logout olur----
        locator.profilResmi.click();
        Assert.assertTrue(locator.loguotButonu.isDisplayed());
        extentTest.pass("Logout butonu başarılı bir şekilde görüntülendiğini test eder");

        locator.loguotButonu.click();
        extentTest.info("Logout olur");

        String expectedAfterLogoutUrl = ConfigReader.getProperty("Url");
        String actualAfterLogoutUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualAfterLogoutUrl,expectedAfterLogoutUrl);
        extentTest.pass("Logout başarılı olduğu test edilir");


        extentTest.info("Sayfayi kapatir");





    }

}
