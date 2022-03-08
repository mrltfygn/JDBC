package jdbctest;

import org.testng.annotations.Test;

import java.sql.*;

public class metaData {
        String dbUrl = "jdbc:oracle:thin:@3.89.104.82:1521:xe";
        String dbUsername = "hr";
        String dbPassword = "hr";

        @Test
        public void MetaDataExamples() throws SQLException {
                //create connection
                Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
                //create statement objenct
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
                //run query and get the result in resultset object
                ResultSet resultSet = statement.executeQuery("Select*from departments");

                //get the database related data inside the dbMetaData object
                DatabaseMetaData dbMetaData=connection.getMetaData();
                System.out.println("User = "+dbMetaData.getUserName());
                System.out.println("Database Product Name = "+dbMetaData.getDatabaseProductName());
                System.out.println("Database Product Version = "+dbMetaData.getDatabaseProductVersion());
                System.out.println("Driver name = "+dbMetaData.getDriverName());
                System.out.println("Driver version = "+dbMetaData.getDriverVersion());

                //get  the resultset object metadata
                ResultSetMetaData rsMetadata=resultSet.getMetaData();

                //how many colummns we have?
                int countColumn=rsMetadata.getColumnCount();
                System.out.println(countColumn);
                System.out.println("--------------------------------------");

                //how to get column names
                System.out.println(rsMetadata.getColumnName(1));
                System.out.println("--------------------------------------");

                //print all the column names dynamically
                for (int i = 1; i <=countColumn; i++) {
                        System.out.println(rsMetadata.getColumnName(i));
                }
                System.out.println("--------------------------------------");

                //


                //close all connection
                resultSet.close();
                statement.close();
                connection.close();


        }

}
