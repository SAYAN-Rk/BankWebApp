package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Invalidate session
        HttpSession session = request.getSession(false); 
        if (session != null) {
            session.invalidate();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>You have been logged out successfully.</h2>");
        out.println("<a href='login.jsp'>Login Again</a>");
    }
}
