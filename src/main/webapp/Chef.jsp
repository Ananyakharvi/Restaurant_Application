<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chef & Admin Control Board - ADPS Restaurant</title>
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
            display: flex;
            background: #0f172a;
            color: #f8fafc;
            min-height: 100vh;
        }

        .sidebar {
            width: 270px;
            min-height: 100vh;
            background: rgba(30, 41, 59, 0.8);
            backdrop-filter: blur(16px);
            border-right: 1px solid rgba(255, 255, 255, 0.1);
            padding: 28px 20px;
            display: flex;
            flex-direction: column;
        }

        .sidebar-brand {
            display: flex;
            align-items: center;
            gap: 12px;
            font-size: 20px;
            font-weight: 800;
            color: #818cf8;
            margin-bottom: 40px;
            padding: 0 8px;
        }

        .sidebar nav a {
            display: flex;
            align-items: center;
            gap: 14px;
            color: #94a3b8;
            padding: 14px 18px;
            margin-bottom: 8px;
            text-decoration: none;
            border-radius: 14px;
            font-size: 14px;
            font-weight: 600;
            transition: all 0.2s ease;
        }

        .sidebar nav a:hover, .sidebar nav a.active {
            background: rgba(99, 102, 241, 0.18);
            color: #818cf8;
        }

        .main-content {
            flex: 1;
            padding: 36px;
            overflow-y: auto;
        }

        .topbar {
            background: rgba(30, 41, 59, 0.5);
            border: 1px solid rgba(255, 255, 255, 0.08);
            border-radius: 20px;
            padding: 20px 28px;
            margin-bottom: 32px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .topbar h2 {
            font-size: 24px;
            font-weight: 800;
            letter-spacing: -0.5px;
        }

        .cards {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(180px, 1fr));
            gap: 20px;
            margin-bottom: 36px;
        }

        .card {
            background: rgba(30, 41, 59, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            padding: 22px;
            border-radius: 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
            transition: transform 0.3s;
        }

        .card:hover {
            transform: translateY(-4px);
        }

        .card-info h4 {
            font-size: 12px;
            color: #94a3b8;
            margin-bottom: 4px;
            font-weight: 600;
        }

        .card-info h2 {
            font-size: 26px;
            font-weight: 800;
        }

        .card-icon {
            width: 48px;
            height: 48px;
            border-radius: 14px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 20px;
        }

        .icon1 { background: rgba(99, 102, 241, 0.2); color: #818cf8; }
        .icon2 { background: rgba(59, 130, 246, 0.2); color: #60a5fa; }
        .icon3 { background: rgba(245, 158, 11, 0.2); color: #fbbf24; }
        .icon-accepted { background: rgba(16, 185, 129, 0.2); color: #34d399; }
        .icon-rejected { background: rgba(239, 68, 68, 0.2); color: #f87171; }

        .dashboard-grid {
            display: grid;
            grid-template-columns: 2fr 1fr;
            gap: 28px;
            margin-bottom: 36px;
        }

        .section-card {
            background: rgba(30, 41, 59, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 20px;
            padding: 28px;
            margin-bottom: 28px;
        }

        .section-title {
            font-size: 19px;
            font-weight: 700;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            text-align: left;
        }

        th, td {
            padding: 14px 16px;
            border-bottom: 1px solid rgba(255, 255, 255, 0.05);
            font-size: 14px;
        }

        th {
            color: #94a3b8;
            font-weight: 600;
            text-transform: uppercase;
            font-size: 12px;
            letter-spacing: 0.5px;
        }

        .badge-status {
            padding: 5px 12px;
            border-radius: 20px;
            font-size: 11px;
            font-weight: 800;
            letter-spacing: 0.3px;
            display: inline-block;
        }

        .status-pending { background: rgba(245, 158, 11, 0.2); color: #fbbf24; border: 1px solid rgba(245, 158, 11, 0.3); }
        .status-accepted { background: rgba(16, 185, 129, 0.2); color: #34d399; border: 1px solid rgba(16, 185, 129, 0.3); }
        .status-rejected { background: rgba(239, 68, 68, 0.2); color: #f87171; border: 1px solid rgba(239, 68, 68, 0.3); }
        .status-completed { background: rgba(59, 130, 246, 0.2); color: #60a5fa; border: 1px solid rgba(59, 130, 246, 0.3); }
        .status-confirmed { background: rgba(168, 85, 247, 0.2); color: #c084fc; border: 1px solid rgba(168, 85, 247, 0.3); }

        .status-form {
            display: flex;
            align-items: center;
            gap: 8px;
        }

        .status-form select {
            padding: 6px 10px;
            background: rgba(15, 23, 42, 0.85);
            border: 1px solid rgba(255, 255, 255, 0.15);
            border-radius: 10px;
            color: white;
            font-size: 12px;
            font-weight: 600;
        }

        .btn-update {
            padding: 6px 12px;
            background: linear-gradient(135deg, #6366f1, #4f46e5);
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 12px;
            font-weight: 700;
            cursor: pointer;
            transition: all 0.2s;
        }

        .btn-update:hover {
            transform: translateY(-1px);
            background: linear-gradient(135deg, #4f46e5, #4338ca);
        }

        .form-group {
            margin-bottom: 16px;
        }

        .form-group label {
            display: block;
            font-size: 12px;
            font-weight: 600;
            color: #cbd5e1;
            margin-bottom: 6px;
        }

        .form-group input, .form-group select, .form-group textarea {
            width: 100%;
            padding: 12px 14px;
            background: rgba(15, 23, 42, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 12px;
            color: white;
            font-size: 13px;
            outline: none;
        }

        .form-group input:focus, .form-group textarea:focus {
            border-color: #818cf8;
        }

        .btn-add {
            width: 100%;
            padding: 14px;
            background: linear-gradient(135deg, #10b981, #059669);
            color: white;
            border: none;
            border-radius: 12px;
            font-weight: 700;
            font-size: 15px;
            cursor: pointer;
            transition: transform 0.2s, box-shadow 0.2s;
            margin-top: 10px;
            box-shadow: 0 10px 20px -5px rgba(16, 185, 129, 0.4);
        }

        .btn-add:hover {
            transform: translateY(-2px);
            box-shadow: 0 15px 25px -5px rgba(16, 185, 129, 0.6);
        }

        .msg-alert {
            margin-bottom: 20px;
            padding: 14px 18px;
            border-radius: 14px;
            font-size: 14px;
            font-weight: 600;
            background: rgba(16, 185, 129, 0.15);
            border: 1px solid rgba(16, 185, 129, 0.4);
            color: #6ee7b7;
        }
    </style>
</head>
<body>

<%
    Object msg = request.getAttribute("msg");
    Object userCount = request.getAttribute("userCount");
    Object orderCount = request.getAttribute("orderCount");
    Object pendingCount = request.getAttribute("pendingCount");
    Object acceptedCount = request.getAttribute("acceptedCount");
    Object rejectedCount = request.getAttribute("rejectedCount");
    Object completedCount = request.getAttribute("completedCount");

    java.util.List<?> orders = (java.util.List<?>) request.getAttribute("orders");
    java.util.List<?> reserveList = (java.util.List<?>) request.getAttribute("reserveList");
    java.util.List<?> menuList = (java.util.List<?>) request.getAttribute("menuList");
%>

<aside class="sidebar">
    <div class="sidebar-brand">
        <i class="fa-solid fa-fire-burner"></i> Chef & Admin Board
    </div>
    <nav>
        <a href="admin" class="active"><i class="fa-solid fa-chart-line"></i> Dashboard</a>
        <a href="#orders-section"><i class="fa-solid fa-receipt"></i> Kitchen Orders</a>
        <a href="#menu-table-section"><i class="fa-solid fa-utensils"></i> Manage Recipes</a>
        <a href="#reservations-section"><i class="fa-solid fa-calendar-check"></i> Reservations</a>
        <a href="menu"><i class="fa-solid fa-eye"></i> Customer Menu View</a>
        <a href="Login.jsp" style="margin-top: auto;"><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
    </nav>
</aside>

<main class="main-content">

    <header class="topbar">
        <h2>Welcome to Executive Chef Board 👨‍🍳</h2>
        <span style="color:#94a3b8; font-size:14px;"><i class="fa-regular fa-clock"></i> Realtime Kitchen & Dining Control</span>
    </header>

    <% if (msg != null) { %>
        <div class="msg-alert"><i class="fa-solid fa-circle-check"></i> <%= msg %></div>
    <% } %>

    <section class="cards">
        <div class="card">
            <div class="card-info">
                <h4>Users</h4>
                <h2><%= userCount != null ? userCount : "1" %></h2>
            </div>
            <div class="card-icon icon1"><i class="fa-solid fa-users"></i></div>
        </div>

        <div class="card">
            <div class="card-info">
                <h4>Total Orders</h4>
                <h2><%= orderCount != null ? orderCount : "2" %></h2>
            </div>
            <div class="card-icon icon2"><i class="fa-solid fa-receipt"></i></div>
        </div>

        <div class="card">
            <div class="card-info">
                <h4>Pending</h4>
                <h2><%= pendingCount != null ? pendingCount : "1" %></h2>
            </div>
            <div class="card-icon icon3"><i class="fa-solid fa-hourglass-half"></i></div>
        </div>

        <div class="card">
            <div class="card-info">
                <h4>Accepted</h4>
                <h2><%= acceptedCount != null ? acceptedCount : "1" %></h2>
            </div>
            <div class="card-icon icon-accepted"><i class="fa-solid fa-circle-check"></i></div>
        </div>

        <div class="card">
            <div class="card-info">
                <h4>Not Accepted</h4>
                <h2><%= rejectedCount != null ? rejectedCount : "0" %></h2>
            </div>
            <div class="card-icon icon-rejected"><i class="fa-solid fa-circle-xmark"></i></div>
        </div>
    </section>

    <div class="dashboard-grid">
        <!-- Live Kitchen Orders -->
        <div class="section-card" id="orders-section">
            <div class="section-title">
                <span><i class="fa-solid fa-fire" style="color:#f97316; margin-right:8px;"></i> Active Kitchen Orders & Status</span>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Order ID</th>
                        <th>User</th>
                        <th>Total Bill</th>
                        <th>Current Status</th>
                        <th>Change Status</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (orders != null && !orders.isEmpty()) {
                            for (Object o : orders) {
                                Object orderId = o.getClass().getMethod("getOrder_id").invoke(o);
                                Object userId = o.getClass().getMethod("getUser_id").invoke(o);
                                Object totalAmt = o.getClass().getMethod("getTotal_amt").invoke(o);
                                Object status = o.getClass().getMethod("getOrder_status").invoke(o);
                                String statusStr = status != null ? status.toString() : "PENDING";

                                String badgeClass = "status-pending";
                                if ("ACCEPTED".equalsIgnoreCase(statusStr)) badgeClass = "status-accepted";
                                else if ("REJECTED".equalsIgnoreCase(statusStr) || "NOT_ACCEPTED".equalsIgnoreCase(statusStr)) badgeClass = "status-rejected";
                                else if ("COMPLETED".equalsIgnoreCase(statusStr)) badgeClass = "status-completed";
                    %>
                        <tr>
                            <td>#<%= orderId %></td>
                            <td>User-<%= userId %></td>
                            <td>₹<%= totalAmt != null ? totalAmt : "350.00" %></td>
                            <td>
                                <span class="badge-status <%= badgeClass %>">
                                    <%= "REJECTED".equalsIgnoreCase(statusStr) ? "NOT ACCEPTED" : statusStr %>
                                </span>
                            </td>
                            <td>
                                <form action="admin" method="post" class="status-form">
                                    <input type="hidden" name="action" value="updateStatus">
                                    <input type="hidden" name="orderId" value="<%= orderId %>">
                                    <select name="status">
                                        <option value="ACCEPTED" <%= "ACCEPTED".equalsIgnoreCase(statusStr) ? "selected" : "" %>>ACCEPTED</option>
                                        <option value="REJECTED" <%= "REJECTED".equalsIgnoreCase(statusStr) ? "selected" : "" %>>NOT ACCEPTED</option>
                                        <option value="PREPARING" <%= "PREPARING".equalsIgnoreCase(statusStr) ? "selected" : "" %>>PREPARING</option>
                                        <option value="COMPLETED" <%= "COMPLETED".equalsIgnoreCase(statusStr) ? "selected" : "" %>>COMPLETED</option>
                                        <option value="PENDING" <%= "PENDING".equalsIgnoreCase(statusStr) ? "selected" : "" %>>PENDING</option>
                                    </select>
                                    <button type="submit" class="btn-update">Save</button>
                                </form>
                            </td>
                        </tr>
                    <%
                            }
                        } else {
                    %>
                        <tr>
                            <td>#101</td>
                            <td>User-1</td>
                            <td>₹588.00</td>
                            <td><span class="badge-status status-accepted">ACCEPTED</span></td>
                            <td>
                                <form action="admin" method="post" class="status-form">
                                    <input type="hidden" name="action" value="updateStatus">
                                    <input type="hidden" name="orderId" value="101">
                                    <select name="status">
                                        <option value="ACCEPTED" selected>ACCEPTED</option>
                                        <option value="REJECTED">NOT ACCEPTED</option>
                                        <option value="PREPARING">PREPARING</option>
                                        <option value="COMPLETED">COMPLETED</option>
                                    </select>
                                    <button type="submit" class="btn-update">Save</button>
                                </form>
                            </td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <!-- Add New Recipe / Menu Form -->
        <div class="section-card" id="add-menu-section">
            <div class="section-title">
                <span><i class="fa-solid fa-plus-circle" style="color:#10b981; margin-right:8px;"></i> Add New Recipe</span>
            </div>
            <form action="admin" method="post">
                <input type="hidden" name="action" value="addMenu">
                
                <div class="form-group">
                    <label>Recipe Name</label>
                    <input type="text" name="foodName" placeholder="e.g. Malai Paneer Tikka" required>
                </div>

                <div class="form-group">
                    <label>Category</label>
                    <select name="category" required>
                        <option value="Starters">Starters</option>
                        <option value="Main Course">Main Course</option>
                        <option value="Breads">Breads</option>
                        <option value="Desserts">Desserts</option>
                        <option value="Beverages">Beverages</option>
                    </select>
                </div>

                <div class="form-group">
                    <label>Price (₹)</label>
                    <input type="number" step="0.01" name="price" placeholder="e.g. 290" required>
                </div>

                <div class="form-group">
                    <label>Image URL (Optional)</label>
                    <input type="text" name="image" placeholder="https://...">
                </div>

                <div class="form-group">
                    <label>Description</label>
                    <textarea name="description" rows="3" placeholder="Brief recipe description..."></textarea>
                </div>

                <button type="submit" class="btn-add"><i class="fa-solid fa-plus"></i> Add Recipe to Menu</button>
            </form>
        </div>
    </div>

    <!-- Active Menu Recipes Table -->
    <div class="section-card" id="menu-table-section">
        <div class="section-title">
            <span><i class="fa-solid fa-utensils" style="color:#818cf8; margin-right:8px;"></i> Current Restaurant Recipes & Menu</span>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Menu ID</th>
                    <th>Recipe Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (menuList != null && !menuList.isEmpty()) {
                        for (Object item : menuList) {
                            Object id = item.getClass().getMethod("getMenu_id").invoke(item);
                            Object name = item.getClass().getMethod("getFood_name").invoke(item);
                            Object cat = item.getClass().getMethod("getCategory").invoke(item);
                            Object pr = item.getClass().getMethod("getPrice").invoke(item);
                            Object desc = item.getClass().getMethod("getDescription").invoke(item);
                %>
                    <tr>
                        <td>#<%= id %></td>
                        <td><b><%= name %></b></td>
                        <td><span class="badge-status status-confirmed"><%= cat %></span></td>
                        <td>₹<%= pr %></td>
                        <td style="color:#94a3b8; font-size:13px;"><%= desc %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td>#1</td>
                        <td><b>Paneer Butter Masala</b></td>
                        <td><span class="badge-status status-confirmed">Main Course</span></td>
                        <td>₹280.00</td>
                        <td style="color:#94a3b8;">Rich cottage cheese cooked in velvet tomato gravy.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <!-- Table Reservations Section -->
    <div class="section-card" id="reservations-section">
        <div class="section-title">
            <span><i class="fa-solid fa-chair" style="color:#34d399; margin-right:8px;"></i> Dining Table Reservations</span>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Reserve ID</th>
                    <th>User ID</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Guests</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (reserveList != null && !reserveList.isEmpty()) {
                        for (Object r : reserveList) {
                            Object reserveId = r.getClass().getMethod("getReserve_id").invoke(r);
                            Object userId = r.getClass().getMethod("getUser_id").invoke(r);
                            Object reservedDate = r.getClass().getMethod("getReserved_date").invoke(r);
                            Object reservedTime = r.getClass().getMethod("getReserved_time").invoke(r);
                            Object guests = r.getClass().getMethod("getGuests").invoke(r);
                            Object status = r.getClass().getMethod("getStatus").invoke(r);
                %>
                    <tr>
                        <td>#<%= reserveId %></td>
                        <td>User-<%= userId %></td>
                        <td><%= reservedDate %></td>
                        <td><%= reservedTime %></td>
                        <td><%= guests != null ? guests : 2 %> Persons</td>
                        <td><span class="badge-status status-confirmed"><%= status %></span></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td>#R-501</td>
                        <td>User-1</td>
                        <td>2026-07-26</td>
                        <td>19:30:00</td>
                        <td>4 Persons</td>
                        <td><span class="badge-status status-confirmed">CONFIRMED</span></td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

</main>

</body>
</html>