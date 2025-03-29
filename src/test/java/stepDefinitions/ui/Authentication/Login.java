package stepDefinitions.ui.Authentication;

import pages.RegisterPages.SignUpLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class Login {
    WebDriver driver = DriverHelper.getDriver();
    SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);

    @Then("user should see {string} on the login form")
    public void user_should_see_on_the_login_form(String expectedTitle) {
        signUpLoginPage.validateLoginFormTitle(expectedTitle);
    }
    @When("user enters email address {string} and password {string}")
    public void user_enters_email_address_and_password(String email, String password) {
        try {
            signUpLoginPage.fillLoginForm(ConfigReader.readProperty(email), ConfigReader.readProperty(password));
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("Warning: IllegalArgumentException caught");
        }
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        signUpLoginPage.clickLoginButton();
    }

    @Then("user verifies error message {string} is visible")
    public void user_verifies_error_message_is_visible(String expectedMessage) {
        signUpLoginPage.validateIncorrectTextLoginData(expectedMessage);
    }


}
