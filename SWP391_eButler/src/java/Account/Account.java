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
    private String username;
    private String password;
    private int role;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String introduce;
    private String image;
    private String isStatus;

    public Account() {
    }

    public Account(int accID) {
        this.accID = accID;
    }

    public Account(String email) {
        this.email = email;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int accID, String username, int role, String name, String phone, String email, String address, String introduce, String image, String isStatus) {
        this.accID = accID;
        this.username = username;
        this.role = role;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.introduce = introduce;
        this.image = image;
        this.isStatus = isStatus;
    }

    public Account(int accID, String username, String password, int role, String name, String phone, String email, String address, String introduce, String image, String isStatus) {
        this.accID = accID;
        this.username = username;
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

    public Account(String username, String password, int role, String name, String phone, String email, String address, String introduce, String image, String isStatus) {
        this.username = username;
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

    public void setAccID(int accID) {
        this.accID = accID;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(String isStatus) {
        this.isStatus = isStatus;
    }

    @Override
    public String toString() {
        return "Account{" + "accID=" + accID + ", username=" + username + ", password=" + password + ", role=" + role + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", introduce=" + introduce + ", image=" + image + ", isStatus=" + isStatus + '}';
    }

}
