package Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DBUtils;

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

    public static Account getAccount(String name, String password) throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        Account acc = null;
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [accID],[password],[role],[name],[phone],[email],[address],[introduce],[image],[isStatus]\n"
                    + "FROM DBO.Accounts\n"
                    + "WHERE name=? AND password=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, password);
            ResultSet table = pst.executeQuery();
            if (table != null && table.next()) {
                int accId = table.getInt("accID");
                password = table.getString("password");
                int role = table.getInt("role");
                name = table.getString("name");
                String phone = table.getString("phone");
                String email = table.getString("email");
                String address = table.getString("address");
                String introduce = table.getString("introduce");
                String image = table.getString("image");
                int isStatus = table.getInt("isStatus");

                acc = new Account(accID, password, role, name, phone, email, address, introduce, image, isStatus);
                list.add(acc);
            }
            cn.close();
        }
        return acc;
    }
    //Register

    public static boolean insertAccount(String newPassword, String newRole, String newName, String newPhone, String newEmail, String newAddress, String newIntroduce, String newImage, int newIsStatus) throws Exception {
        Connection cn = utils.DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "INSERT INTO DBO.Accounts(password,role,name,phone,email,address,introduce,image,isStatus)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newPassword);
            pst.setString(2, newRole);
            pst.setString(3, newName);
            pst.setString(4, newPhone);
            pst.setString(5, newEmail);
            pst.setString(6, newAddress);
            pst.setString(7, newIntroduce);
            pst.setString(8, newImage);
            pst.setInt(9, newIsStatus);

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
    public static ArrayList<Account> getAccounts() throws Exception {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT accID,password,role,name,phone,email,address,introduce,image,isStatus from dbo.Accounts";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    int accId = table.getInt("accID");
                    String password = table.getString("password");
                    int role = table.getInt("role");
                    String name = table.getString("name");
                    String phone = table.getString("phone");
                    String email = table.getString("email");
                    String address = table.getString("address");
                    String introduce = table.getString("introduce");
                    String image = table.getString("image");
                    int isStatus = table.getInt("isStatus");
                    Account acc = new Account(accId,password,role,name,phone,email,address,introduce,image,isStatus);
                    list.add(acc);
                }
            }
            cn.close();
        }
        return list;
    }
}
