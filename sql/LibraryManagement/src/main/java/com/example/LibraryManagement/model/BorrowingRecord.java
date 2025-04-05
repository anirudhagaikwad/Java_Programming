package com.example.LibraryManagement.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "borrowing_records")
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private LocalDateTime borrowDate;

    private LocalDateTime dueDate;

    private LocalDateTime returnDate;

    private boolean returned;

    @Column(nullable = false)
    private double fineAmount = 0.0;

    // Constructors
    public BorrowingRecord() {}

    public BorrowingRecord(Book book, Member member, LocalDateTime borrowDate, LocalDateTime dueDate, LocalDateTime returnDate, boolean returned, double fineAmount) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.returned = returned;
        this.fineAmount = fineAmount;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public LocalDateTime getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;
	}

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	@Override
	public String toString() {
		return "BorrowingRecord [id=" + id + ", book=" + book + ", member=" + member + ", borrowDate=" + borrowDate
				+ ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", returned=" + returned + ", fineAmount="
				+ fineAmount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(book, borrowDate, dueDate, fineAmount, id, member, returnDate, returned);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BorrowingRecord other = (BorrowingRecord) obj;
		return Objects.equals(book, other.book) && Objects.equals(borrowDate, other.borrowDate)
				&& Objects.equals(dueDate, other.dueDate)
				&& Double.doubleToLongBits(fineAmount) == Double.doubleToLongBits(other.fineAmount)
				&& Objects.equals(id, other.id) && Objects.equals(member, other.member)
				&& Objects.equals(returnDate, other.returnDate) && returned == other.returned;
	}


}
