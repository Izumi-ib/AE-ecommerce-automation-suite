package pages.ProductsPages;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductsPage {
    private WebDriver driver = DriverHelper.getDriver();
    private Actions actions = new Actions(driver);
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2.title")
    WebElement productsSectionTitle;
    @FindBy(xpath = "//div[@class='features_items']//div[@class='col-sm-4']")
    List<WebElement> productItemsList;
    @FindBy(xpath = "//div[@class='features_items']//div[@class='productinfo text-center']//p")
    List<WebElement> productTitlesList;
    @FindBy(xpath = "//div[@class='features_items']//div[@class='col-sm-4']//a[contains(text(), 'View')]")
    List<WebElement> productViewProductButtonsList;
    @FindBy(xpath = "//div[@class='overlay-content']/a")
    List<WebElement> productAddToCartButtonsList;
    @FindBy(css = "input#search_product")
    WebElement searchInput;
    @FindBy(css = "button#submit_search")
    WebElement searchButton;
    @FindBy(xpath = "//button[contains(text(), 'Continue')]")
    WebElement continueShoppingButton;
    @FindBy(xpath = "//a/u[contains(text(), 'View')]")
    WebElement viewCartModalButton;
    @FindBy(xpath = "//h2[contains(text(), 'Searched')]")
    WebElement searchedProductsSectionTitle;
    @FindBy(css = "div.brands_products h2")
    WebElement brandsTitle;
    @FindBy(css = "div.brands-name a")
    List<WebElement> brandsList;
//    @FindBy(xpath = "//div[@class='features_items']/h2")
//    WebElement selectedBrandTitle;

    public void verifyUserInProductsPage(String actualUrl, String expectedSectionTitle) {
        Assert.assertEquals("https://automationexercise.com/products", actualUrl);
        Assert.assertEquals(expectedSectionTitle, productsSectionTitle.getText().trim());
    }

    public void verifyProductsListVisible() {
        for (WebElement item : productItemsList) {
            Assert.assertTrue("Element is not visible", item.isDisplayed());
        }
    }

    public void verifyProductsListRelatedToSearch(WebDriver driver, String productTitle) {
        for (WebElement title : productTitlesList) {
            BrowserUtils.scrollIntoView(driver, title);
            Assert.assertTrue("Element title is not visible", title.getText().toLowerCase().contains(productTitle.toLowerCase()));
        }
    }

    public void viewProduct(WebDriver driver, int productIndex) {
        Actions actions = new Actions(driver);
        actions.moveToElement(productViewProductButtonsList.get(productIndex)).scrollByAmount(200, 200).perform();

        productViewProductButtonsList.get(productIndex).click();
    }

    public void searchProduct(String searchTitle) {
        searchInput.sendKeys(searchTitle);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void verifySearchedSectionTitle(String expectedTitle) {
        Assert.assertTrue(searchedProductsSectionTitle.isDisplayed() && searchedProductsSectionTitle.getText().equals(expectedTitle));
    }

    public void addProductToCart(int productIndex) {
        actions.moveToElement(productViewProductButtonsList.get(productIndex)).perform();
        actions.clickAndHold(productItemsList.get(productIndex)).perform();

        wait.until(ExpectedConditions.elementToBeClickable(productAddToCartButtonsList.get(productIndex))).click();
    }

    public void clickContinueShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }

    public void clickViewCartModalButton() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartModalButton)).click();
    }

    public void validateBrandsTitle(String expectedTitle) {
        actions.moveToElement(brandsTitle).scrollByAmount(180, 180).perform();
        Assert.assertEquals(expectedTitle, brandsTitle.getText().trim());
    }

    public void selectBrandFilter(String brandTitle) {
        for (WebElement brand : brandsList) {
            actions.moveToElement(brand).scrollByAmount(50, 50).perform();

            if (brand.getText().toLowerCase().contains(brandTitle.toLowerCase())) {
                wait.until(ExpectedConditions.elementToBeClickable(brand)).click();
                return;
            }
        }
        throw new NoSuchElementException("Brand " + brandTitle + " was not found");
    }

    public void verifyUserIsOnTheBrandPage(String expectedBrandTitle) {
        Assert.assertTrue(productsSectionTitle.getText().toLowerCase().contains(expectedBrandTitle.toLowerCase()));
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedBrandTitle.toLowerCase()));
    }

}
