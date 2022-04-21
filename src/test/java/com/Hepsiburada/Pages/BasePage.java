package com.Hepsiburada.Pages;

import com.Hepsiburada.Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getTitle(){
        return Driver.get().getTitle();
    }
}
