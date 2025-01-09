package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NavBarPage {
    WebDriver driver;
    WebDriverWait wait;

    public static String bookName = "Atomic Habits";

    // **Locators for Navbar Elements**
    @FindBy(xpath = "//span[@id='nav-signin-text']")
    WebElement signInPageButton;

    @FindBy(xpath = "//input[@id='filter_name' and @name= 'filter_name']")  // Search bar
            WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")  // Search button
    WebElement searchButton;

    @FindBy(xpath = "//header/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]")  // Cart button (icon)
    WebElement cartButton;

    // **Constructor**
    public NavBarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
    }

    public void openSignInPage() {
        wait.until(ExpectedConditions.elementToBeClickable(signInPageButton)).click();
    }

    public boolean isSignInPageButtonVisible(){
        return wait.until(ExpectedConditions.visibilityOf(signInPageButton)).isDisplayed();
    }

    public boolean isSignInPageButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signInPageButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSearchBarVisible(){
        return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }

    public boolean isSearchButtonDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed();
    }

    public boolean isSearchButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // **Methods**

    // 1. Search for a book
    public void searchBook(String bookName) {
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(bookName + Keys.ENTER);
    }


    // 2. Click the cart button to navigate to the cart page
    public void clickCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();  // Click cart button
    }

    // 3. Check if the cart button is displayed
    public boolean isCartButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cartButton)).isDisplayed();
    }

}

