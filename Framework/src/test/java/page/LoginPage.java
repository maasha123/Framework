package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageWithStaticUrl{

    @FindBy(xpath = "//*[@id='email']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id='pass']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='send2']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//li[contains(@class,'top-nav__item')][2]")
    private WebElement accountPageButton;

    @FindBy(xpath = "//*[@id='registerEmailAddress']")
    private WebElement emailRegistrationInput;

    @FindBy(xpath = "//*[@id='registerForm']/div[8]/div/button")
    private WebElement createAccountButton;
    
    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordRegistrationInput;

    @FindBy(xpath = "//*[@id='registerEmailAddress-error']")
    private WebElement getEmailErrorSpan;

    @FindBy(xpath = "//*[@id='firstname-error']")
    private WebElement getPasswordErrorSpan;
    
    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public LoginPage openPage()
    {
        driver.navigate().to("https://ru.puma.com/customer/account/login/");
        return this;
    }

    public LoginPage inputUserLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage inputUserPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton(){
        buttonSubmit.click();
        return this;
    }
    
    public LoginPage inputEmailRegistration(){
        emailRegistrationInput.sendKeys("hello");
        return this;
    }

    public LoginPage inputPasswordRegistration(){
        passwordRegistrationInput.sendKeys("hello");
        return this;
    }

    public LoginPage createAccount(){
        createAccountButton.click();
        return this;
    }

    public String getErrorEmailSpan(){
        return getEmailErrorSpan.getText();
    }

    public String getErrorPasswordSpan(){
        return getPasswordErrorSpan.getText();
    }

    public AccountPage clickGoToAccountPageButton(){
        return new AccountPage(driver);
    }

}
