package stepDefinitions.ui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class Hook {
    WebDriver driver = DriverHelper.getDriver();
    @Before("@ui")
    public void setup(){
        driver.get(ConfigReader.readProperty("homePageUrl"));
    }

    @After("@ui")
    public void tearDown(){
        if(driver != null) driver.quit();
    }

}
