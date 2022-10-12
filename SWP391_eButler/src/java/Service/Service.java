/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author Admin
 */
public class Service {
    private int serID;
    private String serName;
    private String serDescription;
    private int cateId;
    private int supplierId;
    private int quantity;
    private int price;
    private String workDate;
    private String releaseDate;
    private String serImage;
    private int serStatus;

    public Service() {
    }

    public Service(int serID, String serName, String serDescription, int cateId, int supplierId, int quantity, int price, String workDate, String releaseDate, String serImage, int serStatus) {
        this.serID = serID;
        this.serName = serName;
        this.serDescription = serDescription;
        this.cateId = cateId;
        this.supplierId = supplierId;
        this.quantity = quantity;
        this.price = price;
        this.workDate = workDate;
        this.releaseDate = releaseDate;
        this.serImage = serImage;
        this.serStatus = serStatus;
    }

    public int getSerID() {
        return serID;
    }

    public String getSerName() {
        return serName;
    }

    public String getSerDescription() {
        return serDescription;
    }

    public int getCateId() {
        return cateId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getWorkDate() {
        return workDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getSerImage() {
        return serImage;
    }

    public int getSerStatus() {
        return serStatus;
    }

    public void setSerID(int serID) {
        this.serID = serID;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public void setSerDescription(String serDescription) {
        this.serDescription = serDescription;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setSerImage(String serImage) {
        this.serImage = serImage;
    }

    public void setSerStatus(int serStatus) {
        this.serStatus = serStatus;
    }
    
    // view Seivice
    @Override
    public String toString() {
        return "Service{" + "serID=" + serID + ", serName=" + serName + ", serDescription=" + serDescription + ", cateId=" + cateId + ", supplierId=" + supplierId + ", quantity=" + quantity + ", price=" + price + ", workDate=" + workDate + ", releaseDate=" + releaseDate + ", serImage=" + serImage + ", serStatus=" + serStatus + '}';
    }
    
    
}
