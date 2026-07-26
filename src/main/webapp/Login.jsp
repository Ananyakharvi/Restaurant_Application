<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - ADPS Restaurant</title>
    <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Plus Jakarta Sans', sans-serif;
        }
        body {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background: radial-gradient(circle at top left, #1e1b4b, #0f172a);
            color: #f8fafc;
            padding: 20px;
        }
        .login-card {
            width: 100%;
            max-width: 420px;
            background: rgba(30, 41, 59, 0.7);
            backdrop-filter: blur(16px);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 24px;
            padding: 40px 32px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
            text-align: center;
        }
        .brand-logo {
            width: 64px;
            height: 64px;
            background: linear-gradient(135deg, #6366f1, #a855f7);
            border-radius: 18px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 28px;
            color: white;
            margin: 0 auto 20px;
            box-shadow: 0 10px 20px -5px rgba(99, 102, 241, 0.5);
        }
        h2 {
            font-size: 26px;
            font-weight: 700;
            margin-bottom: 8px;
            letter-spacing: -0.5px;
        }
        p.subtitle {
            color: #94a3b8;
            font-size: 14px;
            margin-bottom: 28px;
        }
        .input-group {
            position: relative;
            margin-bottom: 18px;
            text-align: left;
        }
        .input-group i {
            position: absolute;
            left: 16px;
            top: 50%;
            transform: translateY(-50%);
            color: #64748b;
            font-size: 16px;
        }
        .input-group input {
            width: 100%;
            padding: 14px 16px 14px 44px;
            background: rgba(15, 23, 42, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 14px;
            color: white;
            font-size: 14px;
            outline: none;
            transition: all 0.3s ease;
        }
        .input-group input:focus {
            border-color: #6366f1;
            box-shadow: 0 0 0 3px rgba(99, 102, 241, 0.2);
            background: rgba(15, 23, 42, 0.9);
        }
        button.btn-submit {
            width: 100%;
            padding: 14px;
            background: linear-gradient(135deg, #6366f1, #8b5cf6);
            color: white;
            border: none;
            border-radius: 14px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            transition: transform 0.2s, box-shadow 0.2s;
            margin-top: 10px;
            box-shadow: 0 10px 20px -5px rgba(99, 102, 241, 0.4);
        }
        button.btn-submit:hover {
            transform: translateY(-2px);
            box-shadow: 0 15px 25px -5px rgba(99, 102, 241, 0.6);
        }
        .msg-alert {
            margin-top: 16px;
            padding: 10px 14px;
            border-radius: 10px;
            font-size: 13px;
            background: rgba(239, 68, 68, 0.15);
            border: 1px solid rgba(239, 68, 68, 0.3);
            color: #fca5a5;
        }
        .footer-link {
            margin-top: 24px;
            font-size: 14px;
            color: #94a3b8;
        }
        .footer-link a {
            color: #818cf8;
            text-decoration: none;
            font-weight: 600;
        }
        .footer-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="login-card">
    <div class="brand-logo">
        <i class="fa-solid fa-utensils"></i>
    </div>
    <h2>Welcome Back</h2>
    <p class="subtitle">Sign in to your ADPS Restaurant account</p>

    <form action="login" method="post">
        <div class="input-group">
            <i class="fa-solid fa-envelope"></i>
            <input type="email" name="email" placeholder="Email Address" required>
        </div>
        <div class="input-group">
            <i class="fa-solid fa-lock"></i>
            <input type="password" name="password" placeholder="Password" required>
        </div>

        <button type="submit" class="btn-submit">Sign In <i class="fa-solid fa-arrow-right" style="margin-left:6px;"></i></button>
    </form>

    <% if (request.getAttribute("msg") != null) { %>
        <div class="msg-alert"><%= request.getAttribute("msg") %></div>
    <% } %>

    <div class="footer-link">
        Don't have an account? <a href="Register.jsp">Register here</a>
    </div>
</div>

</body>
</html>