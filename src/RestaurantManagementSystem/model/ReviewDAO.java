package RestaurantManagementSystem.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReviewDAO {
    public static List<Review> readData(List<Review> reviewList) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "SELECT * FROM `review`;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Review review = new Review();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(review, columnLabel, value);
            }
            reviewList.add(review);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return reviewList;
    }

    public static void addData(String reviewNo, String orderNo, String reviewContent, Date orderDate) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "INSERT INTO `review`(reviewNo ,orderNo, reviewContent,orderDate) values(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, reviewNo);
        preparedStatement.setObject(2, orderNo);
        preparedStatement.setObject(3, reviewContent);
        preparedStatement.setObject(4, orderDate);

        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("add");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(String reviewNo, String orderNo, String reviewContent, Date orderDate) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `review` SET reviewNo=?, orderNo=?, reviewContent=? WHERE orderDate=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, reviewNo);
        preparedStatement.setObject(2, orderNo);
        preparedStatement.setObject(3, reviewContent);
        preparedStatement.setObject(4, orderDate);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(String reviewNo, String orderNo, String reviewContent) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `review` SET reviewNo=?, orderNo=?WHERE reviewContent=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, reviewNo);
        preparedStatement.setObject(2, orderNo);
        preparedStatement.setObject(3, reviewContent);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    public static List<Review> searchData(String keyword) throws Exception {
        List<Review> reviewList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "Select * from `review` where reviewNo like '%" + keyword + "%' or orderNo like '%" + keyword +
                "%' or reviewContent like '%" + keyword + "%' or orderDate like '%" + keyword + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        Main.successAlert("search");
        while (resultSet.next()) {
            Review review = new Review();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(review, columnLabel, value);
            }
            reviewList.add(review);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return reviewList;
    }


    public static void deleteData(String reviewNo) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "DELETE FROM `review` WHERE reviewNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, reviewNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("delete");
        }
        preparedStatement.close();
        connection.close();
    }

    //chooseFun：向该menu对象（数据库的一行）的某一属性传参
    public static void chooseFun(Review review, String funName, Object value) {
        switch (funName) {
            case "reviewNo":
                review.setReviewNo((String) value);
                break;
            case "orderNo":
                review.setOrderNo((String) value);
                break;
            case "reviewContent":
                review.setReviewContent((String) value);
                break;
            case "orderDate":
                review.setOrderDate((Date) value);
                break;
        }
    }
}

