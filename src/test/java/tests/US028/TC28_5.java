package tests.US028;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC28_5 extends CrossTestBaseRapor {

    Locator locator;
    @Test
    public void parcelsKargoFiltreTesti (){
        extentTest = extentReports.createTest("Parcels Kargo Filtresi Testi",
                "Merchant, kargo filtresi doğru parcel'leri listelemelidir");


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



        //----Status görüntülenir ve filtre için "Pending" seçilir----
        WebElement statusDdmElementi = driver.findElement(By.id("parcelStatus"));
        Select select = new Select(statusDdmElementi);
        Assert.assertTrue(statusDdmElementi.isDisplayed());
        extentTest.pass("Filtrede Status alani olduğu test edilir");

        select.selectByVisibleText("Pending");
        extentTest.info("Status filtresinde 'Pending' seçilir");



        //----Filtreme için filter tusuna basilir----
        WebElement filterButonElementi = driver.findElement(By.xpath("//*[.=' Filter']"));
        Assert.assertTrue(filterButonElementi.isDisplayed());
        extentTest.pass("Filter butonu görüntülendiği test edilir");

        filterButonElementi.click();
        extentTest.info("Filter butonuna basılır");



        //----"Tracking ID: AS741003075C513" olan kargonun listelendiği test edilir----
        WebElement parcelIdElementi =
                driver.findElement(By.xpath("//*[.='AS741003075C513']"));
        String expectedSonucYazisi = "AS741003075C513";
        String actualSonucYazisi = parcelIdElementi.getText();
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
        extentTest.pass("Ekranda AS741003075C513 ID'li parcel listelendigini test edilir");


        //----Listenen parcelin status pending olduğu doğrulanır----
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
