package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class WithdrawServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accNum = (String) request.getSession().getAttribute("accountNumber");
        String amtStr = request.getParameter("amount");

        if (accNum == null) {
            request.setAttribute("message", "Session expired. Please login again.");
            request.getRequestDispatcher("message.jsp").forward(request, response);
            return;
        }

        if (amtStr == null || amtStr.trim().isEmpty()) {
            request.setAttribute("message", "Amount is required.");
            request.getRequestDispatcher("message.jsp").forward(request, response);
            return;
        }

        double amount = Double.parseDouble(amtStr);

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            // Step 1: Get current balance
            PreparedStatement ps1 = conn.prepareStatement("SELECT balance FROM accounts WHERE account_number = ?");
            ps1.setString(1, accNum);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");

                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;

                    // Step 2: Deduct balance
                    PreparedStatement ps2 = conn.prepareStatement(
                            "UPDATE accounts SET balance = ? WHERE account_number = ?");
                    ps2.setDouble(1, newBalance);
                    ps2.setString(2, accNum);
                    ps2.executeUpdate();

                    // Step 3: Insert into transactions
                    PreparedStatement ps3 = conn.prepareStatement(
                            "INSERT INTO transactions (account_number, date, type, amount, balance, description) VALUES (?, CURDATE(), ?, ?, ?, ?)");
                    ps3.setString(1, accNum);
                    ps3.setString(2, "withdraw");
                    ps3.setDouble(3, amount);
                    ps3.setDouble(4, newBalance);
                    ps3.setString(5, "Cash withdrawal");
                    ps3.executeUpdate();

                    conn.commit();

                    request.setAttribute("message", "₹" + amount + " withdrawn successfully!");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Insufficient balance!");
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
