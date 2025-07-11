<%@ page import="java.util.List" %>
<%@ page import="com.bankapp.Transaction" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mini Statement | ROY BANK</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
<style>
* {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

body {
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(135deg, #ff9a56 0%, #ff6b35 50%, #f7931e 100%);
    min-height: 100vh;
    position: relative;
    overflow-x: hidden;
}

/* Background Animation */
body::before {
    content: '';
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: 
        radial-gradient(circle at 20% 80%, rgba(255, 154, 86, 0.3) 0%, transparent 50%),
        radial-gradient(circle at 80% 20%, rgba(255, 107, 53, 0.3) 0%, transparent 50%),
        radial-gradient(circle at 40% 40%, rgba(247, 147, 30, 0.2) 0%, transparent 50%);
    z-index: -1;
    animation: backgroundFloat 20s ease-in-out infinite;
}

@keyframes backgroundFloat {
    0%, 100% { transform: translateY(0px) rotate(0deg); }
    50% { transform: translateY(-20px) rotate(1deg); }
}

/* Header Styles */
header {
    background: linear-gradient(135deg, #ff6b35, #f7931e);
    color: white;
    padding: 2rem;
    text-align: center;
    box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1);
    position: relative;
    overflow: hidden;
}

header::before {
    content: '';
    position: absolute;
    top: -50%;
    left: -50%;
    width: 200%;
    height: 200%;
    background: repeating-linear-gradient(
        45deg,
        transparent,
        transparent 10px,
        rgba(255, 255, 255, 0.05) 10px,
        rgba(255, 255, 255, 0.05) 20px
    );
    animation: headerPattern 10s linear infinite;
}

@keyframes headerPattern {
    0% { transform: translateX(-50px) translateY(-50px); }
    100% { transform: translateX(50px) translateY(50px); }
}

.header-content {
    position: relative;
    z-index: 2;
}

.header-title {
    font-size: 2.5rem;
    font-weight: 700;
    margin-bottom: 0.5rem;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
    letter-spacing: 1px;
}

.header-subtitle {
    font-size: 1.1rem;
    font-weight: 300;
    opacity: 0.9;
}

/* Main Container */
.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 2rem;
    position: relative;
    z-index: 1;
}

/* Top Actions Bar */
.actions-bar {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 2rem;
    background: rgba(255, 255, 255, 0.95);
    padding: 1.5rem;
    border-radius: 20px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(10px);
    border: 1px solid rgba(255, 255, 255, 0.2);
}

.page-title {
    font-size: 1.8rem;
    font-weight: 600;
    color: #ff6b35;
    display: flex;
    align-items: center;
    gap: 0.5rem;
}

.export-btn {
    background: linear-gradient(135deg, #ff6b35, #f7931e);
    color: white;
    padding: 1rem 2rem;
    text-decoration: none;
    border-radius: 50px;
    font-weight: 600;
    display: flex;
    align-items: center;
    gap: 0.5rem;
    transition: all 0.3s ease;
    box-shadow: 0 5px 15px rgba(255, 107, 53, 0.3);
    border: none;
    cursor: pointer;
    font-size: 1rem;
}

.export-btn:hover {
    transform: translateY(-2px);
    box-shadow: 0 8px 25px rgba(255, 107, 53, 0.4);
    background: linear-gradient(135deg, #f7931e, #ff6b35);
}

.export-btn:active {
    transform: translateY(0);
}

/* Table Container */
.table-container {
    background: rgba(255, 255, 255, 0.95);
    border-radius: 20px;
    overflow: hidden;
    box-shadow: 0 15px 40px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(10px);
    border: 1px solid rgba(255, 255, 255, 0.2);
    margin-bottom: 2rem;
}

/* Table Styles */
table {
    width: 100%;
    border-collapse: collapse;
    background: transparent;
}

thead {
    background: linear-gradient(135deg, #ff6b35, #f7931e);
    color: white;
}

th {
    padding: 1.5rem 1rem;
    font-size: 1rem;
    font-weight: 600;
    text-align: center;
    position: relative;
    text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
}

th:not(:last-child)::after {
    content: '';
    position: absolute;
    right: 0;
    top: 25%;
    height: 50%;
    width: 1px;
    background: rgba(255, 255, 255, 0.2);
}

tbody tr {
    transition: all 0.3s ease;
    border-bottom: 1px solid rgba(255, 107, 53, 0.1);
}

tbody tr:hover {
    background: rgba(255, 107, 53, 0.05);
    transform: scale(1.01);
}

tbody tr:last-child {
    border-bottom: none;
}

td {
    padding: 1.2rem 1rem;
    text-align: center;
    font-size: 0.95rem;
    color: #333;
    font-weight: 500;
}

.amount {
    font-weight: 600;
    color: #ff6b35;
}

.balance {
    font-weight: 600;
    color: #2d5a87;
}

.transaction-type {
    padding: 0.3rem 0.8rem;
    border-radius: 20px;
    font-size: 0.8rem;
    font-weight: 600;
    text-transform: uppercase;
}

.type-credit {
    background: linear-gradient(135deg, #4CAF50, #45a049);
    color: white;
}

.type-debit {
    background: linear-gradient(135deg, #f44336, #d32f2f);
    color: white;
}

/* No Data State */
.no-data {
    text-align: center;
    padding: 4rem 2rem;
    background: rgba(255, 255, 255, 0.95);
    border-radius: 20px;
    box-shadow: 0 15px 40px rgba(0, 0, 0, 0.1);
    backdrop-filter: blur(10px);
    border: 1px solid rgba(255, 255, 255, 0.2);
}

.no-data-icon {
    font-size: 4rem;
    color: #ff6b35;
    margin-bottom: 1rem;
    opacity: 0.7;
}

.no-data-text {
    font-size: 1.2rem;
    color: #666;
    font-weight: 500;
}

/* Footer */
footer {
    background: rgba(255, 255, 255, 0.95);
    color: #666;
    text-align: center;
    padding: 2rem;
    font-size: 0.9rem;
    backdrop-filter: blur(10px);
    border-top: 1px solid rgba(255, 107, 53, 0.1);
}

/* Responsive Design */
@media (max-width: 768px) {
    .header-title {
        font-size: 2rem;
    }
    
    .actions-bar {
        flex-direction: column;
        gap: 1rem;
        text-align: center;
    }
    
    .page-title {
        font-size: 1.5rem;
    }
    
    .export-btn {
        padding: 0.8rem 1.5rem;
        font-size: 0.9rem;
    }
    
    .container {
        padding: 1rem;
    }
    
    table {
        font-size: 0.85rem;
    }
    
    th, td {
        padding: 0.8rem 0.5rem;
    }
}

@media (max-width: 480px) {
    .header-title {
        font-size: 1.5rem;
    }
    
    .actions-bar {
        padding: 1rem;
    }
    
    .page-title {
        font-size: 1.2rem;
    }
    
    th, td {
        padding: 0.6rem 0.3rem;
        font-size: 0.8rem;
    }
}

/* Animation Classes */
.fade-in {
    animation: fadeIn 0.6s ease-out;
}

@keyframes fadeIn {
    from { opacity: 0; transform: translateY(20px); }
    to { opacity: 1; transform: translateY(0); }
}

.slide-up {
    animation: slideUp 0.5s ease-out;
}

@keyframes slideUp {
    from { opacity: 0; transform: translateY(30px); }
    to { opacity: 1; transform: translateY(0); }
}
</style>
</head>
<body>

<header>
    <div class="header-content">
        <h1 class="header-title">
            <i class="fas fa-university"></i>
            ROY BANK
        </h1>
        <p class="header-subtitle">Your Trusted Banking Partner</p>
    </div>
</header>

<div class="container">
    <div class="actions-bar fade-in">
        <h2 class="page-title">
            <i class="fas fa-file-invoice-dollar"></i>
            Mini Statement
        </h2>
        <a href="ExportPDFServlet" class="export-btn">
            <i class="fas fa-file-pdf"></i>
            Export to PDF
        </a>
    </div>

    <%
    if (transactions != null && !transactions.isEmpty()) {
    %>
    <div class="table-container slide-up">
        <table>
            <thead>
                <tr>
                    <th><i class="fas fa-calendar-alt"></i> Date</th>
                    <th><i class="fas fa-exchange-alt"></i> Type</th>
                    <th><i class="fas fa-money-bill-wave"></i> Amount</th>
                    <th><i class="fas fa-wallet"></i> Balance</th>
                </tr>
            </thead>
            <tbody>
                <%
                for (Transaction txn : transactions) {
                    String typeClass = txn.getType().toLowerCase().equals("credit") ? "type-credit" : "type-debit";
                %>
                <tr>
                    <td><%= sdf.format(txn.getDate()) %></td>
                    <td>
                        <span class="transaction-type <%= typeClass %>">
                            <%= txn.getType() %>
                        </span>
                    </td>
                    <td class="amount">Rs.<%= String.format("%.2f", txn.getAmount()) %></td>
                    <td class="balance">Rs.<%= String.format("%.2f", txn.getBalance()) %></td>
                </tr>
                <%
                }
                %>
            </tbody>
        </table>
    </div>
    <%
    } else {
    %>
    <div class="no-data fade-in">
        <div class="no-data-icon">
            <i class="fas fa-inbox"></i>
        </div>
        <div class="no-data-text">
            No transactions found for your account.
        </div>
    </div>
    <%
    }
    %>
</div>

<footer>
    <p>&copy; 2025 ROY BANK. All rights reserved. | Secure Banking Solutions</p>
</footer>

</body>
</html>