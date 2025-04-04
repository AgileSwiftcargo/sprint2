package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Alpay {

    public Alpay(){
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





}
