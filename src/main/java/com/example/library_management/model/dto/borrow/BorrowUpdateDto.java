package com.example.library_management.model.dto.borrow;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowUpdateDto {

    private int id;
    private int book_id;
    private int user_id;

    private LocalDate borrowDate;
    private LocalDate returnDate;
}
