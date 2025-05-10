package com.example.library_management.service;

import com.example.library_management.model.dto.borrow.BorrowDto;
import com.example.library_management.model.dto.borrow.BorrowSaveDto;
import com.example.library_management.model.dto.borrow.BorrowUpdateDto;

import java.util.List;

public interface BorrowService {
    String addBorrow(BorrowSaveDto borrowSaveDto);
    List<BorrowDto> getAllBorrows();
    String updateBorrow(BorrowUpdateDto borrowUpdateDto);
    String deleteBorrow(int id);
}
