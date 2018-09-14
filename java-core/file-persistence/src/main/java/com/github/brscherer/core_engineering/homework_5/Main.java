package com.github.brscherer.core_engineering.homework_5;

import com.github.brscherer.core_engineering.homework_5.controllers.Library;
import com.github.brscherer.core_engineering.homework_5.dao.LibraryDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static String LIBRARY = "library.json";

    public static void main(String[] args) {
        Library library = LibraryDAO.readFile(LIBRARY);
        library.rentBook(library.getUserByName("tiburcio"), library.getBookByTitle("tdd"));
        library.returnBook(library.getUserByName("tiburcio"), library.getBookByTitle("how to rush"));
        LibraryDAO.writeFile(gson.toJson(library), LIBRARY);
        System.out.println(library.top10Users());
        System.out.println(library.delayedRents());
    }
}
