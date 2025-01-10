package Pages;

import org.openqa.selenium.By;
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

    public static String PRELOADER = "preloader";

    @FindBy(xpath = "//button[contains(text(),'Add to Cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//input[@id= 'qty_54384253']")
    WebElement specificBookQuantity;

    @FindBy(xpath = "//button[@data-field= 'qty_54384253' and @data-type='plus']")
    WebElement plusQuantityButton;

    @FindBy(xpath = "//button[@data-field= 'qty_54384253' and @data-type='minus']")
    WebElement minusQuantityButton;

    @FindBy(xpath = "//div[contains(text(),'Success add to cart') and @class='modal-text']")
    WebElement notificationModal;

    @FindBy(xpath = "//button[@aria-label= 'close']")
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

    public boolean isPlusButtonDisplayed() {
        return plusQuantityButton.isDisplayed();
    }

    public boolean isPlusButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(plusQuantityButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMinusButtonDisplayed() {
        return minusQuantityButton.isDisplayed();
    }

    public boolean isMinusButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(minusQuantityButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isQuantityDisplayed() {
        return specificBookQuantity.isDisplayed();
    }

    public boolean isAddToCartButtonDisplayed() {
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

    public void addToCart() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isNotificationModalDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(notificationModal)).isDisplayed();
    }

    public void closeNotificationModal() {
        wait.until(ExpectedConditions.elementToBeClickable(notificationModalButton)).click();
    }
}
