package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Cihat {
    public Cihat(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

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

}
