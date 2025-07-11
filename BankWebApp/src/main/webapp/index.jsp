<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ROY BANK | Welcome</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    
    <style>
        * {
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
        }

        body {
            min-height: 100vh;
            background: linear-gradient(135deg, #ff9a56 0%, #ff6b35 25%, #f7931e 50%, #e8751a 75%, #d4641a 100%);
            background-size: 400% 400%;
            animation: gradientFlow 15s ease infinite;
            display: flex;
            flex-direction: column;
            align-items: center;
            position: relative;
            overflow-x: hidden;
            padding: 2rem 0;
        }

        @keyframes gradientFlow {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        /* Main Card */
        .card {
            background: linear-gradient(145deg, rgba(255, 255, 255, 0.25), rgba(255, 255, 255, 0.1));
            backdrop-filter: blur(20px);
            border: 1px solid rgba(255, 255, 255, 0.2);
            border-radius: 25px;
            box-shadow: 0 15px 50px rgba(0, 0, 0, 0.2);
            padding: 4rem 3rem;
            max-width: 850px;
            width: 90%;
            text-align: center;
            animation: slideUp 1.2s ease;
            position: relative;
            z-index: 2;
            overflow: hidden;
            margin-bottom: 2rem;
        }

        .card::before {
            content: '';
            position: absolute;
            top: -50%;
            left: -50%;
            width: 200%;
            height: 200%;
            background: linear-gradient(45deg, transparent, rgba(255, 255, 255, 0.1), transparent);
            animation: shimmer 3s ease-in-out infinite;
            z-index: -1;
        }

        @keyframes shimmer {
            0% { transform: translateX(-100%) translateY(-100%) rotate(45deg); }
            100% { transform: translateX(100%) translateY(100%) rotate(45deg); }
        }

        @keyframes slideUp {
            from { 
                transform: translateY(50px); 
                opacity: 0; 
            }
            to { 
                transform: translateY(0); 
                opacity: 1; 
            }
        }

        /* Header */
        h1 {
            font-size: 2.5rem;
            margin-bottom: 1.5rem;
            color: #fff;
            letter-spacing: 2px;
            font-weight: 800;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 1rem;
            white-space: nowrap;
        }

        .bank-icon {
            font-size: 2.5rem;
            display: inline-block;
            color: #fff;
            animation: pulse 2s ease-in-out infinite;
        }

        @keyframes pulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.1); }
        }

        /* Subtitle */
        p {
            font-size: 1.2rem;
            color: rgba(255, 255, 255, 0.9);
            margin-bottom: 3rem;
            font-weight: 400;
            line-height: 1.6;
        }

        /* Button Container */
        .btn-container {
            display: flex;
            justify-content: center;
            gap: 1.5rem;
            flex-wrap: wrap;
        }

        /* Buttons */
        .btn {
            padding: 1rem 2rem;
            font-size: 1.1rem;
            font-weight: 600;
            border: 2px solid rgba(255, 255, 255, 0.3);
            border-radius: 50px;
            color: white;
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.2), rgba(255, 255, 255, 0.1));
            backdrop-filter: blur(10px);
            cursor: pointer;
            text-decoration: none;
            transition: all 0.3s ease;
            position: relative;
            overflow: hidden;
            min-width: 160px;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
        }

        .btn::before {
            content: '';
            position: absolute;
            top: 0;
            left: -100%;
            width: 100%;
            height: 100%;
            background: linear-gradient(90deg, transparent, rgba(255, 255, 255, 0.2), transparent);
            transition: left 0.5s ease;
        }

        .btn:hover::before {
            left: 100%;
        }

        .btn.primary {
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0.2));
            border-color: rgba(255, 255, 255, 0.5);
        }

        .btn.secondary {
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0.05));
            border-color: rgba(255, 255, 255, 0.3);
        }

        .btn:hover {
            transform: translateY(-3px) scale(1.05);
            box-shadow: 0 10px 30px rgba(255, 255, 255, 0.3);
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.4), rgba(255, 255, 255, 0.2));
            border-color: rgba(255, 255, 255, 0.6);
        }

        .btn:active {
            transform: translateY(-1px) scale(1.02);
        }

        /* Features Section */
        .features {
            display: flex;
            justify-content: center;
            margin-top: 2rem;
            padding-top: 2rem;
            border-top: 1px solid rgba(255, 255, 255, 0.2);
        }

        .feature {
            text-align: center;
            padding: 1.5rem;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 15px;
            transition: all 0.3s ease;
            backdrop-filter: blur(10px);
            max-width: 250px;
        }

        .about-feature {
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.2), rgba(255, 255, 255, 0.1));
            border: 1px solid rgba(255, 255, 255, 0.3);
        }

        .feature:hover {
            transform: translateY(-5px);
            background: rgba(255, 255, 255, 0.2);
        }

        .about-feature:hover {
            background: linear-gradient(135deg, rgba(255, 255, 255, 0.3), rgba(255, 255, 255, 0.2));
            transform: translateY(-5px) scale(1.05);
        }

        .feature i {
            font-size: 2.5rem;
            color: #fff;
            margin-bottom: 1rem;
            animation: glow 2s ease-in-out infinite alternate;
        }

        @keyframes glow {
            from { text-shadow: 0 0 10px rgba(255, 255, 255, 0.5); }
            to { text-shadow: 0 0 20px rgba(255, 255, 255, 0.8), 0 0 30px rgba(255, 255, 255, 0.6); }
        }

        .feature h3 {
            font-size: 1.2rem;
            color: #fff;
            font-weight: 700;
            margin-bottom: 0.5rem;
            letter-spacing: 1px;
        }

        .feature p {
            font-size: 0.9rem;
            color: rgba(255, 255, 255, 0.9);
            margin: 0;
            font-style: italic;
        }

        /* About Us Section */
        .about-section {
            margin-top: 2rem;
            padding: 2rem;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 15px;
            backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.2);
        }

        .about-section h2 {
            color: #fff;
            font-size: 1.5rem;
            margin-bottom: 1rem;
            font-weight: 600;
            text-align: center;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
        }

        .about-section h2::before {
            
            font-family: "Apple Color Emoji", "Segoe UI Emoji", "Noto Color Emoji", sans-serif;
            font-style: normal;
        }

        .about-section p {
            font-size: 0.95rem;
            line-height: 1.6;
            color: rgba(255, 255, 255, 0.9);
            text-align: justify;
            margin-bottom: 1rem;
        }

        .about-section p:last-child {
            margin-bottom: 0;
        }

        /* Emoji styling */
        .emoji {
            font-style: normal;
            font-family: "Apple Color Emoji", "Segoe UI Emoji", "Noto Color Emoji", sans-serif;
        }

        /* Footer */
        footer {
            color: rgba(255, 255, 255, 0.8);
            font-size: 0.9rem;
            text-align: center;
            padding: 1rem;
            margin-top: auto;
            width: 100%;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            body {
                padding: 1rem 0;
            }
            
            .card {
                padding: 2.5rem 2rem;
                margin: 1rem;
            }
            
            h1 {
                font-size: 2rem;
                flex-direction: row;
                gap: 0.5rem;
                flex-wrap: wrap;
                justify-content: center;
            }
            
            .bank-icon {
                font-size: 2rem;
            }
            
            p {
                font-size: 1rem;
                margin-bottom: 2rem;
            }
            
            .btn-container {
                flex-direction: column;
                gap: 1rem;
            }
            
            .btn {
                padding: 0.8rem 1.5rem;
                font-size: 1rem;
            }
            
            .features {
                justify-content: center;
            }

            .feature {
                max-width: 100%;
                padding: 1.5rem;
            }

            .about-section {
                padding: 1.5rem;
            }

            .about-section h2 {
                font-size: 1.3rem;
            }
        }

        @media (max-width: 480px) {
            body {
                padding: 0.5rem 0;
            }
            
            .card {
                padding: 2rem 1.5rem;
                margin: 0.5rem;
            }
            
            h1 {
                font-size: 1.8rem;
                white-space: normal;
                line-height: 1.2;
            }
            
            .features {
                margin-top: 1.5rem;
                padding-top: 1.5rem;
            }

            .about-section {
                margin-top: 1.5rem;
                padding: 1rem;
            }
        }
    </style>
