/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadbconn;



/**
 *
 * @author ravi
 */
public class DBConnect {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        MySQLAccess databaseAccessObject = new MySQLAccess();
        databaseAccessObject.readDataBase();
    }
    
}