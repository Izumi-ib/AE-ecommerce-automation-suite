package stepDefinitions.ui.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CommonMethods;
import pages.Homepage.HomePage;
import utils.DriverHelper;

public class scrollUpButtons {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    CommonMethods commonMethods = new CommonMethods(driver);

    @Then("user verifies that the top title in the Home page {string} is displayed")
    public void user_verifies_that_the_top_title_in_the_home_page_is_displayed(String expectedTitle) {
        homePage.validateTopCarouselTitles(expectedTitle);
    }

    @When("user scrolls up to Page top")
    public void user_scrolls_up_to_page_top() {
        commonMethods.scrollUp();
    }
}
