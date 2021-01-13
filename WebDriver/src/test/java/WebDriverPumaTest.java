import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.Keys;
import java.util.List;
import org.openqa.selenium.opera.OperaOptions;

public class WebDriverPumaTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverInitiate(){
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--window-size=1600,900");
        driver = new ChromeDriver(option);
    }

    @Test
    public void addPBackpackToBasketTest() throws InterruptedException {

        driver.get("https://ru.puma.com");
        WebElement openCategoryForMan = driver.findElement(By.xpath
                ("//a[contains(@class,'full-bleed-hero__button full-bleed-hero__button_1 ')][1]"));
        openCategoryForMan.click();

        new WebDriverWait(driver, 50).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.xpath("//img[@alt='Изображение Puma Рюкзак Running backpack']")));

        WebElement pickBackpack = driver.findElement(By.xpath("//*[@id=\"catalog\"]/div[2]/div/div[1]/div/div[1]/a/img"));

        pickBackpack.click();

        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));

        addToCart.click();

        driver.get("https://ru.puma.com/checkout/cart/");

        List<WebElement> bagItems = driver.findElements(By.xpath("//div[@class=\"cart-table\"]"));

        Assert.assertTrue(bagItems.size()>0);
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
    }

}

