<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Home</title>
</head>

<body style="margin:0; font-family:Arial; background:#0f172a; color:white;">

<!-- Navbar -->
<div style="display:flex; justify-content:space-between; align-items:center; padding:20px 50px; background:#1e293b;">
    <h2 style="color:#38bdf8;">Savory</h2>

    <div>
        <a href="index.jsp" style="margin:15px; color:white; text-decoration:none;">Home</a>
        <a href="menu.jsp" style="margin:15px; color:white; text-decoration:none;">Menu</a>
        <a href="gallery.jsp" style="margin:15px; color:white; text-decoration:none;">Gallery</a>
        <a href="contact.jsp" style="margin:15px; color:white; text-decoration:none;">Contact</a>
    </div>

    <a href="booking.jsp">
        <button style="background:#38bdf8; color:black; padding:10px 20px; border:none; border-radius:5px;">
            Book a Table
        </button>
    </a>
</div>

<!-- Hero Section -->
<div style="
    height:90vh;
    background:linear-gradient(rgba(15,23,42,0.8), rgba(15,23,42,0.8)), url('images/food.jpg');
    background-size:cover;
    display:flex;
    align-items:center;
    padding-left:80px;
">

    <div>
        <p style="letter-spacing:2px; color:#94a3b8;">GOOD FOOD. GOOD MOOD.</p>

        <h1 style="font-size:60px; margin:10px 0;">
            Delicious Food for 
            <span style="color:#a78bfa;">Every Mood</span>
        </h1>

        <p style="margin:20px 0; color:#cbd5f5;">
            Experience a delightful blend of flavors and excellent service.
        </p>

        <button style="
            background:#a78bfa;
            color:black;
            padding:12px 20px;
            border:none;
            margin-right:10px;
            border-radius:5px;
        ">
            Explore Menu
        </button>

        <a href="booking.jsp">
        <button style="
            border:1px solid #38bdf8;
            background:transparent;
            color:#38bdf8;
            padding:12px 20px;
            border-radius:5px;
        ">
            Book a Table
        </button>
        </a>
    </div>

</div>

</body>
</html>