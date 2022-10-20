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
    private String serStatus;

    public Service() {
    }

    public Service(int serID, String serName, String serDescription, int cateId, int supplierId, int quantity, int price, String workDate, String releaseDate, String serImage, String serStatus) {
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

    public void setSerID(int serID) {
        this.serID = serID;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getSerDescription() {
        return serDescription;
    }

    public void setSerDescription(String serDescription) {
        this.serDescription = serDescription;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSerImage() {
        return serImage;
    }

    public void setSerImage(String serImage) {
        this.serImage = serImage;
    }

    public String getSerStatus() {
        return serStatus;
    }

    public void setSerStatus(String serStatus) {
        this.serStatus = serStatus;
    }

    @Override
    public String toString() {
        return "Service{" + "serID=" + serID + ", serName=" + serName + ", serDescription=" + serDescription + ", price=" + price + '}';
    }
    
}
