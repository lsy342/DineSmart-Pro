package RestaurantManagementSystem.model;


import java.sql.*;

public class UserDAO {
    public static boolean isValidUser(String account, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "SELECT * FROM user WHERE userID = ? AND userPassword = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, account);
        preparedStatement.setObject(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            //储存用户登录信息
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            User currentUser = new User();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(currentUser, columnLabel, value);
            }
            Main.createUser(currentUser);
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return true;
        } else {
            resultSet.close();
            preparedStatement.close();
            connection.close();
            return false;
        }
    }

    public static void chooseFun(User user, String funName, Object value) {
        switch (funName) {
            case "userName":
                user.setUserName((String) value);
                break;
            case "userAuthority":
                user.setUserAuthority((boolean) value);
                break;
        }
    }
}
