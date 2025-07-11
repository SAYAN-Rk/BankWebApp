package com.bankapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UpdateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accNum = (String) request.getSession().getAttribute("accountNumber");
        String newName = request.getParameter("name");
        String newContact = request.getParameter("contact");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (accNum == null) {
            out.println("<h2>Session expired. Please login again.</h2>");
            return;
        }

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "UPDATE accounts SET name = ?, contact = ? WHERE account_number = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newName);
            ps.setString(2, newContact);
            ps.setString(3, accNum);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                out.println("<h2>Account details updated successfully!</h2>");
            } else {
                out.println("<h2>Failed to update account.</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace(out);
        }
    }
}
