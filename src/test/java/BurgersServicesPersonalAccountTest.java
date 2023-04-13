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
public class BurgersServicesPersonalAccountTest {
    private WebDriver driver;
    private final String browser;
    public BurgersServicesPersonalAccountTest (String browser) {this.browser=browser;}

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
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    @Description("Проверяем текст в личном кабинете")
    public void goToPersonalAccountPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkAccountText();
    }

    @Test
    @DisplayName("Проверь переход по клику на «Конструктор»")
    @Description("Проверяем заголовок «Соберите бургер»")
    public void fromPersonalAccountToConstructorClickConstructorButtonPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkAccountText();
        personalAccountPage.clickConstructorButton();
        homePage.isMainTitle();
    }

    @Test
    @DisplayName("Проверь переход по клику на логотип Stellar Burgers")
    @Description("Проверяем заголовок «Соберите бургер»")
    public void fromPersonalAccountToConstructorClickLogoPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkAccountText();
        personalAccountPage.clickLogo();
        homePage.isMainTitle();
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете")
    @Description("Проверяем наличие кнопки «Войти»")
    public void logOutPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickPersonalAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillAccountData("ton@mail.com", "123xxx");
        loginPage.clickSignInButton();
        homePage.isMainTitle();
        homePage.clickPersonalAccountButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.checkAccountText();
        personalAccountPage.clickLogOutButton();
        loginPage.checkSignInButton();
    }

    @After
    public void teardown() {
        driver.quit();
        UserMethods userMethods = new UserMethods();
        userMethods.delete(userMethods.login("ton@mail.com", "123xxx"));
    }
}
