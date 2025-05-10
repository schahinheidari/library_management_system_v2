package com.example.library_management.model.dto.borrow;

import com.example.library_management.model.entity.Book;
import com.example.library_management.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDto {

    private int id;
    private Book book;
    private User user;

    private LocalDate borrowDate;
    private LocalDate returnDate;
}
