package tests.US023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC23_3 {

    @Test
    public void stripePayoutSayfasiKrediKartiBilgileriTesti() {
        Driver.getDriver().get("https://qa.agileswiftcargo.com/");
        Driver.getDriver().findElement(By.xpath("//*[.='Login']")).click();
        WebElement emailBox = Driver.getDriver().findElement(By.id("email"));
        WebElement passwordBox = Driver.getDriver().findElement(By.id("password"));

        emailBox.sendKeys("omercan.merchant@agileswiftcargo.com");
        passwordBox.sendKeys("Agile.0924");

        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();

        Driver.getDriver().findElement(By.xpath("(//*[@*='collapse'])[1]")).click();

        Driver.getDriver().findElement(By.xpath("//li[*=' Payout']")).click();

        Driver.getDriver().findElement(By.xpath("//*[@Class='col-lg-6  col-md-6']")).click();

        String expectedUrl = "https://qa.agileswiftcargo.com/merchant/online-payment/stripe";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

        WebElement amountTextBox = Driver.getDriver().findElement(By.id("stripe_amount"));
        amountTextBox.click();
        amountTextBox.sendKeys("150");

        WebElement payNowButton = Driver.getDriver().findElement(By.xpath("//*[@Class='btn btn-primary btn-block']"));
        payNowButton.click();

        ReusableMethods.bekle(2);

        WebElement krediKartiEmailBox = Driver.getDriver().findElement(By.id("email"));
        krediKartiEmailBox.sendKeys("omercan.merchant@agileswiftcargo.com");

        WebElement krediKartiNoBox = Driver.getDriver().findElement(By.id("card_number"));
        krediKartiNoBox.sendKeys("4242424242424242");

        WebElement krediKartiAyYılBox = Driver.getDriver().findElement(By.id("cc-exp"));
        krediKartiAyYılBox.sendKeys("242");

        WebElement cvcBox = Driver.getDriver().findElement(By.id("cc-exp-month"));
        cvcBox.sendKeys("242");

        WebElement krediKartiPayButon = Driver.getDriver().findElement(By.xpath("//*[@*='iconTick']"));
        String payButonYazisi = krediKartiPayButon.getText();

        String expectedYaziIcerik = "Pay 150,00";
        Assert.assertTrue(payButonYazisi.contains(expectedYaziIcerik));

        krediKartiPayButon.click();

    }
}
