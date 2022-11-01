/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Order {

    private int orderId;
    private int accID;
    private String accName;
    private String orderAddress;
    private String orderEmail;
    private String orderTime;
    private String orderStatus;
    private int totalPrice;

    public Order() {
    }

    public Order(int orderId, int accID, String orderAddress, String orderEmail, String orderTime, String orderStatus, int totalPrice) {
        this.orderId = orderId;
        this.accID = accID;
        this.orderAddress = orderAddress;
        this.orderEmail = orderEmail;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
    }

    public Order(int orderId, String accName, String orderAddress, String orderEmail, String orderTime, String orderStatus, int totalPrice) {
        this.orderId = orderId;
        this.accName = accName;
        this.orderAddress = orderAddress;
        this.orderEmail = orderEmail;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    private ArrayList<OrderDetail> odtList;

    public ArrayList<OrderDetail> getOdtList() {
        return odtList;
    }

    public void setOdtList(ArrayList<OrderDetail> odtList) {
        this.odtList = odtList;
    }
    
    
    
}
