/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ServiceController", urlPatterns = {"/ServiceController"})
public class ServiceController extends HttpServlet {

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
        String action = (String) request.getAttribute("action");
        String controller = (String) request.getAttribute("controller");
        String op = request.getParameter("op");
        switch (action) {
            case "cate1": {
                if (op != null) {
                    if (op.equals("search")) {
                        searchList(request, response, "cate1");
                    }
                    if (op.equals("addToCart")) {
                        addHandler(request, response);
                        list(request, response, "cate1");
                    }
                } else {
                    list(request, response, "cate1");
                }
            }
            break;
            case "cate2": {
                if (op != null) {
                    if (op.equals("search")) {
                        searchList(request, response, "cate2");
                    }
                    if (op.equals("addToCart")) {
                        addHandler(request, response);
                        list(request, response, "cate2");
                    }
                } else {
                    list(request, response, "cate2");
                }
            }
            break;
            case "cate3": {
                if (op != null) {
                    if (op.equals("search")) {
                        searchList(request, response, "cate3");
                    }
                    if (op.equals("addToCart")) {
                        addHandler(request, response);
                        list(request, response, "cate3");
                    }
                } else {
                    list(request, response, "cate3");
                }
            }
            break;
            case "cate4": {
                if (op != null) {
                    if (op.equals("search")) {
                        searchList(request, response, "cate4");
                    }
                    if (op.equals("addToCart")) {
                        addHandler(request, response);
                        list(request, response, "cate4");
                    }
                } else {
                    list(request, response, "cate4");
                }
            }
            case "cate5": {
                if (op != null) {
                    if (op.equals("search")) {
                        searchList(request, response, "cate5");
                    }
                    if (op.equals("addToCart")) {
                        addHandler(request, response);
                        list(request, response, "cate5");
                    }
                } else {
                    list(request, response, "cate5");
                }
            }
            case "cate6": {
                if (op != null) {
                    if (op.equals("search")) {
                        searchList(request, response, "cate6");
                    }
                    if (op.equals("addToCart")) {
                        addHandler(request, response);
                        list(request, response, "cate6");
                    }
                } else {
                    list(request, response, "cate6");
                }
            }
            break;
            default:
                //chuyen den trang thong bao loi
                request.setAttribute("controller", "error");
                request.setAttribute("action", "index");
                request.setAttribute("message", "Error when proccessing the request");
        }
        request.getRequestDispatcher(config.Config.LAYOUT).forward(request, response);
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
