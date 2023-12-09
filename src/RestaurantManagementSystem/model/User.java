package RestaurantManagementSystem.model;

public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private boolean userAuthority;

    public User() {
    }

    public User(String userID, String userName, String userPassword, boolean userAuthority) {
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

    public boolean getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(boolean userAuthority) {
        this.userAuthority = userAuthority;
    }
}
