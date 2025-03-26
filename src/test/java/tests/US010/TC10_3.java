package tests.US010;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.CrossTestBaseRapor;

public class TC10_3 extends CrossTestBaseRapor {

    @Test
    public void BlogYazisi (){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Blogs Yazisi Detay Testi",
                "Blog yazısının detay sayfasında başlık, yazar adı, yayın tarihi ve tam içerik yer almalı. Yayin tarihi blogun eklenme tarihi olmali");


        driver.get("https://qa.agileswiftcargo.com/get-blogs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs Sayfasina gider");

        WebElement yayinTarihi = locator.blogsYayinTarihi;
        String ilkYayinTarihi = yayinTarihi.getText();
        Assert.assertTrue(yayinTarihi.isDisplayed());
        extentTest.pass("Yayin tarihi oldugunu dogrular");

        driver.get("https://qa.agileswiftcargo.com/blog-details/1");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/blog-details/1");
        extentTest.pass("Blogs yazilarindan 1. sine gider");

        Assert.assertTrue(locator.blogsYaziBasligi.isDisplayed());
        extentTest.pass("Sayfada yazi basligi oldugunu dogrular");

        Assert.assertTrue(locator.blogsYazarAdi.isDisplayed());
        extentTest.pass("Yazar adi oldugunu dogrular");

        WebElement ilkGoruntulenme = locator.blogsGoruntulenmeSayisi;
        String ilkGoruntulenmeSayisi = ilkGoruntulenme.getText();
        Assert.assertTrue(ilkGoruntulenme.isDisplayed());
        extentTest.pass("Goruntulenme sayisi oldugunu dogrular");

        WebElement ikinciYayin = locator.blogsYayinTarihi;
        String ikinciYayinTarihi = ikinciYayin.getText();
        Assert.assertTrue(ikinciYayin.isDisplayed());
        extentTest.pass("Yayin tarihi oldugunu dogrular");

        extentTest.info( "Yayin tarihini onceki tarihle karsilastirir");
        Assert.assertEquals(ilkYayinTarihi, ikinciYayinTarihi);
        extentTest.pass( "Ilk Yayin tarihinin ikinci tarihle ayni oldugunu gorur");

        Assert.assertTrue(locator.blogsYaziIcerigi.isDisplayed());
        extentTest.pass("Yazi iceriginin oldugunu dogrular");

        driver.navigate().refresh();
        extentTest.info("Sayfayi yeniler");

        WebElement ikinciGoruntulenme =  locator.blogsGoruntulenmeSayisi;
        String ikinciGoruntulenmeSayisi = ikinciGoruntulenme.getText();
        Assert.assertNotEquals(ilkGoruntulenmeSayisi, ikinciGoruntulenmeSayisi);
        extentTest.pass("Sayfayi yeniler ve Goruntulenme sayisinin degistigini gorur");

        extentTest.info("Sayfayi kapatir");

    }

}
