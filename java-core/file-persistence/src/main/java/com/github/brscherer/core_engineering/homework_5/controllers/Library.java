package com.github.brscherer.core_engineering.homework_5.controllers;

import com.github.brscherer.core_engineering.homework_5.models.Book;
import com.github.brscherer.core_engineering.homework_5.models.Rent;
import com.github.brscherer.core_engineering.homework_5.models.User;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.temporal.ChronoUnit.DAYS;

public class Library {
    private List<Book> bookList;
    private List<User> userList;
    private List<Rent> rentList;

    private static Gson gson = new Gson();

    private static Integer MAX_BOOKS_PER_USER = 5;
    private static Integer MAX_RENT_TIME = 7;
    private static Double FEE_PER_DAY = 5.00;


    public Library() {
        this.bookList = new ArrayList<>();
        this.userList = new ArrayList<>();
        this.rentList = new ArrayList<>();
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Rent> getRentList() {
        return rentList;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }

    public void addUser(User user) {
        if (user == null) {
            System.out.println("User cannot be null");
            return;
        }
        if (this.userList.stream().anyMatch(u -> u.getId().equals(user.getId())))
            System.out.println("User '" + user.getName() + "' already registered. ID = " + user.getId());
        else this.userList.add(user);
    }

    public void addBook(Book book) {
        if (book == null) {
            System.out.println("Book cannot be null");
            return;
        }
        if (this.bookList.stream().anyMatch(b -> b.getId().equals(book.getId())))
            System.out.println("Book '" + book.getTitle() + "' already registered. ID = " + book.getId());
        else this.bookList.add(book);
    }

    public void removeBookById(Integer id) {
        Optional.ofNullable(id).ifPresent(b -> this.bookList.removeIf(book -> book.getId().equals(id) && !book.isRented()));
    }

    public String listBooks() {
        StringBuilder sb = new StringBuilder();
        this.bookList.forEach(book -> sb.append(LibraryHelper.formatBookString(book)));
        return sb.toString();
    }

    public String listRents() {
        StringBuilder sb = new StringBuilder();
        this.rentList.forEach(rent -> sb.append(LibraryHelper.formatRentedBooks(rent)));
        return sb.toString();
    }

    public String top10Users() {
        StringBuilder sb = new StringBuilder();

        IntStream.range(0, getTop10Users().size())
                .forEach(i -> sb.append("Top ")
                        .append(String.valueOf(i + 1))
                        .append(": ")
                        .append(getTop10Users().get(i))
                        .append("\n"));

        return sb.toString();
    }

    public List<String> getTop10Users() {
        return this.rentList
                .stream()
                .collect(Collectors.groupingBy(rent -> rent.getUser().getName(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .limit(10)
                .collect(Collectors.toList());
    }

    public String delayedRents() {
        StringBuilder sb = new StringBuilder();
        List<Rent> delayedRents = this.rentList
                .stream()
                .filter(this::filterDelayedRents)
                .collect(Collectors.toList());

        delayedRents.forEach(rent -> sb.append(LibraryHelper.formatDelayedRents(rent)));

        return sb.toString();
    }

    private boolean filterDelayedRents(Rent rent) {
        return rent.getReturnDate() == null
                && DAYS.between(rent.getRentDate().plusDays(MAX_RENT_TIME), LocalDate.now()) > 0;
    }

    public Book getBookByTitle(String title) {
        return this.bookList
                .stream()
                .filter(b -> b.getTitle() != null)
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);
    }

    public Book getBookByAuthor(String author) {
        return this.bookList
                .stream()
                .filter(b -> b.getAuthor() != null)
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .findFirst().orElse(null);
    }

    public User getUserByName(String name) {
        return this.userList
                .stream()
                .filter(user -> user.getName() != null)
                .filter(user -> user.getName().equals(name))
                .findFirst().orElse(null);
    }

    public void rentBook(@NotNull User user, @NotNull Book book) {
        if (!book.isRented()) {
            if (user.getRentedBooks().size() < MAX_BOOKS_PER_USER) {
                book.setRented(true);
                user.getRentedBooks().add(book);
                getRentList().add(new Rent(user, book));
            } else System.out.println("Library.rentBook: User '" + user.getName() + "' have 5 books rented!");
        } else System.out.println("Library.rentBook: You can't rent book '" + book.getTitle()
                + "' because its already rented.");
    }

    public void returnBook(User user, Book... books) {
        for (Book book : books) {
            Rent rent = rentList
                    .stream()
                    .filter(r -> filterReturnBook(r, book, user))
                    .findFirst()
                    .orElse(null);
            if (rent != null) {
                checkPenaltyFee(rent);
                book.setRented(false);
                user.removeBookById(book.getId());
                rent.setReturnDate(LocalDate.now());
                rent.getBook().setRented(false);
                rent.setUser(user);
                rent.setBook(book);
            } else
                System.out.println("Library.returnBook: Rent not found");
        }
    }

    private boolean filterReturnBook(Rent rent, Book book, User user) {
        return rent.getBook().getId().equals(book.getId())
                && rent.getUser().getId().equals(user.getId())
                && rent.getBook().isRented();
    }

    public void renewRent(User user, Book book) {
        Rent rent = rentList
                .stream()
                .filter(r -> filterRenewRent(r, book, user))
                .findFirst()
                .orElse(null);
        if (rent != null) {
            checkPenaltyFee(rent);
            if (rent.getPenaltyFee() < 1.00)
                rent.setRentDate(LocalDate.now());
        } else
            System.out.println("Library.renewRent: Cannot find rent!");
    }

    private boolean filterRenewRent(Rent rent, Book book, User user) {
        return rent.getBook().equals(book)
                && rent.getUser().equals(user)
                && rent.getBook().isRented();
    }

    private void checkPenaltyFee(@NotNull Rent rent) {
        Long daysBetween = DAYS.between(rent.getRentDate(), LocalDate.now());
        if (daysBetween > MAX_RENT_TIME) {
            Double penaltyFee = FEE_PER_DAY * (double) (daysBetween - MAX_RENT_TIME);
            rent.setPenaltyFee(penaltyFee);
            System.out.println("Library: You need to pay R$" + penaltyFee);
        } else {
            rent.setPenaltyFee(0.00);
        }
    }

}
