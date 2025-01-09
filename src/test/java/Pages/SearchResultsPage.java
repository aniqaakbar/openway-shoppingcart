package Pages;

import org.openqa.selenium.By;
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

    public static String PRELOADER = "preloader";

    @FindBy(xpath = "//a[contains(text(), 'Atomic Habits')]")
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
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        WebElement bookElement = wait.until(ExpectedConditions.elementToBeClickable(specificBook));
        bookElement.click();
    }
}