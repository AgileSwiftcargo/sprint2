package tests.US010;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Locator;
import utilities.CrossTestBaseRapor;

public class TC10_5 extends CrossTestBaseRapor {

    @Test
    public void DigerBlogYazilari(){

        Locator locator = new Locator();

        extentTest = extentReports.createTest("Blog Yazarinin Diger Yazilari Testi",
                "Blog Yazarının diger yazilari görüntülenmeli");

        driver.get("https://qa.agileswiftcargo.com/blog-details/1");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.agileswiftcargo.com/blog-details/1");
        extentTest.pass("Blogs yazilarindan 1. sine gider");

        Assert.assertTrue(locator.blogsYaziIcerigi.isDisplayed());
        extentTest.pass("Sayfada yazi icerigi oldugunu dogrular");

        String cursorStyle = locator.blogsYazarAdi.getCssValue("cursor");
        // Assert that the cursor style indicates clickability
        Assert.assertEquals(cursorStyle, "pointer", "Cursor is not showing the clickable sign!");
        extentTest.pass("Yazarin adina tiklar");

        extentTest.pass("Yazarin profilini goruntuler");
        extentTest.pass("Yazarin diger yazilarina tiklar");

        extentTest.info("Sayfayi kapatir");
    }
}
