package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Lutfi {

    public Lutfi(){PageFactory.initElements(Driver.getDriver(),this);}

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
    @FindBy(xpath = "(//*[.=' Edit']")
    public WebElement adminProfileEditButton;

    //Admin profile edit butonu
    @FindBy(xpath = "//button[.='Save Change']")
    public WebElement saveChangeButton;

    //Admin profile dosya seç butonu
    @FindBy(xpath = "//input[@placeholder='Enter Image']")
    public WebElement adminProfileFileButton;


}



