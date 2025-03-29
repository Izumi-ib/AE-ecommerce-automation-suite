package pages.ProductsPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverHelper;

import java.time.Duration;

public class ProductPage {

    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.product-information h2")
    WebElement productTitle;
    @FindBy(xpath = "//div[@class='product-information']/p[contains(text(), 'Category')]")
    WebElement productCategory;
    @FindBy(xpath = "//div[@class='product-information']//span[contains(text(), 'Rs')]")
    WebElement productPrice;
    @FindBy(xpath = "//div[@class='product-information']//b[contains(text(), 'Availability')]")
    WebElement productAvailability;
    @FindBy(xpath = "//div[@class='product-information']//b[contains(text(), 'Condition')]")
    WebElement productCondition;
    @FindBy(xpath = "//div[@class='product-information']//b[contains(text(), 'Brand')]")
    WebElement productBrand;
    @FindBy(id = "quantity")
    WebElement productQuantity;
    @FindBy(xpath = "//div[@class='product-information']//button")
    WebElement addToCartButton;
    @FindBy(xpath = "//a/u[contains(text(), 'View')]")
    WebElement viewCartModalButton;
    @FindBy(id = "name")
    WebElement nameInput;
    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(css = "textarea#review")
    WebElement reviewMessageTextArea;
    @FindBy(id = "button-review")
    WebElement reviewSubmitButton;
    @FindBy(xpath = "//a[contains(text(), 'Write')]")
    WebElement reviewSectionTitle;

    public void verifyUserInProductPage(String actualUrl, int productIndex) {
        Assert.assertTrue("Url doesn't matches", actualUrl.equals("https://automationexercise.com/product_details/" + (productIndex + 1)));
    }

    public void verifyProductDetailsVisible() {
        Assert.assertTrue("Product title is not displayed", productTitle.isDisplayed());
        Assert.assertTrue("Product category is not displayed", productCategory.isDisplayed());
        Assert.assertTrue("Product price is not displayed", productPrice.isDisplayed());
        Assert.assertTrue("Product availability is not displayed", productAvailability.isDisplayed());
        Assert.assertTrue("Product condition is not displayed", productCondition.isDisplayed());
        Assert.assertTrue("Product brand is not displayed", productBrand.isDisplayed());
    }

    public void increaseProductQuantity(String value) {
        productQuantity.clear();
        productQuantity.sendKeys(value);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickViewCartModalButton() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartModalButton)).click();
    }


    public void verifyReviewSectionTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, reviewSectionTitle.getText());
    }

    public void addReviewOnProduct(String name, String email, String reviewMessage) {
        nameInput.sendKeys(ConfigReader.readProperty(name));
        emailInput.sendKeys(ConfigReader.readProperty(email));
        reviewMessageTextArea.sendKeys(reviewMessage);
        reviewSubmitButton.submit();
    }

    public void verifyReviewSuccessMessage(String expectedMessage) {
        String actualMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#review-section span"))).getText().trim();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
