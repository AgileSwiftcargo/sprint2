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



}
