/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

/**
 *
 * @author Admin
 */
public class Order {
    private int orderId;
    private int accID;
    private String orderAddress;
    private String orderEmail;
    private String orderTime;
    private int orderStatus;

    public Order() {
    }

    public Order(int accID, String orderAddress, String orderEmail, String orderTime, int orderStatus) {
        this.accID = accID;
        this.orderAddress = orderAddress;
        this.orderEmail = orderEmail;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    public int getAccID() {
        return accID;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public String getOrderEmail() {
        return orderEmail;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public void setOrderEmail(String orderEmail) {
        this.orderEmail = orderEmail;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    
}
