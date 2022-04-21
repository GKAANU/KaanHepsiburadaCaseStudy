package com.Hepsiburada.StepDefinitions;

import com.Hepsiburada.Pages.HomePage;
import com.Hepsiburada.Pages.LoginPage;
import com.Hepsiburada.Utilities.ConfigurationReader;
import com.Hepsiburada.Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UIStepDefinitions {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Given("User navigates to {string}")
    public void user_navigates_to(String URL) {
        Driver.get().get(ConfigurationReader.get(URL));
    }

    @When("User on {string} page login with {string} and {string}")
    public void user_on_page_login_with_and(String pageName, String username, String password) {
        loginPage.girisYapSafyasınaGit();
        String title = Driver.get().getTitle();
        Assert.assertTrue(title.contains(pageName));
        loginPage.girisYap(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    @When("User on {string} page searches for {string}")
    public void user_on_page_searches_for(String pageName, String searchItem) {
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String title = Driver.get().getTitle();
        System.out.println(title);
        Assert.assertTrue(title.contains(pageName));
        homePage.aramaYap(searchItem);
    }

    @When("User on {string} page adds the second book of the page")
    public void user_on_page_adds_the_second_book_of_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User on {string} page goes {string} page")
    public void user_on_page_goes_page(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User on {string} page clicks {string}")
    public void user_on_page_clicks(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User on {string} page picks exist {string} address")
    public void user_on_page_picks_exist_address(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User on {string} page clicks on the following by order")
    public void user_on_page_clicks_on_the_following_by_order(String string, Map<String,String> clickMap) {

    }

    @Then("User on {string} page")
    public void user_on_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Verify on Ödeme Bilgileri page picked bank same on Sipariş Özeti page bank")
    public void verify_on_Ödeme_Bilgileri_page_picked_bank_same_on_Sipariş_Özeti_page_bank() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
