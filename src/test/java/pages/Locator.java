package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.DriverCross.driver;

public class Locator {

    // Bu Locator Havuzunu sadece Testlerini CrossTestBaseRapor'a extends yapanlar kullanabilir.
    // Testlerini TestBaseRapor'a extends yapanlar Anasayfa ve Merchant Pages lerini kullanmali.

    public Locator() {
        PageFactory.initElements(driver, this);
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
    @FindBy(xpath = "//a[.='FAQ ']")
    public WebElement FAQButonu;

    //Anasayfa/Footer About Us butonu
    @FindBy(xpath = "//a[.='About Us']")
    public WebElement AboutUsButonu;

    //Anasayfa/Footer Contact us butonu
    @FindBy(xpath = "//a[.='Contact us']")
    public WebElement ContactUsButonu;

    //Anasayfa/Footer Privacy And Policy butonu
    @FindBy(xpath = "//a[.='Privacy And Policy']")
    public WebElement PrivacyAndPolicyButonu;

    //Anasayfa/Footer Terms of Use butonu
    @FindBy(xpath = "//a[.='Terms of Use']")
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


    //Merchant Dashboard Profil //------------------------

    // Profil Resmi
    @FindBy(xpath = "(//*[@class='nav-link nav-user-img'])[1]")
    public WebElement profilResmi;

    // Profil Butonu
    @FindBy(xpath = "(//*[.='Profile'])[1]")
    public WebElement profilButonu;

    //Logout Butonu
    @FindBy(xpath = "(//*[contains(@href, 'logout')])[1]")
    public WebElement loguotButonu;

    //Profil Edit Butonu
    @FindBy(xpath = "//*[.=' Edit']")
    public WebElement profilEditButonu;


    // Parcel Menusu//-----------------

    // Parcel Menu Basligi
    @FindBy(xpath = "(//*[.='Parcels'])[3]")
    public WebElement parcelMenusu;

    // Parcel Ekleme Butonu
    @FindBy(xpath = "//*[.=' Add']")
    public WebElement parcelEkle;

    // Parcel Ekleme Formu Save Butonu
    @FindBy(xpath = "//*[.='Save']")
    public WebElement parcelSave;

    // Parcel Ekleme Formu Success Mesaji
    @FindBy(xpath = "//*[.='Success']")
    public WebElement parcelSuccess;

    //Parcel Tracking ID Basligi
    @FindBy(xpath = "//th[.='Tracking ID']")
    public WebElement parcelTrackindIdBasligi;

    //Parcel Recipient Info Basligi
    @FindBy(xpath = "//th[.='Recipient Info']")
    public WebElement parcelRecipientInfoBasligi;

    //Parcel Amount Basligi
    @FindBy(xpath = "//th[.='Amount']")
    public WebElement parcelAmountBasligi;

    //Parcel Status Basligi
    @FindBy(xpath = "//th[.='Status']")
    public WebElement parcelStatusBasligi;

    //Parcel Payment Basligi
    @FindBy(xpath = "//th[.='Payment']")
    public WebElement parcelPaymentBasligi;

    //Create Parcel Pickup Points Dropdown
    @FindBy(xpath = "//*[@id='select2-shopID-container']")
    public WebElement createParcelDropdown;

    //Create Parcel Pickup Points TextBox
    @FindBy(xpath = "//*[@class='select2-search__field']")
    public WebElement createParcelTextBox;

    //Create Parcel Pickup Address
    @FindBy(xpath = "//*[@id='pickup_address']")
    public WebElement createParcelPickupAddress;

    //Create Parcel Selling Price
    @FindBy(xpath = "//*[@id='selling_price']")
    public WebElement createParcelSellingPrice;

    //Create Parcel Category Dropdown
    @FindBy(xpath = "//*[@id='select2-category_id-container']")
    public WebElement createParcelCategoryDropdown;

    //Create Parcel Category TextBox
    @FindBy(xpath = "//*[.='KG']")
    public WebElement createParcelCategoryTextBox;

    //Create Parcel Delivery Type Dropdown
    @FindBy(xpath = "//*[@id='select2-delivery_type_id-container']")
    public WebElement createParcelDeliveryDropdown;

    //Create Parcel Delivery Type TextBox
    @FindBy(xpath = "//*[contains(text(), 'Same Day')]")
    public WebElement createParcelDeliveryTextBox;

    //Create Parcel Customer Phone
    @FindBy(xpath = "//*[@id='phone']")
    public WebElement createParcelCustomerPhone;

    //Create Parcel Customer Address
    @FindBy(xpath = "//*[@id='customer_address']")
    public WebElement createParcelCustomerAddress;

    //Create Parcel Pickup Phone
    @FindBy(xpath = "//*[@id='pickup_phone']")
    public WebElement createParcelPickupPhone;

    //Create Parcel Cash Collection
    @FindBy(xpath = "//*[@id='cash_collection']")
    public WebElement createParcelCashCollection;

    //Create Parcel Weight Dropdown
    @FindBy(xpath = "//*[@id='select2-weightID-container']")
    public WebElement createParcelWeightDropdown;

    //Create Parcel Weight TextBox
    @FindBy(xpath = "//*[contains(text(), '2 KG')]")
    public WebElement createParcelWeightTextBox;

    //Create Parcel Customer Name
    @FindBy(xpath = "//*[@id='customer_name']")
    public WebElement createParcelCustomerName;

    //Create Parcel Liquid/Fragile
    @FindBy(xpath = "//*[@for='fragileLiquid']")
    public WebElement createParcelLiquid;

    //Create Parcel Is it Parcel Bank ?
    @FindBy(xpath = "(//*[@class='custom-control-label'])[2]")
    public WebElement createParcelParcelBank;

    //Create Parcel Save Button
    @FindBy(xpath = "//*[.='Save']")
    public WebElement createParcelSaveButton;

    //Create Parcel Succces Mesaji
    @FindBy(xpath = "//*[.='Success']")
    public WebElement createParcelSuccessMesaji;

    //Parcel List Recipient Name
    @FindBy(xpath = "//*[@id=\"table\"]/tbody/tr[1]/td[4]/div/div[1]/p")
    public WebElement parcelListRecipientName;

    //Parcel List Actions Basligi
    @FindBy(xpath = "//*[.=\"###\"]")
    public WebElement parcelListActionsBasligi;

    //Parcel List Actions Butonu
    @FindBy(xpath = "(//*[@class='btn btn-sm ml-2 bnone'])[1]")
    public WebElement parcelListActionsButonu;

    //Parcel List Edit Butonu
    @FindBy(xpath = "(//*[.=' Edit'])[1]")
    public WebElement parcelListEditButonu;

    //Parcel List Save Change Butonu
    @FindBy(xpath = "//*[.='Save Change']")
    public WebElement parcelListSaveChangeButonu;

    //Parcel List Delete Butonu
    @FindBy(xpath = "(//*[.=' Delete'])[1]")
    public WebElement parcelListDeleteButonu;

    //Parcel Delete Yes Butonu
    @FindBy(xpath = "//*[.='Yes']")
    public WebElement parcelDeleteYesButonu;


    //Merchant Dashboard Sol Menü //------------------------

    // DashBoard Linki
    @FindBy(xpath = "//*[.='Dashboard']")
    public WebElement dashBoardLinki;

    // Ticket Linki
    @FindBy(xpath = "(//*[.='Ticket'])[3]")
    public WebElement ticketLinki;

    //Account Açılır Menü
    @FindBy(xpath = "(//*[.=' Accounts'])[2]")
    public WebElement accountLinki;

    //Payment Received Linki
    @FindBy(xpath = "(//*[.=' Payment Received'])[2]")
    public WebElement paymentreceivedLinki;

    //Payout  Linki
    @FindBy(xpath = "(//*[.=' Payout'])[2]")
    public WebElement payOutLinki;

    //Invoice  Linki
    @FindBy(xpath = "(//*[.='Invoice'])[3]")
    public WebElement invoiceLinki;

    //Parcels Linki
    @FindBy(xpath = "(//*[.='Parcels'])[3]")
    public WebElement parcelsLinki;

    //Parcels Bank Linki
    @FindBy(xpath = "//*[.=\"Parcels Bank\"]")
    public WebElement parcelBankLinki;

    //Reports Açılır Menü
    @FindBy(xpath = "(//*[.='Reports'])[2]")
    public WebElement reportsLinki;

    //Parcel Status Reports Linki
    @FindBy(xpath = "(//*[.='Parcel Status Reports'])[2]")
    public WebElement parcelStatusReportsLinki;

    //Total summery Linki
    @FindBy(xpath = "(//*[.='Total summery'])[2]")
    public WebElement totalSummeryLinki;

    //Account Transaction Linki
    @FindBy(xpath = "(//*[.='Account Transaction'])")
    public WebElement accountTransactionLinki;

    //Statements Linki
    @FindBy(xpath = "//*[.='Statements']")
    public WebElement statementsLinki;

    //Settings Açılır Menü
    @FindBy(xpath = "(//*[.=\" Setting\"])[2]")
    public WebElement settingsLinki;

    //COD Charges Linki
    @FindBy(xpath = "(//*[.='COD Charges'])[1]")
    public WebElement codChargesLinki;

    //Delivery Charges Linki
    @FindBy(xpath = "(//*[.='Delivery Charges'])")
    public WebElement deliveryChargesLinki;

    //Pickup Points Linki
    @FindBy(xpath = "(//*[.=' Pickup Points'])[3]")
    public WebElement pickupPointsLinki;

    // Invoice List Sayfası //--------------------------------

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='  Invoice List ']")
    public WebElement invoiceList;

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='Invoice ID']")
    public WebElement invoiceID;

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='Invoice Date']")
    public WebElement invoiceDate;

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='Total Charge']")
    public WebElement invoiceTotalCharge;

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='Cash Collection(Tk)']")
    public WebElement invoiceCashCollection;

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='Payable']")
    public WebElement invoicePayable;

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='Status']")
    public WebElement invoiceStatus;

    //"Invoice List " sütun başlıkları
    @FindBy(xpath = "//*[.='Actions']")
    public WebElement invoiceActions;

    //Fatura Görüntüleme Butonu
    @FindBy(xpath = "//*[.=' View']")
    public WebElement faturaGoruntulemeButonu;

