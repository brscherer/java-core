package com.github.brscherer.core_engineering.homework_5.dao;

import com.github.brscherer.core_engineering.homework_5.controllers.Library;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LibraryDAO {
    private static Gson gson = new Gson();

    public static void writeFile(String data, String filePath) {
        Path path = Paths.get(filePath);
        try {
            byte[] fileByte = data.getBytes();
            if (!Files.exists(path)) Files.createFile(path);
            Files.write(path, fileByte);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Library readFile(String filePath) {
        if (filePath != null && filePath != "") {
            Path path = Paths.get(filePath);
            File file = path.toFile();
            try {
                JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                return gson.fromJson(jsonReader, Library.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else System.out.println("LibraryDAO.readFile: File not Found");
        return null;
    }
}
