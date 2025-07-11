<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("accountNumber") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <title>Transfer | ROY BANK</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css" />
  <style>
   * {
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
        }

        body {
            background: linear-gradient(135deg, #ff9a56 0%, #ffad85 25%, #ffc3a0 50%, #ffad85 75%, #ff9a56 100%);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            position: relative;
            overflow-x: hidden;
        }

        /* Animated background elements */
        body::before {
            content: '';
            position: fixed;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, rgba(255,255,255,0.1) 1px, transparent 1px);
            background-size: 50px 50px;
            animation: float 20s linear infinite;
            pointer-events: none;
            z-index: 1;
        }

        @keyframes float {
            0% { transform: translateY(0) rotate(0deg); }
            100% { transform: translateY(-100px) rotate(360deg); }
        }

        /* Floating money icons */
        .floating-money {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            pointer-events: none;
            z-index: 1;
        }

        .money-icon {
            position: absolute;
            font-size: 20px;
            color: rgba(255, 255, 255, 0.2);
            animation: floatMoney 8s linear infinite;
        }

        .money-icon:nth-child(1) { left: 10%; animation-delay: 0s; }
        .money-icon:nth-child(2) { left: 20%; animation-delay: 2s; }
        .money-icon:nth-child(3) { left: 30%; animation-delay: 4s; }
        .money-icon:nth-child(4) { left: 70%; animation-delay: 1s; }
        .money-icon:nth-child(5) { left: 80%; animation-delay: 3s; }
        .money-icon:nth-child(6) { left: 90%; animation-delay: 5s; }

        @keyframes floatMoney {
            0% { transform: translateY(100vh) rotate(0deg); opacity: 0; }
            10% { opacity: 1; }
            90% { opacity: 1; }
            100% { transform: translateY(-100px) rotate(360deg); opacity: 0; }
        }

        header {
            background: linear-gradient(135deg, #ff6600, #ff8533, #ffad85);
            color: white;
            padding: 25px 20px;
            text-align: center;
            font-size: 28px;
            font-weight: 700;
            letter-spacing: 2px;
            position: relative;
            box-shadow: 0 4px 20px rgba(255, 102, 0, 0.3);
            z-index: 10;
            overflow: hidden;
        }

        header::before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: linear-gradient(45deg, transparent, rgba(255,255,255,0.1), transparent);
            animation: shine 4s linear infinite;
        }

        @keyframes shine {
            0% { transform: translateX(-100%) translateY(-100%); }
            100% { transform: translateX(100%) translateY(100%); }
        }

        .home-btn {
            position: absolute;
            left: 20px;
            top: 50%;
            transform: translateY(-50%);
            background: rgba(255, 255, 255, 0.95);
            color: #ff6600;
            text-decoration: none;
            padding: 12px 20px;
            border-radius: 50px;
            font-weight: 600;
            border: 2px solid rgba(255, 255, 255, 0.3);
            transition: all 0.3s ease;
            backdrop-filter: blur(10px);
            box-shadow: 0 4px 15px rgba(255, 255, 255, 0.3);
            z-index: 2;
        }

        .home-btn:hover {
            background: white;
            color: #e65c00;
            transform: translateY(-50%) scale(1.05);
            box-shadow: 0 6px 20px rgba(255, 255, 255, 0.4);
        }

        main {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 40px 20px;
            position: relative;
            z-index: 10;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(20px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            padding: 50px 60px;
            border-radius: 24px;
            width: 100%;
            max-width: 500px;
            box-shadow: 0 25px 50px rgba(255, 102, 0, 0.2);
            position: relative;
            overflow: hidden;
            animation: slideUp 0.8s ease-out;
        }

        @keyframes slideUp {
            from {
                opacity: 0;
                transform: translateY(50px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .form-container::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 4px;
            background: linear-gradient(90deg, #ff6600, #ff8533, #ffad85, #ff8533, #ff6600);
            background-size: 300% 100%;
            animation: gradientShift 3s ease infinite;
        }

        @keyframes gradientShift {
            0%, 100% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
        }

        .form-header {
            text-align: center;
            margin-bottom: 40px;
        }

        .deposit-icon {
            width: 80px;
            height: 80px;
            background: linear-gradient(135deg, #ff6600, #ff8533);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 36px;
            color: white;
            margin: 0 auto 20px;
            box-shadow: 0 10px 30px rgba(255, 102, 0, 0.3);
            animation: pulse 2s ease-in-out infinite;
        }

        @keyframes pulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.05); }
        }

        h2 {
            color: #333;
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .form-subtitle {
            color: #666;
            font-size: 16px;
            font-weight: 300;
        }

        .form-group {
            margin-bottom: 30px;
            position: relative;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #333;
            font-size: 14px;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .input-wrapper {
            position: relative;
        }

        .currency-symbol {
            position: absolute;
            left: 15px;
            top: 50%;
            transform: translateY(-50%);
            color: #ff6600;
            font-weight: 600;
            font-size: 18px;
            z-index: 2;
        }

        input[type="number"] {
            width: 100%;
            padding: 16px 16px 16px 45px;
            border: 2px solid #e0e0e0;
            border-radius: 12px;
            font-size: 16px;
            transition: all 0.3s ease;
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(5px);
        }

        input[type="number"]:focus {
            border-color: #ff6600;
            outline: none;
            box-shadow: 0 0 0 3px rgba(255, 102, 0, 0.1);
            transform: translateY(-2px);
        }

        input[type="number"]:hover {
            border-color: #ff8533;
        }

        .submit-btn {
            background: linear-gradient(135deg, #ff6600, #ff8533);
            color: white;
            border: none;
            padding: 18px 24px;
            border-radius: 50px;
            width: 100%;
            cursor: pointer;
            font-size: 16px;
            font-weight: 600;
            transition: all 0.3s ease;
            box-shadow: 0 8px 25px rgba(255, 102, 0, 0.3);
            position: relative;
            overflow: hidden;
        }

        .submit-btn::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255,255,255,0.3), transparent);
            transition: left 0.5s ease;
        }

        .submit-btn:hover::before {
            left: 100%;
        }

        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 12px 35px rgba(255, 102, 0, 0.4);
        }

        .submit-btn:active {
            transform: translateY(0);
        }

        .amount-suggestions {
            display: flex;
            gap: 10px;
            margin-top: 15px;
            flex-wrap: wrap;
        }

        .amount-btn {
            background: rgba(255, 102, 0, 0.1);
            color: #ff6600;
            border: 1px solid rgba(255, 102, 0, 0.3);
            padding: 8px 16px;
            border-radius: 20px;
            font-size: 14px;
            cursor: pointer;
            transition: all 0.3s ease;
            flex: 1;
            min-width: 80px;
            text-align: center;
        }

        .amount-btn:hover {
            background: rgba(255, 102, 0, 0.2);
            transform: translateY(-1px);
        }

        footer {
            text-align: center;
            padding: 30px 20px;
            background: rgba(255, 255, 255, 0.9);
            color: #666;
            font-size: 14px;
            backdrop-filter: blur(10px);
            position: relative;
            z-index: 10;
        }

        .footer-gradient {
            background: linear-gradient(135deg, #ff6600, #ff8533);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            background-clip: text;
            font-weight: 600;
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .form-container {
                padding: 40px 30px;
                margin: 20px;
            }
            
            .home-btn {
                left: 15px;
                padding: 10px 16px;
                font-size: 14px;
            }
            
            header {
                font-size: 24px;
                padding: 20px;
            }
            
            h2 {
                font-size: 24px;
            }
            
            .deposit-icon {
                width: 70px;
                height: 70px;
                font-size: 32px;
            }
        }

        @media (max-width: 480px) {
            .form-container {
                padding: 30px 20px;
            }
            
            .amount-suggestions {
                flex-direction: column;
            }
            
            .amount-btn {
                flex: none;
                min-width: auto;
            }
        }

    .transfer-icon {
      width: 80px;
      height: 80px;
      background: linear-gradient(135deg, #ff6600, #ff8533);
      border-radius: 50%;
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 36px;
      color: white;
      margin: 0 auto 20px;
      box-shadow: 0 10px 30px rgba(255, 102, 0, 0.3);
      animation: pulse 2s ease-in-out infinite;
    }
  </style>
</head>
<body>

  <!-- Floating icons -->
  <div class="floating-money">
    <div class="money-icon">🔁</div>
    <div class="money-icon">💳</div>
    <div class="money-icon">💵</div>
    <div class="money-icon">🏦</div>
    <div class="money-icon">💸</div>
    <div class="money-icon">💰</div>
  </div>

  <header>
    <a href="dashboard.jsp" class="home-btn">🏠 Home</a>
    ROY BANK
  </header>

  <main>
    <div class="form-container">
      <div class="form-header">
        <div class="transfer-icon">🔁</div>
        <h2>Transfer Funds</h2>
        <p class="form-subtitle">Send money to another account safely</p>
      </div>

      <form action="TransferServlet" method="post">
        <input type="hidden" name="sender" value="<%= session.getAttribute("accountNumber") %>">

        <div class="form-group">
          <label for="receiver">Recipient Account Number</label>
          <div class="input-wrapper">
            <input type="text" name="receiver" id="receiver" required placeholder="e.g. AC1002">
          </div>
        </div>

        <div class="form-group">
          <label for="amount">Amount to Transfer</label>
          <div class="input-wrapper">
            <span class="currency-symbol">₹</span>
            <input type="number" name="amount" id="amount" min="1" required placeholder="Enter amount">
          </div>

          <div class="amount-suggestions">
            <button type="button" class="amount-btn" onclick="setAmount(500)">₹500</button>
            <button type="button" class="amount-btn" onclick="setAmount(1000)">₹1,000</button>
            <button type="button" class="amount-btn" onclick="setAmount(2000)">₹2,000</button>
            <button type="button" class="amount-btn" onclick="setAmount(5000)">₹5,000</button>
          </div>
        </div>

        <input type="submit" value="🔁 Transfer Now" class="submit-btn">
      </form>
    </div>
  </main>

  <footer>
    <p>&copy; 2025 <span class="footer-gradient">ROY BANK</span>. All rights reserved.</p>
    <p>Secure • Fast • Reliable</p>
  </footer>

  <script>
    function setAmount(amount) {
      document.getElementById('amount').value = amount;
    }
  </script>

</body>
</html>
