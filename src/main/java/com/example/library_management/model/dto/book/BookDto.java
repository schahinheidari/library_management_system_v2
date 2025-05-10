package com.example.library_management.model.dto.book;

import com.example.library_management.model.entity.Author;
import com.example.library_management.model.entity.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private int id;
    private String name;
    private Author author;
    private Publisher publisher;
}
