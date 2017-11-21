package com.andersen.study.jdbc;

import java.sql.*;

public class BatchingProcessingDemo {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/task_sql?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Statement statement = null;

        Class.forName(JDBC_DRIVER);

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        connection.setAutoCommit(false);

        statement = connection.createStatement();

        String SQL = "SELECT * FROM developer";
        ResultSet resultSet = statement.executeQuery(SQL);


        System.out.println("Initial developer's table content:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");

            if (name == null) {
                System.out.println("Table is empty.");
                break;
            }
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("\n================\n");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
            System.out.println("\n================\n");
        }

        SQL = "INSERT INTO developer VALUES (NULL, 'Proselyte', 'Java', 3000)";
        statement.addBatch(SQL);
        SQL = "INSERT INTO developer VALUES (NULL, 'AsyaSmile', 'UI/UX', 2500)";
        statement.addBatch(SQL);
        SQL = "INSERT INTO developer VALUES (NULL, 'Peter', 'C++', 3000)";
        statement.addBatch(SQL);

        try {
            statement.executeBatch();
            connection.commit();

            SQL = "SELECT * FROM developer";
            resultSet = statement.executeQuery(SQL);

            System.out.println("Final developer's table content:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                int salary = resultSet.getInt("salary");

                System.out.println("\n================\n");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: $" + salary);
                System.out.println("\n================\n");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }

        System.out.println("Goodbye!");
    }
}
