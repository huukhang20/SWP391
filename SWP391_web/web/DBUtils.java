/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Zenny
 */
public class DBUtils {
    //ham nay de tao dynamic connection
    public static Connection makeConnection()throws Exception{
 String url = "jdbc:sqlserver://localhost;databaseName=;user=sa;password=12345";
        //Loading a driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //Creating a connection
        Connection con = DriverManager.getConnection(url);
        return con;
    }
}
