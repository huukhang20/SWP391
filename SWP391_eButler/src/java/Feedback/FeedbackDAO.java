/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

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
public class FeedbackDAO {
        //lay het feedback ra
    public static ArrayList<Feedback> getFeedbacks() throws Exception {
        ArrayList<Feedback> list = new ArrayList<>();
        Connection cn = DBUtils.makeConnection();
        if (cn != null) {
            String sql = "SELECT ID, Title, Service_ID, Description, Req_Time, Account_ID, Status from Feedback where Status = 1";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    int ID = table.getInt("ID");
                    String title = table.getString("Title");
                    int serviceID = table.getInt("Service_ID");
                    String description = table.getString("Description");
                    String reqTime = table.getString("Req_Time");
                    int accId = table.getInt("Account_ID");
                    int status = table.getInt("Status");
                    Feedback feedback = new Feedback(ID, title, serviceID, description, reqTime, accId, status);
                    list.add(feedback);
                }
            }
            cn.close();
        }
        return list;
    }
    
        //set status cho feedback
            public static boolean updateFeedbackStatus(int feedbackId, int feedbackStatus) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "UPDATE Feedback\n"
                    + "SET Status=?\n"
                    + "WHERE ID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, feedbackStatus);
            pst.setInt(2, feedbackId);
            int table = pst.executeUpdate();
            if (table == 1) {
                flag = true;
            } else {
                flag = false;
            }
            cn.close();
        }
        return flag;
    }
}
