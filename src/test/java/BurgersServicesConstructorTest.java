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
    private final String driverBin;
    public BurgersServicesConstructorTest (String driverBin) {this.driverBin=driverBin;}

    @Parameterized.Parameters
    public static Object[][] getParams() {
        return TestData.DATA;
    }
    @Before
    public void startUp() {
        System.setProperty(TestData.KEY_DRIVER,TestData.VALUE_PATH + driverBin);
        driver = new ChromeDriver();
        driver.get(TestData.URL);
    }

    @Test
    @DisplayName("Переход в раздел Булки")
    @Description("Проверяем что раздел подсветился")
    public void scrollToBunsPositiveResult() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollingConstructor("Булки");
        homePage.isSectionActive("Булки");
    }

    @Test
    @DisplayName("Переход в раздел Соусы")
    @Description("Проверяем что раздел подсветился")
    public void scrollToSaucesPositiveResult() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollingConstructor("Соусы");
        homePage.isSectionActive("Соусы");
    }

    @Test
    @DisplayName("Переход в раздел Начинки")
    @Description("Проверяем что раздел подсветился")
    public void scrollToFillingsPositiveResult() {
        HomePage homePage = new HomePage(driver);
        homePage.scrollingConstructor("Начинки");
        homePage.isSectionActive("Начинки");
    }

    @After
    public void teardown() {
        driver.quit();
    }




}
