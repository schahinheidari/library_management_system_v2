package com.example.library_management.model.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookUpdateDto {
    private int id;
    private String name;
    private int author_id;
    private int publisher_id;
}
