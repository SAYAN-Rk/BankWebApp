<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Register | ROY BANK</title>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet" />
  <link rel="stylesheet" href="css/style.css" />
  <style>
    * {
      box-sizing: border-box;
      font-family: 'Poppins', sans-serif;
      margin: 0;
      padding: 0;
    }

    body {
      background: linear-gradient(135deg, #ffecd2 0%, #fcb69f 100%);
      min-height: 100vh;
      display: flex;
      flex-direction: column;
    }

    header {
      background: linear-gradient(to right, #ff6600, #ff8533);
      color: white;
      padding: 25px;
      text-align: center;
      font-size: 32px;
      font-weight: bold;
      letter-spacing: 1px;
      box-shadow: 0 3px 15px rgba(0, 0, 0, 0.1);
    }

    main {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
      padding: 40px 20px;
    }

    .form-card {
      background: #fff;
      padding: 50px 40px;
      border-radius: 20px;
      max-width: 480px;
      width: 100%;
      box-shadow: 0 20px 40px rgba(0, 0, 0, 0.1);
      animation: fadeIn 0.8s ease-in-out;
    }

    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }

    .form-card h2 {
      text-align: center;
      color: #333;
      margin-bottom: 25px;
      font-size: 24px;
    }

    label {
      display: block;
      margin-top: 18px;
      font-weight: 600;
      color: #444;
    }

    input[type="text"],
    input[type="tel"],
    input[type="password"] {
      width: 100%;
      padding: 12px 15px;
      margin-top: 6px;
      border: 1px solid #ccc;
      border-radius: 10px;
      font-size: 15px;
      transition: border-color 0.3s, box-shadow 0.3s;
    }

    input:focus {
      border-color: #ff6600;
      outline: none;
      box-shadow: 0 0 0 3px rgba(255, 102, 0, 0.1);
    }

    input[type="submit"] {
      background-color: #ff6600;
      color: white;
      border: none;
      padding: 14px;
      margin-top: 30px;
      border-radius: 10px;
      width: 100%;
      font-size: 16px;
      font-weight: 600;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #e65c00;
    }

    footer {
      text-align: center;
      padding: 12px;
      background-color: #f8f8f8;
      color: #777;
      font-size: 14px;
    }
  </style>
</head>
<body>

  <header>
    ROY BANK ✨
  </header>

  <main>
    <div class="form-card">
      <h2>🚀 Create Your Account</h2>
      <form action="RegisterServlet" method="post">
        <label for="name">👤 Full Name</label>
        <input type="text" name="name" id="name" required>

        <label for="contact">📱 Contact (Phone or Email)</label>
        <input type="tel" name="contact" id="contact" required>

        <label for="pin">🔐 Create 4-digit PIN</label>
        <input type="password" name="pin" id="pin" pattern="\d{4}" maxlength="4" required>

        <input type="submit" value="Create Account 🚀">
      </form>
    </div>
  </main>

  <footer>
    &copy; 2025 ROY BANK. All rights reserved.
  </footer>

</body>
</html>
