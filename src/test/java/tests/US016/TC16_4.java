package tests.US016;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

import java.util.HashSet;
import java.util.Set;

public class TC16_4 extends CrossTestBaseRapor {


    @Test
    public void subscribeUsKayitliEmailleNegatifTest(){
        //***daha önce kayıt yapılmış email ile kayıt yapılamayacaktır.

        driver.get("https://qa.agileswiftcargo.com");
        extentTest = extentReports.createTest("Subscribe Us Abonelik  Testi", "Footer Kismi  Olmali");

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        // Sayfanın footer kısmına kadar kaydır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = driver.findElement(By.xpath("/html/body/footer[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);
        extentTest.pass("Anasayfa aşağı doğru kaydırılır");

        // Bekleme süresi
        try {
            Thread.sleep(2000); // Scroll işleminin tamamlanması için bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Footer menüsündeki Subscribe bölümünü kontrolet
        WebElement subsribe = driver.findElement(By.xpath("//*[.='Subscribe Us']"));
        if (subsribe.isDisplayed()) {
            System.out.println("Subscribe Us  başarıyla görüntülendi.");
        } else {
            System.out.println("Subscribe Us görüntülenemedi.");
        }

        Assert.assertTrue(driver.findElement(By.xpath(("/html/body/footer[1]"))).isDisplayed());
        extentTest.pass("Footer kisminin oldugunu dogrular");

        driver.findElement(By.xpath(("//*[.='Subscribe Us']"))).isDisplayed();
        extentTest.pass("Subsribe  alanının gorundugunu dogrular");

        // Email adresi yazılacak alanı bul
        WebElement emailTextbox = driver.findElement(By.xpath("//*[@name='email']"));
        // Email adresini yaz

        emailTextbox.sendKeys("a@a.com");


        // Kayıt tuşunu bul ve tıkla
        WebElement subscribeButton = driver.findElement(By.xpath("//i[@class='fa fa-paper-plane']"));
        subscribeButton.click();
        extentTest.pass("Subsribe  kayıt butonuna tıklandığını dogrular");


        // Abonelik işleminin başarılı olduğunu doğrulamak için JavaScript kullanarak toastr mesajını kontrol et
        js = (JavascriptExecutor) driver;
        String toastrMessage = (String) js.executeScript(
                "return (document.querySelector('.toast-message') ? document.querySelector('.toast-message').textContent : '');"
        );

        Assert.assertEquals(toastrMessage, "Already Subscribed", "Already Subscribed");
        System.out.println("Kayıtlı email girişi ,abonelik işlemi başarısız");
        extentTest.pass("Kayıtlı email adresiyle kayıt yapamayacağını dogrular");

        // Bekleme süresi
        try {
            Thread.sleep(2000); // Scroll işleminin tamamlanması için bekleme
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        extentTest.info("Sayfayi Kapatir");
    }






}


