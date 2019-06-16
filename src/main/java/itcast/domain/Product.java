package itcast.domain;

public class Product {
    private String pid;
    private String productName;
    private Float productPrice;
    private Integer storeNum;
    private String factory;
    private String shopID;

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", storeNum=" + storeNum +
                ", factory='" + factory + '\'' +
                ", shopID='" + shopID + '\'' +
                '}';
    }

    public Product(String pid, String productName, Float productPrice, Integer storeNum, String factory, String shopID) {
        this.pid = pid;
        this.productName = productName;
        this.productPrice = productPrice;
        this.storeNum = storeNum;
        this.factory = factory;
        this.shopID = shopID;
    }

    public Product() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(Integer storeNum) {
        this.storeNum = storeNum;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }
}
