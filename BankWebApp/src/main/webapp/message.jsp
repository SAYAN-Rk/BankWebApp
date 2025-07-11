<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String msg = (String) request.getAttribute("message");
if (msg == null) {
    response.sendRedirect("dashboard.jsp");
    return;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ROY BANK | Message</title>
    <link rel="stylesheet" href="css/style.css" />
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #ff9a56 0%, #ffad85 25%, #ffc3a0 50%, #ffad85 75%, #ff9a56 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            overflow: hidden;
        }

        /* Animated background elements */
        body::before {
            content: '';
            position: fixed;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: radial-gradient(circle, rgba(255,255,255,0.08) 1px, transparent 1px);
            background-size: 60px 60px;
            animation: float 25s linear infinite;
            pointer-events: none;
        }

        @keyframes float {
            0% { transform: translateY(0) rotate(0deg); }
            100% { transform: translateY(-120px) rotate(360deg); }
        }

        /* Floating geometric shapes */
        .floating-elements {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            pointer-events: none;
            z-index: 1;
        }

        .floating-element {
            position: absolute;
            background: rgba(255, 255, 255, 0.1);
            animation: floatAround 8s ease-in-out infinite;
        }

        .floating-element:nth-child(1) {
            width: 80px;
            height: 80px;
            border-radius: 50%;
            top: 20%;
            left: 10%;
            animation-delay: 0s;
        }

        .floating-element:nth-child(2) {
            width: 60px;
            height: 60px;
            border-radius: 12px;
            top: 60%;
            left: 85%;
            animation-delay: 2s;
        }

        .floating-element:nth-child(3) {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            top: 10%;
            right: 15%;
            animation-delay: 4s;
        }

        .floating-element:nth-child(4) {
            width: 40px;
            height: 40px;
            border-radius: 8px;
            bottom: 20%;
            left: 20%;
            animation-delay: 1s;
        }

        @keyframes floatAround {
            0%, 100% { transform: translateY(0) rotate(0deg) scale(1); }
            25% { transform: translateY(-20px) rotate(90deg) scale(1.1); }
            50% { transform: translateY(0) rotate(180deg) scale(0.9); }
            75% { transform: translateY(20px) rotate(270deg) scale(1.1); }
        }

        .container {
            position: relative;
            z-index: 10;
            max-width: 600px;
            width: 90%;
            animation: slideIn 0.8s ease-out;
        }

        @keyframes slideIn {
            from {
                opacity: 0;
                transform: translateY(50px) scale(0.9);
            }
            to {
                opacity: 1;
                transform: translateY(0) scale(1);
            }
        }

        /* Bank logo/header */
        .header {
            text-align: center;
            margin-bottom: 30px;
            animation: fadeInDown 1s ease-out 0.2s both;
        }

        @keyframes fadeInDown {
            from {
                opacity: 0;
                transform: translateY(-30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .bank-logo {
            font-size: 28px;
            font-weight: 700;
            color: white;
            text-shadow: 2px 2px 8px rgba(0,0,0,0.3);
            margin-bottom: 10px;
            letter-spacing: 2px;
        }

        .bank-tagline {
            font-size: 14px;
            color: rgba(255,255,255,0.9);
            font-weight: 300;
            text-shadow: 1px 1px 4px rgba(0,0,0,0.2);
        }

        /* Message box */
        .message-box {
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(20px);
            padding: 50px 40px;
            border-radius: 24px;
            box-shadow: 0 25px 50px rgba(255, 102, 0, 0.2);
            position: relative;
            overflow: hidden;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        .message-box::before {
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

        /* Message icon */
        .message-icon {
            width: 80px;
            height: 80px;
            margin: 0 auto 30px;
            background: linear-gradient(135deg, #ff6600, #ff8533);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 36px;
            color: white;
            box-shadow: 0 10px 30px rgba(255, 102, 0, 0.3);
            animation: pulseIcon 2s ease-in-out infinite;
        }

        @keyframes pulseIcon {
            0%, 100% { transform: scale(1); box-shadow: 0 10px 30px rgba(255, 102, 0, 0.3); }
            50% { transform: scale(1.1); box-shadow: 0 15px 40px rgba(255, 102, 0, 0.4); }
        }

        /* Message text */
        .message-text {
            font-size: 20px;
            color: #333;
            font-weight: 500;
            margin-bottom: 40px;
            line-height: 1.6;
            animation: fadeInUp 1s ease-out 0.4s both;
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(30px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        /* Button */
        .btn {
            display: inline-block;
            background: linear-gradient(135deg, #ff6600, #ff8533);
            color: white;
            padding: 16px 40px;
            border: none;
            border-radius: 50px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            text-decoration: none;
            transition: all 0.3s ease;
            box-shadow: 0 8px 25px rgba(255, 102, 0, 0.3);
            position: relative;
            overflow: hidden;
            animation: fadeInUp 1s ease-out 0.6s both;
        }

        .btn::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255,255,255,0.3), transparent);
            transition: left 0.6s ease;
        }

        .btn:hover::before {
            left: 100%;
        }

        .btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 15px 35px rgba(255, 102, 0, 0.4);
        }

        .btn:active {
            transform: translateY(-1px);
        }

        /* Status indicators based on message type */
        .success-indicator {
            background: linear-gradient(135deg, #4CAF50, #66BB6A);
        }

        .error-indicator {
            background: linear-gradient(135deg, #F44336, #EF5350);
        }

        .info-indicator {
            background: linear-gradient(135deg, #2196F3, #42A5F5);
        }

        .warning-indicator {
            background: linear-gradient(135deg, #FF9800, #FFB74D);
        }

        /* Responsive design */
        @media (max-width: 768px) {
            .container {
                width: 95%;
                margin: 20px auto;
            }
            
            .message-box {
                padding: 40px 30px;
            }
            
            .message-text {
                font-size: 18px;
            }
            
            .bank-logo {
                font-size: 24px;
            }
            
            .message-icon {
                width: 70px;
                height: 70px;
                font-size: 32px;
            }
        }

        @media (max-width: 480px) {
            .message-box {
                padding: 30px 20px;
                border-radius: 16px;
            }
            
            .message-text {
                font-size: 16px;
            }
            
            .btn {
                padding: 14px 32px;
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="floating-elements">
        <div class="floating-element"></div>
        <div class="floating-element"></div>
        <div class="floating-element"></div>
        <div class="floating-element"></div>
    </div>

    <div class="container">
        <div class="header">
            <div class="bank-logo">ROY BANK</div>
            <div class="bank-tagline">Your Trusted Financial Partner</div>
        </div>

        <div class="message-box">
            <div class="message-icon">
                ℹ️
            </div>
            <div class="message-text">
                <%= msg %>
            </div>
            <a class="btn" href="dashboard.jsp">
                🏠 Back to Dashboard
            </a>
        </div>
    </div>
</body>
</html>