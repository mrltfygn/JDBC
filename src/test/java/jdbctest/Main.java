package jdbctest;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String dbUrl="jdbc:oracle:thin:@3.89.104.82:1521:xe";
        String dbUsername="hr";
        String dbPassword="hr";

        //create connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        //create statement objenct
        Statement statement= connection.createStatement();
        //run query and get the result in resultset object
        ResultSet resultSet= statement.executeQuery("Select*from regions");

        //move pointer to first row
     ///   resultSet.next();
        //1 - Europe
        //2 - Americans
    //    System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2));
    //    resultSet.next();
      //  System.out.println(resultSet.getString(1)+" - "+resultSet.getString(2));

        //  System.out.println(resultSet.getString("region_name"));
      //  System.out.println(resultSet.getString(2));

      //  resultSet.next();
      //  System.out.println(resultSet.getString(2));

      //  resultSet.next();
      //  System.out.println(resultSet.getString("region_name"));




        //close all connection
        resultSet.close();
        statement.close();
        connection.close();




    }
}
