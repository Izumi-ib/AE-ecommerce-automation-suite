package stepDefinitions.ui.CartPage;

import pages.Homepage.HomePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class subscribe_to_updates {
    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);

    @When("user navigates to CartPage")
    public void user_navigates_to_cart_page() {
        homePage.clickCartPageButton();
    }

}
