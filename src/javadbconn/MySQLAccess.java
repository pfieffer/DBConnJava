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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ravi
 */
public class MySQLAccess {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    ArrayList<Phone> phoneArrList = new ArrayList<>();

    public void readDataBase() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/phone_iinfo", "root", "");

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from phone_iinfo.products");
            writeResultSet(resultSet);
        } catch (ClassNotFoundException | SQLException e) {
            //throw e;
            System.out.println("Connection to database failed.");
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            int id = resultSet.getInt("pid");
            String name = resultSet.getString("name");
            String price = resultSet.getString("price");
            String description = resultSet.getString("description");
            String dateCreated = resultSet.getString("created_at");
            //String dateUpdated = resultSet.getString("updated_at");
            
            //System.out.println(id+" "+name+" "+price+" "+description+" "+dateCreated); //this is working
            

            phoneArrList.add(new Phone(id, name, price, description, dateCreated));
        }

        // Iterate over the List we just created with the enhanced for - the method will
        // be called on all objects in the List.
        for (Phone phones : phoneArrList) {
            System.out.println(phones.getName());
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
