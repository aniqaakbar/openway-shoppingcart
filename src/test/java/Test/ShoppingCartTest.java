package Test;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

import static Pages.LoginPage.EMAIL;
import static Pages.LoginPage.PASSWORD;
import static Pages.ProductPage.PRELOADER;

public class ShoppingCartTest {
    WebDriver driver;
    NavBarPage navBarPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromeDriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.periplus.com");
        navBarPage = new NavBarPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void T01_TestSignInPageButtonDisplayed() {
        Assert.assertTrue(navBarPage.isSignInPageButtonVisible());
    }

    @Test(priority = 2)
    public void T02_TestSignInPageButtonClickable() {
        Assert.assertTrue(navBarPage.isSignInPageButtonClickable());
    }

    @Test(priority = 3)
    public void T03_TestLoginPageDisplayed() {
        navBarPage.openSignInPage();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test(priority = 4)
    public void T04_TestEmailFieldDisplayed() {
        Assert.assertTrue(loginPage.isEmailFieldDisplayed());
    }

    @Test(priority = 5)
    public void T05_TestPasswordFieldDisplayed() {
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
    }

    @Test(priority = 6)
    public void T06_TestLoginButtonDisplayed() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test(priority = 7)
    public void T07_TestLoginButtonClickable() {
        Assert.assertTrue(loginPage.isLoginButtonClickable());
    }

    @Test(priority = 8)
    public void T08_TestSignIn() {
        loginPage.signIn(EMAIL, PASSWORD);
        Assert.assertTrue(loginPage.isAccountPageDisplayed());
    }

    @Test(priority = 9)
    public void T09_TestSearchBarDisplayed() {
        Assert.assertTrue(navBarPage.isSearchBarVisible());
    }

    @Test(priority = 10)
    public void T12_TestSearchBook() {
        String bookName = "Atomic Habits";
        navBarPage.searchBook(bookName);

        String partialURL = "filter_name=" + bookName.replace(" ", "+");
        Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed(partialURL));

        Assert.assertTrue(searchResultsPage.isBookDisplayed(bookName));
    }

    @Test(priority = 11)
    public void T11_TestClickBook() {
        String bookName = "Atomic Habits";
        String expectedURLPart = bookName.toLowerCase().replace(" ", "-");

        searchResultsPage.clickSpecificBook(bookName);
        Assert.assertTrue(productPage.isBookPageDisplayed(expectedURLPart));
    }


    @Test(priority = 12)
    public void T12_TestPlusQuantityButtonDisplayed() {
        Assert.assertTrue(productPage.isPlusButtonDisplayed());
    }

    @Test(priority = 13)
    public void T13_TestPlusQuantityButtonClickable() {
        Assert.assertTrue(productPage.isPlusButtonClickable());
    }

    @Test(priority = 14)
    public void T14_TestMinusQuantityButtonDisplayed() {
        Assert.assertTrue(productPage.isMinusButtonDisplayed());
    }

    @Test(priority = 15)
    public void T15_TestMinusQuantityButtonClickable() {
        Assert.assertTrue(productPage.isMinusButtonClickable());
    }

    @Test(priority = 16)
    public void T16_TestQuantityDisplayed() {
        Assert.assertTrue(productPage.isQuantityDisplayed());
    }

    @Test(priority = 17)
    public void T17_TestAddToCartButtonDisplayed() {
        Assert.assertTrue(productPage.isAddToCartButtonDisplayed());
    }

    @Test(priority = 18)
    public void T18_TestAddToCartButtonClickable() {
        Assert.assertTrue(productPage.isAddToCartButtonClickable());
    }

    @Test(priority = 19)
    public void T19_TestAddToCart() {
        productPage.addToCart();
        Assert.assertTrue(productPage.isNotificationModalDisplayed());
        productPage.closeNotificationModal();
    }

    @Test(priority = 20)
    public void T20_TestGoToCartPage() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class = 'modal-backdrop fade']")));
        navBarPage.isCartButtonDisplayed();
        navBarPage.clickCartButton();
        String partialURL = "cart";
        Assert.assertTrue(cartPage.isCartPageDisplayed(partialURL));
    }

    @Test(priority = 21)
    public void T21_TestBookDisplayed() {
        String bookName = "Atomic Habits";
        Assert.assertTrue(cartPage.isBookAddedToCart(bookName));
    }

    @Test(priority = 22)
    public void T22_TestPlusButtonDisplayed() {
        Assert.assertTrue(cartPage.isPlusButtonDisplayed());
    }

    @Test(priority = 23)
    public void T23_TestPlusButtonClickable() {
        Assert.assertTrue(cartPage.isPlusButtonClickable());
    }

    @Test(priority = 24)
    public void T24_TestMinusButtonDisplayed() {
        Assert.assertTrue(cartPage.isMinusButtonDisplayed());
    }

    @Test(priority = 25)
    public void T25_TestMinusButtonClickable() {
        Assert.assertTrue(cartPage.isMinusButtonClickable());
    }

    @Test(priority = 26)
    public void T26_TestRemoveButtonDisplayed() {
        Assert.assertTrue(cartPage.isRemoveButtonDisplayed());
    }

    @Test(priority = 27)
    public void T27_TestRemoveButtonClickable() {
        Assert.assertTrue(cartPage.isRemoveButtonClickable());
    }

    @Test(priority = 28)
    public void T28_TestSaveButtonDisplayed() {
        Assert.assertTrue(cartPage.isSaveButtonDisplayed());
    }

    @Test(priority = 29)
    public void T29_TestSaveButtonClickable() {
        Assert.assertTrue(cartPage.isSaveButtonClickable());
    }

    @Test(priority = 30)
    public void T30_TestCheckoutButtonDisplayed() {
        Assert.assertTrue(cartPage.isCheckoutButtonDisplayed());
    }

    @Test(priority = 31)
    public void T31_TestCheckoutButtonClickable() {
        Assert.assertTrue(cartPage.isCheckoutButtonClickable());
    }

    @Test(priority = 32)
    public void T32_TestCartPriceDisplayed() {
        Assert.assertTrue(cartPage.isCartPriceDisplayed());
    }

    @Test(priority = 33)
    public void T33_TestPlusBookQuantity() {
        int expectedQty = 2;
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        cartPage.clickPlusButton();
        int actualQty = cartPage.getBookQuantity();
        Assert.assertEquals(actualQty, expectedQty);
    }

    @Test(priority = 34)
    public void T34_TestMinusBookQuantity() {
        int expectedQty = 1;
        cartPage.clickMinusButton();
        int actualQty = cartPage.getBookQuantity();
        Assert.assertEquals(actualQty, expectedQty);
    }

    @Test(priority = 35)
    public void T36_TestAddAnotherBook() {
        String bookName = "Funny Story";
        navBarPage.searchBook(bookName);

        searchResultsPage.clickSpecificBook(bookName);

        productPage.addToCart();
        Assert.assertTrue(productPage.isNotificationModalDisplayed());
        productPage.closeNotificationModal();

        navBarPage.clickCartButton();
        Assert.assertTrue(cartPage.isBookAddedToCart(bookName));
    }

    @Test(priority = 36)
    public void T35_TestRemoveButton() {
        String bookName = "Atomic Habits";
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        cartPage.clickRemoveButton();
        Assert.assertTrue(cartPage.isSuccessMessageDisplayed());
    }

    @Test(priority = 37)
    public void T37_TestSaveButton(){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(PRELOADER)));
        cartPage.clickSaveButton();
        Assert.assertTrue(cartPage.isEmptyCartMessageDisplayed());
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
