/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
//lay het service ra
public class ServiceDAO {

    public static ArrayList<Service> getServices() throws Exception {
        ArrayList<Service> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT [serId],[serName],[serDescription],[cateId],[supplierId],[quantity],[price],[workDate],[releaseDate],[serImage],[serStatus] from dbo.Services";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    int serId = table.getInt("serId");
                    String serName = table.getString("serName");
                    String serDescription = table.getString("serDescription");
                    int cateId = table.getInt("cateId");
                    int supplierId = table.getInt("supplierId");
                    int quantity = table.getInt("quantity");
                    int price = table.getInt("price");
                    String workDate = table.getString("workDate");
                    String releaseDate = table.getString("releaseDate");
                    String serImage = table.getString("serImage");
                    int serStatus = table.getInt("serStatus");
                    Service ser = new Service();
                    list.add(ser);
                }
            }
            cn.close();
        }
        return list;
    }
    
//        public static ArrayList<Services> getServices(String cateID) {
//        ArrayList<Services> list = new ArrayList<>();
//        //connecting to database
//        Connection con = DBUtil.getConnection();
//        try {
//            //creating and executing sql statements
//            String sql = "select s.*, c.name as cateName "
//                    + "from Services s join category c on s.category_id=c.category_id "
//                    + "where s.category_id = ?";
//            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, cateID);
//            ResultSet rs = stm.executeQuery();
//            //Loading data into the list
//            while (rs.next()) {
//                Services services = new Services();
//                Services.setSerId(rs.getString("Serid"));
//                Services.setSerName(rs.getString("Sername"));
//                list.add(Services);
//            }
//            //closing the connection 
//            con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ServicesController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
}
