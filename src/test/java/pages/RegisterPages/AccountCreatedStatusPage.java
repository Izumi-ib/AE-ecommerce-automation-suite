package pages.RegisterPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedStatusPage {

    public AccountCreatedStatusPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2 b")
    WebElement accountStatusTitle;
    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    WebElement continueButton;

    public void validateAccountCreatedPage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, accountStatusTitle.getText().trim());
    }

    public void validateAccountDeletedPage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, accountStatusTitle.getText().trim());

    }

    public void clickContinueButton() {
        continueButton.click();
    }


}
