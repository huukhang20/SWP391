/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
//lay het service theo cateId
public class ServiceDAO {

    public static ArrayList<Services> getServices(String cateID) {
        ArrayList<Services> list = new ArrayList<>();
        //connecting to database
        Connection con = DBUtil.getConnection();
        try {
            //creating and executing sql statements
            String sql = "select s.*, c.name as cateName "
                    + "from services s join category c on s.category_id=c.category_id "
                    + "where s.category_id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cateID);
            ResultSet rs = stm.executeQuery();
            //Loading data into the list
            while (rs.next()) {
                Services services = new Services();
                services.setSerId(rs.getString("serId"));
                services.setSerName(rs.getString("serName"));

                list.add(services);
            }
            //closing the connection 
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //get services by name
    public static ArrayList<Services> getSerVicesByName(String serName, String cateId) {
        ArrayList<Services> list = new ArrayList<>();
        //connecting to database
        Connection con = DBUtil.getConnection();
        try {
            //creating and executing sql statements
            String sql = "select s.*, c.name as cateName "
                    + "from services s join category c on s.category_id=c.category_id "
                    + "where s.name like ? and s.category_id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + name + "%");
            stm.setString(2, cateId);
            ResultSet rs = stm.executeQuery();
            //Loading data into the list
            while (rs.next()) {
                Services services = new Services();
                services.setSerId(rs.getString("serId"));
                services.setSerName(rs.getString("serName"));

                list.add(services);
            }
            //closing the connection 
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //get detail of services which are found
    public Services find(String serId) {
        Services services = null;
        Connection con = DBUtil.getConnection();
        String sql = "select * from services where services_id = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, serId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                services = new Services();
                services.setSerId(rs.getString("serId"));
                services.setSerName(rs.getString("serName"));

            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return services;
    }
    
    public boolean checkServices(String serId) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "select * from services where services_id = ?";
        if (con != null) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, serId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        }
        return false;
    }
    
        public static boolean createServices(String newSerName, String newSerDescription, int newQuantity, int newPrice, String newWorkDate, String newReleaseDate, String newSerImage, int newSerStatus) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "INSERT INTO DBO.Services(serName,serDescription,quantity,price,workDate,releaseDate,serImage,serStatus)\n"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newSerName);
            pst.setString(2, newSerDescription);
            pst.setInt(3, newQuantity);
            pst.setInt(4, newPrice);
            pst.setString(5, newWorkDate);
            pst.setString(6, newReleaseDate);
            pst.setString(7, newSerImage);
            pst.setInt(8, newSerStatus);
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
        
            //Set status service 
    public static boolean updateServiceStatus(int serId, String newSerName, String newSerDescription, int newQuantity, int newPrice, String newWorkDate, String newReleaseDate, String newSerImage) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "UPDATE DBO.Services\n"
                    + "SET serName=?,"
                    + "serDescription=?,"
                    + "quantity=?,"
                    + "price=?,"
                    + "workDate=?,"
                    + "releaseDate=?,"
                    + "serImage=?\n"
                    + "WHERE serId=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, newSerName);
            pst.setString(2, newSerDescription);
            pst.setInt(3, newQuantity);
            pst.setInt(4, newPrice);
            pst.setString(5, newWorkDate);
            pst.setString(6, newReleaseDate);
            pst.setString(7, newSerImage);
            pst.setInt(8, serId);
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
    
                //update Services
    public static boolean updateService(int serId, int serStatus) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "UPDATE DBO.Services\n"
                    + "SET serStatus=?\n"
                    + "WHERE serId=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, serStatus);
            pst.setInt(2, serId);
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
    
                    //update Services
    public static boolean deleteService(int serId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "DELETE FROM DBO.Services\n"
                    + "WHERE serId=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, serId);
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
