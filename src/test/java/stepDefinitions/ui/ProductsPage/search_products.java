package stepDefinitions.ui.ProductsPage;

import pages.ProductsPages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class search_products {

    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);

    @When("user enters product name {string}")
    public void user_enters_product_name(String productTitle) {
        productsPage.searchProduct(productTitle);
    }
    @When("user clicks search button")
    public void user_clicks_search_button() {
        productsPage.clickSearchButton();
    }
    @Then("user validates Searched Products title {string} is visible")
    public void user_validates_searched_products_title_is_visible(String expectedTitle) {
        productsPage.verifySearchedSectionTitle(expectedTitle);
    }
    @Then("user verifies all products {string} are related to search and visible")
    public void user_verifies_all_products_are_related_to_search_and_visible(String productTitle) {
        productsPage.verifyProductsListRelatedToSearch(driver, productTitle);
    }

}
