package com.Hepsiburada.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "rerun:target/rerun.txt",
                "html:target/default-html-reports"},
        features = "src/test/resources/Features",
        glue = "com/Hepsiburada/StepDefinitions",
        dryRun = true,
        tags = "@UITest"
)
public class CukesRunner {
}
