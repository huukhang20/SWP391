/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebutler.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import Feedback.Feedback;
import java.util.ArrayList;
import utils.DBUtils;

/**
 *
 * @author Admin
 */
public class CCControlDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public CCControlDAO() {
    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<Feedback> getFeedbackListCC() throws Exception {
        List<Feedback> result = null;
        try {
            String sql = "Select * From Feedback Where Type = 'Feedback'";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            int ID = 0;
            String title = "";
            String description = "";
            String reqTime = "";
            int accId = 0;
            String type = "";
            int status = -1;
            Feedback dto = null;
            result = new ArrayList<Feedback>();

            while (rs.next()) {
                ID = rs.getInt("ID");
                title = rs.getString("Title");
                description = rs.getString("Description");
                reqTime = rs.getString("Req_Time");
                accId = rs.getInt("Account_ID");
                type = rs.getString("Type");
                status = rs.getInt("Status");
                dto = new Feedback(ID, title, description, reqTime, accId, type, status);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean completeFeedbackCC(int id) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Feedback Set Status = ? Where ID = ?";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "True");
            preStm.setInt(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<Feedback> getComplainListCC() throws Exception {
        List<Feedback> result = null;
        try {
            String sql = "Select Feedback.ID, Title, Feedback.Description, Req_Time, Account_ID, Account.Name as AccountName,"
                    + " Order_ID, Type, Status From Feedback, Account Where (Feedback.Account_ID = Account.ID and Type = 'Complaint')";
            conn = DBUtils.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();

            int ID = 0;
            String title = "";
            String description = "";
            String reqTime = "";
            int accId = 0;
            String accName = "";
            int orderId = 0;
            String type = "";
            int status = -1;
            Feedback dto = null;
            result = new ArrayList<Feedback>();

            while (rs.next()) {
                ID = rs.getInt("ID");
                title = rs.getString("Title");
                description = rs.getString("Description");
                reqTime = rs.getString("Req_Time");
                accId = rs.getInt("Account_ID");
                accName = rs.getString("AccountName");
                orderId = rs.getInt("Order_ID");
                type = rs.getString("Type");
                status = rs.getInt("Status");
                dto = new Feedback(ID, title, description, reqTime, accId, accName, orderId, type, status);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
