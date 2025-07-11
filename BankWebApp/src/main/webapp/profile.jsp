<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Profile | ROY BANK</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css" />
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #ff9a56 0%, #ffad85 50%, #ffc3a0 100%);
            min-height: 100vh;
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
        }

        @keyframes float {
            0% { transform: translateY(0) rotate(0deg); }
            100% { transform: translateY(-100px) rotate(360deg); }
        }

        /* Floating shapes */
        .floating-shapes {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            pointer-events: none;
            z-index: 1;
        }

        .shape {
            position: absolute;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 50%;
            animation: floatUp 6s linear infinite;
        }

        .shape:nth-child(1) { width: 40px; height: 40px; left: 10%; animation-delay: 0s; }
        .shape:nth-child(2) { width: 60px; height: 60px; left: 20%; animation-delay: 2s; }
        .shape:nth-child(3) { width: 80px; height: 80px; left: 80%; animation-delay: 4s; }
        .shape:nth-child(4) { width: 30px; height: 30px; left: 70%; animation-delay: 1s; }
        .shape:nth-child(5) { width: 50px; height: 50px; left: 60%; animation-delay: 3s; }

        @keyframes floatUp {
            0% { transform: translateY(100vh) rotate(0deg); opacity: 0; }
            10% { opacity: 1; }
            90% { opacity: 1; }
            100% { transform: translateY(-100px) rotate(360deg); opacity: 0; }
        }

        header {
            background: linear-gradient(135deg, #ff6600, #ff8533, #ffad85);
            color: white;
            padding: 30px 20px;
            text-align: center;
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
            animation: shine 3s linear infinite;
        }

        @keyframes shine {
            0% { transform: translateX(-100%) translateY(-100%); }
            100% { transform: translateX(100%) translateY(100%); }
        }

        header h1 {
            font-size: 32px;
            font-weight: 700;
            margin-bottom: 5px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
            position: relative;
            z-index: 2;
        }

        header p {
            font-size: 16px;
            font-weight: 300;
            opacity: 0.9;
            position: relative;
            z-index: 2;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 40px 20px;
            position: relative;
            z-index: 10;
        }

        .profile-card {
            max-width: 600px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.95);
            backdrop-filter: blur(10px);
            border-radius: 24px;
            padding: 40px;
            box-shadow: 0 20px 40px rgba(255, 102, 0, 0.2);
            position: relative;
            overflow: hidden;
            transform: translateY(20px);
            animation: slideUp 0.8s ease-out forwards;
        }

        @keyframes slideUp {
            to {
                transform: translateY(0);
            }
        }

        .profile-card::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 4px;
            background: linear-gradient(90deg, #ff6600, #ff8533, #ffad85);
        }

        .profile-header {
            text-align: center;
            margin-bottom: 40px;
        }

        .profile-avatar {
            width: 100px;
            height: 100px;
            background: linear-gradient(135deg, #ff6600, #ff8533);
            border-radius: 50%;
            margin: 0 auto 20px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 36px;
            font-weight: 700;
            color: white;
            box-shadow: 0 10px 30px rgba(255, 102, 0, 0.3);
            animation: pulse 2s ease-in-out infinite;
        }

        @keyframes pulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.05); }
        }

        .profile-card h2 {
            color: #333;
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .profile-card .subtitle {
            color: #666;
            font-size: 16px;
            font-weight: 300;
        }

        .info-grid {
            display: grid;
            gap: 20px;
            margin-bottom: 40px;
        }

        .info-item {
            background: rgba(255, 102, 0, 0.05);
            padding: 20px;
            border-radius: 16px;
            border-left: 4px solid #ff6600;
            transition: all 0.3s ease;
            position: relative;
            overflow: hidden;
        }

        .info-item::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255,255,255,0.4), transparent);
            transition: left 0.5s ease;
        }

        .info-item:hover::before {
            left: 100%;
        }

        .info-item:hover {
            transform: translateX(5px);
            box-shadow: 0 5px 20px rgba(255, 102, 0, 0.2);
        }

        .info-label {
            font-size: 14px;
            color: #ff6600;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 1px;
            margin-bottom: 8px;
        }

        .info-value {
            font-size: 18px;
            color: #333;
            font-weight: 500;
        }

        .balance-highlight {
            background: linear-gradient(135deg, #ff6600, #ff8533);
            color: white !important;
            font-size: 24px !important;
            font-weight: 700 !important;
            text-shadow: 1px 1px 2px rgba(0,0,0,0.3);
        }

        .balance-highlight .info-label {
            color: rgba(255,255,255,0.9) !important;
        }

        .btn {
            display: inline-block;
            background: linear-gradient(135deg, #ff6600, #ff8533);
            color: white;
            padding: 16px 32px;
            border: none;
            border-radius: 50px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
            transition: all 0.3s ease;
            box-shadow: 0 8px 25px rgba(255, 102, 0, 0.3);
            position: relative;
            overflow: hidden;
            width: 100%;
            max-width: 250px;
            margin: 0 auto;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 10px;
        }

        .btn::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255,255,255,0.3), transparent);
            transition: left 0.5s ease;
        }

        .btn:hover::before {
            left: 100%;
        }

        .btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 12px 35px rgba(255, 102, 0, 0.4);
        }

        .btn:active {
            transform: translateY(0);
        }

        footer {
            text-align: center;
            padding: 30px 20px;
            background: rgba(255, 255, 255, 0.9);
            color: #666;
            font-size: 14px;
            margin-top: 40px;
            backdrop-filter: blur(10px);
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
            .container {
                padding: 20px 15px;
            }
            
            .profile-card {
                padding: 30px 20px;
                margin: 20px 15px;
            }
            
            header h1 {
                font-size: 26px;
            }
            
            .profile-card h2 {
                font-size: 24px;
            }
        }
    </style>
</head>
<body>
    <div class="floating-shapes">
        <div class="shape"></div>
        <div class="shape"></div>
        <div class="shape"></div>
        <div class="shape"></div>
        <div class="shape"></div>
    </div>

    <header>
        <h1>ROY BANK</h1>
        <p>Your Trusted Financial Partner</p>
    </header>

    <div class="container">
        <div class="profile-card">
            <div class="profile-header">
                <div class="profile-avatar">
                    ${name.charAt(0)}
                </div>
                <h2>Account Profile</h2>
                <p class="subtitle">Welcome back to your personal banking dashboard</p>
            </div>

            <div class="info-grid">
                <div class="info-item">
                    <div class="info-label">Account Number</div>
                    <div class="info-value">${accNum}</div>
                </div>
                
                <div class="info-item">
                    <div class="info-label">Full Name</div>
                    <div class="info-value">${name}</div>
                </div>
                
                <div class="info-item">
                    <div class="info-label">Contact Information</div>
                    <div class="info-value">${contact}</div>
                </div>
                
                <div class="info-item balance-highlight">
                    <div class="info-label">Current Balance</div>
                    <div class="info-value">₹${balance}</div>
                </div>
            </div>

            <a href="dashboard.jsp" class="btn">
                🏠 Go to Dashboard
            </a>
        </div>
    </div>

    <footer>
        <p>&copy; 2025 <span class="footer-gradient">ROY BANK</span>. All rights reserved.</p>
        <p>Secure • Reliable • Trusted</p>
    </footer>
</body>
</html>