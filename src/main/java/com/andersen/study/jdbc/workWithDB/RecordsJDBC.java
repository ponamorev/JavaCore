package com.andersen.study.jdbc.workWithDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RecordsJDBC {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/trainee_db?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Registering JDBC Driver..");
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database..");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Connection successfully established!");

            System.out.println("Inserting records..");
            statement = connection.createStatement();

            String SQL = "INSERT INTO developers VALUES (1, 'Proselyte', 'Java', 3000)";
            statement.executeUpdate(SQL);
            SQL = "INSERT INTO developers VALUES (2, 'AsyaSmile', 'UI/UX', 2000)";
            statement.executeUpdate(SQL);
            SQL = "INSERT INTO developers VALUES (3, 'Peter', 'C++', 3500)";
            statement.executeUpdate(SQL);
            System.out.println("Records successfully inserted!");

        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
