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

    /*Locators*/

    @FindBy(className = "login-content")
    WebElement loginPageContent;

    @FindBy(xpath = "//span[contains(text(),'Sign In to Your Account')]")
    WebElement pageTitle;

    @FindBy(xpath = "//tbody/tr[2]/td[1]/input[1]")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='ps']")
    WebElement passwordField;

    @FindBy(id = "button-login")
    WebElement loginButton;

    @FindBy(xpath = "//li[@class='active']/a[text()='Account Details']")
    WebElement accountDetailsPage;

    /*Constructor*/
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    /*Actions*/


    //Enter Email
    public void enterEmail(String EMAIL) {
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(EMAIL);
    }

    // Enter Password
    public void enterPassword(String PASSWORD) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(PASSWORD);
    }

    //Click Login Button
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    //Signing In
    public void signIn(String EMAIL, String PASSWORD){
        enterEmail(EMAIL);
        enterPassword(PASSWORD);
        clickLoginButton();
    }

    //Validations

    public boolean isLoginPageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(loginPageContent)).isDisplayed();
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

    public boolean isAccountPageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(accountDetailsPage)).isDisplayed();
    }










}
