package com.github.brscherer.core_engineering.homework_6.database;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DB {
    public static Connection connect() {
        ResourceBundle bundle = ResourceBundle.getBundle("application");
        Connection con = null;
        try {
            Class.forName(bundle.getString("DB_DRIVER_CLASS"));

            con = DriverManager.getConnection(bundle.getString("DB_URL"),
                    bundle.getString("DB_USERNAME"),
                    bundle.getString("DB_PASSWORD"));

            DriverManager.registerDriver(new Driver());
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Can't connect to database");
            e.printStackTrace();
        }
        return con;
    }

}
