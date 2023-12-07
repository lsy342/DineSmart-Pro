package RestaurantManagementSystem.model;

public class Material {
    private String materialNo;
    private String materialName;
    private double materialUnitPrice;
    private int materialNumber;
    private String materialDate;
    private String materialType;

    public String getMaterialNo() {
        return materialNo;
    }

    public void setMaterialNo(String materialNo) {
        this.materialNo = materialNo;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public double getMaterialUnitPrice() {
        return materialUnitPrice;
    }

    public void setMaterialUnitPrice(double materialUnitPrice) {
        this.materialUnitPrice = materialUnitPrice;
    }

    public int getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(int materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getMaterialDate() {
        return materialDate;
    }

    public void setMaterialDate(String materialDate) {
        this.materialDate = materialDate;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}
