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
            String sql = "SELECT feedbackId,title,feedbackDescription,feedbackReqTime,accId,feedbackStatus from dbo.Feedbacks";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    int feedbackId = table.getInt("feedbackId");
                    String title = table.getString("title");
                    String feedbackDescription = table.getString("feedbackDescription");
                    String feedbackReqTime = table.getString("feedbackReqTime");
                    int accId = table.getInt("accId");
                    int feedbackStatus = table.getInt("feedbackStatus");
                    Feedback fb = new Feedback(feedbackId,title,feedbackDescription,feedbackReqTime,accId,feedbackStatus);
                    list.add(fb);
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
            String sql = "UPDATE DBO.Feedbacks\n"
                    + "SET feedbackStatus=?\n"
                    + "WHERE feedbackId=?";
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
