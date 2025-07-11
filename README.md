
# 🏦 ROY BANK – JSP-Based Online Banking System

A fully functional online banking web application built using **Java (Servlets & JSP)**, **MySQL**, and **Apache Tomcat**. Features include account registration, login, deposit, withdrawal, fund transfer, mini statement, transaction history export to PDF, and profile management.

---

## 📁 Project Folder Structure

```
roy-bank/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── bankapp/
│                   ├── DBConnection.java             # MySQL DB connectivity class
│                   ├── RegisterServlet.java          # Handles account creation
│                   ├── LoginServlet.java             # User login and session creation
│                   ├── DepositServlet.java           # Deposit funds
│                   ├── WithdrawServlet.java          # Withdraw funds
│                   ├── TransferServlet.java          # Transfer between accounts
│                   ├── MiniStatementServlet.java     # Displays last 10 transactions
│                   ├── TransactionHistoryServlet.java# Transaction history by date
│                   ├── ExportPDFServlet.java         # Export history as PDF
│                   ├── UpdateAccountServlet.java     # Update user profile info
│                   ├── ChangePinServlet.java         # Change account PIN
│                   └── CloseAccountServlet.java      # Close account permanently
│
├── WebContent/
│   ├── index.jsp                 # Landing page with Login & Register options
│   ├── login.jsp                 # Login form for users
│   ├── register.jsp              # New user registration form
│   ├── dashboard.jsp             # User dashboard after login
│   ├── deposit.jsp               # Deposit money form
│   ├── withdraw.jsp              # Withdraw money form
│   ├── transfer.jsp              # Transfer to another account
│   ├── ministatement.jsp         # Shows recent 10 transactions
│   ├── transaction.jsp           # Show transactions within date range
│   ├── update_account.jsp        # Update user details
│   ├── change_pin.jsp            # Change account PIN
│   ├── close_account.jsp         # Account closure confirmation
│   ├── profile.jsp               # User profile display
│   ├── message.jsp               # Success/failure messages from servlets
│   └── css/
│       └── styles.css            # Central CSS file for all pages
│
├── lib/
│   └── pdfbox-3.0.0.jar          # Apache PDFBox library for PDF export
│
├── database/
│   └── bank_schema.sql           # MySQL script for accounts and transactions table
│
```

---

## 🧠 Features & Workflow

- **User Registration**: New users can register and get a system-generated account number.
- **Login**: Secure login using account number and 4-digit PIN.
- **Session Management**: Only logged-in users can access account services.
- **Deposit/Withdraw**: Update balance and log every transaction.
- **Fund Transfer**: Verify sender/receiver accounts and update balances.
- **Mini Statement**: Shows last 10 transactions.
- **Transaction History**: Filter by date range.
- **Export to PDF**: Export full transaction history using PDFBox.
- **PIN & Profile Update**: Users can change PIN or update profile details.
- **Close Account**: Deletes account from DB.
- **Home Navigation**: All pages have HOME button linking to dashboard.

---

## 🛠️ Tech Stack

- **Java (Servlets, JSP)**
- **JDBC + MySQL**
- **HTML/CSS + JSP**
- **Apache Tomcat 10**
- **Apache PDFBox 3.0.0** (for PDF export)

---

## ⚙️ How to Run

1. Clone or download the project.
2. Import into Eclipse or IntelliJ as a **Dynamic Web Project**.
3. Configure Tomcat 10 server.
4. Create database using `bank_schema.sql` in MySQL.
5. Update DB credentials in `DBConnection.java`.
6. Deploy & Run on Server.

---

## 📄 License

This project is open-source and available under the MIT License. You’re free to use, modify, and distribute.
