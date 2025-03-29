package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty","html:target/allTestsReport.html", "rerun:target/allTestsFailedTests.txt"}
)

public class Runner {
}
