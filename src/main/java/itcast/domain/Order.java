package itcast.domain;

import java.util.Date;
import java.util.List;

public class Order {
    private String oid;
    private String shopID;
    private String orderStatus;
    private Date orderTime;

    private Date startTime;
    private Date endTime;

    private List<OrderItem> orderItemList;

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", shopID='" + shopID + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }

    public Order(String oid, String shopID, String orderStatus, Date orderTime, List<OrderItem> orderItemList) {
        this.oid = oid;
        this.shopID = shopID;
        this.orderStatus = orderStatus;
        this.orderTime = orderTime;
        this.orderItemList = orderItemList;
    }

    public Order() {
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
