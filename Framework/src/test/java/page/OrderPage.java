package page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.config.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//div[@class='cart-table']")
    private List<WebElement> bagItems; 

    @FindBy(xpath = "//*[@class='dropdown-trigger__value']")
    private WebElement countOfSameProduct; 
   
    @FindBy(xpath = "//*[@class='cart-item-action']")
    private WebElement removeItemButton; 

    @FindBy(xpath = "//*[@id='cartContent']/aside/div/ul/li/button")
    private WebElement orderButton; 

    @FindBy(xpath = "//*[@data-bind='textInput: word, hasFocus: isFocused']")
    private WebElement localityInput; 

    @FindBy(xpath = "//*[@class='suggest__result-item']")
    private WebElement localitySelect; 

    @FindBy(xpath = "//*[@id='label_method_default_russianpost']")
    private WebElement typeOfOrder; 
    
    @FindBy(xpath = "//div[@class='payment-method-title field choice']/label[@class='label'][1]")
    private WebElement typeOfPayment; 

    @FindBy(xpath = "//*[@id='checkout-payment-method-load']/div/div/div[5]/div[2]/div[3]/div/button")
    private WebElement checkoutButton; 

    @FindBy(xpath = "//*[@id='billing-new-address-form']/div[1]/div/div")
    private WebElement checkoutErrorSpan; 

    @FindBy(xpath = "//*[@id='block-discount']/div/div[1]")
    private WebElement promocodeField; 

    @FindBy(xpath = "//*[@id='discount-code']")
    private WebElement discountField; 

    @FindBy(xpath = "//*[@id='discount-form']/div[2]/button")
    private WebElement applyButton; 

    @FindBy(xpath = "//*[@id='maincontent']/div[2]/div[2]/div/div/div")
    private WebElement errorPromocodeMessage; 

    @FindBy(xpath = "//span[@class='dropdown-trigger__value']")
    private WebElement selectCountOfItems; 
    
    @FindBy(xpath = "//span[@class='price']/span[@class='price'][1]")
    private WebElement firstPrice; 

    @FindBy(xpath = "//*[@id='shopping-cart-table']/div[2]/div[2]/div[2]/div[2]/span/span/div/span/span/span/span")
    private WebElement secondPrice; 

    @FindBy(xpath = "//li[@class='dropdown-menu-item']/div[@class='dropdown-menu-item__value'][1]")
    private WebElement selectCount;

    @FindBy(xpath = "//*[@id='cart-totals']/div/table/tbody/tr[2]/td/strong/span")
    private WebElement finalPrice;

    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public OrderPage openPage() {
        driver.get("https://ru.puma.com/checkout/cart/");
        return this;
    }

    public int countOfItemsInTheCart() {
        return bagItems.size();
    }

    public int countOfSameProducts(){
        return Integer.parseInt(countOfSameProduct.getText());
    }

    public OrderPage removeItemFromCart(){
        removeItemButton.click();
        return this;
    }

    public OrderPage checkout(){
        orderButton.click();
        return this;
    }

    public OrderPage selectLocality(String locality){
        localityInput.sendKeys(locality);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        localitySelect.click();
        return this;
    }

    public OrderPage selectTypeOfOrder(){
        typeOfOrder.click();
        return this;
    }

    public OrderPage selectTypeOfPayment(){
        typeOfPayment.click();
        return this;
    }

    public OrderPage checkoutButton(){
        checkoutButton.click();
        return this;
    }

    public String getChekoutErrorSpan(){
        return checkoutErrorSpan.getText();
    }

    public OrderPage enterPromocode(){
        promocodeField.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        discountField.sendKeys("hello");
        applyButton.click();
        return this;
    }

    public OrderPage checkPrice(){
        waitUntilElementIsClickable(promocodeField).click();
        promocodeField.click();
        waitUntilElementIsClickable(discountField).click();
        discountField.sendKeys("Hello");
        return this;
    }
    public String getPromocodeErrorSpan(){
        return errorPromocodeMessage.getText();
    }

    public OrderPage selectCountOfItems(){
        selectCountOfItems.click();
        waitUntilElementIsClickable(selectCount).click();
        selectCount.click();
        return this;
    }
    public int getOrderPriceValue() {
        return (getPriceByWebElement(firstPrice) + getPriceByWebElement(secondPrice));
    }

    public int getSumAllProductPrice(){
        return Integer.parseInt(finalPrice.getText().replaceAll("[^0-9]", ""));
    }
    public int getPriceByWebElement(WebElement webElement){
        return Integer.parseInt(webElement.getText().split(",")[0].replaceAll("\\s+",""));
    }

}
