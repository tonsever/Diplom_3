import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PersonalAccountPage {
    By accountText = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");
    By constructorButton = By.xpath(".//p[text() = 'Конструктор']");
    By logo = By.xpath(".//div[contains(@class,'logo')]");
    By logOutButton = By.xpath(".//button[text() = 'Выход']");
    private final WebDriver driver;
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public void checkAccountText () {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(accountText));
        Assert.assertEquals(driver.findElement(accountText)
                .getText(), "В этом разделе вы можете изменить свои персональные данные");
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    public void clickLogo() {
        driver.findElement(logo).click();
    }
    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }
}
