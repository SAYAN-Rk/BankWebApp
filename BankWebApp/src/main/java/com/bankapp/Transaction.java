package com.bankapp;

import java.util.Date;

public class Transaction {
    private Date date;
    private String type;
    private double amount;
    private double balance;
    private String description;

    public Transaction() {}

    public Transaction(Date date, String type, double amount, double balance, String description) {
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public Date getDate() { return date; }
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public double getBalance() { return balance; }
    public String getDescription() { return description; }

    public void setDate(Date date) { this.date = date; }
    public void setType(String type) { this.type = type; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setDescription(String description) { this.description = description; }
}
