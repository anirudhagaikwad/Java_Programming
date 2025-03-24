package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    private String title;
    private int author_id;
    private int category_id;
    private double price;
    private int stock;
    private String isbn;
    
	public int getBookId() {
		return book_id;
	}
	public void setBookId(int book_id) {
		this.book_id = book_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorId() {
		return author_id;
	}
	public void setAuthorId(int author_id) {
		this.author_id = author_id;
	}
	public int getCategoryId() {
		return category_id;
	}
	public void setCategoryId(int category_id) {
		this.category_id = category_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

  
}