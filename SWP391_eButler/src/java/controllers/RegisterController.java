/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Account.Account;
import ebutler.beans.AccountBean;
import ebutler.dao.AccessDAO;
import ebutler.dao.AccountErrorObject;
import java.io.IOException;
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

    private static final String fail = "register.jsp";
    private static final String success = "login.jsp";

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
        String url = fail;
        try {
            String username = request.getParameter("txtUsername");
            String name = request.getParameter("txtName");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");

            AccessDAO dao = new AccessDAO();

            AccountErrorObject errorObj = new AccountErrorObject();
            boolean valid = true;

            if (username.length() == 0) {
                errorObj.setUsernameError("Username can't be blank!");
                valid = false;
            } else if (username.length() > 20) {
                errorObj.setUsernameError("Username must less than 20 letters!");
                valid = false;
            }

            if (name.length() == 0) {
                errorObj.setNameError("Name can't be blank!");
                valid = false;
            } else if (name.length() > 100) {
                errorObj.setNameError("Name must less than 100 letters!");
                valid = false;
            }

            if (email.length() == 0) {
                errorObj.setEmailError("Email can't be blank!");
                valid = false;
            } else if (email.length() > 50) {
                errorObj.setEmailError("Email must less than 50 letters!");
                valid = false;
            }

            if (phone.length() == 0) {
                errorObj.setPhoneError("Phone can't be blank!");
                valid = false;
            } else if (phone.length() > 15) {
                errorObj.setPhoneError("Phone must less than 15 letters!");
                valid = false;
            }

            if (password.length() == 0) {
                errorObj.setPasswordError("Password can't be blank!");
                valid = false;
            } else if (password.length() > 50) {
                errorObj.setPasswordError("Password must less than 50 letters!");
                valid = false;
            }

            if (confirm.length() == 0) {
                errorObj.setConfirmError("Confirm password can't be blank!");
                valid = false;
            } else if (!confirm.matches(password)) {
                errorObj.setConfirmError("Confirm password must match password!");
                valid = false;
            }

            if (valid) {
                Account dto = new Account(username, password, 2, name, phone, email, null, null, null, "active");
                boolean checkDup = dao.checkDuplicateUsername(username);

                if (checkDup) {
                    errorObj.setUsernameError("Username is existed!");
                    request.setAttribute("INVALID", errorObj);
                } else {
                    AccountBean beans = new AccountBean();
                    beans.setAccountDTO(dto);
                    boolean check = beans.createUser();

                    if (check == true) {
                        url = success;
                    }
                }
            } else {
                request.setAttribute("INVALID", errorObj);
                url = fail;
            }

        } catch (Exception e) {
            log("ERROR at RegisterController: " + e.getMessage());
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