// Invoice details Sayfası //--------------------------------

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Date']")
    public WebElement invoiceListDate;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Tracking Id']")
    public WebElement invoiceListTrackingId;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Customer Info']")
    public WebElement invoiceListCustomerInfo;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Cash Collection(Tk)']")
    public WebElement invoiceListCashCollection;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Delivery Charge']")
    public WebElement invoiceListDeliveryCharge;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Cod charges']")
    public WebElement invoiceListCodCharges;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Vat']")
    public WebElement invoiceListVat;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Total Charge']")
    public WebElement invoiceListTotalCharge;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.='Paid Out']")
    public WebElement invoiceListPaidOut;

    //Invoice Details sütun başlıkları
    @FindBy(xpath = "//*[.=' CSV']")
    public WebElement invoiceListCSV;



// Pickup Point List Sayfası //--------------------------------

    //Pickup Point Ekleme Butonu
    @FindBy(xpath = "(//i[@class='fa fa-plus'])[3]")
    public WebElement pickupPointEklemeButonu;

    //Pickup Point
    @FindBy(xpath = "//button[.='Toggle Dropdown'][1]")
    public WebElement pickupPointActionButonu;

    //Pickup Point
    @FindBy(xpath = "//*[.=' Edit'][1]")
    public WebElement pickupPointActionEditButonu;

    //Pickup Point
    @FindBy(xpath = "//*[.=' Delete'][1]")
    public WebElement pickupPointActionDeleteButonu;


