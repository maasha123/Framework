package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumProductPage extends AbstractPage {

    public SeleniumProductPage(WebDriver driver)
    {
        super(driver);
    }

    public SeleniumProductPage openPage()
    {
        driver.get("https://ru.puma.com/archive-heather-beanie-021739-01.html?size=adult");
        return this;
    }

    public SeleniumProductPage addProductToOrder()
    {
        WebElement addProductToOrderButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@id='product-addtocart-button']")));
        addProductToOrderButton.click();
        return this;
    }

    public SeleniumOrderPage goToOrderPage(){
        WebElement goToOrderPage = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//*[@id='minicartSubtotal']/div[5]/a")));
        goToOrderPage.click();
        return new SeleniumOrderPage(driver);
    }
}
