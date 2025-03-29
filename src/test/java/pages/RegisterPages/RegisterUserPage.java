package pages.RegisterPages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;
import utils.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class RegisterUserPage {
    public RegisterUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2/b[contains(text(), 'Enter')]")
    WebElement accountInformationTitle;
    @FindBy(id = "uniform-id_gender1")
    WebElement genderRadioMr;
    @FindBy(id = "uniform-id_gender2")
    WebElement genderRadioMrs;
    @FindBy(id = "name")
    WebElement newNameInput;
    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(tagName = "select")
    List<WebElement> dateSelects;
    @FindBy(id = "newsletter")
    WebElement newsLetterCheckbox;
    @FindBy(id = "optin")
    WebElement optinCheckbox;
    @FindBy(xpath = "//p[contains(@class, 'form-group')]/input")
    List<WebElement> addressInformationInputs;
    @FindBy(id = "country")
    WebElement countrySelect;
    @FindBy(xpath = "//button[contains(text(), 'Create')]")
    WebElement createAccountButton;


    // 1 RegisterUser

    public void validateAccountInfoTitle(String expectedMessage) {
        if (accountInformationTitle.isDisplayed())
            Assert.assertEquals(expectedMessage, accountInformationTitle.getText().trim());
    }

    public void chooseTitle(String title) {
        WebElement selectedRadio = title.equalsIgnoreCase("Mr.") ? genderRadioMr
                : title.equalsIgnoreCase("Mrs.") ? genderRadioMrs
                : null;

        if (selectedRadio == null) {
            throw new IllegalArgumentException("Invalid title: " + title + ". Allowed values: 'Mr', 'Mrs'.");
        }

        if (selectedRadio.isDisplayed() && selectedRadio.isEnabled() && !selectedRadio.isSelected()) {
            selectedRadio.click();
        }
    }

    public void fillAccountInformation(String newName, String newEmail) {
        String finalName = (newName != null && !newName.trim().isEmpty()) ? newName : ConfigReader.readProperty("username");
        String finalEmail = (newEmail != null && !newEmail.trim().isEmpty()) ? newEmail : ConfigReader.readProperty("userEmail");

        if (newNameInput.getAttribute("value").isEmpty()) {
            newNameInput.sendKeys(finalName);
        }

        if (emailInput.getAttribute("value").isEmpty()) {
            emailInput.sendKeys(finalEmail);
        }

        passwordInput.sendKeys(ConfigReader.readProperty("password"));
    }


    public void chooseDateAndClickCheckboxes(String dateOfBirth) {
        String[] splitDate = dateOfBirth.split("/");

        for (int i = 0; i < splitDate.length - 1; i++) {
            Select select = new Select(dateSelects.get(i));
            select.selectByValue(splitDate[i]);
        }
    }

    public void chooseCheckboxes(WebDriver driver, String newsCheck, String specialCheck) {
        Actions actions = new Actions(driver);
        BrowserUtils.scrollIntoView(driver, optinCheckbox);
        actions.scrollByAmount(400, 400).perform();

        if (!newsLetterCheckbox.isSelected() && newsLetterCheckbox.isEnabled())
            newsLetterCheckbox.click();
        if (!optinCheckbox.isSelected() && optinCheckbox.isEnabled())
            optinCheckbox.click();
    }

    public void fillTheAddressInformation(WebDriver driver, String firstName, String lastName, String company, String address, String address2, String selectCountry, String state, String city, String zipcode, String mobileNumber) {
        List<String> allInfo = Arrays.asList(firstName, lastName, company, address, address2, state, city, zipcode, mobileNumber);
        Actions actions = new Actions(driver);

        for (int i = 0; i < addressInformationInputs.size(); i++) {
            actions.moveToElement(addressInformationInputs.get(i)).perform();
            addressInformationInputs.get(i).sendKeys(allInfo.get(i));
        }

        actions.moveToElement(countrySelect).perform();
        Select country = new Select(countrySelect);
        country.selectByValue(selectCountry);

        createAccountButton.submit();
    }


}
