package tests.US001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC1_1 extends TestBaseRapor {
    @Test
    public void anasayfaTesti() {
        Driver.getDriver().get("https://qa.agileswiftcargo.com/");
        WebElement anasayfaAgileSwiftCargoLogo = Driver.getDriver().findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(anasayfaAgileSwiftCargoLogo.isDisplayed());
    }
}