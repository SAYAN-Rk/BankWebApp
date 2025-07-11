<%
    session.invalidate(); // Destroy session
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Logged Out | ROY BANK</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="css/style.css" />
  <style>
    * { box-sizing: border-box; font-family: 'Poppins', sans-serif; }

    body {
      margin: 0;
      padding: 0;
      background-color: #f8f8f8;
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }

    header {
      background: linear-gradient(to right, #ff6600, #ff8533);
      color: white;
      padding: 20px;
      text-align: center;
      font-size: 28px;
      font-weight: bold;
    }

    main {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 50px 20px;
    }

    .card {
      background-color: white;
      padding: 40px 35px;
      border-radius: 12px;
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
      text-align: center;
      max-width: 450px;
      width: 100%;
    }

    .card h2 {
      color: #333;
      margin-bottom: 10px;
    }

    .card p {
      color: #555;
      margin-bottom: 30px;
    }

    .btn {
      display: inline-block;
      padding: 12px 20px;
      background-color: #ff6600;
      color: white;
      text-decoration: none;
      border-radius: 8px;
      font-weight: 600;
      transition: background-color 0.3s;
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

  <header>ROY BANK</header>

  <main>
    <div class="card">
      <h2>You have been logged out</h2>
      <p>Thank you for banking with ROY BANK. Your session has been securely closed.</p>
      <a href="login.jsp" class="btn"> Back to Login</a>
    </div>
  </main>

  <footer>&copy; 2025 ROY BANK. All rights reserved.</footer>

</body>
</html>
