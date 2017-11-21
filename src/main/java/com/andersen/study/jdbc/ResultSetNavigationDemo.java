package com.andersen.study.jdbc;

import java.sql.*;

public class ResultSetNavigationDemo {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/task_sql?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Connection connection = null;
        Statement statement = null;

        Class.forName(JDBC_DRIVER);

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Creating statement..");

            statement = connection.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE
            );
            String SQL = "SELECT * FROM developer";
            ResultSet resultSet = statement.executeQuery(SQL);

            System.out.println("Moving cursor to the last position..");
            resultSet.last();

            System.out.println("Getting record..");
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String specialty = resultSet.getString("specialty");
            int salary = resultSet.getInt("salary");

            System.out.println("Last record in the result set:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
            System.out.println("\n============================\n");

            System.out.println("Moving cursor to previous row..");
            resultSet.previous();

            System.out.println("Getting record..");
            id = resultSet.getInt("id");
            name = resultSet.getString("name");
            specialty = resultSet.getString("specialty");
            salary = resultSet.getInt("salary");

            System.out.println("Previous record:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
            System.out.println("\n============================\n");

            System.out.println("Moving cursor to first row..");
            resultSet.first();

            System.out.println("Getting record..");
            id = resultSet.getInt("id");
            name = resultSet.getString("name");
            specialty = resultSet.getString("specialty");
            salary = resultSet.getInt("salary");

            System.out.println("First record:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
            System.out.println("\n============================\n");

            System.out.println("Adding record:");
            SQL = "INSERT INTO developer VALUES (NULL, 'Mike Borsy', 'PHP', 1500)";
            statement.executeUpdate(SQL);

            SQL = "SELECT * FROM developer";
            resultSet = statement.executeQuery(SQL);
            resultSet.last();

            System.out.println("Getting record..");
            id = resultSet.getInt("id");
            name = resultSet.getString("name");
            specialty = resultSet.getString("specialty");
            salary = resultSet.getInt("salary");

            System.out.println("Last record:");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + specialty);
            System.out.println("Salary: $" + salary);
            System.out.println("\n============================\n");


            System.out.println("Full list of the records:");
            resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                specialty = resultSet.getString("specialty");
                salary = resultSet.getInt("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: $" + salary);
                System.out.println("\n============================\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }
}
