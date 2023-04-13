package constants;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestData {
    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    public static final Object[][] DATA = new Object[][]{
            {"chromedriver"},
            {"yandexdriver"}
    };
}
