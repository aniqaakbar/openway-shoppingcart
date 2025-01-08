package Test;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

import static Pages.LoginPage.EMAIL;
import static Pages.LoginPage.PASSWORD;
import static Pages.NavBarPage.bookName;

public class ShoppingCartTest {
    WebDriver driver;
    NavBarPage navBarPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    CartPage cartPage;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeTest
    public void setup(){
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
    public void T01_TestSignInPageButtonVisible(){
        Assert.assertTrue(navBarPage.isSignInPageButtonVisible());
    }

    @Test(priority = 2)
    public void T02_TestSignInPageButtonClickable(){
        Assert.assertTrue(navBarPage.isSignInPageButtonClickable());
    }

    @Test(priority = 3)
    public void T03_TestLoginPageDisplayed(){
        navBarPage.openSignInPage();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test(priority = 4)
    public void T04_TestEmailFieldDisplayed(){
        Assert.assertTrue(loginPage.isEmailFieldDisplayed());
    }

    @Test(priority = 5)
    public void T05_TestPasswordFieldDisplayed(){
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
    }

    @Test(priority = 6)
    public void T06_TestLoginButtonDisplayed(){
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test(priority = 7)
    public void T07_TestLoginButtonClickable(){
        Assert.assertTrue(loginPage.isLoginButtonClickable());
    }

    @Test(priority = 8)
    public void T08_TestSignIn(){
        loginPage.signIn(EMAIL, PASSWORD);
        Assert.assertTrue(loginPage.isAccountPageDisplayed());
    }

    @Test(priority = 9)
    public void T09_TestSearchBarDisplayed(){
        Assert.assertTrue(navBarPage.isSearchBarVisible());
    }

    @Test(priority = 10)
    public void T10_TestSearchButtonDisplayed(){
        Assert.assertTrue(navBarPage.isSearchButtonDisplayed());
    }

    @Test(priority = 11)
    public void T11_TestSearchButtonClickable(){
        Assert.assertTrue(navBarPage.isSearchButtonClickable());
    }

    @Test(priority = 12)
    public void T12_TestSearchBook() {
        navBarPage.searchBook(bookName);
        String partialURL = "filter_name=Atomic+Habits";

        Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed(partialURL),
                "The search results page URL does not contain the expected query.");
    }

    @Test(priority = 13)
    public void T13_TestClickBook(){
        searchResultsPage.clickSpecificBook();
        String partialURL = "9781847941831";
        Assert.assertTrue(productPage.isBookPageDisplayed(partialURL),
                "The search results page URL does not contain the expected query.");
    }


    @Test(priority = 14)
    public void T14_TestPlusQuantityButtonDisplayed(){
        Assert.assertTrue(productPage.isPlusButtonDisplayed());
    }

    @Test(priority = 15)
    public void T15_TestPlusQuantityButtonClickable(){
        Assert.assertTrue(productPage.isPlusButtonClickable());
    }

    @Test(priority = 16)
    public void T16_TestMinusQuantityButtonDisplayed(){
        Assert.assertTrue(productPage.isMinusButtonDisplayed());
    }

    @Test(priority = 17)
    public void T17_TestMinusQuantityButtonClickable(){
        Assert.assertTrue(productPage.isMinusButtonClickable());
    }

    @Test(priority = 18)
    public void T18_TestQuantityDisplayed(){
        Assert.assertTrue(productPage.isQuantityDisplayed());
    }

    @Test(priority = 19)
    public void T19_TestAddToCartButtonDisplayed(){
        Assert.assertTrue(productPage.isAddToCartButtonDisplayed());
    }

    @Test(priority = 20)
    public void T20_TestAddToCartButtonClickable(){
        Assert.assertTrue(productPage.isAddToCartButtonClickable());
    }

    @Test(priority = 21)
    public void T21_TestAddToCart(){
        productPage.addToCart();
        Assert.assertTrue(productPage.isNotificationModalDisplayed());
        productPage.closeNotificationModal();
    }

    @Test(priority = 22)
    public void T22_TestGoToCartPage(){
        navBarPage.clickCartButton();
        String partialURL = "cart";
        Assert.assertTrue(cartPage.isCartPageDisplayed(partialURL),
                "The search results page URL does not contain the expected query.");
    }







    @AfterTest
    public void closeDriver(){
        driver.quit();
    }

}
