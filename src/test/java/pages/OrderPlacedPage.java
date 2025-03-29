package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverHelper;

import java.io.File;
import java.time.Duration;

public class OrderPlacedPage {
    WebDriver driver = DriverHelper.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public OrderPlacedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    WebElement continueButton;
    @FindBy(xpath = "//p[contains(text(), 'Congratulations')]")
    WebElement congratulationsTitle;
    @FindBy(xpath = "//a[contains(text(), 'Download')]")
    WebElement downloadInvoiceButton;

    public void validateCongratulationsTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, congratulationsTitle.getText().trim());
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickDownloadButtonVerifyInvoiceWasDownloaded() {
        downloadInvoiceButton.click();

        boolean isDownloaded = wait.until(driver -> {
            File downloadFolder = new File(System.getProperty("user.home") + "/Downloads");
            File[] files = downloadFolder.listFiles((dir, name) -> name.startsWith("invoice") && name.endsWith(".txt"));
            return files != null && files.length > 0;
        });

        Assert.assertTrue("Invoice was NOT found in the Downloads package", isDownloaded);
    }

}
