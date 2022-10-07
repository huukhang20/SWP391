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
public class OrderDetail {
    private int orderDetailId;
    private int orderId;
    private int serId;
    private int price;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int orderId, int serId, int price, int quantity) {
        this.orderId = orderId;
        this.serId = serId;
        this.price = price;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getSerId() {
        return serId;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setSerId(int serId) {
        this.serId = serId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
