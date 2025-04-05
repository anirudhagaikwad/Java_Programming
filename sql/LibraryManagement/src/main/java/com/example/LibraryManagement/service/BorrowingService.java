package com.example.LibraryManagement.service;


import com.example.LibraryManagement.exception.BorrowingException;
import com.example.LibraryManagement.exception.ResourceNotFoundException;
import com.example.LibraryManagement.model.Book;
import com.example.LibraryManagement.model.BorrowingRecord;
import com.example.LibraryManagement.model.Member;
import com.example.LibraryManagement.repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class BorrowingService {
    private final BorrowingRecordRepository borrowingRepository;
    private final BookService bookService;
    private final MemberService memberService;

    @Value("${library.max-borrows-per-member}")
    private int maxBorrows;

    @Value("${library.borrow-period-days}")
    private int borrowPeriodDays;

    private static final double FINE_PER_DAY = 0.50;

    public BorrowingService(BorrowingRecordRepository borrowingRepository,
                           BookService bookService,
                           MemberService memberService) {
        this.borrowingRepository = borrowingRepository;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    @Transactional
    public BorrowingRecord borrowBook(Long bookId, Long memberId) {
        Book book = bookService.getBookById(bookId);
        Member member = memberService.getMemberById(memberId);

        if (!book.isAvailable() || book.getQuantity() <= 0) {
            throw new BorrowingException("Book is not available for borrowing");
        }
        if (member.getCurrentBorrows() >= maxBorrows) {
            throw new BorrowingException("Member has reached maximum borrow limit");
        }

        BorrowingRecord borrowing = new BorrowingRecord();
        borrowing.setBook(book);
        borrowing.setMember(member);
        borrowing.setBorrowDate(LocalDateTime.now());
        borrowing.setDueDate(LocalDateTime.now().plusDays(borrowPeriodDays));
        borrowing.setReturned(false);

        book.setQuantity(book.getQuantity() - 1);
        book.setAvailable(book.getQuantity() > 0);
        member.setCurrentBorrows(member.getCurrentBorrows() + 1);

        bookService.updateBook(bookId, book);
        memberService.updateMember(memberId, member);

        return borrowingRepository.save(borrowing);
    }

    @Transactional
    public BorrowingRecord returnBook(Long borrowingId) {
        BorrowingRecord borrowing = borrowingRepository.findById(borrowingId)
            .orElseThrow(() -> new ResourceNotFoundException("Borrowing record not found with id: " + borrowingId));

        if (borrowing.isReturned()) {
            throw new BorrowingException("Book has already been returned");
        }

        Book book = borrowing.getBook();
        Member member = borrowing.getMember();

        borrowing.setReturnDate(LocalDateTime.now());
        borrowing.setReturned(true);

        if (borrowing.getReturnDate().isAfter(borrowing.getDueDate())) {
            long daysOverdue = ChronoUnit.DAYS.between(borrowing.getDueDate(), borrowing.getReturnDate());
            borrowing.setFineAmount(daysOverdue * FINE_PER_DAY);
        }

        book.setQuantity(book.getQuantity() + 1);
        book.setAvailable(true);
        member.setCurrentBorrows(member.getCurrentBorrows() - 1);

        bookService.updateBook(book.getId(), book);
        memberService.updateMember(member.getId(), member);

        return borrowingRepository.save(borrowing);
    }
}
