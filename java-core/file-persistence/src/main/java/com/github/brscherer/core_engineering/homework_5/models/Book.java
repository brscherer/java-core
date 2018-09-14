package com.github.brscherer.core_engineering.homework_5.models;

import java.time.LocalDate;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private Boolean rented;

    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.rented = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean isRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

}
