<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADPS Restaurant</title>

<style>

body {
    margin: 0;
    font-family: Arial, sans-serif;
    color: #333;
}

.navbar {
    background-color: #222;
    padding: 15px;
    text-align: center;
}

.navbar a {
    color: #f8f8f8;
    margin: 15px;
    text-decoration: none;
    font-size: 18px;
}

.navbar a:hover {
    color: #ff9800;
}

.hero {
    height: 90vh;
    background: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)),
                url('https://images.unsplash.com/photo-1552566626-52f8b828add9') no-repeat center;
    background-size: cover;
    color: white;
    text-align: center;
    padding-top: 150px;
}

.hero h1 {
    font-size: 50px;
    color: #ffcc00;
}

.hero p {
    font-size: 20px;
    color: #eeeeee;
}

.btn {
    padding: 12px 25px;
    background-color: #ff5722;
    color: white;
    text-decoration: none;
    font-size: 18px;
    border-radius: 5px;
}

.btn:hover {
    background-color: #e64a19;
}

.section {
    padding: 40px;
    text-align: center;
    color: #444;
}

.footer {
    background-color: #222;
    color: #ddd;
    padding: 15px;
    text-align: center;
}

</style>

</head>
<body>

<div class="navbar">
    <a href="index.jsp">Home</a>
    <a href="menu">Menu</a>
    <a href="login.jsp">Login</a>
    <a href="register.jsp">Register</a>
</div>

<div class="hero">
    <h1>Welcome to ADPS Restaurant</h1>
    <p>Delicious Food | Easy Ordering | Quick Service</p>

    <br><br>

    <a href="menu" class="btn">Explore Menu</a>
</div>

<div class="section">
    <h2>About Us</h2>
    <p>
        Welcome to ADPS Restaurant! We provide delicious food with a smooth and easy ordering system.
        Enjoy your favorite meals without waiting.
    </p>
</div>

<div class="footer">
    <p>© 2026 ADPS Restaurant | All Rights Reserved</p>
</div>

</body>
</html>s