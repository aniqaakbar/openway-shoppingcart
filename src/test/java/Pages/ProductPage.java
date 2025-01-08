package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    NavBarPage navBarPage;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    WebElement addToCartButton;  // "Add to Cart" button

    @FindBy(id = "qty_54384253")
    WebElement specificBookQuantity;

    @FindBy(name = "plus")
    WebElement plusQuantityButton;

    @FindBy(name = "minus")
    WebElement minusQuantityButton;

    @FindBy(id = "Nptification-Modal")
    WebElement notificationModal;

    @FindBy(id = "notification-modal-header")
    WebElement notificationModalButton;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);  // Initialize elements using PageFactory
    }

    public boolean isBookPageDisplayed(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.contains(expectedURL);
    }

    //Actions
    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isDisplayed();
    }

    public boolean isAddToCartButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isQuantityVisible() {
        return specificBookQuantity.isDisplayed();
    }

    public boolean isPlusButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(plusQuantityButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isMinusButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(minusQuantityButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNotificationModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(notificationModal));
            return notificationModal.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void closeNotificationModal() {
        wait.until(ExpectedConditions.elementToBeClickable(notificationModalButton)).click();
    }

    public void goToCartPage() {
        navBarPage.clickCartButton();  // Click the cart icon in the navbar
    }

















}
