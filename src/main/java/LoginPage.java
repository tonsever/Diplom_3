import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginPage {
    By emailInput = By.xpath(".//input[@name='name']"); // Поле email
    By passwordInput = By.xpath(".//input[@name='Пароль']"); // Поле password
    By registrationButton = By.linkText("Зарегистрироваться"); // Зарегистрироваться
    By signInButton = By.xpath(".//button[text() = 'Войти']");
    By recoverPasswordButton = By.linkText("Восстановить пароль");
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void fillAccountData(String email, String password) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickRecoverPasswordButton() {
        driver.findElement(recoverPasswordButton).click();
    }

    public void checkSignInButton () {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        Assert.assertEquals(driver.findElement(signInButton)
                .getText(), "Войти");
    }


}
