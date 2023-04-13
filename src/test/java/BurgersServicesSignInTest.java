import constants.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.restassured.response.ValidatableResponse;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import tools.UserMethods;
@RunWith(Parameterized.class)
public class BurgersServicesSignInTest {
    private WebDriver driver;
    private final String browser;
    public BurgersServicesSignInTest (String browser) {this.browser=browser;}

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.DATA;
    }

    @Before
    public void startUp() {
        UserMethods userMethods = new UserMethods();
        userMethods.create("Тон", "ton@mail.com", "123xxx");
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Все данные корректны")
    public void loginUsingSignInButtonPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Все данные корректны")
    public void loginUsingPersonalAccountButtonPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Все данные корректны")
    public void loginFromRegistrationPagePositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickSignInButton();
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Все данные корректны")
    public void loginFromForgotPasswordPagePositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRecoverPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickSignInButton();
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
    }

    @After
    public void teardown() {
        driver.quit();
        UserMethods userMethods = new UserMethods();
        userMethods.delete(userMethods.login("ton@mail.com", "123xxx"));
    }
}
