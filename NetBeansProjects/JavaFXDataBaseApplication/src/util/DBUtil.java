/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alexandrebarao
 */
public class DBUtil {
    private static Connection conn;
    
    public static void estabeleceConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/basedados", "root", "root");

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
     public static void fechaConexao() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    
    
    public static ResultSet dbExecutaQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            estabeleceConexao();
            
            System.out.println("Select statement: " + queryStmt + "\n");
 
            //Create statement
            stmt = conn.createStatement();
 
            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);
 
            //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            fechaConexao();
        }
        //Return CachedRowSet
        return crs;
    }
 
    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecutaUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            estabeleceConexao();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            fechaConexao();
        }
    } 
     
     
}
