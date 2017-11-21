package com.andersen.study.jdbc;

import java.sql.*;

public class PreparedStatementDemo {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/task_sql?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        System.out.println("Registering JDBC driver..");
        Class.forName(JDBC_DRIVER);

        try {
            System.out.println("Creating connection..");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            String sql = "SELECT * FROM developers";
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("Initial developers table content:");
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");

                System.out.println("\n=====================\n");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: $" + salary);
            }

            sql = "UPDATE developers SET salary = ? WHERE name = ?";
            System.out.println("Creating statement..");
            System.out.println("Executing SQL query..");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 3000);
            preparedStatement.setString(2, "Vyacheslav Ponamorev");

            System.out.println("Rows impacted: " + preparedStatement.executeUpdate());

            System.out.println("Final developers table content:");
            sql = "SELECT * FROM developers;";
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");

                System.out.println("\n=====================\n");
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Salary: $" + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }
}
