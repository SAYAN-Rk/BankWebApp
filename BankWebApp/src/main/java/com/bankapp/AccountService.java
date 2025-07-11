package com.bankapp;

import java.sql.*;

public class AccountService {

    // 🔹 Get current balance of an account
    public static double getBalance(String accNum) throws SQLException {
        double balance = 0;
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT balance FROM accounts WHERE account_number = ? AND status = 'active'");
            ps.setString(1, accNum);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
        }
        return balance;
    }

    // 🔹 Check if account exists and is active
    public static boolean accountExists(String accNum) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "SELECT 1 FROM accounts WHERE account_number = ? AND status = 'active'");
            ps.setString(1, accNum);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }
    }

    // 🔹 Update balance of an account
    public static void updateBalance(String accNum, double newBalance) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE accounts SET balance = ? WHERE account_number = ?");
            ps.setDouble(1, newBalance);
            ps.setString(2, accNum);
            ps.executeUpdate();
        }
    }

    // 🔹 Mark account as closed
    public static void closeAccount(String accNum) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE accounts SET status = 'closed' WHERE account_number = ?");
            ps.setString(1, accNum);
            ps.executeUpdate();
        }
    }

    // 🔹 Log transaction
    public static void logTransaction(String accNum, String type, double amount, String desc) throws SQLException {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO transactions (account_number, type, amount, description) VALUES (?, ?, ?, ?)");
            ps.setString(1, accNum);
            ps.setString(2, type);
            ps.setDouble(3, amount);
            ps.setString(4, desc);
            ps.executeUpdate();
        }
    }
}
