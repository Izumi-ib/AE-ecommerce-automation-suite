package stepDefinitions.ui.HomePage;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Homepage.HomePage;
import utils.DriverHelper;

public class add_recommended_product {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);

    @When("user navigates to page bottom and finds {string}")
    public void user_navigates_to_page_bottom_and_finds(String expectedHeader) {
        homePage.scrollDownAndValidateRecommendedItemsTitle(expectedHeader);
    }
    @When("user hovers to product and adds a product {string} from Recommended Items")
    public void user_hovers_to_product_and_adds_a_product_from_recommended_items(String productID) {
        homePage.hoverAndAddRecommendedProduct(productID);
    }

}
