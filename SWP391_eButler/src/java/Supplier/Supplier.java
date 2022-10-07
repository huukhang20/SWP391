/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Supplier;

/**
 *
 * @author Admin
 */
public class Supplier {
    private int supplierId;
    private int accId;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;
    private int supplierStatus;

    public Supplier() {
    }

    public Supplier(int supplierId, int accId, String supplierName, String supplierAddress, String supplierPhone, int supplierStatus) {
        this.supplierId = supplierId;
        this.accId = accId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
        this.supplierStatus = supplierStatus;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public int getAccId() {
        return accId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public int getSupplierStatus() {
        return supplierStatus;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    public void setSupplierStatus(int supplierStatus) {
        this.supplierStatus = supplierStatus;
    }
    
    
    
}
