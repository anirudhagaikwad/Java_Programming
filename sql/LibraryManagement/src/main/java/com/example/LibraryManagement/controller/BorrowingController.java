package com.example.LibraryManagement.controller;


import com.example.LibraryManagement.model.BorrowingRecord;
import com.example.LibraryManagement.service.BorrowingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingController {
    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @Operation(summary = "Borrow a book")
    @ApiResponse(responseCode = "200", description = "Book borrowed successfully")
    @ApiResponse(responseCode = "400", description = "Borrowing not possible")
    @PostMapping("/borrow/{bookId}/{memberId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'LIBRARIAN')")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, 
                                                    @PathVariable Long memberId) {
        return ResponseEntity.ok(borrowingService.borrowBook(bookId, memberId));
    }

    @Operation(summary = "Return a book")
    @ApiResponse(responseCode = "200", description = "Book returned successfully")
    @ApiResponse(responseCode = "400", description = "Return not possible")
    @PutMapping("/return/{borrowingId}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'LIBRARIAN')")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long borrowingId) {
        return ResponseEntity.ok(borrowingService.returnBook(borrowingId));
    }
}
