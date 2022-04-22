package com.Hepsiburada.StepDefinitions;

import com.Hepsiburada.Utilities.ConfigurationReader;
import com.Hepsiburada.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    /**
     * These lines will be executed before every test
     */
    @Before
    public void setUp(Scenario scenario) {
        if (scenario.getName().contains("Hepsiburada UI Test")) {
            // we need driver only for the UI test
            Driver.get().manage().window().maximize();
            Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

        if (scenario.getName().contains("Geocode reverse geocoding test for")) {
            // we need baseURI only for the API test
            RestAssured.baseURI = ConfigurationReader.get("api_url");
        }
    }

    /**
     * These lines will be executed after every test
     * Screenshot will be captured if the scenario fails
     *
     * @param scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        // capture screenshot and close driver only for UI tests
        if (scenario.getName().contains("Hepsiburada UI Test")) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
//               Driver.closeDriver();
        }

    }
}
