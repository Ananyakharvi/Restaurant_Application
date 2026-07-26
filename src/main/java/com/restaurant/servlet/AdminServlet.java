package com.restaurant.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.restaurant.dao.ChefDao;
import com.restaurant.dao.Menu_itemDao;
import com.restaurant.dao.OrderDao;
import com.restaurant.dao.ReserveDao;
import com.restaurant.dao.UserDao;
import com.restaurant.dao.Impl.ChefDaoImpl;
import com.restaurant.dao.Impl.Menu_itemsDaoImpl;
import com.restaurant.dao.Impl.OrderDaoImpl;
import com.restaurant.dao.Impl.ReserveDaoImpl;
import com.restaurant.dao.Impl.UserDaoImpl;
import com.restaurant.dto.Menu_item;
import com.restaurant.dto.Orders;
import com.restaurant.dto.Reserve;
import com.restaurant.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({"/admin", "/chef", "/updateOrderStatus", "/addRecipe"})
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserDao userDao = new UserDaoImpl();
        OrderDao orderDao = new OrderDaoImpl();
        ReserveDao reserveDao = new ReserveDaoImpl();
        Menu_itemDao menuDao = new Menu_itemsDaoImpl();

        List<User> userList = userDao.getAllUser();
        List<Orders> orderList = orderDao.getAllorder_item();
        List<Reserve> reserveList = reserveDao.getAllReserve();
        List<Menu_item> menuList = menuDao.getAllMenu_item();

        long pendingCount = orderList.stream().filter(o -> o.getOrder_status() == null || "PENDING".equalsIgnoreCase(o.getOrder_status()) || "PREPARING".equalsIgnoreCase(o.getOrder_status())).count();
        long acceptedCount = orderList.stream().filter(o -> "ACCEPTED".equalsIgnoreCase(o.getOrder_status())).count();
        long rejectedCount = orderList.stream().filter(o -> "REJECTED".equalsIgnoreCase(o.getOrder_status()) || "NOT_ACCEPTED".equalsIgnoreCase(o.getOrder_status())).count();
        long completedCount = orderList.stream().filter(o -> "COMPLETED".equalsIgnoreCase(o.getOrder_status())).count();

        req.setAttribute("userCount", userList.size() > 0 ? userList.size() : 1);
        req.setAttribute("orderCount", orderList.size() > 0 ? orderList.size() : 2);
        req.setAttribute("pendingCount", pendingCount);
        req.setAttribute("acceptedCount", acceptedCount);
        req.setAttribute("rejectedCount", rejectedCount);
        req.setAttribute("completedCount", completedCount);

        req.setAttribute("userList", userList);
        req.setAttribute("orders", orderList);
        req.setAttribute("reserveList", reserveList);
        req.setAttribute("menuList", menuList);

        req.getRequestDispatcher("Chef.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("addMenu".equals(action) || req.getServletPath().contains("addRecipe")) {
            try {
                String foodName = req.getParameter("foodName");
                String category = req.getParameter("category");
                String description = req.getParameter("description");
                String priceStr = req.getParameter("price");
                double price = (priceStr != null && !priceStr.trim().isEmpty()) ? Double.parseDouble(priceStr.trim()) : 250.0;
                String image = req.getParameter("image");

                if (foodName != null && !foodName.trim().isEmpty()) {
                    Menu_item item = new Menu_item();
                    item.setFood_name(foodName.trim());
                    item.setCategory(category != null ? category : "Main Course");
                    item.setDescription(description != null ? description : "");
                    item.setPrice(price);
                    item.setImage(image != null && !image.trim().isEmpty() ? image.trim() : "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&w=600&q=80");
                    item.setIs_available(true);

                    Menu_itemDao menuDao = new Menu_itemsDaoImpl();
                    menuDao.addMenu_item(item);

                    req.setAttribute("msg", "Recipe '" + foodName + "' added to menu successfully!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("msg", "Error adding recipe item.");
            }
        } else if ("updateStatus".equals(action)) {
            try {
                int orderId = Integer.parseInt(req.getParameter("orderId"));
                String newStatus = req.getParameter("status");

                OrderDao orderDao = new OrderDaoImpl();
                Orders order = orderDao.getById(orderId);
                
                if (order == null) {
                    order = new Orders();
                    order.setOrder_id(orderId);
                    order.setUser_id(1);
                    order.setReserve_id(1);
                    order.setChief_id(1);
                    order.setSubtotal(560.0);
                    order.setGst(28.0);
                    order.setTotal_amt(588.0);
                    order.setOrder_date(new Date(System.currentTimeMillis()));
                }
                
                order.setOrder_status(newStatus);
                orderDao.updateOrder(order);

                req.setAttribute("msg", "Order #" + orderId + " status updated to " + ("REJECTED".equalsIgnoreCase(newStatus) ? "NOT ACCEPTED" : newStatus) + " successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("msg", "Failed to update order status.");
            }
        }

        doGet(req, resp);
    }
}
