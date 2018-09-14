package com.github.brscherer.core_engineering.homework_5.models;

import java.time.LocalDate;

public class Rent {
    private User user;
    private Book book;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private Double penaltyFee;

    public Rent(User user, Book book) {
        this.user = user;
        this.book = book;
        this.rentDate = LocalDate.now();
        this.penaltyFee = 0.00;
    }
    public Rent(User user, Book book, LocalDate date) {
        this.user = user;
        this.book = book;
        this.rentDate = date;
        this.penaltyFee = 0.00;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Double getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Double penaltyFee) {
        this.penaltyFee = penaltyFee;
    }


}
