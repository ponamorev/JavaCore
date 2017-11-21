package com.andersen.study.jdbc.workWithDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DropDBJDBC {
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

            System.out.println("Removing database..");
            String SQL = "DROP DATABASE trainee_db";

            statement = connection.createStatement();
            statement.execute(SQL);
            System.out.println("Database successfully removed!");
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
