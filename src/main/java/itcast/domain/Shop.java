package itcast.domain;

import java.util.List;

public class Shop {
    private String shopID;
    private String shopName;

    private List<Product> productList;

    @Override
    public String toString() {
        return "Shop{" +
                "shopID='" + shopID + '\'' +
                ", shopName='" + shopName + '\'' +
                ", productList=" + productList +
                '}';
    }

    public Shop(String shopID, String shopName, List<Product> productList) {
        this.shopID = shopID;
        this.shopName = shopName;
        this.productList = productList;
    }

    public Shop() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
