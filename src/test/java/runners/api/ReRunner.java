package runners.api;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@",
        glue = "stepDefinitions/api",
        dryRun = false,
        tags = "@regression",
        plugin = {"pretty","html:target/apiReport/apiReport.html", "rerun:target/apiReport/apiFailedTests.txt"}
)

public class ReRunner {
}
