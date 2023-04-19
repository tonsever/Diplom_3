package constants;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestData {
    public static final String URL = "https://stellarburgers.nomoreparties.site/";
    public static final String KEY_DRIVER = "webdriver.chrome.driver";
    public static final String VALUE_PATH = "C:\\WebDriver\\bin\\";

    public static final Object[][] DATA = new Object[][]{
            {"chromedriver.exe"},
            {"yandexdriver.exe"}
    };
}
