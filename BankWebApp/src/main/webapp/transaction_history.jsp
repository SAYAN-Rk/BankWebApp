<%@ page import="java.util.List" %>
<%@ page import="com.bankapp.Transaction" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    String accNum = (String) session.getAttribute("accountNumber");
    if (accNum == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
    String fromDate = request.getParameter("from");
    String toDate = request.getParameter("to");
    String txnType = request.getParameter("type");

    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Transaction History | ROY BANK</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
  <style>
    * { box-sizing: border-box; font-family: 'Poppins', sans-serif; }

    body {
      margin: 0;
      background: #f8f8f8;
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }

    header {
      background: linear-gradient(to right, #ff6600, #ff8533);
      color: white;
      padding: 20px;
      text-align: center;
      font-size: 26px;
      font-weight: bold;
      position: relative;
    }

    .home-btn {
      position: absolute;
      left: 20px;
      top: 50%;
      transform: translateY(-50%);
      background-color: #ffffff;
      color: #ff6600;
      text-decoration: none;
      padding: 10px 18px;
      border-radius: 6px;
      font-weight: 600;
      border: 2px solid #fff;
      transition: all 0.3s ease;
    }

    .home-btn:hover {
      background-color: white;
      color: #e65c00;
    }

    main {
      flex: 1;
      padding: 40px 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
      gap: 30px;
    }

    .card {
      background: white;
      padding: 30px;
      border-radius: 14px;
      box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
      width: 100%;
      max-width: 600px;
    }

    .card h2 {
      text-align: center;
      color: #333;
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin-top: 16px;
      font-weight: 500;
      color: #444;
    }

    input[type="date"],
    select {
      width: 100%;
      padding: 12px;
      margin-top: 6px;
      border: 1px solid #ccc;
      border-radius: 10px;
    }

    .btn {
      background-color: #ff6600;
      color: white;
      border: none;
      padding: 14px;
      border-radius: 10px;
      width: 100%;
      margin-top: 25px;
      font-size: 16px;
      font-weight: 600;
      cursor: pointer;
    }

    .btn:hover {
      background-color: #e65c00;
    }

    table {
      width: 100%;
      max-width: 800px;
      background: white;
      border-collapse: collapse;
      border-radius: 12px;
      box-shadow: 0 0 12px rgba(0,0,0,0.08);
      overflow: hidden;
    }

    th, td {
      padding: 16px;
      text-align: center;
      border-bottom: 1px solid #eee;
    }

    th {
      background-color: #ff6600;
      color: white;
    }

    tr:last-child td {
      border-bottom: none;
    }

    .no-data {
      text-align: center;
      font-size: 16px;
      color: #888;
      margin-top: 20px;
    }

    .export-form {
      max-width: 800px;
      width: 100%;
      display: flex;
      justify-content: flex-end;
      margin-top: 10px;
    }

    .export-form button {
      background-color: #28a745;
      color: white;
      border: none;
      padding: 12px 20px;
      border-radius: 8px;
      cursor: pointer;
      font-weight: 600;
      transition: background-color 0.3s;
    }

    .export-form button:hover {
      background-color: #218838;
    }

    footer {
      text-align: center;
      padding: 12px;
      background-color: #f2f2f2;
      color: #777;
      font-size: 14px;
    }

    @media (max-width: 600px) {
      th, td { font-size: 14px; padding: 12px; }
      .card h2 { font-size: 20px; }
    }
  </style>
</head>
<body>

  <header>
    <a href="dashboard.jsp" class="home-btn"> Home</a>
    ROY BANK - Transaction History
  </header>

  <main>

    <!-- Filter Form -->
    <div class="card">
      <h2>Filter Transactions</h2>
      <form action="TransactionHistoryServlet" method="post">
        <label for="from">Start Date</label>
        <input type="date" id="from" name="from" value="<%= fromDate != null ? fromDate : "" %>" required>

        <label for="to">End Date</label>
        <input type="date" id="to" name="to" value="<%= toDate != null ? toDate : "" %>" required>

        <label for="type">Transaction Type</label>
        <select name="type" id="type">
          <option value="All" <%= ("All".equalsIgnoreCase(txnType) || txnType == null) ? "selected" : "" %>>All</option>
          <option value="Deposit" <%= "Deposit".equalsIgnoreCase(txnType) ? "selected" : "" %>>Deposit</option>
          <option value="Withdraw" <%= "Withdraw".equalsIgnoreCase(txnType) ? "selected" : "" %>>Withdraw</option>
          <option value="Transfer" <%= "Transfer".equalsIgnoreCase(txnType) ? "selected" : "" %>>Transfer</option>
          <option value="Received" <%= "Received".equalsIgnoreCase(txnType) ? "selected" : "" %>>Received</option>
        </select>

        <input type="submit" value="View History" class="btn">
      </form>
    </div>

    <!-- Table -->
    <%
      if (transactions != null && !transactions.isEmpty()) {
    %>
      <table>
        <tr>
          <th>Date</th>
          <th>Type</th>
          <th>Amount</th>
          
        </tr>
        <% for (Transaction txn : transactions) { %>
          <tr>
            <td><%= sdf.format(txn.getDate()) %></td>
            <td><%= txn.getType() %></td>
            <td>Rs <%= String.format("%.2f", txn.getAmount()) %></td>
            
          </tr>
        <% } %>
      </table>

      
    <%
      } else if (transactions != null) {
    %>
      <div class="no-data">No transactions found for the selected filters.</div>
    <%
      }
    %>

  </main>

  <footer>&copy; 2025 ROY BANK. All rights reserved.</footer>

</body>
</html>
