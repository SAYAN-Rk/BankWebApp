package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ChangePinServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accNum = (String) request.getSession().getAttribute("accountNumber");
        String oldPin = request.getParameter("oldPin");
        String newPin = request.getParameter("newPin");

        if (accNum == null) {
            request.setAttribute("message", "Session expired. Please login again.");
            request.getRequestDispatcher("message.jsp").forward(request, response);
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            // Verify old PIN
            PreparedStatement ps = conn.prepareStatement("SELECT pin FROM accounts WHERE account_number = ?");
            ps.setString(1, accNum);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString("pin").equals(oldPin)) {
                    // Update to new PIN
                    PreparedStatement update = conn.prepareStatement("UPDATE accounts SET pin = ? WHERE account_number = ?");
                    update.setString(1, newPin);
                    update.setString(2, accNum);
                    update.executeUpdate();

                    request.setAttribute("message", "PIN changed successfully!");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Incorrect old PIN!");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("message", "Account not found!");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            request.setAttribute("message", "Error: " + e.getMessage());
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
}
