package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchResultsPage {
    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "(//a[contains(text(), 'Atomic Habits')])[1]")
    WebElement specificBook;

    // Constructor
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchResultsDisplayed(String partialURL) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.contains(partialURL);
    }

    // Method to click on a specific book
    public void clickSpecificBook() {
        WebElement bookElement = wait.until(ExpectedConditions.elementToBeClickable(specificBook));
        bookElement.click();
    }
}
