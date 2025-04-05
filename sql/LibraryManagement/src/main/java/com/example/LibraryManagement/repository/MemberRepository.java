package com.example.LibraryManagement.repository;



import com.example.LibraryManagement.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}