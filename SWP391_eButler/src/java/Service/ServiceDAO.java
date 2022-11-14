/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Account.Account;
import Category.Category;
import Service.Service;
import controllers.ServiceController;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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

//    public static ArrayList<Service> getServices(String serID) throws SQLException {
//        ArrayList<Service> list = new ArrayList<>();
//        //connecting to database
//        Connection con = DBUtils.makeConnection();
//        try {
//            //creating and executing sql statements
//            String sql = "select s.*, c.name as CategoryName "
//                    + "from Service s join category c on s.ID=c.ID "
//                    + "where s.ID = ?";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, serID);
//            ResultSet rs = stm.executeQuery();
//            //Loading data into the list
//            while (rs.next()) {
//                Service services = new Service();
//                services.setSerID(rs.getInt("serId"));
//                services.setSerName(rs.getString("serName"));
//                services.setSerDescription(rs.getString("serDescription"));
//                services.setCateId(rs.getInt("cateId"));
//                services.setSupplierId(rs.getInt("supplierId"));
//                services.setQuantity(rs.getInt("quantity"));
//                services.setPrice(rs.getInt("price"));
//                services.setWorkDate(rs.getString("workDate"));
//                services.setReleaseDate(rs.getString("releaseDate"));
//                services.setSerImage(rs.getString("serImage"));
//                services.setSerStatus(rs.getString("serStatus"));
//                list.add(services);
//            }
//            //closing the connection 
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    //get detail of services which are found
    public static Service find(String serId) throws SQLException {
        Service services = null;
        Connection con = DBUtils.makeConnection();
        String sql = "select * from Service where ID = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, serId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                services = new Service();
                services.setSerID(rs.getInt("ID"));
                services.setSerName(rs.getString("Name"));
                services.setSerDescription(rs.getString("Description"));
                services.setCateId(rs.getInt("Category_ID"));
                services.setSupplierId(rs.getInt("Supplier_ID"));
                services.setQuantity(rs.getInt("Quantity"));
                services.setPrice(rs.getInt("Price"));
                services.setWorkDate(rs.getString("Working_Time"));
                services.setReleaseDate(rs.getString("Release_Time"));
                services.setSerImage(rs.getString("Image"));
                services.setSerStatus(rs.getString("Status"));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return services;
    }

    public boolean checkServices(String serId) throws SQLException {
        Connection con = DBUtils.makeConnection();
        String sql = "select * from Service where Service.ID = ?";
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
            String sql = "INSERT INTO Service(Name,Description,Category_ID,Supplier_ID,Working_Time,Release_Time,Image,Status)\n"
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
            String sql = "UPDATE Service\n"
                    + "SET Name=?,"
                    + "Description=?,"
                    + "quantity=?,"
                    + "price=?,"
                    + "Working_Time=?,"
                    + "Release_Time=?,"
                    + "Image=?\n"
                    + "WHERE ID=?";
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
            String sql = "UPDATE DBO.Service \n"
                    + "SET Status=? \n"
                    + "WHERE ID=?";
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
            String sql = "DELETE FROM Service\n"
                    + "WHERE ID=?";
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
    public List<Service> getAllService() {
        List<Service> list = new ArrayList<>();
        String query = "select * from Service "
                + "where Status like 'available'";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
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
        } catch (Exception e) {
        }
        return list;
    }

    // view Service detail
    public Service detail(String serId) throws SQLException {
        Connection con = DBUtils.makeConnection();
        String sql = "select * from Service where id = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, serId);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                return new Service(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

//    public static ArrayList<Service> getServicesByCategory(String cateID) throws SQLException {
//        ArrayList<Service> list = new ArrayList<>();
//        //connecting to database
//        Connection con = DBUtils.makeConnection();
//        try {
//            //creating and executing sql statements
//            String sql = "select s.*, c.name as CategoryName "
//                    + "from Service s join category c on c.ID=s.Category_ID "
//                    + "where c.ID = ?";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, cateID);
//            ResultSet rs = stm.executeQuery();
//            //Loading data into the list
//            while (rs.next()) {
//                Service services = new Service();
//                services.setSerID(rs.getInt("serId"));
//                services.setSerName(rs.getString("serName"));
//                services.setSerDescription(rs.getString("serDescription"));
//                services.setCateId(rs.getInt("cateId"));
//                services.setSupplierId(rs.getInt("supplierId"));
//                services.setQuantity(rs.getInt("quantity"));
//                services.setPrice(rs.getInt("price"));
//                services.setWorkDate(rs.getString("workDate"));
//                services.setReleaseDate(rs.getString("releaseDate"));
//                services.setSerImage(rs.getString("serImage"));
//                services.setSerStatus(rs.getString("serStatus"));
//                list.add(services);
//            }
//            //closing the connection 
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    public List<Service> getServicesByCategory(String cateId) {
        List<Service> result = new ArrayList<>();
        String query = "select * from Service "
                + "where Category_ID = ?";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, cateId);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int categoryID = 0;
            int supplierID = 0;
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            result = new ArrayList<Service>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                categoryID = rs.getInt("Category_ID");
                supplierID = rs.getInt("Supplier_ID");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryID, supplierID, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            Category dto = null;

            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                dto = new Category(id, name);
                list.add(dto);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Service getLast() {
        String query = "select top 1 * from Service\n"
                + "order by ID desc";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int price = 0;
            String image = "";
            Service dto = null;

            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                price = rs.getInt("Price");
                image = rs.getString("Image");
                dto = new Service(id, name, description, price, image);
                return dto;
            }
        } catch (Exception e) {
        }
        return null;
    }

    //lay 3 service random
    public List<Service> getRandom3Service() {
        List<Service> list = new ArrayList<>();
        String query = "Select top 3 *\n"
                + "From Service\n"
                + "Order by NEWID()";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int cateID = 0;
            int supID = 0;
//            String categoryName = "";
//            String supplierName = "";
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            list = new ArrayList<Service>();

            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                cateID = rs.getInt("Category_ID");
                supID = rs.getInt("Supplier_ID");
//                categoryName = rs.getString("CategoryName");
//                supplierName = rs.getString("SupplierName");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, cateID, supID, quantity, price, workTime, releaseTime, image, status);
                list.add(dto);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static boolean reqService(int accID, String serName, int quantity, int price, String releaseDate, int categoryID, String description) throws Exception {
        Connection cn = utils.DBUtils.makeConnection();
        boolean flag = false;
        int suppID = getSuppID(accID);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date date = new Date(System.currentTimeMillis());

        if (cn != null) {
            String sql = "INSERT INTO Service(Name,Description,Category_ID,Supplier_ID,Quantity,Price,Working_Time,Release_Time,Status)\n"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serName);
            pst.setString(2, description);
            pst.setInt(3, categoryID);
            pst.setInt(4, suppID);
            pst.setInt(5, quantity);
            pst.setInt(6, price);
            pst.setString(7, "8h00 - 22h00");
            pst.setDate(8, date);
            pst.setString(9, "Waiting");

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

    public static int getSuppID(int accID) {
        String query = "select Supplier.ID\n"
                + "from Supplier, Account\n"
                + "where (Account.ID = Supplier.Account_ID and Account.ID = ?)";
        int SuppID = 0;
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, accID);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                SuppID = rs.getInt("ID");
            }
        } catch (Exception e) {
        }
        return SuppID;
    }

    public List<Service> servicePaging(String index) {
        List<Service> result = new ArrayList<>();
        String query = "with x as( select ROW_NUMBER() over (order by ID asc) as r "
                + ",* from Service where Status like 'available') "
                + "select * from x where r between ?*12-11 and ?*12";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, index);
            pst.setString(2, index);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int categoryID = 0;
            int supplierID = 0;
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            result = new ArrayList<Service>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                categoryID = rs.getInt("Category_ID");
                supplierID = rs.getInt("Supplier_ID");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryID, supplierID, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List<Service> sortServiceAscByPrice(String index) {
        List<Service> result = new ArrayList<>();
        String query = "with x as( select ROW_NUMBER() over (order by Price asc) as r "
                + ",* from Service where Status like 'available') "
                + "select * from x where r between ?*12-11 and ?*12";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, index);
            pst.setString(2, index);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int categoryID = 0;
            int supplierID = 0;
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            result = new ArrayList<Service>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                categoryID = rs.getInt("Category_ID");
                supplierID = rs.getInt("Supplier_ID");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryID, supplierID, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List<Service> sortServiceAscByPriceAndCate(String cateId, String index) {
        List<Service> result = new ArrayList<>();
        String query = "with x as( select ROW_NUMBER() over (order by Price asc) as r "
                + ",* from Service where Status like 'available' and Category_ID = ?) "
                + "select * from x where r between ?*12-11 and ?*12";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, cateId);
            pst.setString(2, index);
            pst.setString(3, index);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int categoryID = 0;
            int supplierID = 0;
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            result = new ArrayList<Service>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                categoryID = rs.getInt("Category_ID");
                supplierID = rs.getInt("Supplier_ID");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryID, supplierID, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List<Service> sortServiceBySupp(String index) {
        List<Service> result = new ArrayList<>();
        String query = "with x as( select ROW_NUMBER() over (order by Supplier_ID asc) as r "
                + ",* from Service where Status like 'available') "
                + "select * from x where r between ?*12-11 and ?*12";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, index);
            pst.setString(2, index);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int categoryID = 0;
            int supplierID = 0;
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            result = new ArrayList<Service>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                categoryID = rs.getInt("Category_ID");
                supplierID = rs.getInt("Supplier_ID");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryID, supplierID, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List<Service> sortServiceBySuppAndCate(String cateId, String index) {
        List<Service> result = new ArrayList<>();
        String query = "with x as( select ROW_NUMBER() over (order by Supplier_ID asc) as r "
                + ",* from Service where Status like 'available' and Category_ID = ?) "
                + "select * from x where r between ?*12-11 and ?*12";
        try {
            Connection cn = DBUtils.makeConnection();
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, cateId);
            pst.setString(2, index);
            pst.setString(3, index);
            ResultSet rs = pst.executeQuery();
            int id = 0;
            String name = "";
            String description = "";
            int categoryID = 0;
            int supplierID = 0;
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            result = new ArrayList<Service>();
            while (rs.next()) {
                id = rs.getInt("ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                categoryID = rs.getInt("Category_ID");
                supplierID = rs.getInt("Supplier_ID");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryID, supplierID, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } catch (Exception e) {
        }
        return result;
    }
}
