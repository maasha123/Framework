package service;


import model.Product;

public class ProductCreator {
    public static final String PRODUCT_URL="test.data.product.%s.url";

    public static Product withEmptyProductSize(String productNumber){
        String productUrl=String.format(PRODUCT_URL,productNumber);
        return new Product(TestDataReader.getTestData(productUrl));
    }

}
