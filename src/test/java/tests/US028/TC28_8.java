package tests.US028;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC28_8 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void parcelsFaturaNoFiltreTesti (){
        extentTest = extentReports.createTest("Parcels Fatura No Filtresi Testi",
                "Merchant, tel no filtresi doğru parcel'leri listelemelidir");


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



        //----Invoice Id görüntülenir ve filtre için "3422" yazılır----
        WebElement invoiceBoxElementi = driver.findElement(By.id("invoice_id"));
        Assert.assertTrue(invoiceBoxElementi.isDisplayed());
        extentTest.pass("Filtrede Fatura No alani olduğu test edilir");

        invoiceBoxElementi.sendKeys("3422");
        extentTest.info("Fatura filtresinde '3422' yazilir");



        //----Filtreme için filter tusuna basilir----
        WebElement filterButonElementi = driver.findElement(By.xpath("//*[.=' Filter']"));
        Assert.assertTrue(filterButonElementi.isDisplayed());
        extentTest.pass("Filter butonu görüntülendiği test edilir");

        filterButonElementi.click();
        extentTest.info("Filter butonuna basılır");



        //----Ekranda 1 sonuç listelendiği kontrol edilir "Showing 1 to 1 of 1 results"----
        WebElement parcelsSonucYaziElementi =
                driver.findElement(By.xpath("//*[@class='p-2 small']"));
        String expectedSonucYazisi = "Showing 1 to 1 of 1 results";
        String actualSonucYazisi = parcelsSonucYaziElementi.getText();
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
        extentTest.pass("Ekranda 1 adet sonuc listelendigini test edilir");



        //----Listenen parcelin Fatura No doğrulanır----

                // ACTION BUTONU -butonuna basilir
        WebElement actionElementi =
                driver.findElement(By.xpath("(//button[@class='btn btn-sm ml-2 bnone'])[1]"));
        actionElementi.click();
        extentTest.info("Listenen parcelin action butonuna basilir");

                // VİEW BUTONU -butonuna basilir
        WebElement viewButonElementi =
                driver.findElement(By.xpath("(//*[.=' View'])[1]"));
        viewButonElementi.click();
        extentTest.info("View butonuna basilir");

                // FATURA KONTROL - 3422 old test edilir
        WebElement faturaYaziElementi =
                driver.findElement(By.xpath("//div[@class='col-12']"));
        String expextedFaturaNo = "3422";
        String actualFaturaNo = faturaYaziElementi.getText();
        Assert.assertTrue(actualFaturaNo.contains(expextedFaturaNo));
        extentTest.pass("Fatuar No doğruluğu test edilir");



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
