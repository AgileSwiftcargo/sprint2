package tests.US002;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Alpay;
import pages.Anasayfa;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC2_1 {

@Test
    public void baslikVurgusu(){

    Driver.getDriver().get("https://qa.agileswiftcargo.com/faq-list");

    WebElement element = Driver.getDriver().findElement(By.xpath(("//a[.='FAQ']")));

    String className = element.getAttribute("class");
    System.out.println(className);

    // Check if the class name contains the desired text
    Assert.assertTrue(className.contains("active"), "Baslik vurgulu degil");

    Driver.quitDriver();

}


}
