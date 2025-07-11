package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class TransactionHistoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accNum = (String) request.getSession().getAttribute("accountNumber");
        String fromDate = request.getParameter("from");
        String toDate = request.getParameter("to");

        if (accNum == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Transaction> transactions = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM transactions WHERE account_number = ? AND date BETWEEN ? AND ? ORDER BY date DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accNum);
            ps.setString(2, fromDate);
            ps.setString(3, toDate);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction txn = new Transaction();
                txn.setType(rs.getString("type"));
                txn.setAmount(rs.getDouble("amount"));
                txn.setDescription(rs.getString("description"));
                txn.setDate(rs.getDate("date"));
                transactions.add(txn);
            }

            request.setAttribute("transactions", transactions);
            request.setAttribute("from", fromDate);
            request.setAttribute("to", toDate);
            RequestDispatcher rd = request.getRequestDispatcher("transaction_history.jsp");
            rd.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
