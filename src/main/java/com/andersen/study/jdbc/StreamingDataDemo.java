package com.andersen.study.jdbc;

import java.io.*;
import java.sql.*;

public class StreamingDataDemo {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/task_sql?autoReconnect=true&useSSL=false";

    private static final String USER = "root";
    private static final String PASSWORD = "2130";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database..");
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            statement = connection.createStatement();
            createXMLTable(statement);

            File file = new File("Proselyte_Developer.xml");
            long fileLenght = file.length();
            FileInputStream inputStream = new FileInputStream(file);

            String SQL = "INSERT INTO XML_Developer VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, 1);
            preparedStatement.setAsciiStream(2, inputStream, (int) fileLenght);
            preparedStatement.execute();

            inputStream.close();

            SQL = "SELECT Data FROM XML_Developer WHERE id = 1";
            resultSet = statement.executeQuery(SQL);
            if (resultSet.next()) {
                InputStream xmlInputStream = resultSet.getAsciiStream(1);
                int c;
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                while ((c = xmlInputStream.read()) != -1)
                    outputStream.write(c);
                System.out.println(outputStream.toString());
            }

            resultSet.close();
            statement.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (statement != null) statement.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Goodbye!");
    }

    static void createXMLTable(Statement statement) throws SQLException {
        System.out.println("Creating XML_Developer table..");
        String SQL = "CREATE TABLE XML_Developer (id INTEGER, Data LONG)";
        try {
            statement.executeUpdate("DROP TABLE XML_Developer");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        statement.executeUpdate(SQL);
    }
}
