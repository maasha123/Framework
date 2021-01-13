package page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends AbstractPageWithParameterizedUrl {

    @FindBy(xpath = "//*[@class='form__input filter-price__input js-filter-price-input validate-mask'][1]")
    public WebElement filterPriceInput;

    @FindBy(xpath = "//*[@id='product-price-280534']")
    public WebElement productPrice;

    @FindBy(xpath = "//*[@class='filter-size__box']")
    public WebElement productType;

    @FindBy(xpath = "//*[@id='categorySidebar']/ul/li/ul/li[3]/ul/li[1]/a")
    public WebElement listItem;

    @FindBy(xpath = "//*[@id='maincontent']/div[2]/h1")
    public WebElement titleOfCategory;


    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public CatalogPage openPage(String partUrl) {
        driver.get("https://ru.puma.com/"+partUrl);
        return this;
    }

    public CatalogPage clickToChooseFilterPrice(String price) {
        filterPriceInput.sendKeys("10");
        productType.click();
        return this;
    }

    public boolean checkItemsCatalogPage(){
        if(Integer.parseInt(productPrice.getAttribute("data-price-amount")) > 6800){
            return true;
        }
        
        else return false;
    }

    public CatalogPage selectNewCategoryOfItem(){
        listItem.click();
        return this;
    }
    
    public String checkTitleOfNewCategory(){
        return titleOfCategory.getText();
    }
}
