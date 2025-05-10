package com.example.library_management.service;


import com.example.library_management.model.dto.book.BookDto;
import com.example.library_management.model.dto.book.BookSaveDto;
import com.example.library_management.model.dto.book.BookUpdateDto;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDto bookSaveDto);
    List<BookDto> getAllBooks();
    String updateBook(BookUpdateDto bookUpdateDto);
    String deleteBook(int id);
    
}
