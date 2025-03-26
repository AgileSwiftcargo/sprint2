package tests.US016;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;

public class TC16_2 extends CrossTestBaseRapor {

    @Test
    public void subscribeUsKayitPozitif(){


        //*************kayıt için kullanılan email adersi her test çalıştırıldığında değiştirilmelidir.******************

        extentTest = extentReports.createTest("Subscrib Us Kayıt testi",
                "Footer Kismi  Olmali");

        driver.get(ConfigReader.getProperty("Url"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/");
        extentTest.pass("Kullanici Anasayfaya gider");

        // Sayfanın footer kısmına kadar kaydır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = driver.findElement(By.xpath("/html/body/footer[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);", footer);

        // Bekleme süresi
        try {
            Thread.sleep(1000); // Scroll işleminin tamamlanması için bekleme
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
        extentTest.pass("Subsribe  gorundugunu dogrular");

        // Email adresi yazılacak alanı bul
        WebElement emailTextbox = driver.findElement(By.xpath("//*[@name='email']"));
        // Email adresini yaz
        emailTextbox.sendKeys("username@hghj.com");

        // Kayıt tuşunu bul ve tıkla
        WebElement subscribeButton = driver.findElement(By.xpath("//i[@class='fa fa-paper-plane']"));
        subscribeButton.click();


        // Abonelik işleminin başarılı olduğunu doğrulamak için JavaScript kullanarak toastr mesajını kontrol et
        js = (JavascriptExecutor) driver;
        String toastrMessage = (String) js.executeScript(
                "return (document.querySelector('.toast-message') ? document.querySelector('.toast-message').textContent : '');"
        );

        Assert.assertEquals(toastrMessage, "Successfully subscribed.", "Abonelik işlemi başarısız.");



        extentTest.info("Sayfayi Kapatir");
    }






    }


