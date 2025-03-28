package tests.US002;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

public class Sunum extends CrossTestBaseRapor {

    @Test
    public void SunumSenaryoTesti() throws IOException {

        Locator locator = new Locator();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        extentTest = extentReports.createTest("Automation Sprint UI & Functional Test",
                "Sprint Review Demo Testi ");

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        String[] navBarTexts = {"Home", "Pricing", "Tracking", "Blogs", "About", "FAQ", "Contact", "Login"};

        // Locate all nav-links
        List<WebElement> navLinks = driver.findElements(By.xpath("//*[contains(@class, 'nav-link')]"));

        // Validate each nav-link text
        for (int i = 0; i < navBarTexts.length; i++) {
            softAssert.assertEquals(navLinks.get(i).getText(), navBarTexts[i],
                    "Text mismatch at index " + (i + 1));
        }
        extentTest.pass("Basliklarin sirali olup olmadigini kontrol eder");

        locator.navHome.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Home basligina tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollBy({ top: 700, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);


        try {
            locator.navPricing.click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/#pricing");
            extentTest.pass("Pricing basligina tiklar ve URL'yi kontrol eder");

            boolean isActive = driver.findElement(By.xpath("//a[.='Pricing']"))
                    .getAttribute("class").contains("active");
            if (!isActive) {
                throw new AssertionError( "Pricing Linki Secili gozukmuyor");
            }
            extentTest.pass("Pricing'e tiklar, secili ve vurgulanmis oldugunu gozlemler");
        } catch (AssertionError e) {
            captureFailure("Pricing Linki Secili gozukmuyor");
            softAssert.fail(e.getMessage());
        }

        ReusableMethods.bekle(2);
        locator.NextDayButonu.click();
        ReusableMethods.bekle(2);
        locator.SubCityButonu.click();
        ReusableMethods.bekle(2);
        locator.OutsideCityButonu.click();
        ReusableMethods.bekle(2);

        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        locator.navTracking.click();
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/tracking");
        extentTest.pass("Tracking basligina tiklar ve URL'yi kontrol eder");

        locator.navBlogs.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs basligina tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        locator.blogsYaziGirisi.click();

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        locator.navAbout.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/about-us");
        extentTest.pass("About basligina tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        try {
            locator.navFAQ.click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/faq-list");
            extentTest.pass("FAQ basligina tiklar ve URL'yi kontrol eder");

            boolean isActive = driver.findElement(By.xpath("//a[.='FAQ']"))
                    .getAttribute("class").contains("active");
            if (!isActive) {
                throw new AssertionError( "FAQ Baslik Linki Secili gozukmuyor");
            }
            extentTest.pass("FAQ basligina tiklar, secili ve vurgulanmis oldugunu gozlemler");
        } catch (AssertionError e) {
            captureFailure("FAQ Baslik Linki Secili gozukmuyor");
            softAssert.fail(e.getMessage());
        }

        ReusableMethods.bekle(2);
        locator.faqBirinciSoru.click();
        ReusableMethods.bekle(2);
        locator.faqikinciSoru.click();
        ReusableMethods.bekle(2);

        locator.navContact.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/contact-send");
        extentTest.pass("Contact basligina tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' });");
        ReusableMethods.bekle(2);
        js.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' });");
        ReusableMethods.bekle(2);

        locator.registerButonu.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/merchant/sign-up");
        extentTest.pass("Register basligina tiklar ve URL'yi kontrol eder");

        ReusableMethods.bekle(2);

        // Faker'in urettigini kabul etmedigi icin kendimiz 11 Rakamli tel numarasi uretiyoruz
        Random random = new Random();
        StringBuilder mobile = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            mobile.append(random.nextInt(11));
        }

        String businessName = faker.company().name();
        String  fullName = faker.name().fullName();
        String mobileNumber = mobile.toString();
        String password = faker.internet().password();
        String address = faker.address().streetAddress();

        locator.registerbusNamebutonu.sendKeys(businessName);
        extentTest.info("Business Name Girer");
        ReusableMethods.bekle(2);

        locator.namesurNameButonu.sendKeys(fullName);
        extentTest.info("Full Name girer");
        ReusableMethods.bekle(2);

        locator.hubSelect.click();
        locator.hubSelectNewyork.click();
        extentTest.info("Hub secer");
        ReusableMethods.bekle(2);

        locator.mobileButonu.sendKeys(mobileNumber);
        extentTest.info("Mobile Tel numarasi girer");
        ReusableMethods.bekle(2);

        locator.paswordButonu.sendKeys(password);
        extentTest.info("Sifre girer");
        ReusableMethods.bekle(2);

        locator.adresButonu.sendKeys(address);
        extentTest.info("Adres girer");
        ReusableMethods.bekle(7);

        try {
            boolean isSameLink = driver.findElement(By.xpath("//*[.='Agile Swift Cargo']"))
                    .getAttribute("href").contains("https://qa.agileswiftcargo.com/merchant/sign-up#");
            if (isSameLink) {
                throw new AssertionError( "Privacy Policy & Terms Sayfasina Yonlendirmiyor");
            }
            extentTest.pass("Privacy Policy & Terms Sayfasina Yonlendirir");
        } catch (AssertionError e) {
            captureFailure("Privacy Policy & Terms Sayfasina Yonlendirmiyor");
            softAssert.fail(e.getMessage());
        }

        locator.sartlariKabuletbutonu.click();
        extentTest.info("Sartlari kabul eder");
        ReusableMethods.bekle(2);

        locator.kaydetbutonu.click();
        extentTest.info("Kaydol'a tiklar");
        ReusableMethods.bekle(2);

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
        extentTest.pass("Login Sayfasina yonlendirildigini gorur");

        locator.emailInput.sendKeys(ConfigReader.getProperty("MerchantAlpayGecerliMail"));
        extentTest.info("Email yada tel no kismina gecerli emailini girer");
        ReusableMethods.bekle(2);

        locator.passwordInput.sendKeys(ConfigReader.getProperty("MerchantAlpayGecerliPassword"));
        extentTest.info("Password kismina gecerli passwordunu girer");
        ReusableMethods.bekle(2);

        try {
            locator.signInButton.click();
            extentTest.info("Sign in butonuna tiklar");
            ReusableMethods.bekle(2);

            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/dashboard");
            extentTest.pass("Kullanici Merchant Dashboard Sayfasina ulasir");
        } catch (AssertionError e) {
            captureFailure("Merchant Dashboard Sayfasina Ulasilamiyor");
            Assert.fail(e.getMessage());
        }

        try {
            locator.profilResmi.click();
            extentTest.info("Headerdaki Profil resmine tiklar");
            ReusableMethods.bekle(2);

            locator.profilButonu.click();
            extentTest.info("Profil secenegine tiklar");
            extentTest.info( "Profil durumunun active oldugunu dogrular");
            ReusableMethods.bekle(5);

            boolean isInActive = driver.findElement(By.xpath("//*[contains(@class, 'badge')]"))
                    .getText().contains("Inactive");
            if (isInActive) {
                throw new AssertionError( "Status durumu active degil");
            }
            extentTest.pass( "Profil durumunun active oldugunu dogrular");
        }
        catch (AssertionError e) {
            captureFailure("Status Durumu Inactive");
            softAssert.fail(e.getMessage());
        }

        locator.profilEditButonu.click();
        extentTest.info("Edit Butonuna tiklar");
        ReusableMethods.bekle(2);

        locator.profileUpdateName.clear();
        extentTest.info("Name TexBox'undaki Bilgiyi Siler");

        ReusableMethods.bekle(2);
        locator.profileUpdateSaveChange.click();
        extentTest.info("Save Change Butonuna Tiklar");
        ReusableMethods.bekle(5);

        try {
            Assert.assertTrue(locator.profileUpdateNameFieldRequired.isDisplayed());
            extentTest.pass("The Name field is required. yazisini gorur");
        }
        catch (AssertionError e) {
            captureFailure("Eksik bilgi ile update yapildi");
            softAssert.fail("Eksik bilgi ile update yapildi. " + e.getMessage());
        }

        locator.profileUpdateEmail.clear();
        locator.profileUpdateEmail.sendKeys("merchant.alpay@");
        extentTest.info("Email textboxuna gecersiz bir email girer");

        ReusableMethods.bekle(5);

        try {
            locator.profileUpdateSaveChange.click();
            extentTest.info("Save Change Butonuna Tiklar");

            Assert.assertFalse(locator.updateSuccess.isDisplayed());
            extentTest.pass("Success Mesajini Goruntulemez");
        }
        catch (AssertionError e) {
            captureFailure("Eksik email ile update yapildi");
            softAssert.fail("Eksik email ile update yapildi. " + e.getMessage());
        }

        ReusableMethods.bekle(5);
        locator.profilEditButonu.click();
        extentTest.info("Edit Butonuna tiklar");

        ReusableMethods.bekle(2);
        locator.profileUpdateEmail.clear();
        locator.profileUpdateEmail.sendKeys("merchant.alpay@agileswiftcargo.com");
        extentTest.info("Email textboxuna dogru emaili girip duzeltir");

        locator.profileUpdateMobile.clear();
        locator.profileUpdateMobile.sendKeys("0125452");
        extentTest.info("Mobile numarasini eksik Girer");
        ReusableMethods.bekle(5);

        driver.findElement(By.xpath("//*[@id='image_id']")).sendKeys("C:/Users/alpay/Desktop/Alpay Ciftci.jpg");
        ReusableMethods.bekle(3);

        try {
            locator.profileUpdateSaveChange.click();
            extentTest.info("Save Change Butonuna Tiklar");

            Assert.assertFalse(locator.updateSuccess.isDisplayed());
            extentTest.pass("Success Mesajini Goruntulemez");
        }
        catch (AssertionError e) {
            captureFailure("Eksik mobile numarasi ile update yapildi");
            softAssert.fail("Eksik mobile numarasi ile update yapildi. " + e.getMessage());
        }

        ReusableMethods.bekle(5);


        try {
            Assert.assertTrue(locator.parcelMenusu.isDisplayed());
            extentTest.pass("Parcel Menusunu Gorur");
        }
        catch (AssertionError e) {
            captureFailure("Parcel Menusu Bulunamadi");
            Assert.fail("Parcel Menusu Bulunamadi. " + e.getMessage());
        }

        try {
            locator.parcelMenusu.click();
            ReusableMethods.bekle(3);
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/merchant/parcel/index");
            extentTest.pass("Parcel Menusune Tiklar ve Parcel Listesine Ulasir");
        }
        catch (AssertionError e) {
            captureFailure("Parcel Listesine Ulasamadi");
            Assert.fail("Parcel Listesine Ulasamadi. " + e.getMessage());
        }

        locator.parcelEkle.click();
        ReusableMethods.bekle(3);

        locator.createParcelPickupAddress.clear();
        locator.createParcelPickupAddress.sendKeys("Greenwich, London, UK");
        locator.createParcelSellingPrice.sendKeys("100");

        locator.createParcelCategoryDropdown.click();
        ReusableMethods.bekle(2);
        locator.createParcelCategoryTextBox.click();

        locator.createParcelDeliveryDropdown.click();
        ReusableMethods.bekle(2);
        locator.createParcelDeliveryTextBox.click();

        locator.createParcelCustomerPhone.sendKeys("012458785455");
        locator.createParcelCustomerAddress.sendKeys("Manhattan, New York, USA");
        locator.createParcelPickupPhone.clear();
        locator.createParcelPickupPhone.sendKeys("01254887566");
        locator.createParcelCashCollection.sendKeys("50");

        ReusableMethods.bekle(2);

        String customerName = faker.name().fullName();
        locator.createParcelCustomerName.sendKeys(customerName);

        js.executeScript("arguments[0].click();", locator.createParcelLiquid);
        js.executeScript("arguments[0].click();", locator.createParcelParcelBank);

        ReusableMethods.bekle(2);

        try {
            locator.createParcelSaveButton.click();
            ReusableMethods.bekle(2);
            Assert.assertTrue(locator.createParcelSuccessMesaji.isDisplayed());
            extentTest.pass("Parcel Basarili bir sekilde kayit edilir");
        }
        catch (AssertionError e) {
            captureFailure("Parcel Kayit olmadi");
            softAssert.fail("Parcel Kayit olmadi. " + e.getMessage());
        }

        try {
            ReusableMethods.bekle(5);
            Assert.assertEquals(locator.parcelListRecipientName.getText(), customerName );
            extentTest.pass("Yeni Parcelin olusturuldugu goruldu");
        }
        catch (AssertionError e) {
            captureFailure("Yeni Parcel listede gorulmedi");
            softAssert.fail("Yeni Parcel listede gorulmedi. " + e.getMessage());
        }

        ReusableMethods.bekle(3);

        String parcelNumber = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[1]/td[3]")).getText();

        driver.get(ConfigReader.getProperty("Url"));
        ReusableMethods.bekle(3);
        extentTest.info("https://qa.agileswiftcargo.com/ adresine ulaşılır");

        //2_Enter tracking id" textboxuna tıklar.
        locator.enterTrackingIdTextbox.click();
        extentTest.info("Track ID Textbox'ına tıklar.");

        //3_Doğru tracking id'yi girer ve enter butonuna tıklar.
        locator.enterTrackingIdTextbox.sendKeys(parcelNumber + Keys.ENTER);
        extentTest.info("Parcel numarasi girilir ve ENTER tuşuna basılır.");


        //Ismine ve sonra Dashboard'a Tiklar
        ReusableMethods.bekle(5);
        driver.findElement(By.xpath("//*[@class='dropdown-toggle nav-link auth-btn']")).click();
        ReusableMethods.bekle(2);
        driver.findElement(By.xpath("//a[contains(@href, 'dashboard')]")).click();
        ReusableMethods.bekle(2);

//----Menüde ticket bağlantısına görüntüler ve tıklar----
        Assert.assertTrue(locator.ticketLinki.isDisplayed());
        extentTest.pass("Menüde ticket bağlantısının görüntülendiğini test eder");

        // Ticket linkine tıklanır ve sayfanın doğru yüklendiği test edilir
        locator.ticketLinki.click();
        extentTest.info("Ticket bağlantisina tiklar");
        ReusableMethods.bekle(2);

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
        ReusableMethods.bekle(2);

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
        ReusableMethods.bekle(2);


        //----Priority: High olarak seçilir----
        select = new Select(locator.priorityDdmElementi);

        Assert.assertTrue(locator.priorityDdmElementi.isDisplayed());
        extentTest.pass("Priority'nin görüntülendiğini test eder");

        select.selectByVisibleText("High");
        extentTest.info("Priority 'High' seçilir");
        ReusableMethods.bekle(2);

        //----Date görüntülenir (default bugün tarihi seçili olduğu test edilir "GG.AA.YYYY")----
        Assert.assertTrue(locator.ticketAddDateBox.isDisplayed());
        extentTest.pass("Date kutusunun görüntülendiğini test eder");

        String actualDateValue = locator.ticketAddDateBox.getAttribute("value");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        format1.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        String expectedDateValue = format1.format(new Date());
        Assert.assertEquals(actualDateValue,expectedDateValue);
        extentTest.pass("Date kutusunda bugünün tarihinin seçili olduğunu test eder");
        ReusableMethods.bekle(2);

        //----Department: Sales olarak seçilir----
        select = new Select(locator.departmentDdmElementi);

        Assert.assertTrue(locator.departmentDdmElementi.isDisplayed());
        extentTest.pass("Department'in görüntülendiğini test eder");

        select.selectByVisibleText("Sales");
        extentTest.info("Department 'Sales' seçilir");
        ReusableMethods.bekle(2);

        //----Subject görüntülenir ve "DenemeTest" metni girilir ----
        Assert.assertTrue(locator.ticketAddSubjectBox.isDisplayed());
        extentTest.pass("Subject kutusunun görüntülendiğini test eder");

        locator.ticketAddSubjectBox.sendKeys("Kargo Durumu");
        extentTest.info("Subject kutusuna DenemeTest girilir");
        ReusableMethods.bekle(2);


        //----Description tex alanına "Kargomun son durumunu takip edemiyorum" notu girilmeli ----
        Assert.assertTrue(locator.descriptionBox.isDisplayed());
        extentTest.pass("Description kutusunun görüntülendiğini test eder");

        locator.descriptionBox.sendKeys("Kargomun son durumunu takip edemiyorum");
        extentTest.info("Description kutusuna Mesaj girilir");
        ReusableMethods.bekle(2);


        //----Save butonuna basılır ----
        Assert.assertTrue(locator.ticketAddSaveButonu.isDisplayed());
        extentTest.pass("Save butonunun görüntülendiğini test eder");

        locator.ticketAddSaveButonu.click();
        extentTest.info("Save butonuna tiklar");
        ReusableMethods.bekle(2);


        //----Onay mesajını okur ve Kaydın başarılı oldugunu test eder
        WebElement onayMesaji = driver.findElement(By.xpath("//*[.='Ticket Insert successfully!']"));
        ReusableMethods.bekle(2);
        Assert.assertTrue(onayMesaji.isDisplayed());
        extentTest.pass("Onay mesajı görüntülendiği test edilir");
        String expectedUrl2 = "https://qa.agileswiftcargo.com/merchant/support/index";
        String actualUrl2 = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl2,expectedUrl2);
        extentTest.pass("Kayıt oluşturulduğu test edildi");


        locator.profilResmi.click();
        ReusableMethods.bekle(2);
        extentTest.info("Headerdaki Profil resmine tiklar");

        try {
            locator.loguotButonu.click();
            extentTest.info("Logout'a tiklar");

            ReusableMethods.bekle(2);
            Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
            extentTest.pass("Logout Olur");
        }
        catch (AssertionError e) {
            captureFailure("Logout Olamadi");
            Assert.fail("Logout Olamadi. " + e.getMessage());
        }

        extentTest.info("Sayfayi Kapatir");

        softAssert.assertAll();

    }
}
