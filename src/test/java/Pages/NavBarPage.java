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

    @FindBy(xpath = "//span[@id='nav-signin-text']")
    WebElement signInPageButton;

    @FindBy(xpath = "//input[@id='filter_name' and @name= 'filter_name']")
            WebElement searchBar;

    @FindBy(xpath = "//header/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]")
    WebElement cartButton;

    public NavBarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);  // Initialize @FindBy elements
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

    public void openSignInPage() {
        wait.until(ExpectedConditions.elementToBeClickable(signInPageButton)).click();
    }

    public boolean isSearchBarVisible(){
        return wait.until(ExpectedConditions.visibilityOf(searchBar)).isDisplayed();
    }

    public void searchBook(String bookName) {
        wait.until(ExpectedConditions.visibilityOf(searchBar)).sendKeys(bookName + Keys.ENTER);
    }

    public void clickCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();  // Click cart button
    }

    public boolean isCartButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(cartButton)).isDisplayed();
    }
}

