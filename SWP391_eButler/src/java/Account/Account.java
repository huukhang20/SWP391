package Account;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Account {
    private int accID;
    private String password;
    private int role;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String introduce;
    private String image;
    private int isStatus;

    public Account() {
    }

    public Account(int accID, String password, int role, String name, String phone, String email, String address, String introduce, String image, int isStatus) {
        this.accID = accID;
        this.password = password;
        this.role = role;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.introduce = introduce;
        this.image = image;
        this.isStatus = isStatus;
    }

    public int getAccID() {
        return accID;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getImage() {
        return image;
    }

    public int getIsStatus() {
        return isStatus;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIsStatus(int isStatus) {
        this.isStatus = isStatus;
    }
    
    
}
