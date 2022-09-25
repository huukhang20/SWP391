/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Service.Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
}
