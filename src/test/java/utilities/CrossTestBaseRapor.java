package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class CrossTestBaseRapor {

    // TestBaseCross
    protected WebDriver driver;

    @Parameters("kullanilacakBrowser")
    @BeforeMethod
    public void setUp(@Optional String kullanilacakBrowser){

        driver= DriverCross.getDriver(kullanilacakBrowser);

    }


    public static ExtentReports extentReports; //extent report'a ilk atamayi yapar
    protected static ExtentTest extentTest; // test pass veya failed gibi bilgileri kaydeder. Ayrica ekran resmi icin de kullaniriz
    protected static ExtentSparkReporter extentSparkReporter; // Html raporu duzenler

    // Test işlemine başlamadan hemen önce (test methodundan önce değil, tüm test işleminden önce)
    @Parameters("kullanilacakBrowser")
    @BeforeTest(alwaysRun = true) // alwaysRun : her zaman çalıştır.
    public void setUpTest(@Optional String kullanilacakBrowser) {
        extentReports = new ExtentReports(); // Raporlamayi baslatir
        //rapor oluştuktan sonra raporunuz nereye eklensin istiyorsanız buraya yazıyorsunuz.
        String date = new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date());

        //String filePath = System.getProperty("user.dir") + "/test-output/Rapor"+date+".html";
        String filePath = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "Rapor" + date + ".html";

        //oluşturmak istediğimiz raporu (html formatında) başlatıyoruz,
        // filePath ile dosya yolunu belirliyoruz.
        // date class'i ile raporumuza tarih etiketi ekliyoruz
        extentSparkReporter = new ExtentSparkReporter(filePath);
        extentReports.attachReporter(extentSparkReporter);

        // İstediğiniz bilgileri buraya ekeyebiliyorsunuz.
        extentReports.setSystemInfo("Enviroment","Test");
        extentReports.setSystemInfo("Browser", kullanilacakBrowser); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Alpay Ciftci");
        extentSparkReporter.config().setDocumentTitle("TestNG Test");
        extentSparkReporter.config().setReportName("Html Reports");
    }


    // Her test methodundan sonra eğer assertion failed olursa, ekran görüntüsü alıp rapora ekliyor
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // eğer testin sonucu başarısızsa
            String resimYolu = CrossReusableMethods.raporaResimEkle(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(resimYolu);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eğer test çalıştırılmadan geçilmezse
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }

        DriverCross.quitDriver();

    }

    public void captureFailure(String testIsmi) throws IOException {

            String resimYolu = CrossReusableMethods.raporaResimEkle(testIsmi);
            extentTest.fail(testIsmi);
            extentTest.addScreenCaptureFromPath(resimYolu);
    }


    // Raporlandırmayı sonlandırmak icin
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {

        extentReports.flush();
    }
}
