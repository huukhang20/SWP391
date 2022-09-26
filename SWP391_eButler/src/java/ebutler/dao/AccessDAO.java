/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebutler.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class AccessDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public AccessDAO() {
    }
    
    private void closeConnection() throws Exception {
        if(rs != null){
            rs.close();
        }
        if(preStm != null){
            preStm.close();
        }
        if(conn != null){
            conn.close();
        }
    }
    
    public String checkLogin(String username, String password) throws Exception {
        String role = "faield";
        try {
            String sql = "Select Role From Account Where IsStatus = 'active' and username = ? and Password = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if(rs.next()){
                role = rs.getString("Role");
            }
        } finally {
            closeConnection();
        }
        return role;
    }
    
    
}
