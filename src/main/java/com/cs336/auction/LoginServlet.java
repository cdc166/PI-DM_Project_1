package com.cs336.auction;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/login") // This annotation maps this Servlet to the URL pattern /login which is used in the form action in login.jsp
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // logic for checking the username and password against the database
        // If the credentials are valid, start a session and redirect the user to the next page
        // If not, set an attribute with an error message and forward the request back to the login.jsp

        boolean isAuthenticated = authenticateUser(username, password);
        System.out.println(isAuthenticated);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            // Set other user session details as needed
            response.sendRedirect("welcome.jsp"); // Redirect to a homepage or dashboard
        } else {
            request.setAttribute("errorMessage", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    private boolean authenticateUser(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DatabaseUtility.getConnection();
            String sql = "SELECT Password FROM User WHERE Username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("Password");
                
                // Directly compare the password
                return storedPassword.equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // handle any SQL errors and possibly log them
            //Catch any errors
        } finally {
            // Ensure resources are closed in a finally block
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return false;
    }
}
