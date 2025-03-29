package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

    public TestCasesPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "h2 b")
    WebElement testCasesSectionTitle;

    public void validateUserInTestCasesPage(String actualUrl, String expectedSectionTitle){
        Assert.assertEquals("https://automationexercise.com/test_cases", actualUrl);
        Assert.assertEquals(expectedSectionTitle, testCasesSectionTitle.getText().trim());
    }
}
