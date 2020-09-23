/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HARSHIT
 */
public class DBConnection {
    private static Connection conn;
    static{
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String connectionString = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "sca";
            String password = "sca";
            conn = DriverManager.getConnection(connectionString,username,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Cannot load the driver");
        } catch (SQLException ex) {
            System.out.println("DB Exception : "+ex.getMessage());
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
}
