import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.print.Book;
import java.time.Duration;

public class SeleniumTest {
    WebDriver webDriver;
    WebDriverWait wait;

    public static String EMAIL = "aniqa.akbar@gmail.com";
    public static String PASSWORD = "P3r1plu5";

    public static String SIGN_IN_BUTTON = "//a[contains(text(),'Sign In')]";
    public static String EMAIL_INPUT = "//tbody/tr[2]/td[1]/input[1]";
    public static String PASSWORD_INPUT = "//input[@id='ps']";
    public static String LOGIN_BUTTON = "button-login";
    public static String SEARCH_BAR = "filter_name";
    public static String BOOK_NAME = "The Silent Patient";
    public static String PRELOADER = "preloader";
    public static String BOOK_TITLE_BUTTON = "//body/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]";
    public static String ADD_TO_CART_BUTTON = "//button[contains(text(),'Add to Cart')]";
    public static String NOTIFICATION_MODAL = "Notification-Modal";
    public static String NOTIFICATION_MODAL_BUTTON = "notification-modal-header";
    public static String CART_ICON = "//header/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]";
    public static String LOGIN_PAGE = "login-content";
    public static String ACCOUNT_PAGE = "//li[@class='active']/a[text()='Account Details']";
    public static String CART_QUANTITY = "//span[@id='cart_total']";
    public static String CART_PRICE = "//span[@id='sub_total']";





    @BeforeTest
    void Setup(){
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromeDriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://www.periplus.com");
    }

    void OpenSignInPage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SIGN_IN_BUTTON))).click();
    }

    void SigningIn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EMAIL_INPUT))).sendKeys(EMAIL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSWORD_INPUT))).sendKeys(PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(LOGIN_BUTTON))).click();
    }

    void FindBook(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SEARCH_BAR))).sendKeys(BOOK_NAME);
        Actions actions = new Actions(webDriver);
        actions.sendKeys(Keys.RETURN).perform();
    }

    void AddToCart(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        webDriver.findElement(By.xpath(BOOK_TITLE_BUTTON)).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        webDriver.findElement(By.xpath(ADD_TO_CART_BUTTON)).click();
    }

    void CheckCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(NOTIFICATION_MODAL)));
        webDriver.findElement(By.id(NOTIFICATION_MODAL_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CART_ICON))).click();
    }

    void testOpenSignInPage(){
        OpenSignInPage();
        WebElement signInPage = webDriver.findElement(By.className(LOGIN_PAGE));
        Assert.assertTrue(signInPage.isDisplayed());
    }

    void testSigningIn(){
        SigningIn();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        WebElement accountPage =webDriver.findElement(By.xpath(ACCOUNT_PAGE));
        Assert.assertTrue(accountPage.isDisplayed());
    }

    void testAddCart(){
        FindBook();
        AddToCart();
        CheckCart();

        WebElement cartQuantity = webDriver.findElement(By.xpath(CART_QUANTITY));
        String cartQuantityString = cartQuantity.getText();
        Assert.assertEquals(cartQuantityString, "1");

        WebElement cartPrice = webDriver.findElement(By.xpath(CART_PRICE));
        String cartPriceString = cartPrice.getText();
        Assert.assertEquals(cartPriceString, "Rp 505,000");
    }

    @Test
    void testing(){
        testOpenSignInPage();
        testSigningIn();
        testAddCart();
    }

    @AfterTest
    void close(){
        webDriver.close();
    }

}
