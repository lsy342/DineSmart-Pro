package RestaurantManagementSystem.model;

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
            Main.successAlert("add");
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
            Main.successAlert("update");
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
            Main.successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    public static List<Order> searchData(String keyword) throws Exception {
        List<Order> orderList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "Select * from `order` where orderNo like '%" + keyword + "%' or orderContent like '%" + keyword +
                "%' or orderDate like '%" + keyword + "%' or orderPrice like '%" + keyword + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        Main.successAlert("search");
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


    public static void deleteData(String orderNo) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "DELETE FROM `order` WHERE orderNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, orderNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("delete");
        }
        preparedStatement.close();
        connection.close();
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

    public static double[] taxCalculate(java.sql.Date dateFrom, java.sql.Date dateTo) throws Exception {
        double[] list = new double[2];
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "SELECT SUM(orderPrice) FROM `order` WHERE orderDate BETWEEN ? AND ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, dateFrom);
        preparedStatement.setObject(2, dateTo);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            double num = resultSet.getDouble(1);
            list[0] = num;
            list[1] = num * 0.05;
        } else {
            list[0] = 0;
            list[1] = 0;
        }
        return list;
    }
}
