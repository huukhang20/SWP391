/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebutler.beans;

import ebutler.dao.AccessDAO;
import Account.Account;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class AccountBean implements Serializable {

    private String username, password;
    private Account accountDTO;

    public AccountBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccountDTO() {
        return accountDTO;
    }

    public void setAccountDTO(Account accountDTO) {
        this.accountDTO = accountDTO;
    }

    public String checkLogin() throws Exception {
        AccessDAO dao = new AccessDAO();
        return dao.checkLogin(username, password);
    }

    public boolean createUser() throws Exception {
        AccessDAO dao = new AccessDAO();
        return dao.registerUser(accountDTO);
    }

}
