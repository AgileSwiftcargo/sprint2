package tests.US005;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Kerem;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

import static utilities.Driver.driver;

public class TC5_2 extends TestBaseRapor {

    Kerem kerem;

    @Test
    public void servisSayfalariTesti (){
        extentTest = extentReports.createTest("Servis sayfalarina erişim testi"
        ," Kullanıcı anasayfadan servislerin detay sayfasına erişebilmeli");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        //4 adet servisin anasayfada listelendiğini test eder
        kerem = new Kerem();
        WebElement asagiInilecekElement =
                Driver.getDriver().findElement(By.xpath("//*[.='Why Agile Swift Cargo']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(asagiInilecekElement).perform();

        WebElement servisAlani =
                Driver.getDriver().findElement(By.xpath("//div[@class='row py-2 ']"));
        Assert.assertTrue(servisAlani.isDisplayed());
        extentTest.pass("Servis alani görüntülenir");





        // E-Commerce delivery servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        kerem.eCommerceDeliveryButonu.click();
        ReusableMethods.bekle(1);
        String expectedBaslik1 = "E-Commerce delivery";
        String actualBaslik1 = kerem.eCommerceBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik1,expectedBaslik1);
        extentTest.pass("E-Commerce delivery bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");





        //Pick & Drop servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        kerem.pickDropButonu.click();
        String expectedBaslik2 = "Pick & Drop";
        String actualBaslik2 = kerem.pickDropBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik2,expectedBaslik2);
        extentTest.pass("Pick & Drop bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");




        //Packageing servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        kerem.packageingButonu.click();
        ReusableMethods.bekle(1);
        String expectedBaslik3 = "Packageing";
        String actualBaslik3 = kerem.packageingBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik3,expectedBaslik3);
        extentTest.pass("Packageing bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");



        //Warehousing servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        kerem.warehousingButonu.click();
        ReusableMethods.bekle(1);
        String expectedBaslik4 = "Warehousing";
        String actualBaslik4 = kerem.warehousingBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik4,expectedBaslik4);
        extentTest.pass("Warehousing bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");

        extentTest.info("sayfayi kapatir");







    }
}
