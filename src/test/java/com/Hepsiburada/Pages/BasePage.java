package com.Hepsiburada.Pages;

import com.Hepsiburada.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getTitle(){
        return Driver.get().getTitle();
    }

    /**
     * Methods
     */

    public void sayfaKontrol(String sayfaAdi){
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String title = Driver.get().getTitle();
        Assert.assertTrue(title.toLowerCase().contains(sayfaAdi.toLowerCase()));
    }
}
