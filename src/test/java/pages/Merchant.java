package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Merchant {

    public Merchant(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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
    public WebElement parcelmenusu;

    // Parcel Ekleme Butonu
    @FindBy(xpath = "//*[.=' Add']")
    public WebElement parcelEkle;

    // Parcel Ekleme Formu Save Butonu
    @FindBy(xpath = "//*[.='Save']")
    public WebElement parcelSave;

    // Parcel Ekleme Formu Success Mesaji
    @FindBy(xpath = "//*[.='Success']")
    public WebElement parcelSuccess;


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
    @FindBy(xpath = "(//*[contains(@class,'dropdown-item')])[39]")
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
    @FindBy(xpath = "(//*[.='form-control form-control-lg'])[1]")
    public WebElement RegisterbusNamebutonu;

    //name surname butonu//
    @FindBy(xpath = "(//*[.='form-control form-control-lg'])[2]")
    public WebElement namesurNameButonu;

    //registir   mobil butonu//
    @FindBy(xpath = "(//*[.='form-control form-control-lg'])[3]")
    public WebElement MailButonu;

    //registir  pasword butonu//
    @FindBy(xpath = "(//*[.='form-control form-control-lg'])[4]")
    public WebElement paswordButonu;

    //hub seciniz butonu//
    @FindBy(xpath = "(//*[.='Select Hub'])[5]")
    public WebElement Hubbutonu;

    //adres bilgisi//
    @FindBy(xpath = "//*[@id=\"address\"]")
    public WebElement AdresButonu;

    //asc gizlilik sartını kabul etme //
    @FindBy(xpath = "//*[@id='merchant_registration_checkbox']")
    public WebElement sartlarıKabuletbutonu;

    //hesabı kaydetme //
    @FindBy(xpath = "//*[@id='merchant_registration_submit']")
    public WebElement Kaydetbutonu;

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



}
