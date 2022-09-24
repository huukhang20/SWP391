/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Account.Account;
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
            String sql = "SELECT  from dbo.Services";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {

                    Service ser = new Service();
                    list.add(ser;
                }
            }
            cn.close();
        }
        return list;
    }
}
