/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import ebutler.dao.AccessDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private static final String error = "errorLogin.jsp";
    private static final String admin = "admin.jsp";
    private static final String customer = "customer.jsp";
    private static final String supplier = "supplier.jsp";
    private static final String cc = "customercare.jsp";

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
        String url = "afterLogin.jsp";
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            AccessDAO access = new AccessDAO();
            
            String role = access.checkLogin(username, password);
            
            if(role.equals("failed")){
                request.setAttribute("username", username);
                url = "login.jsp";
                request.setAttribute("ERRORLOGIN", "Invalid username or password");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("USERLOGIN", username);
                session.setAttribute("USERROLE", role);
                if(role.equals("admin")){
                    //url = admin;
                } else if (role.equals("customer")) {
                    //url = customer;
                } else if (role.equals("supplier")){
                    //url = supplier;
                } else if (role.equals("cc")){
                    //url = cc;
                } else {
                    request.setAttribute("ERRORLOGIN", "Role doesn't supported!");
                }
            }
            
        } catch (Exception e) {
            log("ERROR at LoginControler: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
