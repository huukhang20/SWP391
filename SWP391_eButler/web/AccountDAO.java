
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

//lay account trung name va pas 
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
                int accID = table.getInt("accID");
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
            }//het if
            cn.close();
        }//het if
        return acc;
    }
    
        public static boolean insertAccount(String newPassword, String newRole, String newName, String newPhone, String newEmail, String newAddress, String newIntroduce, String newImage, int isStatus) throws Exception {
        Connection cn = utils.DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "INSERT INTO DBO.Accounts(password,role,name,phone,email,address,introduce,image,status)\n"
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
            pst.setString(9, newIsStatus);
            
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
}
