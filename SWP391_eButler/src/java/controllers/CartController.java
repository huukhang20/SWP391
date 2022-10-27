/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Cart.Cart;
import Service.Service;
import Service.ServiceDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

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
        try {
            String op = request.getParameter("op");
            String strSerId = request.getParameter("serId");
            String strQuantity = request.getParameter("quantity");
            switch (op) {
                case "add":
                    if (strSerId != null && strQuantity != null) {
                        int serId = Integer.parseInt(strSerId);
                        int quantity = Integer.parseInt(strQuantity);
                        HttpSession session = request.getSession();
                        Cart cart = (Cart) session.getAttribute("cart");
                        if (cart == null) {
                            cart = new Cart();
                        }
                        cart.addToCart(serId, quantity);
                        session.setAttribute("cart", cart);
                    }
                    response.sendRedirect("cart.jsp");
                    break;
                case "remove":
                    HttpSession session = request.getSession(false);
                    if (session != null) {
                        Cart cart = (Cart) session.getAttribute("cart");
                        if (cart != null) {
                            Map<Integer, Integer> cartList = cart.getCart();
                            if (cartList != null) {
                                String[] bookList = request.getParameterValues("isRemove");
                                if (bookList != null && bookList.length > 0) {
                                    for (String strId : bookList) {
                                        int id = Integer.parseInt(strId);
                                        cart.removeFromCart(id);
                                    }
                                    session.setAttribute("cart", cart);
                                }
                            }

                        }
                    }
                    response.sendRedirect("cart.jsp");
                    break;
            }
        } catch (Exception e) {
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
