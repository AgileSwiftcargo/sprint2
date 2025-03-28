package tests.US032;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC32_3 extends CrossTestBaseRapor {

    @Test
    public void adminProfileInformationsTest() {

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Admin Login Testi",
                "Profile sayfasında, profil fotoğrafı, name, email, phone, Address, Joining date, salary, status, role, department, designation bilgileri yer almalıdır.");


//1_https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici anasayfaya gider gider");
//2_Login butonuna tıklar
        locator.loginButonu.click();
        extentTest.pass("Login butonuna tıklar.");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.agileswiftcargo.com/login");
        extentTest.pass("Kullanici login sayfasına gider");
//3_Enter Email or Mobile textboxına tıklar.
        locator.emailInput.click();
        extentTest.pass("Email textbox'ına tıklar.");
//4_Mail adresi bilgisini girer.
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
        extentTest.info("Email textboxına \"lutfi.admin@agileswiftcargo.com\" mail adresi girilir");
//5_Password textboxına tıklar.
        locator.passwordInput.click();
        extentTest.pass("Password textbox'ına tıklar.");
//6_Şifre bilgilerini girer.
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
        extentTest.info("Password textboxına \"Agile.0924\" şifresi girilir");

        String actualPassword = locator.passwordTextbox.getDomAttribute("type");
        System.out.println(actualPassword);

        String expectedPassword = "password";

        Assert.assertEquals(actualPassword,expectedPassword);
        extentTest.pass("Şifre textbox'ı \"****\" şeklinde maskelenmiş olarak görülmektedir.");
//7_Sign in butonuna tıklar.
        locator.signInButton.click();
        extentTest.info("Sign in butonuna basılır.");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
        extentTest.pass("Agile Swift Cargo Dashboard sayfasına erişilir.");
//8_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
        extentTest.info("Profile tuşuna tıklanır.");
        Assert.assertTrue(driver.findElement(By.xpath("(//a[.='Profile'])[3]")).isDisplayed());
        extentTest.pass("Profile sayfasına ulaşır.");
//10_Profil resmi olduğu doğrular.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='img-responsive rounded-circle']")).isDisplayed());
        extentTest.pass("Profile resmi gözükmektedir.");
        //11_Profil resminin altında adminin adı, telefon numarası ve adres bilgisinin olduğunu doğrular.
        String actualName = driver.findElement(By.xpath("(//*[.='Lütfi'])[5]")).getText();
        String expectedName = "Lütfi";
        Assert.assertEquals(actualName,expectedName);
        extentTest.pass("Name kısmı doğrudur.");

        String actualPhoneNum = driver.findElement(By.xpath("(//*[.='12123456974'])[1]")).getText();
        String expectedPhoneNum = "12123456974";
        Assert.assertEquals(actualPhoneNum,expectedPhoneNum);
        extentTest.pass("Telefon bilgisi doğrudur.");

        String actualCountry = driver.findElement(By.xpath("(//*[.='USA'])[1]")).getText();
        String expectedCountry = "USA";
        Assert.assertEquals(actualCountry,expectedCountry);
        extentTest.pass("Ülke bilgisi doğrudur.");
//12_Profil resminin olduğu kısmın yanında adminin name, email, phone, NID, Address bilgilerinin var olduğu bir bölüm olduğunu doğrular.
        String actualNameInform = driver.findElement(By.xpath("//span[.='Name : ']")).getText();
        String expectedNameInform = "Name :";
        Assert.assertEquals(actualNameInform,expectedNameInform);
        extentTest.pass("İsim bilgisi bulunmaktadır.");

        String actualEmailInform = driver.findElement(By.xpath("//span[.='Email : ']")).getText();
        String expectedEmailInform = "Email :";
        Assert.assertEquals(actualEmailInform,expectedEmailInform);
        extentTest.pass("Email bilgisi bulunmaktadır.");

        String actualPhoneInform = driver.findElement(By.xpath("//span[.='Phone : ']")).getText();
        String expectedPhoneInform = "Phone :";
        Assert.assertEquals(actualPhoneInform,expectedPhoneInform);
        extentTest.pass("Phone bilgisi bulunmaktadır.");

        String actualNIDInform = driver.findElement(By.xpath("//span[.='NID : ']")).getText();
        String expectedNIDInform = "NID :";
        Assert.assertEquals(actualNIDInform,expectedNIDInform);
        extentTest.pass("NID bilgisi bulunmaktadır.");

        String actualAddressInform = driver.findElement(By.xpath("//span[.='Address : ']")).getText();
        String expectedAddressInform = "Address :";
        Assert.assertEquals(actualAddressInform,expectedAddressInform);
        extentTest.pass("Address bilgisi bulunmaktadır.");

//13_Profil resminin olduğu kısmın altında Joining Date, Salary, Status bilgilerinin var olduğu bir bölüm olduğunu doğrular.
        String actualJoiningDate = driver.findElement(By.xpath("//span[.='Joining Date : ']")).getText();
        String expectedJoiningDate = "Joining Date :";
        Assert.assertEquals(actualJoiningDate,expectedJoiningDate);
        extentTest.pass("Joining date bilgisi bulunmaktadır.");

        String actualSalaryDate = driver.findElement(By.xpath("//span[.='Salary : ']")).getText();
        String expectedSalaryDate = "Salary :";
        Assert.assertEquals(actualSalaryDate,expectedSalaryDate);
        extentTest.pass("Salary bilgisi bulunmaktadır.");

        String actualStatus = driver.findElement(By.xpath("//span[.='Status : ']")).getText();
        String expectedStatus = "Status :";
        Assert.assertEquals(actualStatus,expectedStatus);
        extentTest.pass("Status bilgisi bulunmaktadır.");

//14_Role ve Hub alanlarının olduğu bir kısım olduğunu doğrular.
        String actualRole = driver.findElement(By.xpath("//span[.='Role : ']")).getText();
        String expectedRole = "Role :";
        Assert.assertEquals(actualRole,expectedRole);
        extentTest.pass("Role bilgisi bulunmaktadır.");

        String actualHub = driver.findElement(By.xpath("//span[.='Hub : ']")).getText();
        String expectedHub = "Hub :";
        Assert.assertEquals(actualHub,expectedHub);
        extentTest.pass("Hub bilgisi bulunmaktadır.");

//15_Department ve designation bilgilerinin olduğu bir alan olduğunu doğrular.
        String actualDepartment = driver.findElement(By.xpath("//span[.='Department : ']")).getText();
        String expectedDepartment = "Department :";
        Assert.assertEquals(actualDepartment,expectedDepartment);
        extentTest.pass("Department bilgisi bulunmaktadır.");

        String actualDesignation = driver.findElement(By.xpath("//span[.='Designation : ']")).getText();
        String expectedDesignation = "Designation :";
        Assert.assertEquals(actualDesignation,expectedDesignation);
        extentTest.pass("Designation bilgisi bulunmaktadır.");

//16_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
        extentTest.info("Profile menu butonuna tıklanır.");
//17_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
        extentTest.info("Logout butonuna tıklanır.");
//18_Sayfa kapatılır.
        extentTest.info("Sayfayi Kapatir");
    }
}
