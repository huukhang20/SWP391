package Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBUtils;
import Account.Account;
import Service.Service;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
//lay account trung name va pass
public class AccountDAO {

    public static Account getAccount(String username, String password) throws Exception {
        Account acc = new Account(username, password);
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [ID],[role_id],[name],[phone],[email],[address],[introduce],[image],[isStatus]\n"
                    + "FROM Account\n"
                    + "WHERE username=? AND password=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet table = pst.executeQuery();
            if (table != null && table.next()) {
                acc.setAccID(table.getInt("ID"));
                acc.setRole(table.getInt("role_id"));
                acc.setName(table.getString("name"));
                acc.setPhone(table.getString("phone"));
                acc.setEmail(table.getString("email"));
                acc.setAddress(table.getString("address"));
                acc.setIntroduce(table.getString("introduce"));
                acc.setImage(table.getString("image"));
                acc.setIsStatus(table.getString("isStatus"));

                acc.setUsername(username);
            }
            cn.close();
        }
        return acc;
    }
    //Register

    public static boolean insertAccount(String newUsername, String newPassword, String newName, String newPhone, String newEmail) throws Exception {
        Connection cn = utils.DBUtils.makeConnection();
        boolean flag = false;
        int newRole_ID = 2;
        String newAddress = null;
        String newIntroduce = null;
        String newIsStatus = "active";
        String newImage = null;
        if (cn != null) {
            String sql = "INSERT INTO Account(username,password,role_id,name,phone,email,address,introduce,image,isStatus)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newUsername);
            pst.setString(2, newPassword);
            pst.setInt(3, newRole_ID);
            pst.setString(4, newName);
            pst.setString(5, newPhone);
            pst.setString(6, newEmail);
            pst.setString(7, newAddress);
            pst.setString(8, newIntroduce);
            pst.setString(9, newImage);
            pst.setString(10, newIsStatus);

            int table = pst.executeUpdate();
            if (table == 1) {
                flag = true;
            } else {
                flag = false;
            }
            cn.close();
        }
        return flag;
    }

    //Check duplicate usetname
    public static boolean checkDuplicateUsername(String username) throws SQLException {
        Connection con = DBUtils.makeConnection();
        String CHECK_DUPLICATE_USERNAME = "SELECT * FROM Account WHERE username = ?";
        if (con != null) {
            PreparedStatement ps = con.prepareStatement(CHECK_DUPLICATE_USERNAME);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        }
        return false;
    }

    //Set status user trong account manager cua page admin
    public static boolean updateAccountStatus(int accId, int isStatus) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "UPDATE DBO.Accounts\n"
                    + "SET isStatus=?\n"
                    + "WHERE accId=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, isStatus);
            pst.setInt(2, accId);
            int table = pst.executeUpdate();
            if (table == 1) {
                flag = true;
            } else {
                flag = false;
            }
            cn.close();
        }
        return flag;
    }

    //lay het account neu can
//    public static ArrayList<Account> getAccounts() throws Exception {
//        ArrayList<Account> list = new ArrayList<>();
//        Connection cn = DBUtils.makeConnection();
//        if (cn != null) {
//            String sql = "SELECT accId,password,role,name,phone,email,address,introduce,image,isStatus from dbo.Accounts";
//            Statement st = cn.createStatement();
//            ResultSet table = st.executeQuery(sql);
//            if (table != null) {
//                while (table.next()) {
//                    int accId = table.getInt("accId");
//                    String password = table.getString("password");
//                    int role = table.getInt("role");
//                    String name = table.getString("name");
//                    String phone = table.getString("phone");
//                    String email = table.getString("email");
//                    String address = table.getString("address");
//                    String introduce = table.getString("introduce");
//                    String image = table.getString("image");
//                    int isStatus = table.getInt("isStatus");
//                    Account acc = new Account(accId,password,role,name,phone,email,address,introduce,image,isStatus);
//                    list.add(acc);
//                }
//            }
//            cn.close();
//        }
//        return list;
//    }
    //view Profile
    public Account editProfile(int accID) throws SQLException{
        Account profiles = null;
        Connection con = DBUtils.makeConnection();
        String sql ="insert into Account value = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, accID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                profiles = new Account();
                profiles.setAccID(rs.getInt("accID"));
                profiles.setName(rs.getString("name"));
                profiles.setUsername(rs.getString("username"));
                profiles.setPhone(rs.getString("phone"));
                profiles.setAddress(rs.getString("address"));
                profiles.setEmail(rs.getString("email"));
                profiles.setImage(rs.getString("image"));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return profiles;
    }

 
}
