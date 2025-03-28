package tests.US020;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC20_8 extends CrossTestBaseRapor {

    @Test
    public void merchantDashboardFilter(){

        Locator locator = new Locator();
        extentTest = extentReports.createTest("Merchant Dashboard Filter Testi",
                "Filtre fonksiyonlarının çalıştığı test edilir.");


    //1_Login sayfaası açılır.
        driver.get(ConfigReader.getProperty("LoginUrl"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");
//2_ Kullanıcı adı ve şifre girilir. Şifrenin ********** şeklinde gözüktüğü doğrulanır.
        locator.emailTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliMail"));
        extentTest.info("Email textboxına \"merchant.lutfi@agileswiftcargo.com\" mail adresi girilir");
        locator.passwordTextbox.sendKeys(ConfigReader.getProperty("MerchantLutfiGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");

        String actualPassword = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPassword = "password";

        Assert.assertEquals(actualPassword,expectedPassword);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");
//3_Sign in butonuna tıklanır.
        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        String actualMerchantYazisi = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi,expectedMerchantYazisi);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
//4_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//5_Today butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Today']")).click();
        extentTest.info("Today seçeneğine tıklar.");

//6_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
        extentTest.info("Filter butonuna tıklar.");
//7_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi1 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi1 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi1,expectedMerchantYazisi1);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");

//8_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//9_Yesterday butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Yesterday']")).click();
        extentTest.info("Yesterday seçeneğine tıklar.");

//10_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
        extentTest.info("Filter butonuna tıklar.");
//11_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi2 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi2 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi2,expectedMerchantYazisi2);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
//12_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//13_Last 7 Days butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Last 7 Days']")).click();
        extentTest.info("Last 7 Days seçeneğine tıklar.");

//14_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
        extentTest.info("Filter butonuna tıklar.");
//15_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi3 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi3 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi3,expectedMerchantYazisi3);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
//16_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//17_Last 30 Days butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Last 30 Days']")).click();
        extentTest.info("Last 30 Days seçeneğine tıklar.");

//18_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
        extentTest.info("Filter butonuna tıklar.");
//19_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi4 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi4 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi4,expectedMerchantYazisi4);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
//20_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//21_This Month Days butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='This Month']")).click();
        extentTest.info("This month seçeneğine tıklar.");
//22_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
        extentTest.info("Filter butonuna tıklar.");
//23_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi5 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi5 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi5,expectedMerchantYazisi5);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
//24_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//25_Last Month butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Last Month']")).click();
        extentTest.info("Last month seçeneğine tıklar.");
//26_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
        extentTest.info("Filter butonuna tıklar.");
//27_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi6 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi6 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi6,expectedMerchantYazisi6);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
//28_Enter date textbox'ına tıklanır.
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='date']")).isDisplayed());
        driver.findElement(By.xpath("//input[@id='date']")).click();
        extentTest.pass("Enter date textbox'ının olduğu doğrulanmıştır.");
//29_Custom Range butonuna tıklanır.
        driver.findElement(By.xpath("//*[.='Custom Range']")).click();
        extentTest.info("Custom range seçeneğine tıklar.");
//30_Takvimden tarih aralığı seçilir.
//31_Filter butonuna basılır.
        Assert.assertTrue(driver.findElement(By.xpath("//button[.=' Filter']")).isDisplayed());
        driver.findElement(By.xpath("//button[.=' Filter']")).click();
        extentTest.info("Filter butonuna tıklar.");
//32_Dashboard butonuna basılır.
        locator.dashBoardLinki.click();
        extentTest.info("Dashboard butonuna basar");
        String actualMerchantYazisi7 = driver.findElement(By.xpath("//p[.='Merchant Dashboard']")).getText();
        String expectedMerchantYazisi7 = "Merchant Dashboard";
        Assert.assertEquals(actualMerchantYazisi1,expectedMerchantYazisi1);
        extentTest.pass("Merchant dashboard sayfasına erişilir.");
        //33_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");

        //34_Açılan menüden logout butonuna tıkla
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
        //35_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");

    }
}
