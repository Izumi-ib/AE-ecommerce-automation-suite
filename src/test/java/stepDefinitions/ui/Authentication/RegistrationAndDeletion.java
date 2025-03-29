package stepDefinitions.ui.Authentication;

import pages.Homepage.HomePage;
import pages.RegisterPages.AccountCreatedStatusPage;
import pages.RegisterPages.RegisterUserPage;
import pages.RegisterPages.SignUpLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class RegistrationAndDeletion {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver);
    RegisterUserPage registerUserPage = new RegisterUserPage(driver);
    AccountCreatedStatusPage accountCreatedStatusPage = new AccountCreatedStatusPage(driver);

    @When("user clicks SignUpLogin button and navigates to the signup page")
    public void user_clicks_sign_up_login_button_and_navigates_to_the_signup_page() {
        homePage.clickSignAndLoginButton();
    }

    @Then("user validates new user {string} title")
    public void user_validates_new_user_title(String expectedMessage) {
        signUpLoginPage.validateNewUserFormTitle(expectedMessage);
    }

    @When("user enters name and email and clicks Signup button")
    public void user_enters_name_and_email_and_clicks_signup_button() {
        signUpLoginPage.fillNewUserForm(ConfigReader.readProperty("username"), ConfigReader.readProperty("userEmail"));
        signUpLoginPage.clickSignUpButton();
    }

    @Then("user validates account information {string} title")
    public void user_validates_account_information_title(String expectedMessage) {
        registerUserPage.validateAccountInfoTitle(expectedMessage);
    }

    @When("user fills in personal details {string}, {string}, {string}, password, {string}")
    public void user_fills_in_personal_details(String title, String name, String email, String dateOfBirth) {
        registerUserPage.chooseTitle(title);
        registerUserPage.fillAccountInformation(name, email);
        registerUserPage.chooseDateAndClickCheckboxes(dateOfBirth);
    }

    @When("user selects checkbox {string} and checkbox {string}")
    public void user_selects_checkbox_and_checkbox(String newsCheckbox, String specialCheckbox) {
        registerUserPage.chooseCheckboxes(driver, newsCheckbox, specialCheckbox);
    }

    @When("user fills details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} And user clicks Create account button")
    public void user_fills_details_and_user_clicks_create_account_button(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        registerUserPage.fillTheAddressInformation(driver, firstName, lastName, company, address, address2, country, state, city, zipcode, mobileNumber);
    }

    @Then("user verifies account created {string} message")
    public void user_verifies_account_created_message(String expectedMessage) {
        accountCreatedStatusPage.validateAccountCreatedPage(expectedMessage);
    }

    @When("user clicks Continue button")
    public void user_clicks_continue_button() {
        accountCreatedStatusPage.clickContinueButton();
    }

    @Then("user verifies {string} username is visible")
    public void user_verifies_username_is_visible(String expectedMessage) {
        homePage.validateLoggedInTitle(expectedMessage.concat(ConfigReader.readProperty("username")));
    }

    @When("user clicks Delete Account button")
    public void user_clicks_delete_account_button() {
        homePage.deleteAccount();
    }

    @Then("user verifies account deleted {string} message")
    public void user_verifies_account_deleted_message(String expectedMessage) {
        accountCreatedStatusPage.validateAccountDeletedPage(expectedMessage);
    }

    @When("clicks Continue button")
    public void clicks_continue_button() {
        accountCreatedStatusPage.clickContinueButton();
    }

    @Then("user redirected to the home page")
    public void user_redirected_to_the_home_page() {
        homePage.validateHomePage(driver.getCurrentUrl());
    }

    @Then("user verifies email already exist message {string} is visible")
    public void user_verifies_email_already_exist_message_is_visible(String expectedMessage) {
        signUpLoginPage.validateAlreadyExistTextSignUpData(expectedMessage);
    }


}
