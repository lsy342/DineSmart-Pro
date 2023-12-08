package RestaurantManagementSystem.model;


public class Menu {
    private String menuNo;
    private String menuName;
    private double menuPrice;

    public Menu() {
    }

    public Menu(String menuNo, String menuName, double menuPrice) {
        this.menuNo = menuNo;
        this.menuName = menuName;
        this.menuPrice = menuPrice;

    }

    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(double menuPrice) {
        this.menuPrice = menuPrice;
    }
}
