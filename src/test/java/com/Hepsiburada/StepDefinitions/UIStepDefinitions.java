package com.Hepsiburada.StepDefinitions;

import com.Hepsiburada.Pages.*;
import com.Hepsiburada.Utilities.ConfigurationReader;
import com.Hepsiburada.Utilities.Driver;
import com.Hepsiburada.Utilities.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

public class UIStepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SepetPage sepetPage = new SepetPage();
    TeslimatBilgileriPage teslimatBilgileriPage = new TeslimatBilgileriPage();
    OdemeBilgileriPage odemeBilgileriPage = new OdemeBilgileriPage();
    SiparisOzetiPage siparisOzetiPage = new SiparisOzetiPage();
    static String odemeBilgileriBankaAdı;

    @Given("User navigates to {string}")
    public void user_navigates_to(String URL) {
        Driver.get().get(ConfigurationReader.get(URL));
    }

    @When("User on {string} page login with {string} and {string}")
    public void user_on_page_login_with_and(String sayfaAdi, String username, String password) throws InterruptedException {
        Thread.sleep(3);
        loginPage.girisYapSafyasınaGit();
        homePage.sayfaKontrol(sayfaAdi);
        loginPage.girisYap(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @When("User on {string} page searches for {string}")
    public void user_on_page_searches_for(String sayfaAdi, String aranacakUrun) throws InterruptedException {
        Thread.sleep(3);
        homePage.sayfaKontrol(sayfaAdi);
        homePage.aramaYap(aranacakUrun);
    }

    @When("User on {string} page adds the second book of the page")
    public void user_on_page_adds_the_second_book_of_the_page(String sayfaAdi) throws InterruptedException {
        Thread.sleep(3);
        homePage.sayfaKontrol(sayfaAdi);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(homePage.aramadakiIkinciUrun).perform();
        Helper.waitForVisibility(homePage.sepeteEkleBtn,5);
        homePage.sepeteEkleBtn.click();
    }

    @When("User on {string} page goes {string} page")
    public void user_on_page_goes_page(String sayfaAdi, String string2) throws InterruptedException {
        Thread.sleep(3);
        homePage.sayfaKontrol(sayfaAdi);
        Helper.waitForVisibility(homePage.sepetimBtn,5);
        homePage.sepetimBtn.click();
    }

    @When("User on {string} page clicks {string}")
    public void user_on_page_clicks(String sayfaAdi, String string2) throws InterruptedException {
        Thread.sleep(3);
        sepetPage.sayfaKontrol(sayfaAdi);
        Helper.waitForVisibility(sepetPage.alisverisiTamamlaBtn,5);
        sepetPage.alisverisiTamamlaBtn.click();
    }

    @When("User on {string} page navigates {string}")
    public void user_on_page_navigates(String sayfaAdi, String string2) throws InterruptedException {
        Thread.sleep(3);
        teslimatBilgileriPage.sayfaKontrol(sayfaAdi);
        Helper.waitForVisibility(teslimatBilgileriPage.devamEtBtn,5);
        teslimatBilgileriPage.devamEtBtn.click();
    }

    @When("User on {string} page clicks on the following by order")
    public void user_on_page_clicks_on_the_following_by_order(String sayfaAdi, Map<String,String> tiklaMap) throws InterruptedException {
        Thread.sleep(3);
        teslimatBilgileriPage.sayfaKontrol(sayfaAdi);

        for (int i = 1; i > 4 ; i++){
            if (i==1){
                Helper.waitForVisibility(odemeBilgileriPage.anindaHavaleBtn,5);
                odemeBilgileriPage.anindaHavaleBtn.click();
            }else if(i==2){
                Helper.waitForVisibility(odemeBilgileriPage.anindaHavaleZiraatBtn,5);
                odemeBilgileriPage.anindaHavaleZiraatBtn.click();
                odemeBilgileriBankaAdı = odemeBilgileriPage.anindaHavaleZiraatBtn.getText();
            }else if (i==3){
                Helper.waitForVisibility(odemeBilgileriPage.devamEtBtn,5);
                odemeBilgileriPage.devamEtBtn.click();
            }
        }
    }

    @Then("User should on {string} page")
    public void user_should_on_page(String sayfaAdi) throws InterruptedException {
        Thread.sleep(3);
        teslimatBilgileriPage.sayfaKontrol(sayfaAdi);
    }

    @Then("Ödeme Bilgileri page selected bank should be same with on Sipariş Özeti page bank")
    public void ödeme_Bilgileri_page_selected_bank_should_be_same_with_on_Sipariş_Özeti_page_bank() {
        Helper.waitForVisibility(siparisOzetiPage.anindaHavaleBankaAdi,5);
        String siparisOzetiBankaAdi = siparisOzetiPage.anindaHavaleBankaAdi.getText();
        Assert.assertTrue(siparisOzetiBankaAdi.toLowerCase().contains(odemeBilgileriBankaAdı));
    }


}
