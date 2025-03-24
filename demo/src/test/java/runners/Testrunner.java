package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepDefinitions"},
        plugin = {"pretty", 

        "html:target/cucumber-reports.html",

        "json:target/cucumber-reports.json",

        "junit:target/cucumber-reports.xml"}

        
)
public class Testrunner {
}
