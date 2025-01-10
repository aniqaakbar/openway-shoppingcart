package Pages;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//button[@name= 'plus[54384253]']")
    WebElement plusButton;

    @FindBy(xpath = "//button[@name= 'minus[54384253]']")
    WebElement minusButton;

    @FindBy(xpath = "//a[contains(text(),'Remove')]")
    WebElement removeButton;

    @FindBy(xpath = "//a[contains(text(),'Save for later')]")
    WebElement saveButton;

    @FindBy(xpath = "//a[contains(text(),'Continue shopping')]")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//span[@id = 'sub_total' and contains(text(), 'Rp ')]")
    WebElement cartPrice;

    @FindBy(xpath = "//div[@class='button5']/a[text()='Checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//div[contains(text(),'Your shopping cart is empty') and @class= 'content']")
    WebElement emptyCartText;

    @FindBy(xpath = "//input[@id='qty_54384253']")
    public WebElement bookQuantity;

    @FindBy(xpath = "//div[@class = 'success' and contains(text(), 'Success: You have modified your shopping cart')]")
    WebElement successMessage;


    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchResultsPage = new SearchResultsPage(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOf(emptyCartText)).isDisplayed();
    }

    public boolean isSuccessMessageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }

    public boolean isPlusButtonDisplayed() {
        return plusButton.isDisplayed();
    }

    public boolean isPlusButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(plusButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickPlusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(plusButton)).click();
    }

    public boolean isMinusButtonDisplayed() {
        return minusButton.isDisplayed();
    }

    public boolean isMinusButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(minusButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickMinusButton() {
        wait.until(ExpectedConditions.elementToBeClickable(minusButton)).click();
    }

    public int getBookQuantity() {
        String quantityText = bookQuantity.getAttribute("value");
        return Integer.parseInt(quantityText);
    }

    public boolean isCartPageDisplayed(String partialURL) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.contains(partialURL);
    }

    public boolean isBookAddedToCart(String bookName) {
        String xpath = "//a[contains(text(), '" + bookName + "')]";  // Dynamic XPath for book name
        try {
            WebElement bookElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return bookElement.isDisplayed();  // Return true if displayed
        } catch (Exception e) {
            return false;  // Return false if not found
        }
    }


    public boolean isCartPriceDisplayed() {
        return cartPrice.isDisplayed();
    }

    public boolean isRemoveButtonDisplayed() {
        return removeButton.isDisplayed();
    }

    public boolean isRemoveButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(removeButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void clickRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public boolean isSaveButtonDisplayed() {
        return saveButton.isDisplayed();
    }

    public boolean isSaveButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(saveButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCheckoutButtonDisplayed() {
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