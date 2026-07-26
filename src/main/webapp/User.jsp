<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.restaurant.dto.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - ADPS Restaurant</title>
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
            background-color: #0f172a;
            color: #f8fafc;
            min-height: 100vh;
        }

        .navbar {
            background: rgba(30, 41, 59, 0.8);
            backdrop-filter: blur(12px);
            border-bottom: 1px solid rgba(255, 255, 255, 0.1);
            padding: 16px 32px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .brand {
            display: flex;
            align-items: center;
            gap: 12px;
            font-size: 20px;
            font-weight: 700;
            color: #818cf8;
            text-decoration: none;
        }

        .nav-links a {
            color: #cbd5e1;
            text-decoration: none;
            margin-left: 24px;
            font-weight: 500;
            font-size: 14px;
            transition: color 0.2s;
        }

        .nav-links a:hover, .nav-links a.active {
            color: #818cf8;
        }

        .container {
            max-width: 1100px;
            margin: 40px auto;
            padding: 0 24px;
        }

        .hero-banner {
            background: linear-gradient(135deg, rgba(99, 102, 241, 0.2), rgba(168, 85, 247, 0.2));
            border: 1px solid rgba(129, 140, 248, 0.3);
            border-radius: 24px;
            padding: 40px;
            margin-bottom: 36px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .hero-text h1 {
            font-size: 32px;
            font-weight: 800;
            margin-bottom: 8px;
        }

        .hero-text p {
            color: #94a3b8;
            font-size: 15px;
        }

        .action-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
            gap: 24px;
        }

        .action-card {
            background: rgba(30, 41, 59, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 20px;
            padding: 32px 24px;
            text-align: center;
            text-decoration: none;
            color: white;
            transition: transform 0.3s, border-color 0.3s;
        }

        .action-card:hover {
            transform: translateY(-6px);
            border-color: #818cf8;
            background: rgba(30, 41, 59, 0.9);
        }

        .action-icon {
            width: 60px;
            height: 60px;
            border-radius: 16px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 26px;
            margin: 0 auto 20px;
        }

        .icon-menu { background: rgba(99, 102, 241, 0.2); color: #818cf8; }
        .icon-reserve { background: rgba(16, 185, 129, 0.2); color: #34d399; }
        .icon-profile { background: rgba(245, 158, 11, 0.2); color: #fbbf24; }
        .icon-cart { background: rgba(236, 72, 153, 0.2); color: #f472b6; }

        .action-card h3 {
            font-size: 18px;
            font-weight: 700;
            margin-bottom: 8px;
        }

        .action-card p {
            color: #94a3b8;
            font-size: 13px;
        }
    </style>
</head>
<body>

<%
    User u = (User) session.getAttribute("user");
    String userName = (u != null && u.getFull_name() != null) ? u.getFull_name() : "Gourmet Guest";
%>

<nav class="navbar">
    <a href="User.jsp" class="brand"><i class="fa-solid fa-utensils"></i> ADPS Restaurant</a>
    <div class="nav-links">
        <a href="User.jsp" class="active">Dashboard</a>
        <a href="menu">Menu</a>
        <a href="Reservation.jsp">Reservation</a>
        <a href="Profile.jsp">Profile</a>
        <a href="Login.jsp">Logout</a>
    </div>
</nav>

<div class="container">
    <div class="hero-banner">
        <div class="hero-text">
            <h1>Welcome back, <%= userName %>! 👋</h1>
            <p>Ready to indulge in exquisite dishes or reserve your next dining experience?</p>
        </div>
    </div>

    <div class="action-grid">
        <a href="menu" class="action-card">
            <div class="action-icon icon-menu">
                <i class="fa-solid fa-book-open"></i>
            </div>
            <h3>Browse Food Menu</h3>
            <p>Explore chef specialities, appetizers & beverages</p>
        </a>

        <a href="Reservation.jsp" class="action-card">
            <div class="action-icon icon-reserve">
                <i class="fa-solid fa-chair"></i>
            </div>
            <h3>Book a Table</h3>
            <p>Reserve a cozy table for your family & friends</p>
        </a>

        <a href="Profile.jsp" class="action-card">
            <div class="action-icon icon-profile">
                <i class="fa-solid fa-id-card"></i>
            </div>
            <h3>My Profile</h3>
            <p>View and manage account details</p>
        </a>

        <a href="OrderSucess.jsp" class="action-card">
            <div class="action-icon icon-cart">
                <i class="fa-solid fa-receipt"></i>
            </div>
            <h3>Order History</h3>
            <p>Check recent orders and item status</p>
        </a>
    </div>
</div>

</body>
</html>