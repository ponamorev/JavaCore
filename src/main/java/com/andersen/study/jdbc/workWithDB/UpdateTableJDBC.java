package com.andersen.study.jdbc.workWithDB;

import java.sql.*;

public class UpdateTableJDBC {
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

            System.out.println("Getting records..");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM developers";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                int salary = resultSet.getInt("salary");

                System.out.println("\n===============\n");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: $" + salary);
                System.out.println("\n===============\n");
            }

            System.out.println("\n******************************\n");

            System.out.println("Increasing salary for all developers (+ $500)");
            SQL = "UPDATE developers SET salary = salary + 500";
            statement.executeUpdate(SQL);

            System.out.println("Getting updating records..");
            SQL = "SELECT * FROM developers";
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                int salary = resultSet.getInt("salary");

                System.out.println("\n===============\n");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: $" + salary);
                System.out.println("\n===============\n");
            }

        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
