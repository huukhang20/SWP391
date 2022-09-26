package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zenny
 */
public class DBUtils {

    //ham nay de tao dynamic connection
    public static Connection makeConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=eButler", "sa", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
