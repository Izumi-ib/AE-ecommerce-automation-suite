package stepDefinitions.ui.Authentication;

import pages.Homepage.HomePage;
import pages.RegisterPages.SignUpLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class Logout {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
    @When("user clicks logout button")
    public void user_clicks_logout_button() {
        homePage.clickLogoutButton();
    }

    @Then("user navigates to loginPage and should validate page title")
    public void user_navigates_to_login_page_and_should_validate_page_title() {
        signUpLoginPage.validateUserInLoginPage(driver.getTitle());
    }
}
