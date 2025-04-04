package tests.US005;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Kerem;
import pages.Locator;
import utilities.*;

import java.time.Duration;
import java.util.List;

import static utilities.Driver.driver;

public class TC5_2 extends CrossTestBaseRapor {

    Locator locator;

    @Test
    public void servisSayfalariTesti (){
        extentTest = extentReports.createTest("Servis sayfalarina erişim testi"
        ," Kullanıcı anasayfadan servislerin detay sayfasına erişebilmeli");

        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


        //servis alanının görüntülendiğini test eder
        locator = new Locator();
        // listeyi tam görüntülemek için aşağı iner
        WebElement asagiInilecekElement =
                driver.findElement(By.xpath("//*[.='Why Agile Swift Cargo']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(asagiInilecekElement).perform();

        WebElement servisAlani =
                driver.findElement(By.xpath("//div[@class='row py-2 ']"));
        Assert.assertTrue(servisAlani.isDisplayed());
        extentTest.pass("Servis alani görüntülenir");



        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement eCommerceButton = wait.until(ExpectedConditions.visibilityOf(locator.eCommerceDeliveryButonu));
        //eCommerceButton.click();



        // E-Commerce delivery servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        locator.eCommerceDeliveryButonu.click();
        ReusableMethods.bekle(1);
        String expectedBaslik1 = "E-Commerce delivery";
        String actualBaslik1 = locator.eCommerceBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik1,expectedBaslik1);
        extentTest.pass("E-Commerce delivery bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");





        //Pick & Drop servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        locator.pickDropButonu.click();
        String expectedBaslik2 = "Pick & Drop";
        String actualBaslik2 = locator.pickDropBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik2,expectedBaslik2);
        extentTest.pass("Pick & Drop bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");




        //Packageing servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        locator.packageingButonu.click();
        ReusableMethods.bekle(1);
        String expectedBaslik3 = "Packageing";
        String actualBaslik3 = locator.packageingBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik3,expectedBaslik3);
        extentTest.pass("Packageing bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");



        //Warehousing servis bağlantısına tıklar ve doğru sayfaya yönlendirilir
        locator.warehousingButonu.click();
        ReusableMethods.bekle(1);
        String expectedBaslik4 = "Warehousing";
        String actualBaslik4 = locator.warehousingBaslikYazisi.getText();
        Assert.assertEquals(actualBaslik4,expectedBaslik4);
        extentTest.pass("Warehousing bağlantısına tıklar ve sayfa doğru bir şekilde yüklenmiştir");

        extentTest.info("sayfayi kapatir");







    }
}
