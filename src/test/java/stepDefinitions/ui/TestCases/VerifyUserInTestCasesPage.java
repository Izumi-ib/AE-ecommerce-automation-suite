package stepDefinitions.ui.TestCases;

import pages.Homepage.HomePage;
import pages.TestCasesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class VerifyUserInTestCasesPage {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    TestCasesPage testCasesPage = new TestCasesPage(driver);

    @When("user navigates to Test Cases page")
    public void user_navigates_to_test_cases_page() {
        homePage.clickTestCasesPageButton();
    }
    @Then("user validates Test Cases url and section title {string}")
    public void user_validates_test_cases_url_and_section_title(String expectedTitle) {
        testCasesPage.validateUserInTestCasesPage(driver.getCurrentUrl(), expectedTitle);
    }
}
