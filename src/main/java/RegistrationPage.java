import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegistrationPage {
    By emailInput = By.xpath(".//input[@name='name']"); // Поля name
    By passwordInput = By.xpath(".//input[@name='Пароль']"); // Поле password
    By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    By incorrectPasswordMessage = By.xpath(".//p[text() = 'Некорректный пароль']");
    By signInButton = By.linkText("Войти");
    private final WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUserData(String name, String email, String password) {
        List<WebElement> inputsName = driver.findElements(emailInput);
        inputsName.get(0).sendKeys(name);
        inputsName.get(1).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(registrationButton).click();
    }

    public void checkIncorrectPasswordMessage () {
        Assert.assertEquals(driver.findElement(incorrectPasswordMessage).getText(), "Некорректный пароль");
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }


}
