package test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;
import model.Filter;
import model.Product;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.OrderPage;
import page.ProductPage;
import service.FilterCreator;
import service.ProductCreator;
import service.TestDataReader;

import java.util.List;

public class ProductTest extends CommonConditions{

    @Test 
    public void checkCorrectTitleOfPage(){
        logger.info("checkCorrectTitleOfPage");
        CatalogPage catalogPage = new CatalogPage(driver)
                    .openPage((TestDataReader.getTestData("test.data.catalog")))
                    .selectNewCategoryOfItem();
        assertEquals(catalogPage.checkTitleOfNewCategory(),"МУЖСКИЕ КЕПКИ И ШАПКИ");
    }

    @Test
    public void checkCorrectFilterByCategory() {
        logger.info("checkCorrectFilterByCategory");
        Filter filter= FilterCreator.withPrice();
        CatalogPage catalogPage = new CatalogPage(driver)
                    .openPage(TestDataReader.getTestData("test.data.catalog"))
                    .clickToChooseFilterPrice(filter.getPrice());
        assertTrue(catalogPage.checkItemsCatalogPage());
    }
}
