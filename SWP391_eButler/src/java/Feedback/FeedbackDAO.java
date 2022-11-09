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
import javax.swing.JOptionPane;
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
            String sql = "SELECT ID, Title, Description, Req_Time, Account_ID, Type, Status from Feedback Where Type = 'Feedback'";
            Statement st = cn.createStatement();
            ResultSet table = st.executeQuery(sql);
            if (table != null) {
                while (table.next()) {
                    int ID = table.getInt("ID");
                    String title = table.getString("Title");
                    String description = table.getString("Description");
                    String reqTime = table.getString("Req_Time");
                    int accId = table.getInt("Account_ID");
                    String type = table.getString("Type");
                    int status = table.getInt("Status");
                    Feedback feedback = new Feedback(ID, title, description, reqTime, accId, type, status);
                    list.add(feedback);
                }
            }
            cn.close();
        }
        return list;
    }

    //set status cho feedback
    public static boolean updateFeedbackStatus(String feedbackId, String feedbackStatus) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "UPDATE Feedback\n"
                    + "SET Status=?\n"
                    + "WHERE ID=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, feedbackStatus);
            pst.setString(2, feedbackId);
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

    //delete feedback
    public static boolean deleteFeedback(String feedbackId) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "DELETE FROM DBO.Feedbacks\n"
                    + "WHERE feedbackId=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, feedbackId);
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

    //create feedback
    public static boolean createFeedbacks(String feedbackTitle, String feedbackDescription, String reqTime, int accID, int status) throws Exception {
        Connection cn = DBUtils.makeConnection();
        boolean flag = false;
        if (cn != null) {
            String sql = "INSERT INTO DBO.Feedback(Title,Description,Req_Time,Account_ID,Status)\n"
                    + "VALUES(?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, feedbackTitle);
            pst.setString(2, feedbackDescription);
            pst.setString(3, reqTime);
            pst.setInt(4, accID);
            pst.setInt(5, status);
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
