package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PaymentPage {
    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#payment-form input")
    List<WebElement> paymentInputs;
    @FindBy(id = "submit")
    WebElement payAndConfirmOrderButton;
    @FindBy(css = "div#success_message div")
    WebElement successMessage;

    public void fillCartInformation(String nameOnCart, String cardNumber, String cvc, String expirationDate) {
        String[] date = expirationDate.split("/");
        List<String> cardData = Arrays.asList(nameOnCart, cardNumber, cvc, date[0], date[1]);

        for (int i = 1; i < paymentInputs.size(); i++) {
            paymentInputs.get(i).sendKeys(cardData.get(i - 1));
        }
    }

    public void clickPayAndConfirmOrderButton() {
        payAndConfirmOrderButton.submit();
    }

    public void validateSuccessMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, successMessage.getText().trim());
    }


}
