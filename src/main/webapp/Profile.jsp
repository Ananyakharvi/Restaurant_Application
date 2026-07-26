<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="com.restaurant.dto.User" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Profile - ADPS Restaurant</title>
            <link
                href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@300;400;500;600;700&display=swap"
                rel="stylesheet">
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

                .nav-links a:hover,
                .nav-links a.active {
                    color: #818cf8;
                }

                .container {
                    max-width: 540px;
                    margin: 60px auto;
                    padding: 0 24px;
                }

                .profile-card {
                    background: rgba(30, 41, 59, 0.7);
                    backdrop-filter: blur(16px);
                    border: 1px solid rgba(255, 255, 255, 0.1);
                    border-radius: 24px;
                    padding: 40px;
                    box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
                    text-align: center;
                }

                .avatar-circle {
                    width: 80px;
                    height: 80px;
                    background: linear-gradient(135deg, #6366f1, #a855f7);
                    border-radius: 50%;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    font-size: 32px;
                    color: white;
                    margin: 0 auto 20px;
                    box-shadow: 0 10px 20px -5px rgba(99, 102, 241, 0.5);
                }

                h2 {
                    font-size: 24px;
                    font-weight: 700;
                    margin-bottom: 24px;
                }

                .info-list {
                    text-align: left;
                    margin-bottom: 32px;
                }

                .info-item {
                    background: rgba(15, 23, 42, 0.6);
                    border: 1px solid rgba(255, 255, 255, 0.08);
                    padding: 16px 20px;
                    border-radius: 14px;
                    margin-bottom: 14px;
                    display: flex;
                    align-items: center;
                    gap: 16px;
                }

                .info-item i {
                    color: #818cf8;
                    font-size: 18px;
                    width: 24px;
                }

                .info-label {
                    font-size: 12px;
                    color: #94a3b8;
                    margin-bottom: 2px;
                }

                .info-value {
                    font-size: 15px;
                    font-weight: 600;
                    color: #f1f5f9;
                }

                .btn-menu {
                    display: inline-block;
                    width: 100%;
                    padding: 14px;
                    background: linear-gradient(135deg, #6366f1, #4f46e5);
                    color: white;
                    text-decoration: none;
                    border-radius: 14px;
                    font-size: 15px;
                    font-weight: 600;
                    transition: transform 0.2s, box-shadow 0.2s;
                    box-shadow: 0 10px 20px -5px rgba(99, 102, 241, 0.4);
                }

                .btn-menu:hover {
                    transform: translateY(-2px);
                    box-shadow: 0 15px 25px -5px rgba(99, 102, 241, 0.6);
                }
            </style>
        </head>

        <body>

            <% User u=(User) session.getAttribute("user"); String name=(u !=null && u.getFull_name() !=null) ?
                u.getFull_name() : "John Doe" ; String email=(u !=null && u.getEmail() !=null) ? u.getEmail()
                : "user@example.com" ; String phone=(u !=null && u.getPhone() !=null) ? String.valueOf(u.getPhone())
                : "Not provided" ; %>

                <nav class="navbar">
                    <a href="User.jsp" class="brand"><i class="fa-solid fa-utensils"></i> ADPS Restaurant</a>
                    <div class="nav-links">
                        <a href="User.jsp">Dashboard</a>
                        <a href="menu">Menu</a>
                        <a href="Reservation.jsp">Reservation</a>
                        <a href="Profile.jsp" class="active">Profile</a>
                        <a href="Login.jsp">Logout</a>
                    </div>
                </nav>

                <div class="container">
                    <div class="profile-card">
                        <div class="avatar-circle">
                            <i class="fa-solid fa-user"></i>
                        </div>
                        <h2>User Profile</h2>

                        <div class="info-list">
                            <div class="info-item">
                                <i class="fa-solid fa-signature"></i>
                                <div>
                                    <div class="info-label">Full Name</div>
                                    <div class="info-value">
                                        <%= name %>
                                    </div>
                                </div>
                            </div>

                            <div class="info-item">
                                <i class="fa-solid fa-envelope"></i>
                                <div>
                                    <div class="info-label">Email Address</div>
                                    <div class="info-value">
                                        <%= email %>
                                    </div>
                                </div>
                            </div>

                            <div class="info-item">
                                <i class="fa-solid fa-phone"></i>
                                <div>
                                    <div class="info-label">Phone Number</div>
                                    <div class="info-value">
                                        <%= phone %>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <a href="menu" class="btn-menu">Browse Menu & Order <i class="fa-solid fa-arrow-right"
                                style="margin-left:6px;"></i></a>
                    </div>
                </div>

        </body>

        </html>