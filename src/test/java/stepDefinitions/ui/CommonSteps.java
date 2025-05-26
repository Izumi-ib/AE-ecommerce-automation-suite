package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CommonMethods;
import pages.Homepage.HomePage;
import pages.RegisterPages.AccountCreatedStatusPage;
import pages.RegisterPages.RegisterUserPage;
import pages.RegisterPages.SignUpLoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class CommonSteps {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    CommonMethods commonMethods = new CommonMethods(driver);
    SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
    RegisterUserPage registerUserPage = new RegisterUserPage(driver);
    AccountCreatedStatusPage accountCreatedStatusPage = new AccountCreatedStatusPage(driver);

    @Given("user clicks consent button verifies home page is visible")
    public void user_clicks_consent_button_verifies_home_page_is_visible() {
        homePage.clickConsentButton();
        homePage.validateHomePage(driver.getCurrentUrl());
    }

    @When("user clicks Upward Arrow button")
    public void user_clicks_upward_arrow_button() {
        commonMethods.clickArrowScrollUpButton();
    }

    @When("user successfully registers")
    public void user_successfully_registers() {
        // user enters a name and email then goes to register page
        signUpLoginPage.fillNewUserForm(ConfigReader.readProperty("username"), ConfigReader.readProperty("registerUserEmail"));
        signUpLoginPage.clickSignUpButton();

        // user gives the info
        registerUserPage.chooseTitle("Mr.");
        registerUserPage.fillAccountInformation("name", "email");
        registerUserPage.chooseDateAndClickCheckboxes("19/3/1989");

        // user selects checkboxes
        registerUserPage.chooseCheckboxes(driver, "Sign up for our newsletter!", "Receive special offers from our partners!");

        // user fills Address Info
        registerUserPage.fillTheAddressInformation(driver, "Arlen", "StraightSword", "Birds", "Address", "Address2", "United States", "State", "City", "12354", "465468454895600");
    }

    @When("user successfully deletes the account")
    public void user_successfully_deletes_the_account(){
        homePage.deleteAccount();

        accountCreatedStatusPage.validateAccountDeletedPage("ACCOUNT DELETED!");

        accountCreatedStatusPage.clickContinueButton();
    }

    @Then("user should see browser alert and validate the message {string}")
    public void user_should_see_browser_alert_and_validate_the_message(String expectedMessage) {
        commonMethods.validateFormSubmitErrorAlert(expectedMessage);
    }


}
