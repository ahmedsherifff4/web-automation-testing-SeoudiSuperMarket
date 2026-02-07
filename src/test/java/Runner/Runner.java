package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:\\intelliJ\\AutomationTestingProject\\src\\main\\resources\\Features\\Cart.feature",
        glue = {"StepDefinitions", "HooksPackage"},
        plugin = {"pretty"}
)
public class Runner extends AbstractTestNGCucumberTests {
}
