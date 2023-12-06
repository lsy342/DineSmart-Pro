package food_system.model;

public class Administrator extends User{
    public Administrator() {
    }

    public Administrator(String userID, String userName, String userPassword, String userAuthority) {
        super(userID, userName, userPassword, userAuthority);
    }
}
