package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DeliveryMan {

    public  DeliveryMan(){
        PageFactory.initElements(Driver.getDriver(),this);

    }



}
