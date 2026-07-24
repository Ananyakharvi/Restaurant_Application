<%@ page import="java.util.List, com.restaurant.dto.MenuDTO" %>

<!DOCTYPE html>
<html>
<head><title>Menu</title></head>
<body>

<h2>Menu</h2>

<%
List<MenuDTO> list = (List<MenuDTO>) request.getAttribute("menuList");

if(list != null){
    for(MenuDTO m : list){
%>

<form action="CartServlet" method="post">
<b><%= m.getName() %></b><br>
Price: ₹<%= m.getPrice() %><br>

Qty: <input type="number" name="qty" value="1" min="1">

<input type="hidden" name="menuId" value="<%= m.getMenuId() %>">

<input type="submit" value="Add to Cart">
</form>

<hr>

<%
    }
}
%>

</body>
</html>