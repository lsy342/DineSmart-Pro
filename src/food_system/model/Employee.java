package food_system.model;

public class Employee extends User{
    public Employee() {
    }

    public Employee(String userID, String userName, String userPassword, String userAuthority) {
        super(userID, userName, userPassword, userAuthority);
    }
}
