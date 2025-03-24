package tests.US013;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import static utilities.Driver.driver;

public class TC13_1 extends CrossTestBaseRapor {

    Locator locator;

@Test
public void downloadAppYazisiKontrolu (){
    extentTest = extentReports.createTest("Download Yazisi Kontrol Testi",
            "Kullanici ana sayfada download alanını görüntülemeli");

    // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
    driver.get(ConfigReader.getProperty("Url"));
    extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");


    //Download App bölümü ana sayfada görüntülenmelidir
    WebElement downloadAppYaziElementi =
            driver.findElement(By.xpath("//*[.='Download App']"));

    Actions actions = new Actions(driver);
    actions.moveToElement(downloadAppYaziElementi).perform();

    Assert.assertTrue(downloadAppYaziElementi.isDisplayed());
    extentTest.pass("Kullanıcı download app yazisini görüntüler");

    extentTest.info("Sayfa kapatilir");







}

}
