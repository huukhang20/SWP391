/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(urlPatterns = {"/cartcontroller"})
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
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String action = (String) request.getAttribute("action");
//        String controller = (String) request.getAttribute("controller");
//        String op = request.getParameter("op");
//        if (op != null) {
//            if (op.equals("delete")) {
//                removeFromCart(request, response);
//            } else if (op.equals("addInvoice")) {
//                try {
//                    String[] cartId = request.getParameterValues("id");
//                    String[] size = request.getParameterValues("size");
//                    String[] quantity = request.getParameterValues("quantity");
//                    String invoiceId = generateRandomChars();
//                    Float total_price = Float.valueOf(request.getParameter("total_price"));
//                    Date payDate = new Date(System.currentTimeMillis());
//
//                    HttpSession session = request.getSession();
//                    Customers customer = (Customers) session.getAttribute("LOGIN_CUSTOMER");
//                    if (customer == null) {
//                        request.setAttribute("controller", "user");
//                        request.setAttribute("action", "login");
//                        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
//                        return;
//                    }
//                    InvoiceManager invoiceManager = new InvoiceManager();
//                    Invoice invoice = new Invoice();
//                    InvoiceDetail invoiceDetail = new InvoiceDetail();
//                    invoice.setInvoiceId(invoiceId);
//                    invoice.setDate(payDate);
//                    invoice.setTotalPrice(total_price);
//                    invoice.setCustomer(customer);
//                    invoiceDetail.setInvoice(invoice);
//                    Shoes shoe = null;
//                    ArrayList<Shoes> shoes = new ArrayList<>();
//                    for (int i = 0; i < shoesId.length; i++) {
//                        shoe = new Shoes();
//                        shoe.setShoeId(shoesId[i]);
//                        shoe.setAmount(Integer.valueOf(quantity[i]));
//                        shoe.setSize(Integer.valueOf(size[i]));
//                        shoes.add(shoe);
//                    }
//                    invoiceDetail.setShoe(shoes);
//                    if (invoiceManager.add(invoice, invoiceDetail)) {
//                        session = request.getSession();
//                        session.setAttribute("cart",null);
//                        request.setAttribute("controller", "invoice");
//                        request.setAttribute("action", "detail");
//                        request.setAttribute("invoiceId", invoiceId);
//                        request.setAttribute("customerId", customer.getCustomerId());
//                        request.getRequestDispatcher("/invoice").forward(request, response);
//                        return;
//                    }
//                } catch (SQLException ex) {
//                    request.setAttribute("controller", "error");
//                    request.setAttribute("action", "index");
//                    request.setAttribute("message", ex.getMessage());
//                }
//            }
//        }
//        request.getRequestDispatcher(Config.LAYOUT).forward(request, response);
//    }
//
//    protected void removeFromCart(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String id = request.getParameter("id");
//        HttpSession session = request.getSession();
//        Cart cart = (Cart) session.getAttribute("cart");
//        ArrayList<Shoes> cartList = cart.getCartList();
//        Iterator<Shoes> iter = cartList.iterator();
//        while (iter.hasNext()) {
//            Shoes shoes = iter.next();
//            if (shoes.getShoeId().equals(id)) {
//                iter.remove();
//            }
//        }
//        cart.setCartList(cartList);
//        session.setAttribute("cart", cart);
//    }

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
