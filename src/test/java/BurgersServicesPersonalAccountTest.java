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
    private final String driverBin;
    public BurgersServicesPersonalAccountTest (String driverBin) {this.driverBin=driverBin;}

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.DATA;
    }

    @Before
    public void startUp() {
        UserMethods userMethods = new UserMethods();
        userMethods.create("Тон", "ton@mail.com", "123xxx");
        System.setProperty(TestData.KEY_DRIVER,TestData.VALUE_PATH + driverBin);
        driver = new ChromeDriver();
        driver.get(TestData.URL);
    }

    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    @Description("Проверяем текст в личном кабинете")
    public void goToPersonalAccountPositiveResult() {
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
