/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Service.Service;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDetail {
    private Order order;
    private List<Service> service;
    private int price;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(Order order, List<Service> service) {
        this.order = order;
        this.service = service;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetail(Order order, List<Service> service, int price, int quantity) {
        this.order = order;
        this.service = service;
        this.price = price;
        this.quantity = quantity;
    }

    


    
    
}
