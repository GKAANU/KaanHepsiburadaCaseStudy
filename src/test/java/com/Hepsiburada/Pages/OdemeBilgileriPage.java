package com.Hepsiburada.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OdemeBilgileriPage extends BasePage{

    /**
     * Locators
     */

    @FindBy (xpath = "(//div[@class='sardesPaymentPage-Accordion-header_context'])[2]")
    public WebElement anindaHavaleBtn;

    @FindBy (xpath = "(//p[@class='sardesPaymentPage-MoneyTransfer-bank_name'])[3]")
    public WebElement anindaHavaleZiraatBtn;

    @FindBy (id = "continue_step_btn")
    public WebElement devamEtBtn;

}
