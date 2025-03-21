package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Busra {

    public Busra(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    public static void main(String[] args) {
        System.out.println("busra");
    }







}



