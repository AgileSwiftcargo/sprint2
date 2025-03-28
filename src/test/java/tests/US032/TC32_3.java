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
//2_Login butonuna tıklar
        locator.loginButonu.click();
//3_Enter Email or Mobile textboxına tıklar.
        locator.emailInput.click();
//4_Mail adresi bilgisini girer.
        locator.emailInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliMail"));
//5_Password textboxına tıklar.
        locator.passwordInput.click();
//6_Şifre bilgilerini girer.
        locator.passwordInput.sendKeys(ConfigReader.getProperty("AdminLutfiGecerliPassword"));
//7_Sign in butonuna tıklar.
        locator.signInButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='Agile Swift Cargo Dashboard ']")).isDisplayed());
//8_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//9_Açılan menüden "Profile" seçeneğine tıklar.
        locator.adminProfileMenu.click();
//10_Profil resmi olduğu doğrular.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='img-responsive rounded-circle']")).isDisplayed());
        //11_Profil resminin altında adminin adı, telefon numarası ve adres bilgisinin olduğunu doğrular.
        String actualName = driver.findElement(By.xpath("(//*[.='Lütfi'])[5]")).getText();
        String expectedName = "Lütfi";
        Assert.assertEquals(actualName,expectedName);

        String actualPhoneNum = driver.findElement(By.xpath("(//*[.='12123456974'])[1]")).getText();
        String expectedPhoneNum = "12123456974";
        Assert.assertEquals(actualPhoneNum,expectedPhoneNum);

        String actualCountry = driver.findElement(By.xpath("(//*[.='USA'])[1]")).getText();
        String expectedCountry = "USA";
        Assert.assertEquals(actualCountry,expectedCountry);
//12_Profil resminin olduğu kısmın yanında adminin name, email, phone, NID, Address bilgilerinin var olduğu bir bölüm olduğunu doğrular.
        String actualNameInform = driver.findElement(By.xpath("//span[.='Name : ']")).getText();
        String expectedNameInform = "Name :";
        Assert.assertEquals(actualNameInform,expectedNameInform);

        String actualEmailInform = driver.findElement(By.xpath("//span[.='Email : ']")).getText();
        String expectedEmailInform = "Email :";
        Assert.assertEquals(actualEmailInform,expectedEmailInform);

        String actualPhoneInform = driver.findElement(By.xpath("//span[.='Phone : ']")).getText();
        String expectedPhoneInform = "Phone :";
        Assert.assertEquals(actualPhoneInform,expectedPhoneInform);

        String actualNIDInform = driver.findElement(By.xpath("//span[.='NID : ']")).getText();
        String expectedNIDInform = "NID :";
        Assert.assertEquals(actualNIDInform,expectedNIDInform);

        String actualAddressInform = driver.findElement(By.xpath("//span[.='Address : ']")).getText();
        String expectedAddressInform = "Address :";
        Assert.assertEquals(actualAddressInform,expectedAddressInform);

//13_Profil resminin olduğu kısmın altında Joining Date, Salary, Status bilgilerinin var olduğu bir bölüm olduğunu doğrular.
        String actualJoiningDate = driver.findElement(By.xpath("//span[.='Joining Date : ']")).getText();
        String expectedJoiningDate = "Joining Date :";
        Assert.assertEquals(actualJoiningDate,expectedJoiningDate);

        String actualSalaryDate = driver.findElement(By.xpath("//span[.='Salary : ']")).getText();
        String expectedSalaryDate = "Salary :";
        Assert.assertEquals(actualSalaryDate,expectedSalaryDate);

        String actualStatus = driver.findElement(By.xpath("//span[.='Status : ']")).getText();
        String expectedStatus = "Status :";
        Assert.assertEquals(actualStatus,expectedStatus);
//14_Role ve Hub alanlarının olduğu bir kısım olduğunu doğrular.
        String actualRole = driver.findElement(By.xpath("//span[.='Role : ']")).getText();
        String expectedRole = "Role :";
        Assert.assertEquals(actualRole,expectedRole);

        String actualHub = driver.findElement(By.xpath("//span[.='Hub : ']")).getText();
        String expectedHub = "Hub :";
        Assert.assertEquals(actualHub,expectedHub);

//15_Department ve designation bilgilerinin olduğu bir alan olduğunu doğrular.
        String actualDepartment = driver.findElement(By.xpath("//span[.='Department : ']")).getText();
        String expectedDepartment = "Department :";
        Assert.assertEquals(actualDepartment,expectedDepartment);

        String actualDesignation = driver.findElement(By.xpath("//span[.='Designation : ']")).getText();
        String expectedDesignation = "Designation :";
        Assert.assertEquals(actualDesignation,expectedDesignation);

//16_Kullanıcı headerdaki profile resmine tıklar
        locator.profilResmi.click();
//17_Açılan menüden logout butonuna tıklar.
        locator.loguotButonu.click();
//18_Sayfa kapatılır.
    }
}
