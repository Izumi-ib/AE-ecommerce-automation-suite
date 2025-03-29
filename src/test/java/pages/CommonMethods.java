package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;

public class CommonMethods {
    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions actions = new Actions(driver);

    public CommonMethods(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "scrollUp")
    WebElement scrollUpArrowButton;
    @FindBy(xpath = "//img[contains(@alt, 'Website')]")
    WebElement automationTopLogo;

    public void clickArrowScrollUpButton(){
        wait.until(ExpectedConditions.elementToBeClickable(scrollUpArrowButton)).click();
    }
    public void scrollUp(){
        actions.moveToElement(automationTopLogo).perform();
    }



}
