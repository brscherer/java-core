package com.github.brscherer.core_engineering.homework_6.controllers;

import com.github.brscherer.core_engineering.homework_6.database.DB;
import com.github.brscherer.core_engineering.homework_6.models.Contact;

import java.sql.*;

public class Agenda {
    public void addContact(Contact contact) {
        String query = "INSERT INTO Contacts (name, email, phone) values (?, ?, ?)";
        try (
                Connection connection = DB.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, contact.getName());
            preparedStatement.setString(2, contact.getEmail());
            preparedStatement.setString(3, contact.getPhone());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeContact(Integer id) {
        String query = "DELETE FROM Contacts WHERE id =" + id.toString();
        try (
                Connection connection = DB.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByName(String name) {
        String query = "SELECT * FROM Contacts WHERE name LIKE '%" + name + "%'";
        try (
                Connection connection = DB.connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next())
                System.out.println(listContacts(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getById(Integer id) {
        String query = "SELECT * FROM Contacts WHERE id = " + id.toString() + " ORDER BY name";
        try (
                Connection connection = DB.connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next())
                System.out.println(listContacts(resultSet));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listContacts() {
        String query = "SELECT * FROM Contacts ORDER BY name";
        try (
                Connection connection = DB.connect();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next())
                System.out.println(listContacts(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String listContacts(ResultSet rs) throws SQLException {
        return rs.getString("id") + " | " +
                rs.getString("name") + " | " +
                rs.getString("email") + " | " +
                rs.getString("phone") + " | ";
    }
}
