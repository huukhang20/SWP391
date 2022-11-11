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
import Account.Account;
import Service.Service;
import Order.Order;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class AdminControlDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public AdminControlDAO() {
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

    public List<Account> getListAccountForAdmin() throws Exception {
        List<Account> result = null;
        try {
            String sql = "Select ID, Username, Role_ID, Name, Phone, Email, Address, Introduce, Image, IsStatus From Account";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            int id = 0;
            String username = "";
            int role = 0;
            String name = "";
            String phone = "";
            String email = "";
            String address = "";
            String introduce = "";
            String image = "";
            String isStatus = "";
            Account dto = null;
            result = new ArrayList<Account>();

            while (rs.next()) {
                id = rs.getInt("ID");
                username = rs.getString("Username");
                role = rs.getInt("Role_ID");
                name = rs.getString("Name");
                phone = rs.getString("Phone");
                email = rs.getString("Email");
                address = rs.getString("Address");
                introduce = rs.getString("Introduce");
                image = rs.getString("Image");
                isStatus = rs.getString("IsStatus");
                dto = new Account(id, username, role, name, phone, email, address, introduce, image, isStatus);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<Service> getListWaitingServiceForAdmin() throws Exception {
        List<Service> result = null;
        try {
//            String sql = "Select ID, Name, Description, Category_ID, Supplier_ID, Quantity, Price, Working_Time, Release_Time, Image, Status From Service Where Status = 'Waiting'";
            String sql2 = "Select Service.ID, Service.Name, Service.Description, Category.Name as CategoryName, Supplier.Supplier_Name as SupplierName, Service.Quantity, Service.Price, Service.Working_Time, Service.Release_Time, Service.Image, Service.Status\n"
                    + "from Service, Category, Supplier\n"
                    + "where ( Service.Category_ID = Category.ID and Service.Supplier_ID = Supplier.ID and Service.Status like 'Waiting')";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql2);
            rs = preStm.executeQuery();

            int id = 0;
            String name = "";
            String description = "";
//            int categoryID = 0;
//            int supplierID = 0;
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

    public List<Service> getListServiceForAdmin() throws Exception {
        List<Service> result = null;
        try {
            String sql = "Select Service.ID, Service.Name, Service.Description, Category.Name as CategoryName, Supplier.Supplier_Name as SupplierName, Service.Quantity, Service.Price, Service.Working_Time, Service.Release_Time, Service.Image, Service.Status\n"
                    + "from Service, Category, Supplier\n"
                    + "where ( Service.Category_ID = Category.ID and Service.Supplier_ID = Supplier.ID)";
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

    public List<Order> getListOrderForAdmin() throws Exception {
        List<Order> result = null;
        try {
            String sql = "Select Orders.ID, Account.Name as AccountName, Orders.Order_Address,"
                    + " Orders.Order_Email, Orders.Order_TIme, Orders.Order_Status,"
                    + " Orders.Total_Price from Orders, Account where ( Orders.Account_ID = Account.ID)";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            int id = 0;
//            int accID;
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

    public boolean completeFeedback(int id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Feedback Set Status = ? Where ID = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "True");
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean banAccount(int id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Account Set IsStatus = ? Where Username = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "Banned");
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public int countOrder() throws Exception {
        int count = 0;
        try {
            String sql = "Select COUNT(ID) as Counting From Orders";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if(rs.next()){
                count = rs.getInt("Counting");
            }
        } finally {
            closeConnection();
        }
        return count;
    }
    
    public int countOrderDone() throws Exception {
        int count = 0;
        try {
            String sql = "Select COUNT(ID) as Counting From Orders Where Order_Status = 'Done'";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if(rs.next()){
                count = rs.getInt("Counting");
            }
        } finally {
            closeConnection();
        }
        return count;
    }
        
    public int countProfit() throws Exception {
        int count = 0;
        try {
            String sql = "Select SUM(Total_Price) as Counting From Orders";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if(rs.next()){
                count = rs.getInt("Counting");
            }
        } finally {
            closeConnection();
        }
        return count;
    }
    
    public boolean updateRequestService(int id, String stt) throws Exception {
        boolean check = true;
        try {
            String sql = "Update Service Set Status = ? Where ID = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, stt);
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
