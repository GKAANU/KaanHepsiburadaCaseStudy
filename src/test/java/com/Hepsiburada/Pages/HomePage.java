package com.Hepsiburada.Pages;

import com.Hepsiburada.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    /**
     * Locators
     */

    @FindBy(id = "myAccount")
    public WebElement homeGirisYapIcon;

    @FindBy(id = "login")
    public WebElement homeGirisYapBtn;

    @FindBy(xpath = "//input[@aria-autocomplete='list']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[text()='ARA']")
    public WebElement aramaBtn;

    public void girisYapSafyasınaGit(){
        Driver.get().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(homeGirisYapIcon).perform();
        Driver.get().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        homeGirisYapBtn.click();
    }

    public void aramaYap(String aranacakKelime){
        aramaKutusu.sendKeys(aranacakKelime);
        aramaBtn.click();
    }
}
