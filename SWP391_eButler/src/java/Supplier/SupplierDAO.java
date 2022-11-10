/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supplier;

import Order.Order;
import Service.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class SupplierDAO {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

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

    public List<Service> getListWaitingServiceForSupp() throws Exception {
        List<Service> result = null;
        try {
            String sql2 = "Select Service.ID, Service.Name, Service.Description, Category.Name as CategoryName, Supplier.Supplier_Name as SupplierName, Service.Quantity, Service.Price, Service.Working_Time, Service.Release_Time, Service.Image, Service.Status\n"
                    + "from Service, Category, Supplier\n"
                    + "where ( Service.Category_ID = Category.ID and Service.Supplier_ID = Supplier.ID and Service.Status like 'Waiting')";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql2);
            rs = preStm.executeQuery();

            int id = 0;
            String name = "";
            String description = "";
            String categoryName = "";
            String supplierName = "";
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
                categoryName = rs.getString("CategoryName");
                supplierName = rs.getString("SupplierName");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryName, supplierName, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public Service getServiceByID(String id) throws Exception {
        Service dto = null;
        int serID = Integer.parseInt(id);
        try {
            String sql = "Select * From Service Where ID = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, serID);
            rs = preStm.executeQuery();
            String name = "";
            String des = "";
            int price = 0;
            int sup = 0;
            int cate = 0;
            int quantity = 0;
            String wt = "";
            String rt = "";
            String image = "";
            String status = "";
            if (rs.next()) {
                name = rs.getString("Name");
                des = rs.getString("Description");
                cate = rs.getInt("Category_ID");
                sup = rs.getInt("Supplier_ID");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                wt = rs.getString("Working_Time");
                rt = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(serID, name, des, cate, sup, quantity, price, wt, rt, image, status);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<Service> getListServiceForSupp() throws Exception {
        List<Service> result = null;
        try {
            String sql = "Select * From Service Where Supplier_ID = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            int id = 0;
            String name = "";
            String description = "";
            String categoryName = "";
            String supplierName = "";
            int quantity = 0;
            int price = 0;
            String workTime = "";
            String releaseTime = "";
            String image = "";
            String status = "";
            Service dto = null;
            result = new ArrayList<Service>();

            while (rs.next()) {
                id = rs.getInt("Supplier_ID");
                name = rs.getString("Name");
                description = rs.getString("Description");
                categoryName = rs.getString("CategoryName");
                supplierName = rs.getString("SupplierName");
                quantity = rs.getInt("Quantity");
                price = rs.getInt("Price");
                workTime = rs.getString("Working_Time");
                releaseTime = rs.getString("Release_Time");
                image = rs.getString("Image");
                status = rs.getString("Status");
                dto = new Service(id, name, description, categoryName, supplierName, quantity, price, workTime, releaseTime, image, status);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<Order> getListOrderForSupp() throws Exception {
        List<Order> result = null;
        try {
            String sql = "Select Orders.ID, Account.Name as AccountName, Orders.Order_Address,"
                    + " Orders.Order_Email, Orders.Order_TIme, Orders.Order_Status,"
                    + " Orders.Total_Price from Orders, Account where ( Orders.Account_ID = Account.ID and Service.Status like 'Done' or 'reject')";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            int id = 0;
            String accName = "";
            String orderAddress = "";
            String orderEmail = "";
            String orderTime = "";
            String orderStatus = "";
            int totalPrice = 0;
            Order dto = null;
            result = new ArrayList<Order>();

            while (rs.next()) {
                id = rs.getInt("ID");
                accName = rs.getString("AccountName");
                orderAddress = rs.getString("Order_Address");
                orderEmail = rs.getString("Order_Email");
                orderTime = rs.getString("Order_Time");
                orderStatus = rs.getString("Order_Status");
                totalPrice = rs.getInt("Total_Price");
                dto = new Order(id, accName, orderAddress, orderEmail, orderTime, orderStatus, totalPrice);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<Order> getListOrderForManage() throws Exception {
        List<Order> result = null;
        try {
            String sql = "Select Orders.ID, Account.Name as AccountName, Orders.Order_Address,"
                    + " Orders.Order_Email, Orders.Order_TIme, Orders.Order_Status,"
                    + " Orders.Total_Price from Orders, Account where ( Orders.Account_ID = Account.ID and Service.Status like 'waiting' or 'Processing')";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            int id = 0;
            String accName = "";
            String orderAddress = "";
            String orderEmail = "";
            String orderTime = "";
            String orderStatus = "";
            int totalPrice = 0;
            Order dto = null;
            result = new ArrayList<Order>();

            while (rs.next()) {
                id = rs.getInt("ID");
                accName = rs.getString("AccountName");
                orderAddress = rs.getString("Order_Address");
                orderEmail = rs.getString("Order_Email");
                orderTime = rs.getString("Order_Time");
                orderStatus = rs.getString("Order_Status");
                totalPrice = rs.getInt("Total_Price");
                dto = new Order(id, accName, orderAddress, orderEmail, orderTime, orderStatus, totalPrice);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

}
