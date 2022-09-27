/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

// Phan register co gi ong tham khao thu
//    private static final String REGISTER = "INSERT into customers VALUES (?,?,?,?,?);";
//    private static final String CHECK_DUPLICATE_USERNAME = "SELECT * FROM customers WHERE username = ?";
//
//   public boolean register(Customers customer) throws SQLException {
//        Connection con = DBUtil.getConnection();
//        if (con != null) {
//            PreparedStatement ps = con.prepareStatement(REGISTER);
//            ps.setString(1, customer.getName());
//            ps.setString(2, customer.getUsername());
//            ps.setInt(3, customer.getGender());
//            ps.setString(4, customer.getAddress());
//            ps.setString(5, customer.getPassword());
//            if (ps.executeUpdate() > 0) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean checkDuplicateUsername(String username) throws SQLException {
//        Connection con = DBUtil.getConnection();
//        if (con != null) {
//            PreparedStatement ps = con.prepareStatement(CHECK_DUPLICATE_USERNAME);
//            ps.setString(1, username);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                return true;
//            }
//        }
//        return false;
//    }