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
public class BurgersServicesRegistrationTest {
    private WebDriver driver;
    private final String browser;
    public BurgersServicesRegistrationTest (String browser) {this.browser=browser;}

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.DATA;
    }

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Все данные корректны")
    public void registrationPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillUserData("Тон", "ton@mail.com", "123xxx");
        registrationPage.clickRegistrationButton();
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
        UserMethods userMethods = new UserMethods();
        userMethods.delete(userMethods.login("ton@mail.com", "123xxx"));
    }

    @Test
    @DisplayName("Ошибку для некорректного пароля")
    @Description("Пароль 5 символов")
    public void registrationIncorrectPasswordError() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillUserData("Тон", "ton@mail.com", "123xx");
        registrationPage.checkIncorrectPasswordMessage();
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
