package com.example.library_management.controller;


import com.example.library_management.model.dto.book.BookDto;
import com.example.library_management.model.dto.book.BookSaveDto;
import com.example.library_management.model.dto.book.BookUpdateDto;
import com.example.library_management.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookController {
/*
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PublisherService publisherService;

    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book book){
        List<Author> authors = new ArrayList<>();
        for (Author author : book.getAuthors()){
            Author foundAuthor = authorService.getAuthorById(author.getId());
            if(foundAuthor == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            authors.add(foundAuthor);
        }
        book.setAuthors(authors);

        List<Category> categories = new ArrayList<>();
        for (Category category : book.getCategories()){
            Category foundCategory = categoryService.getCategoryById(category.getId());
            if(foundCategory == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            categories.add(foundCategory);
        }
        book.setCategories(categories);

        List<Publisher> publishers = new ArrayList<>();
        for (Publisher publisher : book.getPublishers()){
            Publisher foundPublisher = publisherService.getPublisherById(publisher.getId());
            if(foundPublisher == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            publishers.add(foundPublisher);
        }
        book.setPublishers(publishers);

        Book savedBook = bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> listAllBooks() {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        Book existingBook = bookService.getBookById(id);
        if (existingBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Author> authors = new ArrayList<>();
        for (Author author : book.getAuthors()){
            Author foundAuthor = authorService.getAuthorById(author.getId());
            if(foundAuthor == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            authors.add(foundAuthor);
        }
        book.setAuthors(authors);

        List<Category> categories = new ArrayList<>();
        for (Category category : book.getCategories()){
            Category foundCategory = categoryService.getCategoryById(category.getId());
            if(foundCategory == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            categories.add(foundCategory);
        }
        book.setCategories(categories);

        List<Publisher> publishers = new ArrayList<>();
        for (Publisher publisher : book.getPublishers()){
            Publisher foundPublisher = publisherService.getPublisherById(publisher.getId());
            if(foundPublisher == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            publishers.add(foundPublisher);
        }
        book.setPublishers(publishers);


        book.setId(id);
        bookService.update(id, book);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }*/

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/save")
    public String saveBook(@RequestBody BookSaveDto bookSaveDto){
        String bookName = bookService.addBook(bookSaveDto);
        return "Added Successfully";
    }

    @GetMapping(path = "/getAllBook")
    public List<BookDto> getAllBooks(){
        List<BookDto> bookList = bookService.getAllBooks();
        return bookList;
    }

    @PutMapping(path = "/update")
    public String updateBook(@RequestBody BookUpdateDto bookUpdateDto){
        String bookName = bookService.updateBook(bookUpdateDto);
        return "Updated Successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") int id){
        String autherName = bookService.deleteBook(id);
        return "Deleted Successfully";
    }
}
