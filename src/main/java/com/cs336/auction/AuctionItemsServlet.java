package com.cs336.auction;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuctionItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT ItemID, Name, Description, StartingBid FROM Items";

        try (Connection conn = DatabaseUtility.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("ItemID");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                double startingBid = rs.getDouble("StartingBid");
                items.add(new Item(id, name, description, startingBid));
            }
            request.setAttribute("items", items);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/auction.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("SQL Error retrieving auction items", e);
        }
    }
}
