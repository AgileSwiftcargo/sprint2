package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Anasayfa {

    // Testlerini TestBaseRapor'a extends yapanlar bu Anasayfa page'sini, Merchant ve Admin Pages lerini kullanmali.
    // Testlerini CrossTestBaseRapor'a extends yapanlar Locator Page'ini kullanmali.

    public Anasayfa (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Anasayfa Header Logo
    @FindBy(xpath = "(//*[@class='logo'])[1]")
    public WebElement headerLogo;

    //Login Butonu
    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginButonu;

    //Register Butonu
    @FindBy(xpath = "//a[.='Register']")
    public WebElement registerButonu;


    // Navigasyon Basliklari Linkleri
    @FindBy(xpath = "//a[.='Home']")
    public WebElement navHome;

    @FindBy(xpath = "//a[.='Pricing']")
    public WebElement navPricing;

    @FindBy(xpath = "//a[.='Tracking']")
    public WebElement navTracking;

    @FindBy(xpath = "//a[.='Blogs']")
    public WebElement navBlogs;

    @FindBy(xpath = "//a[.='About']")
    public WebElement navAbout;

    @FindBy(xpath = "//a[.='FAQ']")
    public WebElement navFAQ;

    @FindBy(xpath = "//a[.='Contact']")
    public WebElement navContact;

    @FindBy(xpath = "(//*[contains(@class, 'navbar')])[1]")
    public WebElement navBar;

    @FindBy(xpath = "//*[contains(@class, 'nav-link')]")
    public WebElement navLinks;

    @FindBy(xpath = "//*[@class='navbar-toggler-icon']")
    public WebElement navToggler;

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

    //Anasayfa/Footer About başlığı
    @FindBy(xpath = "(//*[.='About'])[3]")
    public WebElement AboutBaşlığı;


    // Anasayfa "Happy Achievement" //--------------------------

    //Happy Achievement Başlık
    @FindBy(xpath = "//*[.='Happy Achievement']")
    public WebElement happyAchievementBaslik;

    //Happy Achievement Branches
    @FindBy(xpath = "//*[.='Branches']")
    public WebElement happyAchievementBranches;

    //Happy Achievement Parcel Delivered
    @FindBy(xpath = "(//*[.='Parcel Delivered'])")
    public WebElement parcelDelivered;

    //Happy Achievement Merchant
    @FindBy(xpath = "(//*[.='Happy Merchant'])")
    public WebElement happyMerchant;

    //Happy Achievement Positive Reviews
    @FindBy(xpath = "(//*[.='Positive Reviews'])")
    public WebElement positiveReviews;

    //Subscribe Us Başlığı
    @FindBy(xpath = "(//*[.='Subscribe Us'])")
    public WebElement subscribeUsTitle;

    //Subscribe Us Metni
    @FindBy(xpath = "(//*[.='Get business news , tip and solutions to your problems our experts.'])")
    public WebElement subscribeUsMetni;

    //Subscribe Us butonu
    @FindBy(xpath = "(//i[@class='fa fa-paper-plane'])[1]")
    public WebElement subscribeUsButonu;

    //Subscribe Us text kutusu
    @FindBy(xpath = "//*[@name='email']")
    public WebElement subscribeUstextbox;

    //us006

    //Why Agile Swift Cargo Bölümü
    @FindBy(xpath = "/html/body/section[4]/div")
    public WebElement WhyAgileSwiftCargoBolum;

    //Why Agile Swift Cargo Bölümü Bilgilendirici Kutular
    @FindBy(xpath = "/html/body/section[4]/div/div[2]")
    public WebElement WhyAgileSwiftCargoBox;

    //Why Agile Swift Cargo Bölümü Text
    @FindBy(xpath = "(//*[.='Why Agile Swift Cargo'])[2]")
    public WebElement WhyAgileSwiftCargoText;

    //us014

    //Agile Swift Cargo Linkedin Sosyal Medya Butonları
    @FindBy(xpath = "//a[@title='Linkedin']")
    public WebElement AgileSwiftCargoLinkedIn;

    //Agile Swift Cargo Facebook Sosyal Medya Butonları
    @FindBy(xpath = "//a[@title='facebook']")
    public WebElement AgileSwiftCargoFacebook;

    //Agile Swift Cargo Instagram Sosyal Medya Butonları
    @FindBy(xpath = "//a[@title='Instagram']")
    public WebElement AgileSwiftCargoInstagram;

    //Agile Swift Cargo Youtube Sosyal Medya Butonları
    @FindBy(xpath = "//a[@title='Youtube']")
    public WebElement AgileSwiftCargoYoutube;

    //Agile Swift Cargo Skype Sosyal Medya Butonları
    @FindBy(xpath = "//a[@title='Skype']")
    public WebElement AgileSwiftCargoSkype;

    //Agile Swift Cargo Sosyal Medya Butonları
    @FindBy(xpath = "/html/body/footer[1]/div/div/div/div[4]/div/div")
    public WebElement AgileSwiftCargoSosyalMedya;

    //Email Input Butonu
    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailInput;

    //Password Input Butonu
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordInput;

    //AnaSayfa ourservis yazisi
    @FindBy(xpath = "(//*[.='Our Services'])[2]")
    public WebElement ourServicesYaziElementi;


    //Servis detay sayfalarına erişim butonları
    @FindBy(xpath = "(//a[@class='text-primary'])[1]")
    public WebElement eCommerceDeliveryButonu;

    @FindBy( xpath = "(//a[@class='text-primary'])[3]")
    public WebElement pickDropButonu;

    @FindBy( xpath = "(//a[@class='text-primary'])[2]")
    public WebElement packageingButonu;

    @FindBy ( xpath = "(//a[@class='text-primary'])[1]")
    public WebElement warehousingButonu;

    @FindBy ( xpath = "//*[.='  E-Commerce delivery ']")
    public WebElement eCommerceBaslikYazisi;

    @FindBy ( xpath = "//*[.='  Pick & Drop ']")
    public WebElement pickDropBaslikYazisi;

    @FindBy ( xpath = "//*[.='  Packageing ']")
    public WebElement packageingBaslikYazisi;

    @FindBy ( xpath ="//*[.='  Warehousing '] ")
    public WebElement warehousingBaslikYazisi;

    // Track çalışmaları

    //Anasayfa Tracknow Butonu
    @FindBy(xpath = "//*[.='Track Now']")
    public WebElement tracknowButton;

    //Enter tracking id Textbox'ı

    @FindBy(xpath = "//*[@placeholder='Enter tracking id']")
    public WebElement enterTrackingIdTextbox;

    //Parcel not found resmi

    @FindBy(xpath = "//img[@src='https://qa.agileswiftcargo.com/public/frontend/images/parcel-was-not-found.png']")
    public WebElement parcelNotFound;

    // Contact Çalışmaları

    //Anasayfa header/contact

    @FindBy(xpath = "//a[.='Contact']")
    public WebElement contactButton;

    //contact us sayfası submit butonu

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    // Merchant Çalışmaları

    //Anasayfa login
    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginButton;

    //Login Enter Email or Mobile textbox
    @FindBy(xpath = "//*[@placeholder='Enter Email or Mobile']")
    public WebElement emailTextbox;

    //Login Password
    @FindBy(xpath = "//*[@placeholder='Password']")
    public WebElement passwordTextbox;

    //Login Sign in Buttonu
    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;


}
