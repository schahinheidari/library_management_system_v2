package com.example.library_management.repository;

import com.example.library_management.model.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowDao extends JpaRepository<Borrow, Integer> {
}
