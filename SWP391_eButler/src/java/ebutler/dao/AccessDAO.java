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
import Account.Account;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class AccessDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public AccessDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        try {
            String sql = "Select Role_Name From Role where ID = (select Role_ID from Account Where IsStatus = 'active' and username = ? and Password = ?)";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role_Name");
            }
        } finally {
            closeConnection();
        }
        return role;
    }

    public boolean registerUser(Account dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into Account(Username, Password, Role_ID, Name, Phone, Email, Address, Introduce, Image, IsStatus) values(?,?,?,?,?,?,?,?,?,?)";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getAccID());
            preStm.setString(2, dto.getPassword());
            preStm.setInt(3, dto.getRole());
            preStm.setString(4, dto.getName());
            preStm.setString(5, dto.getPhone());
            preStm.setString(6, dto.getEmail());
            preStm.setString(7, dto.getAddress());
            preStm.setString(8, dto.getIntroduce());
            preStm.setString(9, dto.getImage());
            preStm.setString(10, dto.getIsStatus());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean checkDuplicateUsername(String username) throws Exception {
        boolean check = false;
        try {
            String sql = "SELECT Username FROM Account WHERE Username = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while(rs.next()){
                check = true;
            }
        } finally {
            closeConnection();
        }

        return check;
    }

}
