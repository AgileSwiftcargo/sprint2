package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;

public class Kerem {

    public Kerem (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //AnaSayfa ourservis yazisi
    @FindBy(xpath = "(//*[.='Our Services'])[2]")
    public WebElement ourServicesYaziElementi;


    //Servis detay sayfalarına erişim butonları
    @FindBy(xpath = "(//i[@class='fa fa-arrow-right'])[1]")
    public WebElement eCommerceDeliveryButonu;

    @FindBy( xpath = "(//i[@class='fa fa-arrow-right'])[2]")
    public WebElement pickDropButonu;

    @FindBy( xpath = "(//i[@class='fa fa-arrow-right'])[3]")
    public WebElement packageingButonu;

    @FindBy ( xpath = "(//i[@class='fa fa-arrow-right'])[4]")
    public WebElement warehousingButonu;

    @FindBy ( xpath = "//*[.='  E-Commerce delivery ']")
    public WebElement eCommerceBaslikYazisi;

    @FindBy ( xpath = "//*[.='  Pick & Drop ']")
    public WebElement pickDropBaslikYazisi;

    @FindBy ( xpath = "//*[.='  Packageing ']")
    public WebElement packageingBaslikYazisi;

    @FindBy ( xpath ="//*[.='  Warehousing '] ")
    public WebElement warehousingBaslikYazisi;






}
