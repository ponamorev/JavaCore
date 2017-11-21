package com.andersen.study.jdbc;

import java.sql.*;

public class DeveloperJDBCDemo {
    /**
     * JDBC Driver and database URL
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/task_sql?autoReconnect=true&useSSL=false";

    /**
     * User and Password
     */
    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver..");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection..");
        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement..");
        statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM developers;";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database..");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");

            System.out.println("\n=====================\n");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Salary: $" + salary);
        }

        System.out.println("Closing connection and releasing resources..");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