</head>
<body>
    <div class="card">
        <h1>
            Welcome to ROY BANK 
            <i class="fas fa-university bank-icon"></i>
        </h1>
        <p>Your trusted partner for secure and smart banking solutions. Experience the future of digital banking with advanced security and seamless transactions.</p>
        
        <div class="btn-container">
            <a href="login.jsp" class="btn primary">
                <i class="fas fa-sign-in-alt"></i>
                Login
            </a>
            <a href="register.jsp" class="btn secondary">
                <i class="fas fa-user-plus"></i>
                Open New Account
            </a>
        </div>
        
        <div class="features">
            <div class="feature about-feature">
                <i class="fas fa-crown"></i>
                <h3>About ROY BANK</h3>
                <p>Where Excellence Meets Innovation</p>
            </div>
        </div>

        <div class="about-section">
            <h2>&#127942; Why Choose ROY BANK?</h2>
            <p>
                <strong>ROY BANK</strong> - Where tradition meets innovation! Founded on the principles of trust, integrity, and customer excellence, we've been transforming lives through smart financial solutions for over two decades. Our state-of-the-art digital banking platform combined with personalized service makes us the preferred choice for modern banking needs.
            </p>
            <p>
                <span class="emoji">&#128142;</span> <strong>What Makes Us Special:</strong> Advanced AI-powered security systems, 24/7 customer support, lightning-fast transactions, and innovative investment opportunities. Whether you're planning your dream home, starting a business, or securing your family's future, ROY BANK is your trusted financial partner on every step of your journey.
            </p>
            <p>
                <span class="emoji">&#128640;</span> <strong>Our Vision:</strong> To democratize banking by making premium financial services accessible to everyone, everywhere. Join thousands of satisfied customers who've made ROY BANK their financial home - because your dreams deserve the best banking experience!
            </p>
        </div>
    </div>

    <footer>
        &copy; 2025 ROY BANK. All rights reserved. | Banking Made Simple
    </footer>
</body>
</html>