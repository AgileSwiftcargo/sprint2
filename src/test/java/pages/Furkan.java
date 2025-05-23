package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Furkan {
    public Furkan(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

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

    //us022

    //Register Butonu
    @FindBy(xpath = "//a[.='Register']")
    public WebElement registerButonu;

    //Login Butonu
    @FindBy(xpath = "//a[.='Login']")
    public WebElement loginButonu;

    //Email Input Butonu
    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailInput;

    //Password Input Butonu
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passwordInput;

    //Reports Menu Butonu
    @FindBy(xpath = "/html/body/div[1]/div[4]/ul/li[7]/a")
    public WebElement reportsMenuInput;

    //Reports Altındaki Menu Butonları
    @FindBy(xpath = "//*[@id='reports']/ul")
    public WebElement reportsMenu;

}
