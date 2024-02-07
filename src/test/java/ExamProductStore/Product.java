package ExamProductStore;

public class Product {
    int ID;
    String categoryName = "";
    String deviceName = "";
    int devicePrice = 0 ;

    public Product(int id , String cn ,String dn , int dp){
        this.ID = id;
        this.categoryName = cn;
        this.deviceName = dn;
        this.devicePrice = dp;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(int devicePrice) {
        this.devicePrice = devicePrice;
    }
}
