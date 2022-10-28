/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Account.Account;
import Account.AccountDAO;
import Cart.Cart;
import Order.OrderDAO;
import java.io.IOException;
import java.util.Map;
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
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

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
        String fullName = request.getParameter("fullName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Account account;
        String url;
        HttpSession session = request.getSession();

        try {
            if (session.getAttribute("USERLOGIN") == null) {
                if (AccountDAO.checkEmail(email)) {
                    account = AccountDAO.getAccountByEmail(email);
                } else {
                    String username = email;
                    String password = "1";
                    AccountDAO.insertAccount(username, password, "", phone, email, address);
                }
            }
            if (session != null) {
                Cart cart = (Cart) session.getAttribute("CART");
                if (cart != null) {
                    Map<Integer, Integer> cartList = cart.getCart();
                    if (cartList != null) {
                        OrderDAO dao = new OrderDAO();
                        //boolean result = dao.createOrder(name, address, cart);
                        if (true) {
                            // Order successfully
                            url = "ShowService";
                            session.removeAttribute("CART");
                        } else {

                        }
                    }
                }
            }

        } catch (Exception e) {
        }

        session.removeAttribute("cart");
        response.sendRedirect("ShowService");
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
