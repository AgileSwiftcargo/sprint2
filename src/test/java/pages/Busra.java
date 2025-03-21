package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Busra {

    public Busra(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

   //Anasayfa Same Day butonu
     @FindBy(xpath = "//*[.='Same Day']")
      public WebElement SamDayButonu;

   //Anasayfa Next Day butonu
    @FindBy(xpath = "//*[.='Next Day']")
    public  WebElement NextDayButonu;

    //Anasayfa Sub City butonu
    @FindBy(xpath = "//*[.='Sub City']")
    public  WebElement SubCityButonu;

   //Anasayfa Outside City butonu
    @FindBy(xpath = "//*[.='Outside City']")
    public WebElement OutsideCityButonu;

    //Anasayfa Available Services başlığı
    @FindBy(xpath = "//*[.='Available Services']")
    public WebElement AvailableServicesBaşlığı;

    //Anasayfa/Footer FAQ butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[5]")
    public WebElement FAQButonu;

    //Anasayfa/Footer About Us butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[6]")
    public WebElement AboutUsButonu;

    //Anasayfa/Footer Contact us butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[7]")
    public WebElement ContactUsButonu;

    //Anasayfa/Footer Privacy And Policy butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[8]")
    public WebElement PrivacyAndPolicyButonu;

    //Anasayfa/Footer Terms of Use butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[9]")
    public WebElement TermsOfUseButonu;

    //Anasayfa/Footer Warehousin butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[4]")
    public WebElement  WarehousinButonu;

    //Anasayfa/Footer Packagein butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[3]")
    public WebElement PackageinButonu;

    //Anasayfa/Footer Pick & Drop butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[2]")
    public WebElement PickDropButonu;

    //Anasayfa/Footer E-Commerce delivery butonu
    @FindBy(xpath = "(//*[contains(@class,'list-ite')])[1]")
    public WebElement ECommerceDeliveryButonu;

    //Odeme bilgileri Setting butonu
    @FindBy(xpath = " //*[.='Setting']")
    public WebElement SettingButonu;

    //Odeme bilgileri COD Charges butonu
    @FindBy(xpath = "(//*[contains(@class,'nav-link active')])[20]")
    public  WebElement CODChargesButonu;

    //Odeme bilgileri Delivery Charges butonu
    @FindBy(xpath = "(//*[contains(@class,'nav-link active')])[21]")
    public WebElement DeliveryChargesButonu;

    //banka bilgileri Accounts butonu
    @FindBy(xpath = " //*[.='Accounts']")
    public WebElement AccountsButonu;

    //banka bilgileri Payment Received butonu
    @FindBy(xpath = "( //*[.='Payment Received'])[1]")
    public WebElement PaymentReceivedButonu;

    //banka bilgileri  Payout butonu
    @FindBy(xpath = "(//*[contains(@class,'nav-link active')])[2]")
    public WebElement PayoutButonu;

    //Anasayfa/Footer About başlığı
    @FindBy(xpath = "(//*[.='About'])[3]")
    public WebElement AboutBaşlığı;

    //banka bilgileri Pay Now Buton
    @FindBy(xpath = "//*[.='Pay Now']")
    public WebElement PayNowButon;

    //banka bilgileri Amount butonu
    @FindBy(xpath = "//*[@class='form-control w-unset']")
    public WebElement AmountButonu;














}



