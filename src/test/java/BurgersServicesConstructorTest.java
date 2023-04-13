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
public class BurgersServicesConstructorTest {
    private WebDriver driver;
    private final String browser;
    public BurgersServicesConstructorTest (String browser) {this.browser=browser;}

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.DATA;
    }

    @Test
    @DisplayName("Переход в раздел Булки")
    @Description("Проверяем что раздел подсветился")
    public void scrollToBunsPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.scrollingConstructor("Булки");
        homePage.isSectionActive("Булки");
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    @Description("Проверяем что раздел подсветился")
    public void scrollToSaucesPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.scrollingConstructor("Соусы");
        homePage.isSectionActive("Соусы");
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    @Description("Проверяем что раздел подсветился")
    public void scrollToFillingsPositiveResult() {
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\"+browser+".exe");
        driver = new ChromeDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.scrollingConstructor("Начинки");
        homePage.isSectionActive("Начинки");
    }

    @After
    public void teardown() {
        driver.quit();
    }




}
