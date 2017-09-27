/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ravi
 */
public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/phone_iinfo","root","");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from phone_iinfo.products");
            writeResultSet(resultSet);

//            // PreparedStatements can use variables and are more efficient
//            preparedStatement = connect
//                    .prepareStatement("insert into  phone_iinfo.products values (?, ?, ?, ?)");
//            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
//            // Parameters start with 1
//            preparedStatement.setString(1, "");
//            preparedStatement.setString(2, "Some phone name");
//            preparedStatement.setString(3, "some price");
//            preparedStatement.setString(4, "description of the product");
//            preparedStatement.setString(5, String.valueOf(System.currentTimeMillis()));
////            preparedStatement.setString(6, "product updated at");
//            preparedStatement.executeUpdate();
//            
//            preparedStatement = connect
//                    .prepareStatement("SELECT name, price, description from phone_iinfo.products");
//            resultSet = preparedStatement.executeQuery();
//            writeResultSet(resultSet);
//
//            // Remove again the insert comment
//            preparedStatement = connect
//            .prepareStatement("delete from phone_iinfo.products where pid= ? ; ");
//            preparedStatement.setString(1, "Test"); //what is this?
//            preparedStatement.executeUpdate();
//
//            resultSet = statement
//            .executeQuery("select * from phone_iinfo.products");
//            writeMetaData(resultSet);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String name = resultSet.getString("name");
            String price = resultSet.getString("price");
            String description = resultSet.getString("description");
            System.out.println("Name: " + name);
            System.out.println("Price: " + price);
            System.out.println("Description: " + description);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    
}
