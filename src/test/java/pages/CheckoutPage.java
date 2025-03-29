package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2.heading")
    List<WebElement> sectionsTitle;
    @FindBy(tagName = "textarea")
    WebElement commentTextArea;
    @FindBy(xpath = "//a[contains(text(),'Place')]")
    WebElement placeOrderButton;
    @FindBy(css = "#address_delivery li")
    List<WebElement> deliveryAddressList;
    @FindBy(css = "#address_invoice li")
    List<WebElement> billingAddressList;


    public void verifySectionsTitle(List<String> expectedTitles) {
        for (int i = 0; i < sectionsTitle.size(); i++) {
            Assert.assertEquals(expectedTitles.get(i), sectionsTitle.get(i).getText().trim());
        }
    }

    public void enterComment(String text) {
        commentTextArea.sendKeys(text);
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void verifyAddressSectionsIsVisible(){
        Assert.assertTrue(deliveryAddressList.get(0).isDisplayed());
        Assert.assertTrue(billingAddressList.get(0).isDisplayed());
    }

    public void verifyDeliveryAddress(String name, String company, String address1, String address2, String cityStateZip, String country, String phoneNumber) {
        List<String> expectedList = Arrays.asList(name, company, address1, address2, cityStateZip, country, phoneNumber);
        for (int i = 1; i < deliveryAddressList.size(); i++) {
            Assert.assertEquals(expectedList.get(i - 1), deliveryAddressList.get(i).getText().trim());
        }
    }
    public void verifyBillingAddress(String name, String company, String address1, String address2, String cityStateZip, String country, String phoneNumber) {
        List<String> expectedList = Arrays.asList(name, company, address1, address2, cityStateZip, country, phoneNumber);
        for (int i = 1; i < deliveryAddressList.size(); i++) {
            Assert.assertEquals(expectedList.get(i - 1), deliveryAddressList.get(i).getText().trim());
        }
    }
}
