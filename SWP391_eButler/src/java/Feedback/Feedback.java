/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Feedback implements Serializable {

    private int ID;
    private String title;
    private String description;
    private String reqTime;
    private int accId;
    private int orderId;
    private String type;
    private int status;

    public Feedback() {
    }

    public Feedback(int ID, String title, String description, String reqTime, int accId, String type, int status) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.reqTime = reqTime;
        this.accId = accId;
        this.type = type;
        this.status = status;
    }

    public Feedback(int ID, String title, String description, String reqTime, int accId, int orderId, String type, int status) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.reqTime = reqTime;
        this.accId = accId;
        this.orderId = orderId;
        this.type = type;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
