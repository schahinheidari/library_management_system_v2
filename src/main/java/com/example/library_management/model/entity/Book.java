package com.example.library_management.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
    @JoinTable( name = "books_categories",
            joinColumns = { @JoinColumn(name = "book_id")},
            inverseJoinColumns = { @JoinColumn(name = "category_id")}
    )
    private List<Category> categories;

    @OneToMany(mappedBy = "book")
    private Set<Borrow> borrows;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public Book() {

    }

    public Book(int id, String name, Author author, Publisher publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(String name, Author author, Publisher publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthors() {
        return author;
    }

    public void setAuthors(Author author) {
        this.author = author;
    }

    public Publisher getPublishers() {
        return publisher;
    }

    public void setPublishers(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + author +
                ", publisher=" + publisher +
                '}';
    }
}
