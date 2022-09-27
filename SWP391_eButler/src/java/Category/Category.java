/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Category;

/**
 *
 * @author Admin
 */
public class Category {
    private int cateId;
    private String cateName;
    private String cateDescription;
    private int cateStatus;

    public Category() {
    }

    public Category(int cateId, String cateName) {
        this.cateId = cateId;
        this.cateName = cateName;
    }
    
    public Category(int cateId, String cateName, String cateDescription, int cateStatus) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.cateDescription = cateDescription;
        this.cateStatus = cateStatus;
    }

    public int getCateId() {
        return cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public String getCateDescription() {
        return cateDescription;
    }

    public int getCateStatus() {
        return cateStatus;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public void setCateDescription(String cateDescription) {
        this.cateDescription = cateDescription;
    }

    public void setCateStatus(int cateStatus) {
        this.cateStatus = cateStatus;
    }
    
    
}
