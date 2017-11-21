package com.andersen.study.jdbc.workWithDB;

import java.sql.*;

public class DeleteRecordsJDBC {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/trainee_db?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Registering JDBC driver..");
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database..");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            System.out.println("Connection successfully established!");

            System.out.println("Getting initial records..");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM developers";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String specialty = resultSet.getString(3);
                int salary = resultSet.getInt(4);

                System.out.println("\n==================\n");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: " + salary);
                System.out.println("\n==================\n");
            }

            System.out.println("\n***************************\n");

            System.out.println("Removing record with id = 3");
            SQL = "DELETE FROM developers WHERE id = 3";
            statement.executeUpdate(SQL);

            System.out.println("Getting records..");
            SQL = "SELECT * FROM developers";
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String specialty = resultSet.getString(3);
                int salary = resultSet.getInt(4);

                System.out.println("\n==================\n");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: " + salary);
                System.out.println("\n==================\n");
            }

        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
