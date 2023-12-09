package RestaurantManagementSystem.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialDAO {
    public static List<Material> readData(List<Material> materialList) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "SELECT * FROM `material`;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        while (resultSet.next()) {
            Material material = new Material();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(material, columnLabel, value);
            }
            materialList.add(material);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return materialList;
    }

    public static void addData(String materialNo, String materialName, double materialUnitPrice, int materialNumber, Date materialDate, String materialType) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "INSERT INTO `material`(materialNo, materialName, materialUnitPrice, materialNumber, materialDate, materialType) values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, materialNo);
        preparedStatement.setObject(2, materialName);
        preparedStatement.setObject(3, materialUnitPrice);
        preparedStatement.setObject(4, materialNumber);
        preparedStatement.setObject(5, materialDate);
        preparedStatement.setObject(6, materialType);

        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("add");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(String materialNo, String materialName, double materialUnitPrice, int materialNumber, Date materialDate, String materialType) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `material` SET materialName=?, materialUnitPrice=?, materialNumber=?, materialDate=?, materialType=? WHERE materialNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, materialName);
        preparedStatement.setObject(2, materialUnitPrice);
        preparedStatement.setObject(3, materialNumber);
        preparedStatement.setObject(4, materialDate);
        preparedStatement.setObject(5, materialType);
        preparedStatement.setObject(6, materialNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    public static void updateData(String materialNo, String materialName, double materialUnitPrice, int materialNumber, String materialType) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "UPDATE `material` SET materialName=?, materialUnitPrice=?, materialNumber=?, materialType=?WHERE materialNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, materialName);
        preparedStatement.setObject(2, materialUnitPrice);
        preparedStatement.setObject(3, materialNumber);
        preparedStatement.setObject(4, materialType);
        preparedStatement.setObject(5, materialNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("update");
        }
        preparedStatement.close();
        connection.close();
    }

    public static List<Material> searchData(String keyword) throws Exception {
        List<Material> materialList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "Select * from `material` where materialNo like '%" + keyword + "%' or materialName like '%" + keyword +
                "%' or materialUnitPrice like '%" + keyword + "%' or materialNumber like '%" + keyword + "%' or materialDate like '%" + keyword + "%' or materialType like '%" + keyword + "%' ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        //  metaData 存放当前结果集列的信息对象
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        Main.successAlert("search");
        while (resultSet.next()) {
            Material material = new Material();
            for (int i = 1; i <= columnCount; i++) {
                Object value = resultSet.getObject(i);
                String columnLabel = metaData.getColumnLabel(i);
                chooseFun(material, columnLabel, value);
            }
            materialList.add(material);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return materialList;
    }


    public static void deleteData(String materialNo) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/food_system", "root", "123456");
        String sql = "DELETE FROM `material` WHERE materialNo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, materialNo);
        int rows = preparedStatement.executeUpdate();
        if (rows > 0) {
            Main.successAlert("delete");
        }
        preparedStatement.close();
        connection.close();
    }

    //chooseFun：向该material对象（数据库的一行）的某一属性传参
    public static void chooseFun(Material material, String funName, Object value) {
        switch (funName) {
            case "materialNo":
                material.setMaterialNo((String) value);
                break;
            case "materialName":
                material.setMaterialName((String) value);
                break;
            case "materialUnitPrice":
                value = Main.formatDouble((Double) value);
                material.setMaterialUnitPrice((Double) value);
                break;
            case "materialNumber":
                material.setMaterialNumber((Integer) value);
                break;
            case "materialDate":
                material.setMaterialDate((Date) value);
                break;
            case "materialType":
                material.setMaterialType((String) value);
                break;
        }
    }
}

