package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Admin {

    public Admin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


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
