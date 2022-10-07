/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

/**
 *
 * @author Admin
 */
public class Feedback {
    private int feedbackId;
    private String title;
    private String feedbackDescription;
    private String feedbackReqTime;
    private int accId;
    private int feedbackStatus;

    public Feedback() {
    }

    public Feedback(int feedbackId, String title, String feedbackDescription, String feedbackReqTime, int accId, int feedbackStatus) {
        this.feedbackId = feedbackId;
        this.title = title;
        this.feedbackDescription = feedbackDescription;
        this.feedbackReqTime = feedbackReqTime;
        this.accId = accId;
        this.feedbackStatus = feedbackStatus;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public String getTitle() {
        return title;
    }

    public String getFeedbackDescription() {
        return feedbackDescription;
    }

    public String getFeedbackReqTime() {
        return feedbackReqTime;
    }

    public int getAccId() {
        return accId;
    }

    public int getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFeedbackDescription(String feedbackDescription) {
        this.feedbackDescription = feedbackDescription;
    }

    public void setFeedbackReqTime(String feedbackReqTime) {
        this.feedbackReqTime = feedbackReqTime;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public void setFeedbackStatus(int feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }
    
    
}
