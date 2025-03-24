package com.example.model;



import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_id;
    private int user_id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date order_date;
    private double total_amount;
    private String status;

    // Getters and Setters
    public int getOrderId() { return order_id; }
    public void setOrderId(int order_id) { this.order_id = order_id; }
    public int getUserId() { return user_id; }
    public void setUserId(int user_id) { this.user_id = user_id; }
    public Date getOrderDate() { return order_date; }
    public void setOrderDate(Date order_date) { this.order_date = order_date; }
    public double getTotalAmount() { return total_amount; }
    public void setTotalAmount(double total_amount) { this.total_amount = total_amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}