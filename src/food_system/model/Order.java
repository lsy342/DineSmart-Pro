package food_system.model;

import java.util.Date;

public class Order {
    private String orderNo;
    private String orderContent;
    private double orderPrice;
    private Date orderDate;

    public Order() {
    }

    public Order(String orderNo, String orderContent, double orderPrice, Date orderDate) {
        this.orderNo = orderNo;
        this.orderContent = orderContent;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
