package pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactUsPage {
    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='Get In Touch']")
    WebElement formTitle;
    @FindBy(css = "form#contact-us-form input")
    List<WebElement> contactUsFormInputs;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameInput;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailInput;
    @FindBy(xpath = "//input[@name='subject']")
    WebElement subjectInput;
    @FindBy(id = "message")
    WebElement messageSection;
    @FindBy(xpath = "//input[@name='upload_file']")
    WebElement uploadFileInput;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitInput;
    @FindBy(xpath = "//div[@class='contact-form']//div[contains(text(), 'Success!')]")
    WebElement successfulSubmitMessage;
    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    WebElement homeButton;


    public void validateFormTitle(String expectedMessage){
        Assert.assertEquals(expectedMessage, formTitle.getText().trim());
    }

    public void fillContactUsForm(String name, String email, String subject, String message, String fileUrl) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        subjectInput.sendKeys(subject);
        messageSection.sendKeys(message);
        uploadFileInput.sendKeys(fileUrl);
    }

    public void submitContactUsForm() {
        submitInput.submit();
    }

    public void handleAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void validateSuccessMessage(String expectedMessage) {
        Assert.assertTrue(successfulSubmitMessage.getText().trim().contains(expectedMessage));
    }

    public void clickHomeButton() {
        homeButton.click();
    }


}
