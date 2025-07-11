package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class CloseAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accNum = (String) request.getSession().getAttribute("accountNumber");
        String confirm = request.getParameter("confirm");

        if (accNum == null) {
            request.setAttribute("message", "Session expired. Please login again.");
            request.getRequestDispatcher("message.jsp").forward(request, response);
            return;
        }

        if (!"yes".equalsIgnoreCase(confirm)) {
            request.setAttribute("message", "Account closure cancelled.");
            request.getRequestDispatcher("message.jsp").forward(request, response);
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE accounts SET status = 'closed' WHERE account_number = ?");
            ps.setString(1, accNum);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                request.getSession().invalidate(); // Logout
                request.setAttribute("message", "Your account has been closed successfully.");
            } else {
                request.setAttribute("message", "Error closing account.");
            }

            request.getRequestDispatcher("message.jsp").forward(request, response);

        } catch (SQLException e) {
            request.setAttribute("message", "SQL Error: " + e.getMessage());
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
}
