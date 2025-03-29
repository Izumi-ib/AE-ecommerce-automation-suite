package stepDefinitions.ui.ProductsPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductsPages.ProductsPage;
import utils.DriverHelper;

public class brands_selecting {

    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);

    @Then("user verifies brands that the {string} title is visible")
    public void user_verifies_brands_that_the_title_is_visible(String expectedTitle) {
        productsPage.validateBrandsTitle(expectedTitle);
    }
    @When("user selects the brand {string}")
    public void user_selects_the_brand(String brand) {
        productsPage.selectBrandFilter(brand);
    }
    @Then("user verifies that they have navigated to the {string} page")
    public void user_verifies_that_they_have_navigated_to_the_page(String brand) {
        productsPage.verifyUserIsOnTheBrandPage(brand);
    }
    @Then("user verifies that only brand {string} products are displayed")
    public void user_verifies_that_only_brand_products_are_displayed(String string) {
        productsPage.verifyProductsListVisible();
    }



}
