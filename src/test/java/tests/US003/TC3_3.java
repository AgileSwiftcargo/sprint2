package tests.US003;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;
import java.util.Random;

public class TC3_3  extends CrossTestBaseRapor {

    @Test
    public void TestKayitOlma (){

        Locator locator = new Locator();

        Faker faker = new Faker();

        extentTest = extentReports.createTest("Anasayfa Merchant Kayit Olma Testi",
                "Kullanıcının geçerli verilerle kayıt olması testi");

        // Faker'in urettigini kabul etmedigi icin kendimiz 11 Rakamli tel numarasi uretiyoruz
        Random random = new Random();
        StringBuilder mobile = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            mobile.append(random.nextInt(11));
        }

        String businessName = faker.company().name();
        String  fullName = faker.name().fullName();
        String mobileNumber = "123456";
        String password = faker.internet().password();
        String address = faker.address().streetAddress();

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("kullanıcı ana sayfaya gider");

        locator.registerButonu.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/merchant/sign-up");
        extentTest.pass("Kayit olma sayfasina gider");

        locator.registerbusNamebutonu.sendKeys(businessName);
        extentTest.pass("Business Name Girer");

        locator.namesurNameButonu.sendKeys(fullName);
        extentTest.pass("Full Name girer");

        locator.hubSelect.click();
        locator.hubSelectEntry.sendKeys("New York City");
        extentTest.pass("Hub secer");

        locator.mobileButonu.sendKeys(mobileNumber);
        extentTest.pass("Mobile Tel numarasi girer");

        locator.paswordButonu.sendKeys(password);
        extentTest.pass("Sifre girer");

        locator.adresButonu.sendKeys(address);
        extentTest.pass("Adres girer");

        locator.sartlariKabuletbutonu.click();
        extentTest.pass("Sartlari kabul eder");

        ReusableMethods.bekle(2);

        locator.kaydetbutonu.click();
        extentTest.pass("Kaydol'a tiklar");

        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/login");
        extentTest.pass("Login Sayfasina yonlendirildigini gorur");

        extentTest.info("Sayfayi Kapatir");

        ReusableMethods.bekle(2);

    }
}

