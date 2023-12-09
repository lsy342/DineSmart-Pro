package RestaurantManagementSystem.model;

import java.util.Date;
public class Review {
    private String reviewNo;
    private String orderNo;
    private String reviewContent;
    private Date orderDate;

    public Review() {
    }

    public Review(String reviewNo, String orderNo, String reviewContent, Date orderDate) {
        this.reviewNo = reviewNo;
        this.orderNo = orderNo;
        this.reviewContent = reviewContent;
        this.orderDate = orderDate;
    }
    public String getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(String reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
