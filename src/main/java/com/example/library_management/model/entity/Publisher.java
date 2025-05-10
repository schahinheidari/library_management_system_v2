package com.example.library_management.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {}

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

}
