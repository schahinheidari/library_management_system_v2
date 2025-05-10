package com.example.library_management.service;

import com.example.library_management.model.dto.book.BookDto;
import com.example.library_management.model.dto.book.BookSaveDto;
import com.example.library_management.model.dto.book.BookUpdateDto;
import com.example.library_management.model.entity.Book;
import com.example.library_management.repository.AuthorDao;
import com.example.library_management.repository.BookDao;
import com.example.library_management.repository.PublisherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private PublisherDao publisherDao;


    @Override
    public String addBook(BookSaveDto bookSaveDto) {
        Book book = new Book(
                bookSaveDto.getName(),
                authorDao.getById(bookSaveDto.getAuthor_id()),
                publisherDao.getById(bookSaveDto.getPublisher_id())
        );
        bookDao.save(book);
        return book.getName();
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> getBooks = bookDao.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : getBooks) {
            BookDto bookDto = new BookDto(
                    book.getId(),
                    book.getName(),
                    book.getAuthors(),
                    book.getPublishers()
            );
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    @Override
    public String updateBook(BookUpdateDto bookUpdateDto) {
        if(bookDao.existsById(bookUpdateDto.getId())){
            Book book = bookDao.findById(bookUpdateDto.getId()).get();
            book.setAuthors(authorDao.getById(bookUpdateDto.getAuthor_id()));
            book.setPublishers(publisherDao.getById(bookUpdateDto.getPublisher_id()));
            book.setName(bookUpdateDto.getName());
            bookDao.save(book);
            return book.getName();
        }
        else {
            System.out.println("Book does not exist");
        }
        return null;
    }

    @Override
    public String deleteBook(int id) {
        if (bookDao.existsById(id)) {
            bookDao.deleteById(id);
        } else {
            System.out.println("Book ID does not exist");
        }
        return null;
    }
}
