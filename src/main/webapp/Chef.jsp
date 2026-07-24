<%@ page import="java.util.*" %>
<%@ page import="com.restaurant.dto.OrderDTO" %>

<%
    List<OrderDTO> orders = (List<OrderDTO>) request.getAttribute("orders");

    int total = 0, inProgress = 0, ready = 0, completed = 0, cancelled = 0;

    if (orders != null) {
        for (OrderDTO o : orders) {
            total++;
            String s = o.getStatus();

            if ("In Progress".equals(s)) inProgress++;
            else if ("Ready".equals(s)) ready++;
            else if ("Completed".equals(s)) completed++;
            else if ("Cancelled".equals(s)) cancelled++;
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chef Dashboard</title>

<style>
body {
    margin:0;
    font-family: Arial;
    background:#f5f6fa;
}

.header {
    background:#2c3e50;
    color:white;
    padding:15px;
    text-align:center;
}

.container {
    padding:20px;
}

.cards {
    display:flex;
    gap:15px;
    margin-bottom:20px;
}

.card {
    flex:1;
    background:white;
    padding:15px;
    border-radius:8px;
    text-align:center;
    box-shadow:0 2px 5px rgba(0,0,0,0.1);
}

.card h3 {
    margin:0;
    font-size:16px;
}

.card p {
    font-size:22px;
    font-weight:bold;
    margin:5px 0 0;
}

.table-box {
    background:white;
    padding:15px;
    border-radius:8px;
    box-shadow:0 2px 5px rgba(0,0,0,0.1);
}

table {
    width:100%;
    border-collapse:collapse;
}

th, td {
    padding:10px;
    border-bottom:1px solid #ddd;
    text-align:center;
}

.status {
    padding:5px 10px;
    border-radius:5px;
    color:white;
}

</style>

</head>

<body>

<div class="header">
    <h2>Chef Dashboard</h2>
</div>

<div class="container">

<!-- STAT CARDS -->
<div class="cards">
    <div class="card">
        <h3>Total Orders</h3>
        <p><%= total %></p>
    </div>

    <div class="card">
        <h3>In Progress</h3>
        <p><%= inProgress %></p>
    </div>

    <div class="card">
        <h3>Ready</h3>
        <p><%= ready %></p>
    </div>

    <div class="card">
        <h3>Completed</h3>
        <p><%= completed %></p>
    </div>

    <div class="card">
        <h3>Cancelled</h3>
        <p><%= cancelled %></p>
    </div>
</div>

<!-- ORDER TABLE -->
<div class="table-box">
    <h3>Orders</h3>

    <table>
        <tr>
            <th>ID</th>
            <th>Table</th>
            <th>Items</th>
            <th>Status</th>
            <th>Time</th>
        </tr>

        <%
            if (orders != null) {
                for (OrderDTO o : orders) {
        %>

        <tr>
            <td><%= o.getOrderId() %></td>
            <td><%= o.getTableNo() %></td>
            <td><%= o.getItemsCount() %></td>

            <td>
                <span class="status"
                style="background:
                <%= "Completed".equals(o.getStatus()) ? "green" :
                    "Ready".equals(o.getStatus()) ? "orange" :
                    "Cancelled".equals(o.getStatus()) ? "red" :
                    "blue" %>;">
                    <%= o.getStatus() %>
                </span>
            </td>

            <td><%= o.getTime() %></td>
        </tr>

        <%
                }
            }
        %>

    </table>
</div>

</div>

</body>
</html>ss