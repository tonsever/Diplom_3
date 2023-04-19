import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage {
    By signInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");
    By mainTitle = By.xpath(".//h1[text() = 'Соберите бургер']");
    By personalAccount = By.xpath(".//p[text() = 'Личный Кабинет']");
    //By.xpath("//h2[text()='']//ancestor::div[@class='block-wrapper']")).scrollIntoView(false);
    By fillings = By.xpath(".//h2[text() = 'Начинки']");
    By headerСontainer = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccount).click();
    }

    public void isMainTitle () {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(mainTitle));
        Assert.assertEquals(driver.findElement(mainTitle).getText(), "Соберите бургер");
    }
    public void scrollingConstructor (String section) {
    WebElement element = driver.findElement(By.xpath(".//h2[text() = '" + section + "']"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void isSectionActive (String section) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(fillings));
        WebElement element = driver.findElement(headerСontainer);
        Assert.assertEquals(element.findElement(By.xpath(".//span[text() = '" + section + "']")).getText(), section);
    }


}
