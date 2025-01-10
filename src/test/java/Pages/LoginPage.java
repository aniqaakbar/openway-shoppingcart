package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    public static String EMAIL = "aniqa.akbar@gmail.com";
    public static String PASSWORD = "P3r1plu5";

    @FindBy(xpath = "//span[contains(text(),'Sign In to Your Account')]")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@id='button-login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Account Details')]")
    WebElement accountDetailsPage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public boolean isLoginPageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(pageTitle)).isDisplayed();
    }

    public boolean isEmailFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(emailField)).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(passwordField)).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.elementToBeClickable(loginButton)).isDisplayed();
    }

    public boolean isLoginButtonClickable() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void enterEmail(String EMAIL) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(EMAIL);
    }

    public void enterPassword(String PASSWORD) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(PASSWORD);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public void signIn(String EMAIL, String PASSWORD){
        enterEmail(EMAIL);
        enterPassword(PASSWORD);
        clickLoginButton();
    }

    public boolean isAccountPageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(accountDetailsPage)).isDisplayed();
    }
}
