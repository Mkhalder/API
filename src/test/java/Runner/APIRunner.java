package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


    @CucumberOptions(
            features = {"src/test/resources/Features"},
            glue = {"StepDefinition"},
            tags ="@smoke",
            monochrome = true,
            dryRun = false,
            plugin = {
                    "pretty",
                    "html:build/reports/feature.html"
            })
    @Test
    public class APIRunner extends AbstractTestNGCucumberTests {
    }


