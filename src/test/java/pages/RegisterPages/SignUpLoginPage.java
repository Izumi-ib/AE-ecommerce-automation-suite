package pages.RegisterPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpLoginPage {
    public SignUpLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(), 'New')]")
    WebElement newUserFormTitle;
    @FindBy(xpath = "//h2[contains(text(), 'Login')]")
    WebElement loginFormTitle;
    @FindBy(xpath = "//input[@name='name']")
    WebElement signUpNameInput;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmailInput;
    @FindBy(xpath = "//form[@action='/login']/input[@name='email']")
    WebElement loginEmailInput;
    @FindBy(xpath = "//form[@action='/login']/input[@name='password']")
    WebElement loginPasswordInput;
    @FindBy(xpath = "//button[contains(text(), 'Signup')]")
    WebElement signUpButton;
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//p[contains(text(), 'Your')]")
    WebElement loginIncorrectDataText;
    @FindBy(xpath = "//p[contains(text(), 'Email')]")
    WebElement alreadyExistText;

    public void fillNewUserForm(String name, String email) {
        signUpNameInput.sendKeys(name);
        signUpEmailInput.sendKeys(email);
    }

    public void fillLoginForm(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
    }

    public void clickSignUpButton() {
        signUpButton.submit();
    }

    public void clickLoginButton() {
        loginButton.submit();
    }

    public void validateNewUserFormTitle(String expectedText) {
        if (newUserFormTitle.isDisplayed()) Assert.assertEquals(expectedText, newUserFormTitle.getText().trim());
    }

    public void validateLoginFormTitle(String expectedText) {
        if (loginFormTitle.isDisplayed()) Assert.assertEquals(expectedText, loginFormTitle.getText().trim());
    }

    public void validateIncorrectTextLoginData(String expectedText) {
        if (loginIncorrectDataText.isDisplayed())
            Assert.assertEquals(expectedText, loginIncorrectDataText.getText().trim());
    }

    public void validateAlreadyExistTextSignUpData(String expectedText) {
        if (alreadyExistText.isDisplayed()) Assert.assertEquals(expectedText, alreadyExistText.getText().trim());
    }

    public void validateUserInLoginPage(String actualTitle) {
        Assert.assertTrue(actualTitle.contains("Signup / Login"));
    }


}
