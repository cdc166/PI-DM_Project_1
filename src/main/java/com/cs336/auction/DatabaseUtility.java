package com.cs336.auction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtility {
    // Example credentials, replace with your database details
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cs336project";
    private static final String USER = System.getenv("MYSQL_USER");
    private static final String PASS = System.getenv("MYSQL_PASSWORD");
    
    
    static {
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
    	System.out.println(USER);
    	System.out.println(PASS);
        // Open a connection
        return DriverManager.getConnection(DB_URL, USER, PASS);
//    	return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}
