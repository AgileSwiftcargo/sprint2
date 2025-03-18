package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Merchant {

    public Merchant(){
        PageFactory.initElements(Driver.getDriver(),this);
    }




}
