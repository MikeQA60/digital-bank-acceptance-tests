package co.wemiguel.digitalbank.automation.ui.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.wemiguel.digitalbank.automation.ui.utils.ConfigReader.getPropertiesValue;

public class DBUtils {
    private static Connection connection = null;

    private static Statement statement = null;

    private static ResultSet resultSet = null;

    public static void establishConnection() {


//        String url = "jdbc:mysql://3.249.240.23:3306/miguel";
//        String username = "miguel";
//        String password = "0<bH8tZ>";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection = DriverManager.getConnection(url, username, password);
            connection = DriverManager.getConnection(ConfigReader.getPropertiesValue("digitalbank.db.url"),
                    getPropertiesValue("digitalbank.db.username"),
                    getPropertiesValue("digitalbank.db.password"));

//                            .getPropertiesValue("digitalbank.db.url"),
//                    getPropertiesValue("digitalbank.db.username"),
//                    getPropertiesValue("digtalbank.db.password"));


        } catch (SQLException | ClassNotFoundException e) {
          //  e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //method to establish connection with the db

    // a method that can dynamically send select statements
    //and returns a list of all columns

    public static List<Map<String, Object>> runSQLSelectQuery(String sqlQuery) {

        List<Map<String, Object>> dbResultList = new ArrayList<>();

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            //getMetaData method return info about your info.

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> rowMap = new HashMap<>();

                for (int col = 1; col <= columnCount; col++) {
                   // rowMap.putIfAbsent(resultSetMetaData.getColumnName(col), resultSet.getObject(col));
                    rowMap.put(resultSetMetaData.getColumnName(col), resultSet.getObject(col));
                }

                dbResultList.add(rowMap);

            }

            return dbResultList;
        } catch (SQLException e) {

            throw new RuntimeException(e);
            //throwables
            //throwables.printStackTrace();
        }

       // return dbResultList;
    }


    //create a method that inserts into db
    //return the nums of rows updated or 9 when action is not taken


    //delete or truncate the table

    //update query
    public static int runSQLUpdateQuery(String sqlQuery) {

        int rowsAffected = 0;
        try {
            statement = connection.createStatement();
            rowsAffected = statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
       // catch (SQLException throwables) {
            //e.printStackTrace();
           // throwables.printStackTrace();
            throw new RuntimeException(e);
        }

        return rowsAffected;
    }

    //close connection


    public static void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();

            }

            if (statement != null) {
                statement.close();

            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {


         // throwables.printStackTrace();

            throw new RuntimeException(e);
        }
    }
}

