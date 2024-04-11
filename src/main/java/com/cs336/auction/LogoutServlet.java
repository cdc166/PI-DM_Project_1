package com.cs336.auction;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Invalidate the current session and removes any session attributes
        HttpSession session = request.getSession(false); // false means do not create a new session if it doesn't exist
        if (session != null) {
            session.invalidate();
        }
        
        // Redirect back to the login page
        response.sendRedirect("login.jsp");
    }
}
