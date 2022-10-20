/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Category.Category;
import Service.Service;
import controllers.ServiceController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
//lay het service theo cateId
public class ServiceDAO {

    public static ArrayList<Service> getServices(String cateID) throws SQLException {
        ArrayList<Service> list = new ArrayList<>();
        //connecting to database
        Connection con = DBUtils.makeConnection();
        try {
            //creating and executing sql statements
            String sql = "select s.*, c.name as cateName "
                    + "from service s join category c on s.category_id=c.category_id "
                    + "where s.category_id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cateID);
            ResultSet rs = stm.executeQuery();
            //Loading data into the list
            while (rs.next()) {
                Service services = new Service();
                services.setSerID(rs.getInt("serId"));
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
    public static ArrayList<Service> getSerVicesByName(String serName, String cateId) throws SQLException {
        ArrayList<Service> list = new ArrayList<>();
        //connecting to database
        Connection con = DBUtils.makeConnection();
        try {
            //creating and executing sql statements
            String sql = "select s.*, c.name as cateName "
                    + "from services s join category c on s.category_id=c.category_id "
                    + "where s.name like ? and s.category_id = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + serName + "%");
            stm.setString(2, cateId);
            ResultSet rs = stm.executeQuery();
            //Loading data into the list
            while (rs.next()) {
                Service services = new Service();
                services.setSerID(rs.getInt("serId"));
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
    public Service find(String serId) throws SQLException {
        Service services = null;
        Connection con = DBUtils.makeConnection();
        String sql = "select * from services where id = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, serId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                services = new Service();
                services.setSerID(rs.getInt("serId"));
                services.setSerName(rs.getString("serName"));

            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return services;
    }
    
    public boolean checkServices(String serId) throws SQLException {
        Connection con = DBUtils.makeConnection();
        String sql = "select * from services where id = ?";
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
        //add new service
        public static boolean createServices(String serName, String serDescription, String quantity, String price, String workDate, String releaseDate, String serImage, String serStatus) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "INSERT INTO DBO.Service(Name,Description,Category_ID,Supplier_ID,Working_Time,Release_Time,Image,Status)\n"
                    + "VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serName);
            pst.setString(2, serDescription);
            pst.setString(3, quantity);
            pst.setString(4, price);
            pst.setString(5, workDate);
            pst.setString(6, releaseDate);
            pst.setString(7, serImage);
            pst.setString(8, serStatus);
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
        
            //update service 
    public static boolean updateService(String serName, String serDescription, String quantity, String price, String workDate, String releaseDate, String serImage, String serId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "UPDATE DBO.Service\n"
                    + "SET Name=?,"
                    + "Description=?,"
                    + "quantity=?,"
                    + "price=?,"
                    + "Working_Time=?,"
                    + "Release_Time=?,"
                    + "Image=?\n"
                    + "WHERE Id=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serName);
            pst.setString(2, serDescription);
            pst.setString(3, quantity);
            pst.setString(4, price);
            pst.setString(5, workDate);
            pst.setString(6, releaseDate);
            pst.setString(7, serImage);
            pst.setString(8, serId);
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
    public static boolean updateServiceStatus(String serStatus, String serId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "UPDATE DBO.Service\n"
                    + "SET Status=?\n"
                    + "WHERE Id=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serStatus);
            pst.setString(2, serId);
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
    
                    //delete Services
    public static boolean deleteService(String serId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "DELETE FROM DBO.Services\n"
                    + "WHERE serId=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serId);
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
    
    // veew Service
    public List<Service> getAllService(){
        List<Service> list = new ArrayList<>();
        String query ="select * from Service";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Service(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getInt(6), 
                        rs.getInt(7), 
                        rs.getString(8), 
                        rs.getString(9), 
                        rs.getString(10), 
                        rs.getString(11)));
            }
        }catch (Exception e) {            
        }
        return list;
    }
    
    // view Service detail
    public Service detail(String serId) throws SQLException {
        Service services = null;
        Connection con = DBUtils.makeConnection();
        String sql = "select * from services where id = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, serId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                services = new Service();
                services.setSerID(rs.getInt("serId"));
                services.setSerName(rs.getString("serName"));
                services.setSerDescription(rs.getString("serDescription"));
                services.setCateId(rs.getInt("cateId"));
                services.setSupplierId(rs.getInt("supplierId"));
                services.setQuantity(rs.getInt("quantity"));
                services.setPrice(rs.getInt("price"));
                services.setWorkDate(rs.getString("workDate"));
                services.setReleaseDate(rs.getString("releaseDate"));
                services.setSerImage(rs.getString("serImage"));                

            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return services;
    }
    // view Category
    public List<Category> getAllCategory(){
        List<Category> list = new ArrayList<>();
        String query ="select * from Category";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1), 
                        rs.getString(2)));
            }
        }catch (Exception e) {            
        }
        return list;
    }
}
