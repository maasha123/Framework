package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumOrderPage extends AbstractPage {

    public SeleniumOrderPage(WebDriver driver) {
        super(driver);
    }

    public SeleniumOrderPage openPage() {
        driver.get("https://ru.puma.com/checkout/cart/");
        return this;
    }
    public int checkBasketForProduct() {
        List<WebElement> bagItems = driver.findElements(By.xpath("//div[@class=\"cart-table\"]"));
        return bagItems.size();
    }

    public SeleniumOrderPage clickCheckoutButton() {
        WebElement checkoutButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                   .until(ExpectedConditions.presenceOfElementLocated(By
                   .xpath("//*[@data-role='proceed-to-checkout']")));
        checkoutButton.click();
        return this;
    }

    public SeleniumOrderPage inputLocality(String locality) {
        WebElement localityInput = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                   .until(ExpectedConditions.presenceOfElementLocated(By
                   .xpath("//*[@data-bind='textInput: word, hasFocus: isFocused']")));
        localityInput.sendKeys(locality);
        return this;
    }

    public SeleniumOrderPage selectLocality() {
        WebElement localityButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                   .until(ExpectedConditions.presenceOfElementLocated(By
                   .xpath("//*[@data-bind='data-value: sample_id, click: $parent.selectZip.bind($parent)']")));
        localityButton.click();
        return this;
    }

    public SeleniumOrderPage selectMail() {
        WebElement mailButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                   .until(ExpectedConditions.presenceOfElementLocated(By
                   .xpath("//*[@class='col col-method shipping-method__radio-wrapper'][1]")));
        mailButton.click();
        return this;
    }

    public SeleniumOrderPage selectTypeOfPayment() {
        WebElement paymentButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                   .until(ExpectedConditions.presenceOfElementLocated(By
                   .xpath("//*[@for='cloudpayments_mc']")));
        paymentButton.click();
        return this;
    }

    public SeleniumOrderPage refreshPage()
    {
        driver.navigate().refresh();
        return this;
    }

    public SeleniumOrderPage checkoutButton() {
        WebElement checkoutButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                   .until(ExpectedConditions.elementToBeClickable(By
                   .xpath("//*[@id='checkout-payment-method-load']/div/div/div[4]/div[2]/div[3]/div[2]/button")));
        checkoutButton.click();
        return this;
    }

    public String getPaymentErrorSpan() {
        WebElement paymentErrorSpan = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                   .until(ExpectedConditions.presenceOfElementLocated(By
                   .xpath("//*[@id='cloudpayments_mc_cryptogram_form']/div")));
        return paymentErrorSpan.getText();
    }

}
