package com.andersen.study.jdbc;

import java.sql.*;

public class SavePointDemo {
    /**
     * JDBC Driver and database URL
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql:" +
            "//localhost:3306/task_sql?autoReconnect=true&useSSL=false";

    /**
     * User and Password
     */
    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        Class.forName(JDBC_DRIVER);

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        connection.setAutoCommit(false);

        statement = connection.createStatement();

        String SQL;
        SQL = "SELECT * FROM developer";

        ResultSet resultSet = statement.executeQuery(SQL);

        System.out.println("Retrieving data from database..");
        System.out.println("\nDevelopers:");
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
        }

        System.out.println("\n================\n");
        System.out.println("Creating savepoint..");
        Savepoint savepointOne = connection.setSavepoint("SavepointOne");

        /**
         * Check of working Savepoint
         */
        /*try {
            SQL = "INSERT INTO developer VALUES (NULL, 'Andry Weisly', 'Android', 2200)";
            statement.executeUpdate(SQL);

            SQL = "INSE INTHE developer VALUES (7, 'Ron Cutch', 'Ruby', 1900)";
            statement.executeUpdate(SQL);

            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQLException. Executing rollback to savepoint..");
            connection.rollback(savepointOne);
        }*/

        SQL = "SELECT * FROM developer";
        resultSet = statement.executeQuery(SQL);
        System.out.println("Retrieving data from database..");
        System.out.println("\nDevelopers:");
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
        }

        System.out.println("Closing connection and releasing resources..");
        resultSet.close();
        statement.close();
        connection.close();
    }
}
