package com.github.brscherer.core_engineering.homework_5.controllers;

import com.github.brscherer.core_engineering.homework_5.models.Book;
import com.github.brscherer.core_engineering.homework_5.models.Rent;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class LibraryHelper {

    @NotNull
    public static String formatBookString(@NotNull Book book) {
        return "{\n id:" + String.valueOf(book.getId()) + ",\n " +
                "title: " + book.getTitle() + ",\n " +
                "author: " + book.getAuthor() + ",\n " +
                "rented: " + book.isRented() + ",\n }\n";
    }

    @NotNull
    public static String formatRentedBooks(@NotNull Rent rent) {
        return "{\n book: " + rent.getBook().getTitle() + ",\n " +
                "user: " + rent.getUser().getName() + ",\n " +
                "rentDate: " + rent.getRentDate() + ",\n " +
                "returnDate: " + rent.getReturnDate() + ",\n " +
                "penaltyFee: " + rent.getPenaltyFee() + ",\n}\n";
    }

    public static String formatDelayedRents(@NotNull Rent rent) {
        return "{\n user: " + rent.getUser().getName() + ",\n " +
                "delayedDays: " + DAYS.between(rent.getRentDate().plusDays(7), LocalDate.now()) + ",\n}\n";
    }
}
