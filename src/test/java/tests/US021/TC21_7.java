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

public class TC21_7 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void ticketEditTesti () {
        extentTest = extentReports.createTest("Ticket Güncelleme",
                "Merchant, ticket güncellemeyi başarılı olarak yapabilmelidir");

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



        //----Action ve Edit butonu tıklanır----
        WebElement actionButonu =
                driver.findElement(By.xpath("(//button[@data-toggle='dropdown'])[4]"));
        Assert.assertTrue(actionButonu.isDisplayed());
        extentTest.pass("Action butonu görüntülendiği test edilir");
        actionButonu.click();
        extentTest.info("Action butona tiklar");

        WebElement editButonu = driver.findElement(By.xpath("//*[.=' Edit']"));
        Assert.assertTrue(editButonu.isDisplayed());
        extentTest.pass("Edit butonu görüntülendiği test edilir");
        editButonu.click();
        extentTest.info("Edit butona tiklar");


        //----Doğru sayfa açılmalıdır ve sayfa düzgün görüntülenmelidir----
        WebElement ticketEditTitle = driver.findElement(By.xpath("//*[.='Ticket Edit']"));
        String expectedTitleEdit = "Ticket Edit";
        String actualTitleEdit = ticketEditTitle.getText();
        Assert.assertEquals(actualTitleEdit,expectedTitleEdit);
        extentTest.pass("Sayfanın düzgün yüklendiği test edilir");



        //---Service alanı Payment olarak değiştirilir----
        Select select = new Select(locator.serviceDdmElementi);
        Assert.assertTrue(locator.serviceDdmElementi.isDisplayed());
        extentTest.pass("Service alanının görüntülendiği test edilir");

        select.selectByVisibleText("Delivery");
        extentTest.pass("Service 'Payment' seçilebildiği test edilir");


        //---Date Alanı tiklanir ve "21.05.2025" yazilir----
        Assert.assertTrue(locator.ticketAddDateBox.isDisplayed());
        extentTest.pass("Date kutusunun görüntülendiğini test eder");

        locator.ticketAddDateBox.sendKeys("21.05.2025");
        extentTest.info("Date kismi 21.05.2025 olarak değiştirilir");


        //----Priority: Low olarak güncellenir----
        select = new Select(locator.priorityDdmElementi);
        Assert.assertTrue(locator.priorityDdmElementi.isDisplayed());
        extentTest.pass("Priority'nin görüntülendiğini test eder");

        select.selectByVisibleText("Low");
        extentTest.info("Priority 'Low' olarak güncellenir");


        //----Department: Purchase olarak güncellenir----
        select = new Select(locator.departmentDdmElementi);
        Assert.assertTrue(locator.departmentDdmElementi.isDisplayed());
        extentTest.pass("Department'in görüntülendiğini test eder");

        select.selectByVisibleText("Sales");
        extentTest.info("Department 'Puchase' olarak güncellenir");


        //----Subject görüntülenir ve "Update Test" metni ile güncellenir ----
        Assert.assertTrue(locator.ticketAddSubjectBox.isDisplayed());
        extentTest.pass("Subject kutusunun görüntülendiğini test eder");

        locator.ticketAddSubjectBox.clear();
        locator.ticketAddSubjectBox.sendKeys("Update Test");
        extentTest.info("Subject kutusuna 'Update Test' olarak güncellenir");


        //----Description tex alanına "UpDateManuelTest" notu güncellenir ----
        Assert.assertTrue(locator.descriptionBox.isDisplayed());
        extentTest.pass("Description kutusunun görüntülendiğini test eder");

        locator.descriptionBox.clear();
        locator.descriptionBox.sendKeys("UpDateManuelTest");
        extentTest.info("Description kutusu 'UpDateManuelTest' olarak güncellenir");


        //----Attached ->Dosya Seç butonu görüntülenir ve "Deneme.rtf" dosyası yüklenir ----
        Assert.assertTrue(locator.attachedBoxDosyaSecButonu.isDisplayed());
        extentTest.pass("Attached kutusunun görüntülendiğini test eder");

        WebElement dosyaSecButonu = locator.attachedBoxDosyaSecButonu;
        String filePath = System.getProperty("user.home")+"\\Desktop\\Deneme2.rtf";
        dosyaSecButonu.sendKeys(filePath);
        extentTest.info("Deneme2 eklentisi eklenir");
        ReusableMethods.bekle(2);



        //----SaveChange butonu ile güncelleme yapilir----
        WebElement saveChangeButonElement =
                driver.findElement(By.xpath("//*[.='Save Change']"));
        Assert.assertTrue(saveChangeButonElement.isDisplayed());
        extentTest.pass("SaveChange butonu görüntülendiği test edilir");

        saveChangeButonElement.click();
        extentTest.info("SaveChange butonuna tiklanir");


        //----Kaydın başarili olduğu URL'den kontrol edilir----
        String expectedEditSonrasiUrl = "https://qa.agileswiftcargo.com/merchant/support/index";
        String actualEditSonrasiUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualEditSonrasiUrl,expectedEditSonrasiUrl);
        extentTest.pass("Edit başarili olarak yapilmistir");


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
