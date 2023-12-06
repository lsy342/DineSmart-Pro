package food_system.model;

import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO {
    public static List<Order> readData(List<Order> orderList) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "SELECT * FROM `order`;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Order order = new Order();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(order, columnLabel, value);
            }
            orderList.add(order);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return orderList;
    }

    public static void addData(String orderNo, String orderContent, double orderPrice, Date orderDate) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "INSERT INTO `order`(orderNo, orderContent, orderPrice, orderDate) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, orderNo);
        preparedStatement.setObject(2, orderContent);
        preparedStatement.setObject(3, orderPrice);
        preparedStatement.setObject(4, orderDate);

        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            successAlert("add");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(String orderNo, String orderContent, double orderPrice, Date orderDate) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `order` SET orderContent=?, orderPrice=?, orderDate=? WHERE orderNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, orderContent);
        preparedStatement.setObject(2, orderPrice);
        preparedStatement.setObject(3, orderDate);
        preparedStatement.setObject(4, orderNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(String orderNo, String orderContent, double orderPrice) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `order` SET orderContent=?, orderPrice=?WHERE orderNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, orderContent);
        preparedStatement.setObject(2, orderPrice);
        preparedStatement.setObject(3, orderNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void searchData() {

    }


    public static void deleteData(String orderNo) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "DELETE FROM `order` WHERE orderNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, orderNo);
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

    //chooseFun：向该order对象（数据库的一行）的某一属性传参
    public static void chooseFun(Order order, String funName, Object value) {
        switch (funName) {
            case "orderNo":
                order.setOrderNo((String) value);
                break;
            case "orderContent":
                order.setOrderContent((String) value);
                break;
            case "orderPrice":
                value = Main.formatDouble((Double) value);
                order.setOrderPrice((Double) value);
                break;
            case "orderDate":
                order.setOrderDate((Date) value);
                break;
        }
    }
}
