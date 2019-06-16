package itcast.domain;

public class OrderItem {
    private String oid;
    private String pid;
    private Integer num;
    private Float price;

    private Product product;

    @Override
    public String toString() {
        return "OrderItem{" +
                "oid='" + oid + '\'' +
                ", pid='" + pid + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", product=" + product +
                '}';
    }

    public OrderItem(String oid, String pid, Integer num, Float price, Product product) {
        this.oid = oid;
        this.pid = pid;
        this.num = num;
        this.price = price;
        this.product = product;
    }

    public OrderItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
