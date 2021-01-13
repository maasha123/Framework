package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//*[@id='product-addtocart-button']")
    private WebElement addProductToOrderButton;

    @FindBy(xpath = "//*[@class='dropdown dropdown-qty']/*/span[@class='dropdown-trigger__value']")
    private WebElement selectCountOfProduct;

    @FindBy(xpath = "//li[@class='dropdown-menu-item'][4]")
    private WebElement numberOfCountProducts;

    @FindBy(xpath = "//div[@class='fastorder-popup']//button[contains(@class,'buy')]")
    private WebElement toMakeOrderButton;

    @FindBy(xpath = "//div[@class='fastorder-popup']//div[@class='form__row form-input']//span[contains(@class,'form-error')]")
    private WebElement errorInInputEmail;

    @FindBy(xpath = "//a[@class='product__controls-link js-add-favorite']")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//*[@id='minicartSubtotal']/div[5]/a")
    private WebElement goToOrderPageButton;

    @FindBy(xpath = "//li[@class='top-nav__item']//a[@class='main-nav__head-link js-nav-item-link mod-user-link']")
    private WebElement goToFavoritePageButton;

    @FindBy(xpath = "//ul[@class='product-colors__list']")
    private WebElement similarProductList;

    @FindBy(xpath = "//span[@class='js-article']")
    private WebElement articleSpan;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public ProductPage openPage(String urlPart) {
        driver.get("https://ru.puma.com/" + urlPart);
        return this;
    }

    public ProductPage addProductToOrder() {
        addProductToOrderButton.click();
        return this;
    }

    public OrderPage goToOrderPage(){
        return new OrderPage(driver);
    }
    public ProductPage selectCountOfProduct(){
        selectCountOfProduct.click();        
        numberOfCountProducts.click();
        return this;
    }

}
