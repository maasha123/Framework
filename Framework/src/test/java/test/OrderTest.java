package test;

import static org.assertj.core.api.Assertions.*;
import model.Product;
import model.User;
import org.testng.annotations.Test;
import page.OrderPage;
import page.ProductPage;
import service.ProductCreator;
import service.TestDataReader;
import service.UserCreator;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.*;
public class OrderTest extends CommonConditions {

    @Test
    public void checkPriceWithDifferentQuantitiesOfGoods() {
        logger.info("checkPriceWithDifferentQuantitiesOfGoods");
        Product productFirst = ProductCreator.withEmptyProductSize("first");
        Product productSecond = ProductCreator.withEmptyProductSize("second");

        OrderPage orderPage = new ProductPage(driver)
                .openPage(productFirst.getProductUrl())
                .addProductToOrder()
                .openPage(productSecond.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage();

        assertThat(orderPage.getSumAllProductPrice()).isEqualTo(orderPage.getOrderPriceValue());
        
    }


    @Test
    public void checkSaleWithIncorrectPromocode() {
        logger.info("checkSaleWithIncorrectPromocode");
        Product product= ProductCreator.withEmptyProductSize("first");
        OrderPage productPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .enterPromocode();  
        
        assertThat(productPage.getPromocodeErrorSpan()).isEqualTo("Условия купона \"hello\" не выполнены");
    }

    @Test
    public void attemptOrderWithEmptyData() {
        logger.info("attemptOrderWithEmptyData");
        Product product= ProductCreator.withEmptyProductSize("first");
        OrderPage productPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage()
                .checkout()
                .selectLocality("\u041c\u0438\u043d\u0441\u043a\u043e\u0435")
                .selectTypeOfOrder()
                .selectTypeOfPayment()
                .checkoutButton();
        assertThat(productPage.getChekoutErrorSpan()).isEqualTo("Пожалуйста, заполните поле");
    }

    @Test
    public void checkOrderWithNoCorrectQuantity() {
        logger.info("checkOrderWithNoCorrectQuantity");
        Product product= ProductCreator.withEmptyProductSize("first");
        OrderPage productPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .selectCountOfProduct()
                .addProductToOrder()
                .selectCountOfProduct()
                .addProductToOrder()
                .goToOrderPage()
                .openPage();
        int CountOfSomeProduct = 9;
        assertThat(productPage.countOfSameProducts(),not(equalTo(CountOfSomeProduct)));
    }

    @Test
    public void checkCorrectRemovalOfGoods(){
        logger.info("checkCorrectRemovalOfGoods");
        Product product = ProductCreator.withEmptyProductSize("first");
        OrderPage productPage = new ProductPage(driver)
                .openPage(product.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage();
        int countOfItemsInTheCart = productPage.countOfItemsInTheCart();
        productPage.removeItemFromCart();
        assertThat(productPage.countOfItemsInTheCart(),not(equalTo(countOfItemsInTheCart)));
    }   

    @Test
    public void checkBasketForProduct() {
        logger.info("checkBasketForProduct");
        Product productFirst = ProductCreator.withEmptyProductSize("first");

        OrderPage orderPage = new ProductPage(driver)
                .openPage(productFirst.getProductUrl())
                .addProductToOrder()
                .goToOrderPage()
                .openPage();
        assertThat(orderPage.countOfItemsInTheCart() > 0).isTrue();
    }
}
