package RestaurantManagementSystem.model;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;

import java.util.List;

public class MenuDAO {
        public static List<Menu> readData(List<Menu> menuList) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "SELECT * FROM `menu`;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Menu menu = new Menu();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(menu, columnLabel, value);
            }
            menuList.add(menu);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return menuList;
    }

    public static void addData(String menuNo, String menuName, double menuPrice) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "INSERT INTO `menu`(menuNo ,menuName, menuPrice) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, menuNo);
        preparedStatement.setObject(2, menuName);
        preparedStatement.setObject(3, menuPrice);


        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            successAlert("add");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(String menuNo, String menuName, double menuPrice) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `menu` SET menuName=?, menuPrice=?  WHERE menuNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, menuName);
        preparedStatement.setObject(2, menuPrice);
        preparedStatement.setObject(3, menuNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    /*public static void updateData(String menuNo, String menuName, double menuPrice) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `menu` SET menuName=?, menuPrice=?WHERE menuNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, menuName);
        preparedStatement.setObject(2, menuPrice);
        preparedStatement.setObject(3, menuNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }完全重复，注释掉一个function
*/
    public static List<Menu> searchData(String keyword) throws Exception {
        List<Menu> menuList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "Select * from `menu` where menuNo like '%" + keyword + "%' or menuName like '%" + keyword +
                "%' or menuPrice like '%" + keyword + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        successAlert("search");
        while (resultSet.next()) {
            Menu menu = new Menu();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(menu, columnLabel, value);
            }
            menuList.add(menu);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return menuList;
    }


    public static void deleteData(String menuNo) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "DELETE FROM `menu` WHERE menuNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, menuNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            successAlert("delete");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void successAlert(String string) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Data " + string + " successful");
        alert.setContentText("Please refresh the page!");
        alert.showAndWait();
    }

    //chooseFun：向该menu对象（数据库的一行）的某一属性传参
    public static void chooseFun(Menu menu, String funName, Object value) {
        switch (funName) {
            case "menuNo":
                menu.setMenuNo((String) value);
                break;
            case "menuName":
                menu.setMenuName((String) value);
                break;
            case "menuPrice":
                value = Main.formatDouble((Double) value);
                menu.setMenuPrice((Double) value);
                break;

        }
    }

}
