<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Session check
    if (session.getAttribute("accountNumber") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Update Info | ROY BANK</title>
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
      padding: 20px 30px;
      text-align: center;
      font-size: 28px;
      font-weight: bold;
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
      max-width: 500px;
      width: 100%;
      padding: 40px;
      border-radius: 14px;
      box-shadow: 0 8px 24px rgba(0, 0, 0, 0.06);
    }

    .icon {
      font-size: 40px;
      color: #ff6600;
      text-align: center;
      margin-bottom: 10px;
    }

    h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #333;
    }

    label {
      display: block;
      margin-top: 16px;
      font-weight: 500;
      color: #444;
    }

    input[type="text"],
    input[type="tel"] {
      width: 100%;
      padding: 12px;
      margin-top: 6px;
      border: 1px solid #ccc;
      border-radius: 10px;
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
      font-size: 16px;
      font-weight: 600;
      cursor: pointer;
    }

    .btn:hover {
      background-color: #e65c00;
    }

    footer {
      text-align: center;
      padding: 12px;
      background-color: #f2f2f2;
      color: #777;
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
      <div class="icon">✏️</div>
      <h2>Update Account Info</h2>
      <form action="UpdateAccountServlet" method="post">
        <%-- Account number from session (not visible to user) --%>
        <input type="hidden" name="accountNumber" value="<%= session.getAttribute("accountNumber") %>">

        <label for="name">New Full Name</label>
        <input type="text" name="name" id="name" required>

        <label for="contact">New Contact Info</label>
        <input type="tel" name="contact" id="contact" required>

        <input type="submit" value="Update Info" class="btn">
      </form>
    </div>
  </main>

  <footer>
    &copy; 2025 ROY BANK. All rights reserved.
  </footer>

</body>
</html>
