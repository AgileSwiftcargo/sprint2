package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Filiz {

public Filiz() {


    PageFactory.initElements(Driver.getDriver(), this);

}
      // register butonu
    @FindBy(xpath = "//a[.='Register']")
            public WebElement registerButonu;

// sıkca sorulan sorulr butonu
    @FindBy(xpath = "//a[.='FAQ']")
    public WebElement FQABtonu;

        //login butonu merchant girişi
    @FindBy(xpath = "//a[.='Login']")
    public  WebElement loginButonu;

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




}


