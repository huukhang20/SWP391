/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Order.OrderDAO;
import Order.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "InvoiceController", urlPatterns = {"/InvoiceController"})
public class InvoiceController extends HttpServlet {

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
String action = (String) request.getAttribute("action");
        String controller = (String) request.getAttribute("controller");
        try {
            switch (action) {
                case "list":
                    list(request, response);
                    break;
                case "detail":
                    showDetail(request, response);
                    break;
                default:
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "index");
                    request.setAttribute("message", new AssertionError());
                    break;
            }
        } catch (Exception e) {
            //chuyen den trang thong bao loi
            request.setAttribute("controller", "error");
            request.setAttribute("action", "index");
            request.setAttribute("message", e.getMessage());
        } finally {
//            request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
        }

    }

    private void showDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int orderId = (Integer) request.getAttribute("orderId");
        int serId = (Integer) request.getAttribute("serId");
        OrderDAO od = new OrderDAO();
        OrderDetail oD = od.detail(orderId,serId);
        request.setAttribute("controller", "invoice");
        request.setAttribute("action", "index");
        request.setAttribute("orderDetail", oD);
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        //chua login rang buoc
//        Customers customer = null;
//        if(session != null){
//            customer = (Customers) session.getAttribute("LOGIN_CUSTOMER");
//        }else{
//            request.setAttribute("controller", "user");
//            request.setAttribute("action", "login");
//            return;
//        }        
        OrderDAO od = new OrderDAO();
//        ArrayList<Order> orders = (ArrayList<Order>) od.list(customer.getCustomerId());
        request.setAttribute("controller", "invoice");
        request.setAttribute("action", "index");
        request.setAttribute("list", orders);
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
