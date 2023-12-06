package food_system.model;

public class User {
    private String userID;
    private String userName;
    private String userPassword;
    private String userAuthority;

    public User() {
    }

    public User(String userID, String userName, String userPassword, String userAuthority) {
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

    public String getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(String userAuthority) {
        this.userAuthority = userAuthority;
    }
}
