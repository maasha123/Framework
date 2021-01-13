package service;

import model.Filter;

public class FilterCreator {
    
    public static final String PRICE="test.data.filter.price";
                                                                                                                                                                                                                    
    public static Filter withPrice(){
        return new Filter.Builder()
                .withPrice(TestDataReader.getTestData(PRICE))
                .build();
    }

}
