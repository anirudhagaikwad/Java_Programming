package com.example.LibraryManagement.repository;


import com.example.LibraryManagement.model.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
}
