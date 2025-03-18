package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Anasayfa {

    public Anasayfa (){
        PageFactory.initElements(Driver.getDriver(),this);
    }




}
