package com.Hepsiburada.Pages;

import com.Hepsiburada.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage extends HomePage{

    /**
     * Locators
     */

    @FindBy(id = "txtUserName")
    public WebElement epostaKutusu;

    @FindBy(id = "btnLogin")
    public WebElement loginGirisYapBtn;

    @FindBy(id = "txtPassword")
    public WebElement sifreKutusu;

    @FindBy(id = "btnEmailSelect")
    public WebElement loginSifreGirisYapBtn;

    public void girisYap(String username, String password){
        Driver.get().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        epostaKutusu.sendKeys(username);
        loginGirisYapBtn.click();
        sifreKutusu.sendKeys(password);
        loginSifreGirisYapBtn.click();
    }
}
