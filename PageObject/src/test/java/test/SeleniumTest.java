package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SeleniumOrderPage;
import page.SeleniumProductPage;

public class SeleniumTest {

    private WebDriver driver;
    private final String locality="Минское";

    @BeforeTest
    public void browserStart() {
        driver = new ChromeDriver();
    }

    @Test
    public void addItemToTheCart() {
        SeleniumOrderPage orderPage = new SeleniumProductPage(driver)
            .openPage()
            .addProductToOrder()
            .goToOrderPage()
            .openPage();
        Assert.assertTrue(orderPage.checkBasketForProduct()>0);
    }

    @Test
    public void checkValidationNumberOfPayCard() {
        SeleniumOrderPage orderPage = new SeleniumProductPage(driver)
            .openPage()
            .addProductToOrder()
            .goToOrderPage()
            .openPage()
            .clickCheckoutButton()
            .inputLocality(locality)
            .selectLocality()
            .selectMail()
            .selectTypeOfPayment()
            .checkoutButton();
            Assert.assertEquals(orderPage.getPaymentErrorSpan(), "Пожалуйста, введите корректное число в это поле");
    }
    
    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.manage().deleteAllCookies();
    }

    @AfterTest
    public void quiteBrowserAfterTest() {
        driver.quit();
    }
}
