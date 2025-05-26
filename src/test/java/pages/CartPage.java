package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;


import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class CartPage {
    WebDriver driver = DriverHelper.getDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[contains(text(), 'Shopping Cart')]")
    WebElement shoppingCartTitle;
    @FindBy(css = "tbody tr")
    List<WebElement> productsList;
    @FindBy(css = ".cart_price p")
    List<WebElement> productsPriceList;
    @FindBy(css = ".cart_quantity button")
    List<WebElement> productsQuantityList;
    @FindBy(css = ".cart_total_price")
    List<WebElement> productsTotalPrice;
    @FindBy(xpath = "//a[contains(text(), 'Proceed')]")
    WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//a/u[contains(text(), 'Register')]")
    WebElement registerAndLoginButton;
    @FindBy(xpath = "//td[@class='cart_delete']/a")
    List<WebElement> removeProductButtonsList;
    @FindBy(css = "td.cart_description h4")
    List<WebElement> productsTitleList;
    @FindBy(css = "#empty_cart p")
    WebElement emptyCartMessage;

    public void verifyTheNumberOfAddedProducts(int expectedNum) {
        Assert.assertEquals(expectedNum, productsList.size());
    }

    public void verifyProductsDetails(String prices, String quantities, String totalPrices) {
        String[] expectedProductsPriceList = prices.split(",");
        String[] expectedProductsQuantityList = quantities.split(",");
        String[] expectedProductTotalPriceList = totalPrices.split(",");

        for (int i = 0; i < productsList.size(); i++) {
            Assert.assertEquals(expectedProductsPriceList[i].trim(), productsPriceList.get(i).getText());
            Assert.assertEquals(expectedProductsQuantityList[i].trim(), productsQuantityList.get(i).getText());
            Assert.assertEquals(expectedProductTotalPriceList[i].trim(), productsTotalPrice.get(i).getText());
        }
    }

    public void verifyProductQuantity(String expectedQuantity) {
        Assert.assertEquals(expectedQuantity, productsQuantityList.get(0).getText().trim());
    }

    public void verifyProductQuantity(List<String> expectedQuantityList) {
        for (int i = 0; i < productsQuantityList.size(); i++) {
            Assert.assertEquals(expectedQuantityList.get(i), productsQuantityList.get(i).getText().trim());
        }
    }

    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickRegisterAndLoginButton() {
        registerAndLoginButton.click();
    }

    public void checkUserIsOnTheCartPage(String actualUrl) {
        Assert.assertEquals("https://automationexercise.com/view_cart", actualUrl);
        shoppingCartTitle.isDisplayed();
    }

    public void removeProduct(String productId) {
        boolean isProductFound = false;

        for (WebElement link : removeProductButtonsList) {
            if (link.getAttribute("data-product-id").equals(productId)) {
                actions.moveToElement(link).click().perform();
                isProductFound = true;
                break;
            }
            wait.until(ExpectedConditions.stalenessOf(link));
        }

        if (!isProductFound) {
            throw new NoSuchElementException("Product with ID " + productId + " not found in the list.");
        }
    }

    public void verifyProductsAreRemoved(int expectedLength) {
        wait.until(driver -> productsList.size() == expectedLength);
        Assert.assertEquals(expectedLength, productsList.size());
    }

    public void verifyProductsAreRelatedToSearch(String expectedTitle) {
        for (WebElement title : productsTitleList) {
            Assert.assertTrue(title.getText().toLowerCase().trim().contains(expectedTitle.toLowerCase()));
        }
    }

    public void validateProductsArePresent(String expectedIDS) {
        String actualId = removeProductButtonsList.get(0).getAttribute("data-product-id");

        if (expectedIDS.length() > 1) {
            for (int i = 0; i < expectedIDS.length(); i++) {
                String[] expectedIdList = expectedIDS.split(",");
                actualId = removeProductButtonsList.get(i).getAttribute("data-product-id");

                Assert.assertEquals(expectedIdList[i], actualId);
            }
        }

        Assert.assertEquals(actualId, expectedIDS);
    }

    public void validateCartEmptyMessage(String expectedMessage){
        wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        Assert.assertTrue("Empty cart message has failed", emptyCartMessage.getText().contains(expectedMessage));
    }

}
