/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import Account.Account;
import Account.AccountDAO;
import Cart.Cart;
import Service.ServiceDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.naming.NamingException;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class OrderDAO {

    public boolean createOrder(String email, String address,
            Cart cart)
            throws SQLException, NamingException, Exception {
        Date date = new Date(System.currentTimeMillis());
        boolean result = false;
        Connection con = null;
        PreparedStatement stmtOrder = null;
        PreparedStatement stmtOrderDetails = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {

                String orderInfo = "INSERT INTO [Orders] "
                        + "OUTPUT INSERTED.id "
                        + "VALUES (?, ?, ?, ?, ?, ?)";

                String orderDetails = "INSERT INTO [OrderDetail] "
                        + "VALUES (?, ?, ?, ?)";

                stmtOrder = con.prepareStatement(orderInfo);
                stmtOrderDetails = con.prepareStatement(orderDetails);

                con.setAutoCommit(false); // Disable Auto-Commit

                // Add Order Info
                int accID = AccountDAO.getAccountByEmail(email).getAccID();
                stmtOrder.setInt(1, accID);
                stmtOrder.setString(2, address);
                stmtOrder.setString(3, email);
                stmtOrder.setDate(4, date);
                stmtOrder.setString(5, "Processing");
                stmtOrder.setInt(6, cart.orderTotal());

                rs = stmtOrder.executeQuery();
                if (rs.next()) {
                    int orderId = rs.getInt("id");

                    // Add Order Details
                    stmtOrderDetails.setInt(1, orderId);
                    Map<Integer, Integer> cartList = cart.getCart();
                    Set<Integer> idSey = cartList.keySet();

                    for (Integer id : idSey) {
                        stmtOrderDetails.setInt(2, id);
                        stmtOrderDetails.setInt(3, ServiceDAO.find(id.toString()).getPrice());
                        stmtOrderDetails.setInt(4, cartList.get(id));
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
        } finally {
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

    public static ArrayList<Order> getOrderList(Account account) throws Exception {
        ArrayList<Order> list = new ArrayList<>();

        int accID = account.getAccID();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [Orders].* \n"
                    + "FROM [Orders] \n"
                    + "WHERE Account_ID = ? and (Order_Status like 'Dang xu ly' or Order_Status like 'Done')";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, accID);
            ResultSet table = pst.executeQuery();
            while (table.next()) {
                Order order = new Order();
                order.setOrderId(table.getInt("ID"));
                order.setAccID(table.getInt("Account_ID"));
                order.setOrderAddress(table.getString("Order_Address"));
                order.setOrderEmail(table.getString("Order_Email"));
                order.setOrderTime(table.getDate("Order_TIme").toString());
                order.setOrderStatus(table.getString("Order_Status"));
                order.setTotalPrice(table.getInt("Total_Price"));
                order.setOdtList(getOrderDetails(order.getOrderId()));
                list.add(order);
            }
            cn.close();
        }
        return list;
    }

    public static ArrayList<OrderDetail> getOrderDetails(int orderID) throws Exception {
        ArrayList<OrderDetail> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [OrderDetail].*\n"
                    + "FROM [OrderDetail]\n"
                    + "WHERE Order_ID = ?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, orderID);
            ResultSet table = pst.executeQuery();
            while (table.next()) {
                OrderDetail od = new OrderDetail();
                od.setID(table.getInt("ID"));
                od.setOrder_ID(table.getInt("Order_ID"));
                od.setService_ID(table.getInt("Service_ID"));
                od.setPrice(table.getInt("Price"));
                od.setQuantity(table.getInt("Quantity"));
                String serID = Integer.toString(od.getService_ID());
                od.setSerName(ServiceDAO.find(serID).getSerName());
                list.add(od);
            }

            cn.close();
        }
        return list;
    }
    
    public boolean cancelOrder(String orderId) throws Exception{
         Connection cn=DBUtils.makeConnection();
         boolean flag=false;
         if(cn!=null){
             String sql = "UPDATE Orders \n"
                     + "SET Order_Status= 'Cancelled' \n"
                     + "WHERE ID=?";
             PreparedStatement pst=cn.prepareStatement(sql);
             pst.setString(1, orderId);
             int table = pst.executeUpdate();
              if (table == 1) {
                  flag=true;
              }else flag=false;
              cn.close();
         }
          return flag;
     }
}
