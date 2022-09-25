/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

/**
 *
 * @author Admin
 */
public class Cart {
    private int cartId;
    private int accId;
    private int serId;
    private String serName;
    private int quantity;
    private int price;
    private int totalPrice;
    private int cartStatus;

    public Cart() {
    }

    public Cart(int cartId, int accId, int serId, String serName, int quantity, int price, int totalPrice, int cartStatus) {
        this.cartId = cartId;
        this.accId = accId;
        this.serId = serId;
        this.serName = serName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.cartStatus = cartStatus;
    }

    public int getCartId() {
        return cartId;
    }

    public int getAccId() {
        return accId;
    }

    public int getSerId() {
        return serId;
    }

    public String getSerName() {
        return serName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int getCartStatus() {
        return cartStatus;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setSerId(int serId) {
        this.serId = serId;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCartStatus(int cartStatus) {
        this.cartStatus = cartStatus;
    }
    
    
}
