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
        public static ArrayList<Feedbacks> getFeedbacks(String feedbackId) {
        ArrayList<Feedbacks> list = new ArrayList<>();
        //connecting to database
        Connection con = DBUtil.getConnection();
        try {
            //creating and executing sql statements
            String sql = ""
                    + ""
                    + "";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, feedbackId);
            ResultSet rs = stm.executeQuery();
            //Loading data into the list
            while (rs.next()) {
                Feedbacks feedbacks = new Feedbacks();
                feedbacks.setFeedbackId(rs.getInt("feedbackId"));
                feedbacks.setTitle(rs.getString("title"));
                feedbacks.setFeedbackDescription(rs.getString("feedbackDescription"));
                feedbacks.setFeedbackReqTime(rs.getString("feedbackReqTime"));
                feedbacks.setAccId(rs.getInt("accId"));
                feedbacks.setFeedbackStatus(rs.getInt("feedbackStatus"));              
                list.add(feedbacks);
            }
            //closing the connection 
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackController.class.getName()).log(Level.SEVERE, null, ex);
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
