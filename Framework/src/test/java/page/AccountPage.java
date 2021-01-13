package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends AbstractPageWithStaticUrl {

    @FindBy(xpath = "//*[@id='email']")
    private WebElement userEmail;

    @FindBy(xpath = "//*[@id='lastnameInfo']")
    private WebElement userLastNameField;
    
    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public AccountPage openPage() {
        driver.get("https://ru.puma.com/customer/account/");
        return this;
    }

    public String getUserEmail(){
        return userEmail.getAttribute("value");
    }

    public String getUserLastName(){
        return userLastNameField.getAttribute("value");
    }
}
