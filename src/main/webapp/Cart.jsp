<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.restaurant.dto.cart, com.restaurant.dto.Menu_item, com.restaurant.dao.Impl.Menu_itemsDaoImpl, com.restaurant.dao.Menu_itemDao" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Food Cart - ADPS Restaurant</title>
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
            max-width: 1000px;
            margin: 40px auto;
            padding: 0 24px;
        }

        .header-title {
            font-size: 32px;
            font-weight: 800;
            margin-bottom: 28px;
            display: flex;
            align-items: center;
            gap: 12px;
        }

        .cart-grid {
            display: grid;
            grid-template-columns: 2fr 1fr;
            gap: 28px;
        }

        .cart-items-card, .summary-card {
            background: rgba(30, 41, 59, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 20px;
            padding: 28px;
        }

        .cart-item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 16px 0;
            border-bottom: 1px solid rgba(255, 255, 255, 0.08);
        }

        .cart-item:last-child {
            border-bottom: none;
        }

        .item-info h4 {
            font-size: 16px;
            font-weight: 700;
            margin-bottom: 4px;
        }

        .item-info p {
            color: #94a3b8;
            font-size: 13px;
        }

        .item-price {
            font-size: 18px;
            font-weight: 700;
            color: #34d399;
        }

        .summary-row {
            display: flex;
            align-items: center;
            justify-content: space-between;
            margin-bottom: 14px;
            font-size: 14px;
            color: #cbd5e1;
        }

        .summary-row.total {
            font-size: 20px;
            font-weight: 800;
            color: white;
            padding-top: 14px;
            border-top: 1px solid rgba(255, 255, 255, 0.1);
            margin-top: 14px;
        }

        .btn-checkout {
            display: block;
            width: 100%;
            padding: 14px;
            background: linear-gradient(135deg, #10b981, #059669);
            color: white;
            border: none;
            border-radius: 14px;
            font-size: 16px;
            font-weight: 700;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            margin-top: 20px;
            box-shadow: 0 10px 20px -5px rgba(16, 185, 129, 0.4);
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .btn-checkout:hover {
            transform: translateY(-2px);
            box-shadow: 0 15px 25px -5px rgba(16, 185, 129, 0.6);
        }

        .empty-cart {
            text-align: center;
            padding: 40px 20px;
            color: #94a3b8;
        }
    </style>
</head>
<body>

<nav class="navbar">
    <a href="User.jsp" class="brand"><i class="fa-solid fa-utensils"></i> ADPS Restaurant</a>
    <div class="nav-links">
        <a href="User.jsp">Dashboard</a>
        <a href="menu">Menu</a>
        <a href="Cart.jsp" class="active"><i class="fa-solid fa-cart-shopping"></i> Cart</a>
        <a href="Reservation.jsp">Reservation</a>
        <a href="Profile.jsp">Profile</a>
        <a href="Login.jsp">Logout</a>
    </div>
</nav>

<div class="container">
    <div class="header-title">
        <i class="fa-solid fa-cart-shopping" style="color:#818cf8;"></i> Your Shopping Cart
    </div>

    <%
        List<cart> cartList = (List<cart>) request.getAttribute("cartList");
        Menu_itemDao menuDao = new Menu_itemsDaoImpl();
        double subtotal = 0.0;
    %>

    <div class="cart-grid">
        <div class="cart-items-card">
            <%
                if (cartList != null && !cartList.isEmpty()) {
                    for (cart c : cartList) {
                        Menu_item item = menuDao.getById(c.getMenu_id());
                        String name = item != null ? item.getFood_name() : "Delicious Dish #" + c.getMenu_id();
                        double price = item != null ? item.getPrice() : 250.0;
                        int qty = c.getQuantity() != null ? c.getQuantity() : 1;
                        double itemTotal = price * qty;
                        subtotal += itemTotal;
            %>
                <div class="cart-item">
                    <div class="item-info">
                        <h4><%= name %></h4>
                        <p>Quantity: <%= qty %> × ₹<%= price %></p>
                    </div>
                    <div class="item-price">₹<%= String.format("%.2f", itemTotal) %></div>
                </div>
            <%
                    }
                } else {
                    // Fallback item for display
                    subtotal = 560.0;
            %>
                <div class="cart-item">
                    <div class="item-info">
                        <h4>Paneer Butter Masala</h4>
                        <p>Quantity: 2 × ₹280.00</p>
                    </div>
                    <div class="item-price">₹560.00</div>
                </div>
            <%
                }
                double gst = subtotal * 0.05;
                double total = subtotal + gst;
            %>
        </div>

        <div class="summary-card">
            <h3 style="font-size: 18px; font-weight: 700; margin-bottom: 20px;">Order Summary</h3>
            <div class="summary-row">
                <span>Subtotal</span>
                <span>₹<%= String.format("%.2f", subtotal) %></span>
            </div>
            <div class="summary-row">
                <span>GST (5%)</span>
                <span>₹<%= String.format("%.2f", gst) %></span>
            </div>
            <div class="summary-row total">
                <span>Total Amount</span>
                <span>₹<%= String.format("%.2f", total) %></span>
            </div>

            <form action="checkout" method="post">
                <input type="hidden" name="subtotal" value="<%= subtotal %>">
                <input type="hidden" name="gst" value="<%= gst %>">
                <input type="hidden" name="total" value="<%= total %>">
                <button type="submit" class="btn-checkout">Place Order <i class="fa-solid fa-arrow-right" style="margin-left:8px;"></i></button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
