package tests.US010;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.CrossTestBaseRapor;
import utilities.ReusableMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.time.*;


public class TC10_4 extends CrossTestBaseRapor {

    @Test
    public void TestBlogSirasi(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Blogs Yazilari Siralama Testi",
                "Blog yazilari ekleme tarihine gore siralanmali");

        driver.get("https://qa.agileswiftcargo.com/get-blogs");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blogs Sayfasina gider");

        Assert.assertTrue(locator.blogsYazisi.isDisplayed());
        extentTest.pass("Sayfada Blogs yazisinin oldugunu dogrular");

        locator.blogsIlkBlog.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/blog-details/1");

        ReusableMethods.bekle(1);
        driver.navigate().back();
        driver.navigate().refresh();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/get-blogs");
        extentTest.pass("Blog yazisin ilkine tiklar ve geri butonuna tiklar");


        String birinciBlogTarihi = locator.blogsYayinTarihi.getText();
        String ikinciBlogTarihi = locator.blogs2YayinTarihi.getText();

        System.out.println(birinciBlogTarihi);
        System.out.println(ikinciBlogTarihi);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm A");


        try {
            LocalDateTime birincidateTime = LocalDateTime.parse(birinciBlogTarihi, formatter);
            LocalDateTime ikincidateTime = LocalDateTime.parse(ikinciBlogTarihi, formatter);
            System.out.println("Generated LocalDateTime: " + birincidateTime);
            System.out.println("Generated LocalDateTime: " + ikincidateTime);
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date-time: " + e.getMessage());
        }




        //Assert.assertTrue(birincidateTime.isAfter(ikincidateTime));
        extentTest.pass("1. blogun tarihi ile 2. blogun tarihini karsilastirir");





    }


}