// Creat Pickup Point List Sayfası //--------------------------------

    //Creat Pickup Point Başlık
    @FindBy(xpath = "//*[.='Create Pickup Point']")
    public WebElement createPickupPointBaslik;

    //Creat Pickup Point Name
    @FindBy(xpath = "//input[@placeholder='Enter name']")
    public WebElement createPickupPointName;

    //Creat Pickup Point Phone
    @FindBy(xpath = "//input[@placeholder='Enter phone']")
    public WebElement createPickupPointPhone;

    //Creat Pickup Point Adres
    @FindBy(xpath = "//*[@id=\"address\"]")
    public WebElement createPickupPointAdres;

    //Creat Pickup Point Save Butonu
    @FindBy(xpath = "//*[.='Save']")
    public WebElement createPickupPointSaveButonu;

    //Creat Pickup Point Cancel Butonu
    @FindBy(xpath = "//*[.='Cancel']")
    public WebElement createPickupPointCancelButonu;


// Edit Pickup Point List Sayfası //--------------------------------

    //Edit Pickup Point Başlığı
    @FindBy(xpath = "//*[.='Edit Pickup Point']")
    public WebElement editPickupPointBasligi;

    //Edit Pickup Point
    @FindBy(xpath = "//input[@placeholder='Enter name']")
    public WebElement editPickupPointName;

    //Edit Pickup Point
    @FindBy(xpath = "//input[@placeholder='Enter phone']")
    public WebElement editPickupPointPhone;

    //Edit Pickup Point
    @FindBy(xpath = "//*[@id=\"address\"]")
    public WebElement editPickupPointAddress;

    //Edit Pickup Point
    @FindBy(xpath = "//*[@id=\"basicform\"]/div[1]/div/div[4]/select")
    public WebElement editPickupPointStatus;

    //Edit Pickup Point
    @FindBy(xpath = "//*[.='Save Change']")
    public WebElement editPickupPointSaveButonu;

    //Edit Pickup Point
    @FindBy(xpath = "//*[.='Cancel']")
    public WebElement editPickupPointCancelButonu;

    //Edit Pickup Point Delete Sayfası Yes
    @FindBy(xpath = "/html/body/div[2]/div/div[6]/button[1]")
    public WebElement editPickupPointDeleteYesButonu;

    //Edit Pickup Point Delete Sayfası No
    @FindBy(xpath = "/html/body/div[2]/div/div[6]/button[3]")
    public WebElement editPickupPointdeleteNoButonu;

    //Edit Pickup Point Delete Sayfası Mesaj
    @FindBy(xpath = "/html/body/script[25]/text()")
    public WebElement editPickupPointMesaj;


    //banka bilgileri Pay Now Buton
    @FindBy(xpath = "//*[.='Pay Now']")
    public WebElement PayNowButon;

    //banka bilgileri Amount butonu
    @FindBy(xpath = "//*[@class='form-control w-unset']")
    public WebElement AmountButonu;

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

    // merchant şifre değişikliği          //
    @FindBy(xpath = "(//*[.='Select Hub'])[4]")
    public WebElement selectHubBasligi;

    //şifre değiştir butonu//
    @FindBy(xpath = "(//i[@class='fas fa-key mr-2'])[1]")
    public WebElement sifeDegistirButonu;

    //eski şifre butonu//
    @FindBy(xpath = "(//*[contains(@class,'form-control')])[20]")
    public WebElement EskiSifreButnu;

    //yeni şifre butonu//
    @FindBy(xpath = "(//*[contains(@class,'form-control')])[21]")
    public WebElement YeniSifreButonu;

    //yeni şifre tekrar butonu//
    @FindBy(xpath = "(//*[contains(@class,'form-control')])[22]")
    public WebElement YeniSifreTekrarButonu;

    // değişikliği kaydet butonu//
    @FindBy(xpath = "//*[.='Değişikliği Kaydet'][3]")
    public WebElement degisikligiKaydetButonu;

    //merchant çıkış//
    @FindBy(xpath = "(//*[contains(@href, 'logout')])[1]")
    public WebElement LogoutButonu;

    //Reports açılır menü//
    @FindBy(xpath = "(//*[.='Reports'])[2]")
    public WebElement ReportsButonu;

    //parcel menu baslıgı//
    @FindBy(xpath = "(//*[.='Parcels'])[3]")
    public WebElement ParcelMenuBaslıgı;

    //status başlığı//
    @FindBy(xpath = "//th[.='Status']")
    public WebElement StatsBaslıgı;

    //parcel alt menuleri//
    @FindBy(xpath = "(//*[.='Parcel Status Reports'])[2]")
    public WebElement ParcelAltMenu;

    //Total Summery butonu//
    @FindBy(xpath = "(//*[.='Total summery'])[2]")
    public WebElement TotalSummeryButonu;

    // menü "Account Transaction"//
    @FindBy(xpath = "(//*[.='Account Transaction'])")
    public WebElement AccountTransactionbutonu;

    //menü "Statements" butonu//
    @FindBy(xpath = "(//*[.='Statements'])")
    public WebElement StatementsMenusu;
    //profil resmi butonu//
    @FindBy(xpath = "(//*[.='user-avatar-md rounded-circle'][1])")
    public WebElement ProfilresmiButonu;

    //registir busines name butonu//
    @FindBy(xpath = "//*[@id='business_name']")
    public WebElement registerbusNamebutonu;

    //name surname butonu//
    @FindBy(xpath = "//*[@id='full_name']")
    public WebElement namesurNameButonu;

    //registir   mobil butonu//
    @FindBy(xpath = "//*[@id='mobile']")
    public WebElement mobileButonu;

    //registir  pasword butonu//
    @FindBy(xpath = "//*[@id='password']")
    public WebElement paswordButonu;

    //hub seciniz butonu//
    @FindBy(xpath = "(//*[.='Select Hub'])[5]")
    public WebElement hubSelect;

    @FindBy(xpath = " //*[@class='select2-search__field']")
    public WebElement hubSelectEntry;

    @FindBy(xpath = " //li[.='New York City']")
    public WebElement hubSelectNewyork;

    //adres bilgisi//
    @FindBy(xpath = "//*[@id='address']")
    public WebElement adresButonu;

    //asc gizlilik sartını kabul etme //
    @FindBy(xpath = "//*[@id='merchant_registration_checkbox']")
    public WebElement sartlariKabuletbutonu;

    //hesabı kaydetme //
    @FindBy(xpath = "//*[@id='merchant_registration_submit']")
    public WebElement kaydetbutonu;

    //Reports Menu Butonu
    @FindBy(xpath = "/html/body/div[1]/div[4]/ul/li[7]/a")
    public WebElement reportsMenuInput;

    //Reports Altındaki Menu Butonları
    @FindBy(xpath = "//*[@id='reports']/ul")
    public WebElement reportsMenu;

    //Merchant Dashboard FilterButonu
    @FindBy(xpath = "//button[.=' Filter']")
    public WebElement merchantFilterButton;

    //Merchant filtreleme için Enter Date Textbox
    @FindBy(xpath = "//input[@id='date']")
    public WebElement merchantFilterTextbox;

    //Merchant Header Profil Menü
    @FindBy(xpath = "(//img[@src='https://qa.agileswiftcargo.com/public/images/default/user.png'])[1]")
    public WebElement merchantProfileMenu;

    //Merchant logout butonu
    @FindBy(xpath = "//i[@class='fas fa-power-off mr-2']")
    public WebElement merchantLogoutButton;


    //Admin
    //Admin Header Profil Menüsü
    @FindBy(xpath = "(//img[@src='https://qa.agileswiftcargo.com/public/uploads/users/20250311215941.jpg'])[1]")
    public WebElement adminHeaderProfileMenu;

    //Admin profile menüsü
    @FindBy(xpath = "(//a[.='Profile'])[1]")
    public WebElement adminProfileMenu;

    //Admin profile edit butonu
    @FindBy(xpath = "(//*[text()=' Edit']")
    public WebElement adminProfileEditButton;

    //Admin profile edit butonu
    @FindBy(xpath = "//button[.='Save Change']")
    public WebElement saveChangeButton;

    //Admin profile dosya seç butonu
    @FindBy(xpath = "//input[@placeholder='Enter Image']")
    public WebElement adminProfileFileButton;

    @FindBy(xpath = "//*[text()='  Blogs ']")
    public WebElement blogsYazisi;

    @FindBy(xpath = "(//*[@class='card-title'])[1]")
    public WebElement blogsYaziGirisi;

    @FindBy(xpath = "//h3[contains(@class, 'my-4')]")
    public WebElement blogsYaziBasligi;

    @FindBy(xpath = "(//*[@class='text-body-secondary'])[1]")
    public WebElement blogsYazarAdi;

    @FindBy(xpath = "(//*[@class='text-body-secondary'])[2]")
    public WebElement blogsYayinTarihi;

    @FindBy(xpath = "(//*[@class='text-body-secondary'])[4]")
    public WebElement blogs2YayinTarihi;

    @FindBy(xpath = "//*[@class='text-body-secondary me-2']")
    public WebElement blogsGoruntulenmeSayisi;

    @FindBy(xpath = "//*[@class='page-content']")
    public WebElement blogsYaziIcerigi;

    @FindBy(xpath = "(//*[@class='card-title'])[1]")
    public WebElement blogsIlkBlog;

    @FindBy(xpath = "//*[@id='name']")
    public WebElement profileUpdateName;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement profileUpdateEmail;

    @FindBy(xpath = "//*[@id='mobile']")
    public WebElement profileUpdateMobile;

    @FindBy(xpath = "//*[@id='business_name']")
    public WebElement profileUpdateBusinessName;

    @FindBy(xpath = "//*[@id='address']")
    public WebElement profileUpdateAddress;

    @FindBy(xpath = "//*[.='Save Change']")
    public WebElement profileUpdateSaveChange;

    @FindBy(xpath = "//*[.='The Name field is required.']")
    public WebElement profileUpdateNameFieldRequired;

    @FindBy(xpath = "//*[.='Success']")
    public WebElement updateSuccess;

    // Merchant Ticket Sayfası //-----------------------------
    @FindBy(xpath = "//*[@aria-label='Ticket Add']")
    public WebElement ticketAddButonu;

    @FindBy(xpath = "//*[.='Ticket Add']")
    public WebElement ticketAddYaziElementi;

    @FindBy (xpath = "//*[@name='priority']")
    public WebElement priorityDdmElementi;

    @FindBy( xpath = "//*[@name='date']")
    public WebElement ticketAddDateBox;

    @FindBy(id = "subject")
    public WebElement ticketAddSubjectBox;

    @FindBy (id = "attached_file")
    public WebElement attachedBoxDosyaSecButonu;

    @FindBy (xpath = "//*[@role='textbox']")
    public WebElement descriptionBox;

    @FindBy (xpath = "//*[.='Save']")
    public WebElement ticketAddSaveButonu;

    @FindBy(xpath = "//*[.='The service field is required.']")
    public WebElement ticketAddServiceKayitUyariYazisi;

    @FindBy ( xpath = "//*[@name='department_id']")
    public WebElement departmentDdmElementi;

    @FindBy( xpath = "//*[@name='service']")
    public WebElement serviceDdmElementi;

    @FindBy( xpath = " (//*[@type='button'])[3]")
    public WebElement faqBirinciSoru;

    @FindBy( xpath = " (//*[@type='button'])[4]")
    public WebElement faqikinciSoru;


}