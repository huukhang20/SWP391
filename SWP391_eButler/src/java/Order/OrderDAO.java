/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Cart.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import javax.naming.NamingException;
import utils.DBUtils;



/**
 *
 * @author Admin
 */
public class OrderDAO {
   public boolean createOrder(String name, String address, 
            Cart cart) 
        throws SQLException, NamingException {
        
        boolean result = false;
        Connection con = null;
        PreparedStatement stmtOrder = null;
        PreparedStatement stmtOrderDetails = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                
                String order = "INSERT INTO orderInfo "
                        + "(Account_ID, Order_Address, Order_Email, Order_TIme, Order_Status, Total_Price) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
                
                String orderDetails = "INSERT INTO orderDetails "
                        + "(Order_ID, Service_ID, Price, Quantity) "
                        + "VALUES (?, ?, ?, ?)";
                
                stmtOrder = con.prepareStatement(order);
                stmtOrderDetails = con.prepareStatement(orderDetails);
                
                con.setAutoCommit(false); // Disable Auto-Commit
                
                // Add Order Info
                
                
                rs = stmtOrder.executeQuery();
                if (rs.next()) {
                    int orderId = rs.getInt("id");

                    // Add Order Details
                    stmtOrderDetails.setInt(1, orderId);
                    Map<Integer, Integer> cartList = cart.getCart();
                    Set<Integer> idSey = cartList.keySet();

                    for (Integer id : idSey) {
                        stmtOrderDetails.setInt(2, id);
                        stmtOrderDetails.setInt(3, cartList.get(id));
                        stmtOrderDetails.executeUpdate();
                    }
                }
                con.commit(); // Commit Change to DB
                result = true;
            }
        } catch (SQLException ex) {
            if (con != null) {
                con.rollback();
            }
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (stmtOrderDetails != null) {
                stmtOrderDetails.close();
            }
            if (stmtOrder != null) {
                stmtOrder.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
