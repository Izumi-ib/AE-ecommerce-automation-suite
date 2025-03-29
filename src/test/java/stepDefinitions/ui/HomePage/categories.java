package stepDefinitions.ui.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Homepage.CategoriesPage;
import utils.DriverHelper;

public class categories {
    WebDriver driver = DriverHelper.getDriver();
    CategoriesPage categoriesPage = new CategoriesPage(driver);

    @When("user chooses category {string}")
    public void user_chooses_category(String category) {
        categoriesPage.selectCategory(category);
    }

    @When("user chooses subcategory {string}")
    public void user_chooses_subcategory(String subcategory) throws InterruptedException {
        categoriesPage.selectSubcategory(subcategory);
    }

    @Then("user should validate subcategory title {string}")
    public void user_should_validate_subcategory_title(String expectedTitle) {
        categoriesPage.validateSectionCategoryTitle(expectedTitle);
    }



}
