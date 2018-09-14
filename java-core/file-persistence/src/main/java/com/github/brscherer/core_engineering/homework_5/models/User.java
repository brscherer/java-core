package com.github.brscherer.core_engineering.homework_5.models;

import com.github.brscherer.core_engineering.homework_5.controllers.Library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class User {
    private Integer id;
    private String name;
    private List<Book> rentedBooks;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.rentedBooks = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public void removeBookById(Integer id) {
        Optional.ofNullable(id).ifPresent(b -> this.rentedBooks.removeIf(book -> book.getId().equals(id)));
    }

}
