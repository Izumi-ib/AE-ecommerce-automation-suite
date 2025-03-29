package runners.ui;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = "stepDefinitions/ui",
        dryRun = false,
        tags = "@ui",
        plugin = {"pretty","html:target/uiReport/uiReport.html", "rerun:target/uiReport/uiFailedTests.txt"}
)

public class Runner {
}
