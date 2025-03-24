package tests.US006;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Furkan;
import utilities.ConfigReader;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.util.Scanner;

public class TC6_1 extends CrossTestBaseRapor {
    Furkan furkan ;

    @Test
    public void servisYazisiKontrolTesti (){

        extentTest = extentReports.createTest("Neden Agile Swift Cargo Yazısı Kontrol Testi" +
                "Kullanici ana sayfada neden agile swift cargo alanını görüntülemeli");
        System.out.println("0");
        ReusableMethods.bekle(5);
        // Kullanıcı, https://qa.agileswiftcargo.com/ adresine gider.
        driver.get(ConfigReader.getProperty("Url"));
        System.out.println("1");
        extentTest.info("Kullanici agileswiftcargo ana sayfasina gider");
        ReusableMethods.bekle(5);
        // Ana sayfada "Why Agile Swift Cargo" yazısının bulunduğunu kontrol eder
        String expectedYazi = "Why Agile Swift Cargo";
        String actualYazi = furkan.WhyAgileSwiftCargoText.getText();
        System.out.println("2");
        ReusableMethods.bekle(5);
        Assert.assertEquals(actualYazi,expectedYazi);
        extentTest.pass("Servis alanının doğru bir şekilde görüntülendiğini doğrular");


        // sayfayi kapatir
        extentTest.info("sayfayi kapatir");




    }
}
