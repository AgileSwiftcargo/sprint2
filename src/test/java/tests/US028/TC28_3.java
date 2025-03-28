package tests.US028;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC28_3 extends CrossTestBaseRapor {

    Locator locator;
    @Test
    public void parcelsBilgileriGorunurlukTesti (){
        extentTest = extentReports.createTest("Parcel Bilgileri Görünürlük Testi",
                "Merchant, belirtilen bilgilere ait parceli listede görüntüleyebilmeli");

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



        //----Menüde parcels bağlantısına görüntüler ve tıklar----
        WebElement parcelsBaglantiElementi =
                driver.findElement(By.xpath("(//a[@class='nav-link '])[7]"));
        Assert.assertTrue(parcelsBaglantiElementi.isDisplayed());
        extentTest.pass("Menüde parcels bağlantısının görüntülendiğini test eder");


        //----Parcels sayfasına tıklanır----
        parcelsBaglantiElementi.click();
        String expectedParcelsUrl = "https://qa.agileswiftcargo.com/merchant/parcel/index";
        String actualParcelsUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualParcelsUrl,expectedParcelsUrl);
        extentTest.pass("Parcels sayfasına gidildiğini test edilir");


        //----Sayfanın düzgün yüklendiği test edilir----
        WebElement parcelYaziElementi = driver.findElement(By.xpath("//*[.='Parcels ']"));
        String expectedParcelTitle = "Parcels";
        String actualParcelTitle = parcelYaziElementi.getText();
        Assert.assertEquals(actualParcelTitle,expectedParcelTitle);
        extentTest.pass("Parcels sayfasının düzgün yüklendiği test edilir");



        /*
        ----Aşağıdaki bilgilere ait Parcels Ekranda görünür----
        Tracking ID: AS741003075C513
        Müşteri adı: Merchant_KC_deneme_Müşteri2
        Adres: Merchant_Kerem_Deneme_Adress
        Status: Pending
        */
        //------------------TRACKİNG ID-------------------------------
        WebElement trackingIdElementi =
                driver.findElement(By.xpath("//*[.='AS741003075C513']"));
        String expectedTrackingId = "AS741003075C513";
        String actualTrackingId = trackingIdElementi.getText();
        Assert.assertEquals(actualTrackingId,expectedTrackingId);
        extentTest.pass("Tacking ID doğruluğu test edilir");

        //------------------Müşteri Adı-------------------------------
        WebElement customerNameElementi =
                driver.findElement(By.xpath("//*[.='Merchant_KC_deneme_Müşteri2']"));
        String expectedCustomerName = "Merchant_KC_deneme_Müşteri2";
        String actualCustomerName = customerNameElementi.getText();
        Assert.assertEquals(actualCustomerName,expectedCustomerName);
        extentTest.pass("Müşteri Adı doğruluğu test edilir");

        //------------------Adres-------------------------------
        WebElement adresElementi =
                driver.findElement(By.xpath("//*[.='Merchant_Kerem_Deneme_Adress2']"));
        String expectedAdres = "Merchant_Kerem_Deneme_Adress2";
        String actualAdres = adresElementi.getText();
        Assert.assertEquals(actualAdres,expectedAdres);
        extentTest.pass("Adres doğruluğu test edilir");

        //------------------Phone-------------------------------
        WebElement phoneElementi =
                driver.findElement(By.xpath("//*[.='111111111110']"));
        String expectedPhone = "111111111110";
        String actualPhone = phoneElementi.getText();
        Assert.assertEquals(actualPhone,expectedPhone);
        extentTest.pass("Tel no doğruluğu test edilir");

        //------------------Status-------------------------------
        WebElement statusElementi =
                driver.findElement(By.xpath("//span[.='Pending']"));
        String expectedStatus = "Pending";
        String actualStatus = statusElementi.getText();
        Assert.assertEquals(actualStatus,expectedStatus);
        extentTest.pass("Statü doğruluğu test edilir");




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
