package stepDefinitions.ui.ContactUs_Get_In_Touch_Functionality;

import pages.ContactUsPage;
import pages.Homepage.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class Get_In_touch_functionality {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @When("user navigates to the Contact Us page")
    public void user_navigates_to_the_contact_us_page() {
        homePage.clickContactUsButton();
    }

    @Then("user verifies that the message {string} is visible")
    public void user_verifies_that_the_message_is_visible(String expectedMessage) {
        contactUsPage.validateFormTitle(expectedMessage);
    }

    @When("user fills out the Contact Us form with {string}, {string}, {string}, {string}, {string}")
    public void user_fills_out_the_contact_us_form_with(String name, String email, String subject, String message, String fileUrl) {
        contactUsPage.fillContactUsForm(name, email, subject, message, fileUrl);
    }

    @When("user submits the Contact Us form")
    public void user_submits_the_contact_us_form() {
        contactUsPage.submitContactUsForm();
    }

    @When("user accepts the alert")
    public void user_accepts_the_alert() {
        contactUsPage.handleAlert(driver);
    }

    @Then("user verifies Contact Us submission success message {string} is visible")
    public void user_verifies_contact_us_submission_success_message_is_visible(String expectedMessage) {
        contactUsPage.validateSuccessMessage(expectedMessage);
    }

    @When("user navigates back to the Home page")
    public void user_navigates_back_to_the_home_page() {
        homePage.clickHomeButton();
    }

    @Then("user verifies that the Home page URL is correct")
    public void user_verifies_that_the_home_page_url_is_correct() {
        homePage.validateHomePage(driver.getCurrentUrl());
    }
}
