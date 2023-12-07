package RestaurantManagementSystem.model;

public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private int userAuthority;

    public User() {
    }

    public User(String userID, String userName, String userPassword, int userAuthority) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAuthority = userAuthority;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(int userAuthority) {
        this.userAuthority = userAuthority;
    }
}
