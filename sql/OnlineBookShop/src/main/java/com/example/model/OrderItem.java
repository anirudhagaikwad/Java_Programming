package com.example.model;



import jakarta.persistence.*;

@Entity
@Table(name = "Order_Items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_item_id;
    private int order_id;
    private int book_id;
    private int quantity;
    private double unit_price;

    // Getters and Setters
    public int getOrderItemId() { return order_item_id; }
    public void setOrderItemId(int order_item_id) { this.order_item_id = order_item_id; }
    public int getOrderId() { return order_id; }
    public void setOrderId(int order_id) { this.order_id = order_id; }
    public int getBookId() { return book_id; }
    public void setBookId(int book_id) { this.book_id = book_id; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getUnitPrice() { return unit_price; }
    public void setUnitPrice(double unit_price) { this.unit_price = unit_price; }
}
