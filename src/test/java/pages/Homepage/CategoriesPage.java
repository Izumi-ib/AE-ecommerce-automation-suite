package pages.Homepage;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class CategoriesPage {

    WebDriver driver = DriverHelper.getDriver();
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


    public CategoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='accordian']//h4/a")
    List<WebElement> categoriesList;
    @FindBy(xpath = "//div[@class='col-sm-9 padding-right']/div/h2")
    WebElement sectionSubcategoryTitle;


    public void selectCategory(String categoryName) {
        for (WebElement category : categoriesList) {
            actions.moveToElement(category).scrollByAmount(180, 180).perform();

            if (category.getText().trim().equalsIgnoreCase(categoryName)) {
                category.click();
                return;
            }
        }
        throw new NoSuchElementException("Category '" + categoryName + "' not found!");
    }

    public void selectSubcategory(String subcategoryName) {
        List<WebElement> subcategoriesList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='panel-body']//a")));
        subcategoriesList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='panel-body']//a")));
        subcategoriesList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='panel-body']//a")));

        for (WebElement subcategory : subcategoriesList) {

            if (subcategory.isDisplayed() && subcategory.getText().equalsIgnoreCase(subcategoryName)) {
                subcategory.click();
                return;
            }
        }
        throw new NoSuchElementException("Subcategory '" + subcategoryName + "' not found!");
    }

    public void validateSectionCategoryTitle(String expectedTitle) {
        Assert.assertTrue(sectionSubcategoryTitle.getText().toLowerCase().contains(expectedTitle.toLowerCase()));
    }


}
