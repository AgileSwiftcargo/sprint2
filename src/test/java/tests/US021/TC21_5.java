package tests.US021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TC21_5 extends CrossTestBaseRapor {

    Locator locator;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void deparmentAlaniBosTicketOlusturmaTesti () {
        extentTest = extentReports.createTest("Department Kutusu Boş Bırakıldığında TicketAdd Testi",
                "Merchant, department kutusunu boş bıraktığında yeni ticket oluşturamalı ve hata mesajı almamalı");

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
        Assert.assertEquals(actualUrl,expectedUrl);
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
        Assert.assertEquals(actualTitle,expectedtTitle);
        extentTest.pass("Ticket sayfasının başarılı olarak yüklendiğini test eder");


        //----TicketAdd butonu görüntülenir ve tıklanır, ticket add sayfasına yönlendirilir----
        Assert.assertTrue(locator.ticketAddButonu.isDisplayed());
        extentTest.pass("TicketAdd butonunun başarılı olarak görüntülendiğini test eder");

        locator.ticketAddButonu.click();
        extentTest.info("TicketAdd butonuna tiklar");

        String expectedTicketAddUrl = ConfigReader.getProperty("TicketAddUrl");
        String actualTicketAddUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualTicketAddUrl,expectedTicketAddUrl);
        extentTest.pass("TicketAdd sayfasına gidildiği test edilir");

        Assert.assertTrue(locator.ticketAddYaziElementi.isDisplayed());
        extentTest.pass("TicketAdd başlığı görünür ve sayfanın başarılı yüklendiği test edilir");


        //----Service: Delivery olarak seçilir----
        Select select = new Select(locator.serviceDdmElementi);

        Assert.assertTrue(locator.serviceDdmElementi.isDisplayed());
        extentTest.pass("Service'nin görüntülendiğini test eder");

        select.selectByVisibleText("Delivery");
        extentTest.info("Service 'Delivery' seçilir");



        //----Priority: High olarak seçilir----
        select = new Select(locator.priorityDdmElementi);

        Assert.assertTrue(locator.priorityDdmElementi.isDisplayed());
        extentTest.pass("Priority'nin görüntülendiğini test eder");

        select.selectByVisibleText("High");
        extentTest.info("Priority 'High' seçilir");


        //----Date görüntülenir (default bugün tarihi seçili olduğu test edilir "GG.AA.YYYY")----
        Assert.assertTrue(locator.ticketAddDateBox.isDisplayed());
        extentTest.pass("Date kutusunun görüntülendiğini test eder");

        String actualDateValue = locator.ticketAddDateBox.getAttribute("value");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String expectedDateValue = format1.format(new Date());
        Assert.assertEquals(actualDateValue,expectedDateValue);
        extentTest.pass("Date kutusunda bugünün tarihinin seçili olduğunu test eder");


        //----Subject görüntülenir ve "DenemeTest" metni girilir ----
        Assert.assertTrue(locator.ticketAddSubjectBox.isDisplayed());
        extentTest.pass("Subject kutusunun görüntülendiğini test eder");

        locator.ticketAddSubjectBox.sendKeys("DenemeTest");
        extentTest.info("Subject kutusuna DenemeTest girilir");


        //----Attached ->Dosya Seç butonu görüntülenir ve "Deneme.rtf" dosyası yüklenir ----
        Assert.assertTrue(locator.attachedBoxDosyaSecButonu.isDisplayed());
        extentTest.pass("Attached kutusunun görüntülendiğini test eder");

        WebElement dosyaSecButonu = locator.attachedBoxDosyaSecButonu;
        String filePath = "C:\\Users\\Kerem Hürşad\\Desktop\\Deneme.rtf";
        dosyaSecButonu.sendKeys(filePath);
        ReusableMethods.bekle(2);


        //----Description tex alanına "MerhabaManuelTest" notu girilmeli ----
        Assert.assertTrue(locator.descriptionBox.isDisplayed());
        extentTest.pass("Description kutusunun görüntülendiğini test eder");

        locator.descriptionBox.sendKeys("MerhabaManuelTest");
        extentTest.info("Description kutusuna MerhabaManuelTest girilir");


        //----Save butonuna basılır ----
        Assert.assertTrue(locator.ticketAddSaveButonu.isDisplayed());
        extentTest.pass("Save butonunun görüntülendiğini test eder");

        locator.ticketAddSaveButonu.click();
        extentTest.info("Save butonuna tiklar");



        //----Kaydın başarılı oldugunu test eder
        String expectedUrl2 = "https://qa.agileswiftcargo.com/merchant/support/index";
        String actualUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl2,expectedUrl2);
        extentTest.pass("Kayıt oluşturulamadığı test edildi");


        //----Merchant logout olur----
        locator.profilResmi.click();
        Assert.assertTrue(locator.loguotButonu.isDisplayed());
        extentTest.pass("Logout butonu başarılı bir şekilde görüntülendiğini test eder");

        locator.loguotButonu.click();
        extentTest.info("Logout olur");


        extentTest.info("Sayfayi kapatir");



    }

}
