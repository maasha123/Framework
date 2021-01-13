package model;

public class Filter {
    private String price;

    public static class Builder{
        private Filter filter;

        public Builder(){
            filter=new Filter();
        }
        
        public Builder withPrice(String price){
            filter.price=price;
            return this;
        }

        public Filter build(){
            return filter;
        }
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
