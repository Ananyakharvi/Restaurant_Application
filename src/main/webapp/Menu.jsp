<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.restaurant.dto.Menu_item" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gourmet Menu & Recipes - ADPS Restaurant</title>
    <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@300;400;500;600;700;800&display=swap" rel="stylesheet">
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
            position: sticky;
            top: 0;
            z-index: 100;
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
            max-width: 1240px;
            margin: 40px auto;
            padding: 0 24px;
        }
        .header-section {
            text-align: center;
            margin-bottom: 40px;
        }
        .header-section h1 {
            font-size: 38px;
            font-weight: 800;
            background: linear-gradient(135deg, #818cf8, #c084fc, #f472b6);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            margin-bottom: 10px;
            letter-spacing: -0.5px;
        }
        .header-section p {
            color: #94a3b8;
            font-size: 16px;
        }
        .menu-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(340px, 1fr));
            gap: 28px;
        }
        .menu-card {
            background: rgba(30, 41, 59, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 20px;
            overflow: hidden;
            transition: transform 0.3s, box-shadow 0.3s;
            display: flex;
            flex-direction: column;
        }
        .menu-card:hover {
            transform: translateY(-6px);
            box-shadow: 0 20px 35px -10px rgba(0, 0, 0, 0.5);
            border-color: rgba(129, 140, 248, 0.4);
        }
        .card-img {
            height: 200px;
            background: #1e293b;
            position: relative;
            overflow: hidden;
        }
        .card-img img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.4s ease;
        }
        .menu-card:hover .card-img img {
            transform: scale(1.06);
        }
        .category-badge {
            position: absolute;
            top: 14px;
            right: 14px;
            background: rgba(15, 23, 42, 0.85);
            backdrop-filter: blur(8px);
            color: #a78bfa;
            padding: 5px 12px;
            border-radius: 20px;
            font-size: 12px;
            font-weight: 700;
            border: 1px solid rgba(255, 255, 255, 0.1);
        }
        .card-body {
            padding: 22px;
            display: flex;
            flex-direction: column;
            flex: 1;
        }
        .food-name {
            font-size: 19px;
            font-weight: 700;
            margin-bottom: 8px;
            color: #f1f5f9;
        }
        .food-desc {
            font-size: 13px;
            color: #94a3b8;
            line-height: 1.5;
            margin-bottom: 18px;
            flex: 1;
        }
        .card-footer {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-top: auto;
            padding-top: 16px;
            border-top: 1px solid rgba(255, 255, 255, 0.08);
        }
        .price {
            font-size: 22px;
            font-weight: 800;
            color: #34d399;
        }
        .qty-controls {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .qty-controls input[type="number"] {
            width: 52px;
            padding: 8px;
            background: #0f172a;
            border: 1px solid rgba(255, 255, 255, 0.15);
            border-radius: 10px;
            color: white;
            text-align: center;
            font-weight: 600;
        }
        .btn-cart {
            background: linear-gradient(135deg, #6366f1, #4f46e5);
            color: white;
            border: none;
            padding: 10px 16px;
            border-radius: 12px;
            font-size: 13px;
            font-weight: 700;
            cursor: pointer;
            transition: all 0.2s;
            box-shadow: 0 4px 12px rgba(99, 102, 241, 0.3);
        }
        .btn-cart:hover {
            background: linear-gradient(135deg, #4f46e5, #4338ca);
            transform: translateY(-1px);
        }
    </style>
</head>
<body>

<nav class="navbar">
    <a href="User.jsp" class="brand"><i class="fa-solid fa-utensils"></i> ADPS Restaurant</a>
    <div class="nav-links">
        <a href="User.jsp">Dashboard</a>
        <a href="menu" class="active">Menu & Recipes</a>
        <a href="Reservation.jsp">Reservation</a>
        <a href="Profile.jsp">Profile</a>
        <a href="Login.jsp">Logout</a>
    </div>
</nav>

<div class="container">
    <div class="header-section">
        <h1>Crafted Recipes & Specialities</h1>
        <p>Hand-crafted culinary creations prepared by Head Chef Gordon</p>
    </div>

    <div class="menu-grid">
    <%
        List<Menu_item> list = (List<Menu_item>) request.getAttribute("menuList");

        if (list != null && !list.isEmpty()) {
            for (Menu_item m : list) {
                String imgUrl = (m.getImage() != null && !m.getImage().trim().isEmpty()) 
                    ? m.getImage() 
                    : "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&w=600&q=80";
    %>
        <div class="menu-card">
            <div class="card-img">
                <img src="<%= imgUrl %>" alt="<%= m.getFood_name() %>" onerror="this.src='https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&w=600&q=80';">
                <span class="category-badge"><%= m.getCategory() != null ? m.getCategory() : "Chef Special" %></span>
            </div>
            <div class="card-body">
                <div class="food-name"><%= m.getFood_name() %></div>
                <div class="food-desc"><%= m.getDescription() != null ? m.getDescription() : "Freshly crafted with authentic spices and local ingredients." %></div>
                <form action="CartServlet" method="post" class="card-footer">
                    <div class="price">₹<%= m.getPrice() != null ? m.getPrice() : "0.00" %></div>
                    <div class="qty-controls">
                        <input type="number" name="qty" value="1" min="1" max="10">
                        <input type="hidden" name="menuId" value="<%= m.getMenu_id() %>">
                        <button type="submit" class="btn-cart"><i class="fa-solid fa-cart-plus"></i> Add to Cart</button>
                    </div>
                </form>
            </div>
        </div>
    <%
            }
        } else {
            // High quality fallback recipe showcase
            Object[][] fallbackRecipes = {
                {"Crispy Paneer 65", "Starters", "Crispy cottage cheese cubes tossed in spicy South Indian curry leaf & chili temperate.", 240.0, "https://images.unsplash.com/photo-1567188040759-fb8a883dc6d8?auto=format&fit=crop&w=600&q=80", 1},
                {"Chicken Tandoori Tikka", "Starters", "Tender chicken chunks marinated in yogurt, Kashmiri red chili & smoked in clay oven.", 320.0, "https://images.unsplash.com/photo-1599487488170-d11ec9c172f0?auto=format&fit=crop&w=600&q=80", 2},
                {"Paneer Butter Masala", "Main Course", "Soft cottage cheese cubes simmering in rich velvet tomato, cashew & butter gravy.", 280.0, "https://images.unsplash.com/photo-1631452180519-c014fe946bc7?auto=format&fit=crop&w=600&q=80", 3},
                {"Hyderabadi Chicken Biryani", "Main Course", "Fragrant long-grain basmati rice layered with slow-cooked spiced chicken & saffron.", 360.0, "https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?auto=format&fit=crop&w=600&q=80", 4},
                {"Butter Chicken Delicacy", "Main Course", "Charcoal-grilled tandoori chicken simmered in rich silky tomato cream gravy.", 370.0, "https://images.unsplash.com/photo-1588166524941-3bf61a9c41db?auto=format&fit=crop&w=600&q=80", 5},
                {"Mutton Rogan Josh", "Main Course", "Tender lamb morsels cooked in traditional Kashmiri red chili & aromatic fennel sauce.", 420.0, "https://images.unsplash.com/photo-1545247181-516773cae754?auto=format&fit=crop&w=600&q=80", 6},
                {"Butter Garlic Naan", "Breads", "Freshly baked tandoori naan brushed with roasted garlic & melted butter.", 60.0, "https://images.unsplash.com/photo-1601050690597-df0568f70950?auto=format&fit=crop&w=600&q=80", 7},
                {"Sizzling Chocolate Brownie", "Desserts", "Hot fudgy chocolate brownie topped with vanilla ice cream & hot fudge sauce.", 180.0, "https://images.unsplash.com/photo-1606313564200-e75d5e30476c?auto=format&fit=crop&w=600&q=80", 8},
                {"Mango Lassi Delight", "Beverages", "Creamy chilled yogurt smoothie blended with Alphonso mango pulp & cardamom.", 110.0, "https://images.unsplash.com/photo-1553530666-ba11a7da3888?auto=format&fit=crop&w=600&q=80", 9}
            };

            for (Object[] recipe : fallbackRecipes) {
    %>
        <div class="menu-card">
            <div class="card-img">
                <img src="<%= recipe[4] %>" alt="<%= recipe[0] %>">
                <span class="category-badge"><%= recipe[1] %></span>
            </div>
            <div class="card-body">
                <div class="food-name"><%= recipe[0] %></div>
                <div class="food-desc"><%= recipe[2] %></div>
                <form action="CartServlet" method="post" class="card-footer">
                    <div class="price">₹<%= recipe[3] %></div>
                    <div class="qty-controls">
                        <input type="number" name="qty" value="1" min="1" max="10">
                        <input type="hidden" name="menuId" value="<%= recipe[5] %>">
                        <button type="submit" class="btn-cart"><i class="fa-solid fa-cart-plus"></i> Add to Cart</button>
                    </div>
                </form>
            </div>
        </div>
    <%
            }
        }
    %>
    </div>
</div>

</body>
</html>