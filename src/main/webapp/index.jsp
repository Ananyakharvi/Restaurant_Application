<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Restaurant Home</title>
</head>

<body style="margin:0; font-family:Arial; background:black; color:white;">

<!-- Navbar -->
<div style="display:flex; justify-content:space-between; align-items:center; padding:20px 50px;">
    <h2 style="color:#d4a373;">Savory</h2>

    <div>
        <a href="index.jsp" style="margin:15px; color:white; text-decoration:none;">Home</a>
        <a href="menu.jsp" style="margin:15px; color:white; text-decoration:none;">Menu</a>
        <a href="gallery.jsp" style="margin:15px; color:white; text-decoration:none;">Gallery</a>
        <a href="contact.jsp" style="margin:15px; color:white; text-decoration:none;">Contact</a>
    </div>

    <a href="booking.jsp">
        <button style="background:#d4a373; padding:10px 20px; border:none;">
            Book a Table
        </button>
    </a>
</div>

<!-- Hero Section -->
<div style="
    height:90vh;
    background:url('images/food.jpg') no-repeat center/cover;
    display:flex;
    align-items:center;
    padding-left:80px;
">

    <div>
        <p style="letter-spacing:2px;">GOOD FOOD. GOOD MOOD.</p>

        <h1 style="font-size:60px; margin:10px 0;">
            Delicious Food for 
            <span style="color:#d4a373;">Every Mood</span>
        </h1>

        <p style="margin:20px 0;">
            Experience a delightful blend of flavors and excellent service.
        </p>

        <button style="
            background:#d4a373;
            color:black;
            padding:12px 20px;
            border:none;
            margin-right:10px;
        ">
            Explore Menu
        </button>

        <a href="booking.jsp">
        <button style="
            border:1px solid #d4a373;
            background:transparent;
            color:#d4a373;
            padding:12px 20px;
        ">
            Book a Table
        </button>
        </a>
    </div>

</div>

</body>
</html>