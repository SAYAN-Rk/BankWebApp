package snippet;

public class Snippet {
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%
	    // Optional session check
	    if (session.getAttribute("accountNumber") == null) {
	        response.sendRedirect("login.jsp");
	        return;
	    }
	%>
	<!DOCTYPE html>
	<html lang="en">
	<head>
	  <meta charset="UTF-8" />
	  <title>Withdraw | ROY BANK</title>
	  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
	  <style>
	    * {
	      box-sizing: border-box;
	      font-family: 'Poppins', sans-serif;
	    }
	
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
	      padding: 20px 30px;
	      text-align: center;
	      font-size: 28px;
	      font-weight: bold;
	      letter-spacing: 1px;
	      box-shadow: 0 2px 8px rgba(0,0,0,0.1);
	      position: relative;
	    }
	
	    .home-btn {
	      position: absolute;
	      left: 20px;
	      top: 20px;
	      background-color: #ffffff;
	      color: #ff6600;
	      text-decoration: none;
	      padding: 8px 14px;
	      border-radius: 6px;
	      font-weight: bold;
	      border: 2px solid #fff;
	      transition: background-color 0.3s, color 0.3s;
	    }
	
	    .home-btn:hover {
	      background-color: white;
	      color: #e65c00;
	    }
	
	    main {
	      flex: 1;
	      display: flex;
	      justify-content: center;
	      align-items: center;
	      padding: 40px 20px;
	    }
	
	    .card {
	      background: white;
	      width: 100%;
	      max-width: 500px;
	      padding: 40px 35px;
	      border-radius: 14px;
	      box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
	    }
	
	    .card h2 {
	      text-align: center;
	      margin-bottom: 25px;
	      color: #333;
	      font-size: 22px;
	    }
	
	    label {
	      display: block;
	      margin: 16px 0 6px;
	      font-weight: 500;
	      color: #444;
	    }
	
	    input[type="number"] {
	      width: 100%;
	      padding: 12px;
	      border: 1px solid #ccc;
	      border-radius: 10px;
	      transition: border 0.3s;
	    }
	
	    input:focus {
	      border-color: #ff6600;
	      outline: none;
	    }
	
	    .btn {
	      background-color: #ff6600;
	      color: white;
	      border: none;
	      padding: 14px;
	      border-radius: 10px;
	      width: 100%;
	      margin-top: 25px;
	      cursor: pointer;
	      font-size: 16px;
	      font-weight: 600;
	      transition: background-color 0.3s;
	    }
	
	    .btn:hover {
	      background-color: #e65c00;
	    }
	
	    .icon {
	      font-size: 40px;
	      color: #ff6600;
	      display: block;
	      text-align: center;
	      margin-bottom: 10px;
	    }
	
	    footer {
	      text-align: center;
	      padding: 12px;
	      background-color: #f2f2f2;
	      color: #777;
	      font-size: 14px;
	    }
	  </style>
	</head>
	<body>
	
	  <header>
	    <a href="dashboard.jsp" class="home-btn">🏠 Home</a>
	    ROY BANK
	  </header>
	
	  <main>
	    <div class="card">
	      <div class="icon">🏧</div>
	      <h2>Withdraw Funds</h2>
	      <form action="WithdrawServlet" method="post">
	        <%-- Account number fetched from session --%>
	        <input type="hidden" name="accountNumber" value="<%= session.getAttribute("accountNumber") %>">
	
	        <label for="amount">Amount to Withdraw (₹)</label>
	        <input type="number" id="amount" name="amount" min="1" required>
	
	        <input type="submit" value="Withdraw Now" class="btn">
	      </form>
	    </div>
	  </main>
	
	  <footer>
	    &copy; 2025 ROY BANK. All rights reserved.
	  </footer>
	
	</body>
	</html>
	
}

