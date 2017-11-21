package com.andersen.study.jdbc;

import java.sql.*;

public class CallableStatementDemo {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/task_sql?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;

        System.out.println("Registering JDBC driver..");
        Class.forName(JDBC_DRIVER);

        try {
            System.out.println("Creating connection..");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Creating callable statement..");

            String sql = "{call getDeveloperName (?, ?)}";
            callableStatement = connection.prepareCall(sql);

            int developerID = 1;
            callableStatement.setInt(1, developerID);
            callableStatement.registerOutParameter(2, Types.VARCHAR);

            System.out.println("Executing procedure..");
            callableStatement.execute();

            String developerName = callableStatement.getString(2);
            System.out.println("Developer INFO:");
            System.out.println("ID: " + developerID);
            System.out.println("Name: " + developerName);
        } finally {
            if (callableStatement != null) callableStatement.close();
            if (connection != null) connection.close();
        }

        System.out.println("Thank you!");
    }
}
