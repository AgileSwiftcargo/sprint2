package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Furkan {
    public static void main(String[] args) {
        System.out.println("Başlangıç...");
    }
    public Furkan(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Why Agile Swift Cargo Bölümü
    @FindBy(xpath = "/html/body/section[4]/div")
    public WebElement WhyAgileSwiftCargoBolum;

    //Why Agile Swift Cargo Bölümü Bilgilendirici Kutular
    @FindBy(xpath = "/html/body/section[4]/div/div[2]")
    public WebElement WhyAgileSwiftCargoBox;
}
