package obj;

import stdc.IdName;

public class Goods extends IdName {
    public final static String TABLE_NAME = "goods";

    public static class ColumnName {
        public final static String CODE = "code";
        public final static String PRICE = "price";
        public final static String STOCK = "stock";
        public final static String LOCATION_CODE = "locationCode";
    }

    private String code = "";
    private double price = 0;
    private double stock = 0;
    private String locationCode = "";

    public Goods() {

    }
    public Goods(String id) {
        setId(id);
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getStock() {
        return stock;
    }
    public void setStock(double stock) {
        this.stock = stock;
    }

    public String getLocationCode() {
        return locationCode;
    }
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }
}
