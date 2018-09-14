package com.github.brscherer.core_engineering.homework_5;

import com.github.brscherer.core_engineering.homework_5.controllers.Library;
import com.github.brscherer.core_engineering.homework_5.models.Book;
import com.github.brscherer.core_engineering.homework_5.models.Rent;
import com.github.brscherer.core_engineering.homework_5.models.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    private Library library;
    private List<User> userList;
    private List<Book> bookList;
    private List<Rent> rentList;

    @Before
    public void createOutputTest() {
        library = new Library();
        userList = new ArrayList<>();
        bookList = new ArrayList<>();
        rentList = new ArrayList<>();
        library.setBookList(bookList);
        library.setUserList(userList);
        library.setRentList(rentList);
    }
    @Test
    public void addBookTest() {
        Integer size = library.getBookList().size();
        library.addBook(new Book(1,"vue","leahpar"));
        assertSame("Test add a book", size + 1, library.getBookList().size());
    }
    @Test
    public void addDuplicateBookTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        Integer size = library.getBookList().size();
        library.addBook(new Book(1,"vue","leahpar"));
        assertSame("Test add a book that is already added", size, library.getBookList().size());
    }
    @Test
    public void addNullBookTest() {
        Integer size = library.getBookList().size();
        library.addBook(null);
        assertSame("Test add a null book", size, library.getBookList().size());
    }
    @Test
    public void removeBookTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        Integer size = library.getBookList().size();
        library.removeBookById(1);
        assertSame(size - 1, library.getBookList().size());
    }
    @Test
    public void removeNullBookTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        Integer size = library.getBookList().size();
        library.removeBookById(null);
        assertSame(size, library.getBookList().size());
    }
    @Test
    public void rentBooksTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        library.addUser(new User(1, "bruno"));
        Integer size = library.getRentList().size();
        library.rentBook(library.getUserByName("bruno"), library.getBookByTitle("vue"));
        assertSame(size + 1, library.getBookList().size());
    }
    @Test
    public void renewRentTest() {
        LocalDate today = LocalDate.now();
        Book book = new Book(1,"vue","leahpar");
        book.setRented(true);
        library.addBook(book);
        User user = new User(1, "bruno");
        library.addUser(user);
        Rent rent = new Rent(user, book, LocalDate.now().minusDays(5));
        library.getRentList().add(rent);
        library.renewRent(library.getUserByName("bruno"), library.getBookByTitle("vue"));
        assertEquals(library.getRentList().get(0).getRentDate(), today);
    }
    @Test
    public void renewRentDelayedTest() {
        LocalDate today = LocalDate.now();
        Book book = new Book(1,"vue","leahpar");
        book.setRented(true);
        library.addBook(book);
        User user = new User(1, "bruno");
        library.addUser(user);
        Rent rent = new Rent(user, book, LocalDate.now().minusDays(10));
        library.getRentList().add(rent);
        library.renewRent(library.getUserByName("bruno"), library.getBookByTitle("vue"));
        assertEquals(library.getRentList().get(0).getRentDate(), today.minusDays(10));
    }
    @Test
    public void returnRentTest() {
        LocalDate today = LocalDate.now();
        Book book = new Book(1,"vue","leahpar");
        book.setRented(true);
        library.addBook(book);
        User user = new User(1, "bruno");
        library.addUser(user);
        Rent rent = new Rent(user, book, LocalDate.now().minusDays(5));
        library.getRentList().add(rent);
        library.returnBook(library.getUserByName("bruno"), library.getBookByTitle("vue"));
        assertEquals(library.getRentList().get(0).getReturnDate(), today);
    }
    @Test
    public void listBooksTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        String test = "{\n" +
                " id:1,\n" +
                " title: vue,\n" +
                " author: leahpar,\n" +
                " rented: false,\n" +
                " }\n";
        assertEquals(test, library.listBooks());
    }
    @Test
    public void listRentsTest() {
        LocalDate today = LocalDate.now();
        library.addBook(new Book(1,"vue","leahpar"));
        library.addUser(new User(1, "bruno"));
        library.rentBook(library.getUserByName("bruno"), library.getBookByTitle("vue"));
        String test = "{\n" +
                " book: vue,\n" +
                " user: bruno,\n" +
                " rentDate: " + today + ",\n" +
                " returnDate: null,\n" +
                " penaltyFee: 0.0,\n" +
                "}\n";
        assertEquals(test, library.listRents());
    }
    @Test
    public void listTop10UsersTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        library.addBook(new Book(2,"node","onurb"));
        library.addUser(new User(1, "bruno"));
        library.addUser(new User(2, "raphael"));
        library.rentBook(library.getUserByName("bruno"), library.getBookByTitle("vue"));
        library.rentBook(library.getUserByName("bruno"), library.getBookByTitle("node"));
        library.returnBook(library.getUserByName("bruno"), library.getBookByTitle("vue"), library.getBookByTitle("node"));
        library.rentBook(library.getUserByName("raphael"), library.getBookByTitle("node"));
        String test = "Top 1: bruno\n" +
                "Top 2: raphael\n";
        assertEquals(test, library.top10Users());
    }
    @Test
    public void delayedRentsTest() {
        Rent rent = new Rent(new User(1, "bruno"), new Book(1,"vue","leahpar"), LocalDate.now().minusDays(10));
        library.getRentList().add(rent);
        String test = "{\n" +
                " user: bruno,\n" +
                " delayedDays: 3,\n" +
                "}\n";
        assertEquals(test, library.delayedRents());
    }
    @Test
    public void getBookByTitleTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        assertEquals(bookList.get(0).getTitle(), library.getBookByTitle("vUe").getTitle());
    }
    @Test
    public void getBookByAuthorTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        assertEquals(bookList.get(0).getAuthor(), library.getBookByAuthor("leahpar").getAuthor());
    }
    @Test
    public void getBookByTitleNullTest() {
        assertNull(library.getBookByTitle(null));
    }
    @Test
    public void getBookByAuthorNullTest() {
        library.addBook(new Book(1,"vue","leahpar"));
        assertNull(library.getBookByAuthor(null));
    }
}
