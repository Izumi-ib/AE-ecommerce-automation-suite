package stepDefinitions.ui.ProductsPage;

import pages.Homepage.HomePage;
import pages.ProductsPages.ProductPage;
import pages.ProductsPages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class product_details {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    ProductPage productPage = new ProductPage(driver);

    @When("user navigates to Products page")
    public void user_navigates_to_products_page() {
        homePage.clickProductsPageButton();
    }

    @Then("user verifies products section title {string} is visible")
    public void user_verifies_products_section_title_is_visible(String expectedTitle) {
        productsPage.verifyUserInProductsPage(driver.getCurrentUrl(), expectedTitle);
    }

    @Then("user verifies products list is visible")
    public void user_verifies_products_list_is_visible() {
        productsPage.verifyProductsListVisible();
    }

    @When("user clicks on View Product for the product, product index {string}")
    public void user_clicks_on_view_product_for_the_first_product(String i) {
        productsPage.viewProduct(driver, Integer.parseInt(i));
    }

    @Then("user verifies product index {string} details are visible on the Product Page")
    public void user_verifies_product_index_details_are_visible_on_the_Product_Page(String productIndex) {
        productPage.verifyUserInProductPage(driver.getCurrentUrl(), Integer.parseInt(productIndex));
        productPage.verifyProductDetailsVisible();
    }

    @When("user sets product quantity to {string}")
    public void user_sets_product_quantity_to(String value) {
        productPage.increaseProductQuantity(value);
    }

    @When("user clicks Add to Cart button in Product page")
    public void user_clicks_add_to_cart_button_in_product_page() {
        productPage.clickAddToCartButton();
    }

    @Then("user verifies review title {string} on the Product page")
    public void user_verifies_review_title_on_the_product_page(String expectedTitle) {
        productPage.verifyReviewSectionTitle(expectedTitle);
    }

    @When("user enters name {string}, email {string}, review message {string} and user clicks submit button")
    public void user_enters_name_email_review_message_and_user_clicks_submit_button(String name, String email, String reviewMessage) {
        productPage.addReviewOnProduct(name, email, reviewMessage);
    }

    @Then("user verifies success review message {string}")
    public void user_verifies_success_review_message(String expectedMessage) {
        productPage.verifyReviewSuccessMessage(expectedMessage);
    }


}
