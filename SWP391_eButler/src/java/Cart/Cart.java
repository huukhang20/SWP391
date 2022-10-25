/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

import Service.Service;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Cart {
    private ArrayList<Service> cartList = null;

    public Cart() {
        cartList = new ArrayList<>();
    }
    
    public void add(Service service) {
        cartList.add(service);
    }
    
    public void empty() {
        cartList.clear();
    }

    public ArrayList<Service> getCartList() {
        return cartList;
    } 

    public void setCartList(ArrayList<Service> cartList) {
        this.cartList = cartList;
    }
}
