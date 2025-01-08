package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    SearchResultsPage searchResultsPage;


    @FindBy(xpath = "//a[contains(text(),'Remove')]")
    WebElement removeButton;

    @FindBy(xpath = "//a[contains(text(),'Save for later')]")
    WebElement saveButton;

    @FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
    WebElement continueShoppingButton;

    @FindBy(id = "sub-total")
    WebElement cartPrice;

    @FindBy(xpath = "//body/div[3]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")
    WebElement checkoutButton;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isCartPageDisplayed(String partialURL) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.contains(partialURL);
    }

    public boolean isBookAddedToCart() {
        return wait.until(ExpectedConditions.visibilityOf(searchResultsPage.specificBook)).isDisplayed();
    }

    public boolean isBookPriceDisplayed() {
        return cartPrice.isDisplayed();
    }

    public boolean isRemoveButtonVisibleAndClickable() {
        try {
            wait.until(ExpectedConditions.visibilityOf(removeButton));
            wait.until(ExpectedConditions.elementToBeClickable(removeButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public boolean isCheckoutButtonVisible() {
        return checkoutButton.isDisplayed();
    }

    public boolean isCheckoutButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }







}
