package com.cs336.auction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public static List<Item> getAuctionItems() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT id, name, description, starting_bid FROM items"; // Adjust SQL as necessary

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                double startingBid = rs.getDouble("starting_bid");
                items.add(new Item(id, name, description, startingBid));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }
