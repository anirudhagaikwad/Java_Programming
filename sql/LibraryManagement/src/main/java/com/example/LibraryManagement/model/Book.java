package com.example.LibraryManagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(min = 2, max = 100, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "ISBN is required")
    @Pattern(
        regexp = "^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|[0-9X]{10}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
        message = "Invalid ISBN format"
    )
    @Column(unique = true)
    private String isbn;

    @NotBlank(message = "Author is required")
    @Size(min = 2, max = 100, message = "Author name must be between 2 and 100 characters")
    private String author;

    @PastOrPresent(message = "Publication date cannot be in the future")
    private LocalDate publicationDate;

    private boolean available;

    @PositiveOrZero(message = "Quantity must be zero or positive")
    private int quantity;

    // Constructors
    public Book() {}

    public Book(String title, String isbn, String author, LocalDate publicationDate, boolean available, int quantity) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationDate = publicationDate;
        this.available = available;
        this.quantity = quantity;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", author=" + author + ", publicationDate="
				+ publicationDate + ", available=" + available + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, available, id, isbn, publicationDate, quantity, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && available == other.available && Objects.equals(id, other.id)
				&& Objects.equals(isbn, other.isbn) && Objects.equals(publicationDate, other.publicationDate)
				&& quantity == other.quantity && Objects.equals(title, other.title);
	}

 
}
