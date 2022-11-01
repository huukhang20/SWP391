/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import Service.ServiceDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author Admin
 */
public class Cart implements Serializable{
    
    private Map<Integer, Integer> cart;

    public Map<Integer, Integer> getCart() {
        return cart;
    }

    public void addToCart(int serId, int quantity) {
        // 1. Check existed cart
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        
        // 2. Check existed book
        if (this.cart.containsKey(serId)) {
            quantity = this.cart.get(serId) + quantity;
        }
        
        // 3. Update cart
        this.cart.put(serId, quantity);
    }
    
    public void removeFromCart(int serId) {
        // 1. Check existed cart
        if (this.cart == null) {
            return;
        }
        
        // 2. Check existed book
        if (this.cart.containsKey(serId)) {
            this.cart.remove(serId);
            if (this.cart.isEmpty()) {
                this.cart = null;
            }
        }
    }
    
    public int orderTotal() throws SQLException{
        int total = 0;
        for (Map.Entry<Integer, Integer> e : cart.entrySet()){
            int price = ServiceDAO.find(e.getKey().toString()).getPrice();
            total = total + price * e.getValue();
        }            
        return total;
    }
}
