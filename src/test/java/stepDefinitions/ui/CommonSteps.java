package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CommonMethods;
import pages.Homepage.HomePage;
import utils.DriverHelper;

public class CommonSteps {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    CommonMethods commonMethods = new CommonMethods(driver);
    @Given("user clicks consent button verifies home page is visible")
    public void user_clicks_consent_button_verifies_home_page_is_visible() {
        homePage.clickConsentButton();
        homePage.validateHomePage(driver.getCurrentUrl());
    }

    @When("user clicks Upward Arrow button")
    public void user_clicks_upward_arrow_button() {
        commonMethods.clickArrowScrollUpButton();
    }


}
