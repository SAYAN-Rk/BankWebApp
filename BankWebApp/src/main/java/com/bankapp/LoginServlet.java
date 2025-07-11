package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accNum = request.getParameter("accountNumber");
        String pin = request.getParameter("pin");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE account_number = ? AND pin = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accNum);
            ps.setString(2, pin);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Login successful
                HttpSession session = request.getSession();
                session.setAttribute("accountNumber", accNum);
                session.setAttribute("accountHolder", rs.getString("name"));

                response.sendRedirect("dashboard.jsp");
            } else {
                out.println("<h2>Invalid Account Number or PIN!</h2>");
                out.println("<a href='login.jsp'>Try Again</a>");
            }
        } catch (SQLException e) {
            e.printStackTrace(out);
        }
    }
}
