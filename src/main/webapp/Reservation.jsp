<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table Reservation - ADPS Restaurant</title>
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
            max-width: 500px;
            margin: 60px auto;
            padding: 0 24px;
        }

        .reservation-card {
            background: rgba(30, 41, 59, 0.7);
            backdrop-filter: blur(16px);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 24px;
            padding: 40px 32px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
            text-align: center;
        }

        .card-icon {
            width: 64px;
            height: 64px;
            background: linear-gradient(135deg, #10b981, #059669);
            border-radius: 18px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 28px;
            color: white;
            margin: 0 auto 20px;
            box-shadow: 0 10px 20px -5px rgba(16, 185, 129, 0.5);
        }

        h2 {
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 8px;
        }

        p.subtitle {
            color: #94a3b8;
            font-size: 14px;
            margin-bottom: 28px;
        }

        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }

        .form-group label {
            display: block;
            font-size: 13px;
            font-weight: 600;
            color: #cbd5e1;
            margin-bottom: 8px;
        }

        .input-wrapper {
            position: relative;
        }

        .input-wrapper i {
            position: absolute;
            left: 16px;
            top: 50%;
            transform: translateY(-50%);
            color: #64748b;
            font-size: 16px;
        }

        .input-wrapper input {
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

        .input-wrapper input:focus {
            border-color: #10b981;
            box-shadow: 0 0 0 3px rgba(16, 185, 129, 0.2);
            background: rgba(15, 23, 42, 0.9);
        }

        button.btn-reserve {
            width: 100%;
            padding: 14px;
            background: linear-gradient(135deg, #10b981, #059669);
            color: white;
            border: none;
            border-radius: 14px;
            font-size: 15px;
            font-weight: 600;
            cursor: pointer;
            transition: transform 0.2s, box-shadow 0.2s;
            margin-top: 10px;
            box-shadow: 0 10px 20px -5px rgba(16, 185, 129, 0.4);
        }

        button.btn-reserve:hover {
            transform: translateY(-2px);
            box-shadow: 0 15px 25px -5px rgba(16, 185, 129, 0.6);
        }

        .msg-alert {
            margin-top: 20px;
            padding: 12px 16px;
            border-radius: 12px;
            font-size: 14px;
            background: rgba(16, 185, 129, 0.15);
            border: 1px solid rgba(16, 185, 129, 0.3);
            color: #6ee7b7;
        }
    </style>
</head>
<body>

<nav class="navbar">
    <a href="User.jsp" class="brand"><i class="fa-solid fa-utensils"></i> ADPS Restaurant</a>
    <div class="nav-links">
        <a href="User.jsp">Dashboard</a>
        <a href="menu">Menu</a>
        <a href="Reservation.jsp" class="active">Reservation</a>
        <a href="Profile.jsp">Profile</a>
        <a href="Login.jsp">Logout</a>
    </div>
</nav>

<div class="container">
    <div class="reservation-card">
        <div class="card-icon">
            <i class="fa-solid fa-calendar-days"></i>
        </div>
        <h2>Book Your Table</h2>
        <p class="subtitle">Reserve your spot for an exceptional dining experience</p>

        <form action="ReservationServlet" method="post">
            <div class="form-group">
                <label>Date</label>
                <div class="input-wrapper">
                    <i class="fa-solid fa-calendar"></i>
                    <input type="date" name="date" required>
                </div>
            </div>

            <div class="form-group">
                <label>Time</label>
                <div class="input-wrapper">
                    <i class="fa-solid fa-clock"></i>
                    <input type="time" name="time" required>
                </div>
            </div>

            <div class="form-group">
                <label>Number of Guests</label>
                <div class="input-wrapper">
                    <i class="fa-solid fa-users"></i>
                    <input type="number" name="guests" min="1" max="20" placeholder="e.g. 4" required>
                </div>
            </div>

            <button type="submit" class="btn-reserve">Confirm Reservation <i class="fa-solid fa-check" style="margin-left:6px;"></i></button>
        </form>

        <% if (request.getAttribute("msg") != null) { %>
            <div class="msg-alert"><%= request.getAttribute("msg") %></div>
        <% } %>
    </div>
</div>

</body>
</html>