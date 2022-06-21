package it.selvaggi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for db connection
 * @author Pasquale Selvaggi
 */
public class MyJdbcUtil {

    private static String url = "jdbc:mysql://localhost:3306/newdb";
    private static String user = "developer";
    private static String password = "devpass";
    public static Connection connection;

    private MyJdbcUtil(){}

    /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        connection = null;

        try{
            // create a connection to the database
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

}
