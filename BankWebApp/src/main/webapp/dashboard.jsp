<%
String accountHolder = (String) session.getAttribute("accountHolder");
if (accountHolder == null) {
    response.sendRedirect("login.html");
    return;
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard | ROY BANK</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            height: 100vh;
            background: linear-gradient(135deg, #ff9a56 0%, #ff6b35 50%, #f7931e 100%);
            overflow: hidden;
            position: relative;
        }

        /* Animated Background */
        body::before {
            content: '';
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: 
                radial-gradient(circle at 20% 80%, rgba(255, 154, 86, 0.4) 0%, transparent 50%),
                radial-gradient(circle at 80% 20%, rgba(255, 107, 53, 0.4) 0%, transparent 50%),
                radial-gradient(circle at 40% 40%, rgba(247, 147, 30, 0.3) 0%, transparent 50%);
            z-index: -1;
            animation: backgroundFloat 20s ease-in-out infinite;
        }

        @keyframes backgroundFloat {
            0%, 100% { transform: translateY(0px) rotate(0deg); }
            50% { transform: translateY(-20px) rotate(1deg); }
        }

        /* Sidebar Styles */
        .sidebar {
            width: 280px;
            background: linear-gradient(145deg, rgba(255, 255, 255, 0.25), rgba(255, 255, 255, 0.1));
            backdrop-filter: blur(20px);
            border-right: 1px solid rgba(255, 255, 255, 0.2);
            color: white;
            padding: 2rem 1.5rem;
            display: flex;
            flex-direction: column;
            gap: 0.5rem;
            box-shadow: 8px 0 32px rgba(0, 0, 0, 0.1);
            position: relative;
            overflow: hidden;
        }

        .sidebar::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: linear-gradient(145deg, rgba(255, 107, 53, 0.1), rgba(247, 147, 30, 0.1));
            z-index: -1;
        }

        .sidebar h2 {
            font-size: 1.8rem;
            text-align: center;
            font-weight: 800;
            margin-bottom: 2rem;
            letter-spacing: 2px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
            color: #fff;
            padding: 1rem;
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.2), rgba(255, 255, 255, 0.1));
            border-radius: 15px;
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        .sidebar a {
            text-decoration: none;
            color: white;
            font-size: 1rem;
            font-weight: 500;
            padding: 1rem 1.5rem;
            border-radius: 15px;
            transition: all 0.3s ease;
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0.05));
            border: 1px solid rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            display: flex;
            align-items: center;
            gap: 0.8rem;
            margin-bottom: 0.5rem;
            position: relative;
            overflow: hidden;
        }

        .sidebar a::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.2), transparent);
            transition: left 0.5s ease;
        }

        .sidebar a:hover::before {
            left: 100%;
        }

        .sidebar a:hover {
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.25), rgba(255, 255, 255, 0.15));
            transform: translateX(5px) scale(1.02);
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
            border-color: rgba(255, 255, 255, 0.3);
        }

        .sidebar a i {
            font-size: 1.1rem;
            width: 20px;
            text-align: center;
        }

        /* Main Content */
        .main {
            flex: 1;
            padding: 3rem;
            position: relative;
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0.05));
            backdrop-filter: blur(10px);
            overflow-y: auto;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        /* Welcome Box */
        .welcome-box {
            background: linear-gradient(145deg, rgba(255, 255, 255, 0.25), rgba(255, 255, 255, 0.1));
            backdrop-filter: blur(20px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            padding: 3rem 2.5rem;
            border-radius: 25px;
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            text-align: center;
            position: relative;
            overflow: hidden;
            animation: welcomeFloat 3s ease-in-out infinite;
        }

        @keyframes welcomeFloat {
            0%, 100% { transform: translateY(0px); }
            50% { transform: translateY(-10px); }
        }

        .welcome-box::before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: linear-gradient(45deg, transparent, rgba(255, 255, 255, 0.1), transparent);
            animation: shimmer 4s ease-in-out infinite;
        }

        @keyframes shimmer {
            0% { transform: translateX(-100%) translateY(-100%) rotate(45deg); }
            100% { transform: translateX(100%) translateY(100%) rotate(45deg); }
        }

        .welcome-box h1 {
            font-size: 2.5rem;
            font-weight: 800;
            color: white;
            margin-bottom: 1rem;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
            position: relative;
            z-index: 2;
        }

        .welcome-box p {
            font-size: 1.2rem;
            color: rgba(255, 255, 255, 0.9);
            line-height: 1.6;
            position: relative;
            z-index: 2;
            font-weight: 400;
        }

        /* Quick Stats Cards */
        .stats-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
            gap: 1.5rem;
            margin-top: 2rem;
            width: 100%;
            max-width: 800px;
        }

        .stat-card {
            background: linear-gradient(145deg, rgba(255, 255, 255, 0.2), rgba(255, 255, 255, 0.1));
            backdrop-filter: blur(15px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            padding: 1.5rem;
            border-radius: 20px;
            text-align: center;
            transition: all 0.3s ease;
            cursor: pointer;
        }

        .stat-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            background: linear-gradient(145deg, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0.15));
        }

        .stat-card i {
            font-size: 2rem;
            color: white;
            margin-bottom: 0.5rem;
        }

        .stat-card h3 {
            color: white;
            font-size: 1rem;
            font-weight: 600;
            margin-bottom: 0.5rem;
        }

        .stat-card p {
            color: rgba(255, 255, 255, 0.8);
            font-size: 0.9rem;
        }

        /* Footer */
        footer {
            position: absolute;
            bottom: 0;
            left: 280px;
            width: calc(100% - 280px);
            text-align: center;
            padding: 1rem;
            font-size: 0.9rem;
            background: linear-gradient(145deg, rgba(255, 255, 255, 0.2), rgba(255, 255, 255, 0.1));
            backdrop-filter: blur(15px);
            color: rgba(255, 255, 255, 0.8);
            border-top: 1px solid rgba(255, 255, 255, 0.2);
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            body {
                flex-direction: column;
            }
            
            .sidebar {
                width: 100%;
                padding: 1rem;
                flex-direction: row;
                overflow-x: auto;
                gap: 0.5rem;
            }
            
            .sidebar h2 {
                display: none;
            }
            
            .sidebar a {
                min-width: 120px;
                text-align: center;
                padding: 0.8rem;
                font-size: 0.9rem;
            }
            
            .main {
                padding: 2rem 1rem;
            }
            
            .welcome-box {
                padding: 2rem 1.5rem;
            }
            
            .welcome-box h1 {
                font-size: 2rem;
            }
            
            .welcome-box p {
                font-size: 1rem;
            }
            
            footer {
                left: 0;
                width: 100%;
                position: relative;
            }
        }

        /* Scrollbar Styling */
        ::-webkit-scrollbar {
            width: 8px;
        }

        ::-webkit-scrollbar-track {
            background: rgba(255, 255, 255, 0.1);
        }

        ::-webkit-scrollbar-thumb {
            background: rgba(255, 255, 255, 0.3);
            border-radius: 10px;
        }

        ::-webkit-scrollbar-thumb:hover {
            background: rgba(255, 255, 255, 0.5);
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <h2><i class="fas fa-landmark"></i> ROY BANK</h2>
        <a href="ProfileServlet"><i class="fas fa-user"></i> View Profile</a>
        <a href="deposit.jsp"><i class="fas fa-piggy-bank"></i> Deposit</a>
        <a href="withdraw.jsp"><i class="fas fa-money-bill-wave"></i> Withdraw</a>
        <a href="transfer.jsp"><i class="fas fa-exchange-alt"></i> Transfer</a>
        <a href="MiniStatementServlet"><i class="fas fa-receipt"></i> Mini Statement</a>
        <a href="transaction_history.jsp"><i class="fas fa-history"></i> Transaction History</a>
        <a href="change_pin.jsp"><i class="fas fa-key"></i> Change PIN</a>
        <a href="update_account.jsp"><i class="fas fa-edit"></i> Update Info</a>
        <a href="close_account.jsp"><i class="fas fa-user-slash"></i> Close Account</a>
        <a href="logout.jsp"><i class="fas fa-sign-out-alt"></i> Logout</a>
    </div>

    <div class="main">
        <div class="welcome-box">
            <h1>Welcome, <%= accountHolder %></h1>
            <p>Select an action from the left menu to continue banking with us!</p>
        </div>
        
        <div class="stats-container">
            <div class="stat-card">
                <i class="fas fa-university"></i>
                <h3>Secure Banking</h3>
                <p>Advanced encryption technology</p>
            </div>
            <div class="stat-card">
                <i class="fas fa-clock"></i>
                <h3>24/7 Service</h3>
                <p>Round the clock availability</p>
            </div>
            <div class="stat-card">
                <i class="fas fa-shield-alt"></i>
                <h3>Protected</h3>
                <p>Your money is safe with us</p>
            </div>
            <div class="stat-card">
                <i class="fas fa-mobile-alt"></i>
                <h3>Mobile Ready</h3>
                <p>Access anywhere, anytime</p>
            </div>
        </div>
    </div>

    <footer>
        &copy; 2025 ROY BANK. All rights reserved. | Your Trusted Banking Partner
    </footer>
</body>
</html>