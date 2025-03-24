package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;

import static utilities.Driver.driver;

public class Kerem {

    public Kerem (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
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


    //Download App bölümü Locate'leri







}
