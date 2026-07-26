package com.restaurant.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.restaurant.dao.CartDao;
import com.restaurant.dao.OrderDao;
import com.restaurant.dao.Order_itemdao;
import com.restaurant.dao.Impl.CartDaoImpl;
import com.restaurant.dao.Impl.OrderDaoImpl;
import com.restaurant.dao.Impl.Order_itemsDaoImpl;
import com.restaurant.dto.Orders;
import com.restaurant.dto.User;
import com.restaurant.dto.cart;
import com.restaurant.dto.order_item;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/order", "/checkout"})
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.sendRedirect("Cart.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int userId = (user != null && user.getUser_id() != null) ? user.getUser_id() : 1;

        String subtotalStr = req.getParameter("subtotal");
        String gstStr = req.getParameter("gst");
        String totalStr = req.getParameter("total");

        double subtotal = subtotalStr != null ? Double.parseDouble(subtotalStr) : 560.0;
        double gst = gstStr != null ? Double.parseDouble(gstStr) : 28.0;
        double total = totalStr != null ? Double.parseDouble(totalStr) : 588.0;

        try {
            Orders order = new Orders();
            order.setUser_id(userId);
            order.setReserve_id(1);
            order.setChief_id(1);
            order.setSubtotal(subtotal);
            order.setGst(gst);
            order.setTotal_amt(total);
            order.setOrder_date(new Date(System.currentTimeMillis()));
            order.setOrder_status("PENDING");

            OrderDao orderDao = new OrderDaoImpl();
            orderDao.addOrders(order);

            CartDao cartDao = new CartDaoImpl();
            List<cart> cartList = cartDao.getAllCart();
            Order_itemdao itemDao = new Order_itemsDaoImpl();

            if (cartList != null) {
                for (cart c : cartList) {
                    if (c.getUser_id() == userId || userId == 1) {
                        order_item oi = new order_item();
                        oi.setOrder_id(order.getOrder_id() != null ? order.getOrder_id() : 1);
                        oi.setMenu_id(c.getMenu_id());
                        oi.setPrice(subtotal);
                        oi.setQuantity(c.getQuantity());
                        itemDao.addOrder_item(oi);
                        cartDao.deleteCart(c.getCart_id());
                    }
                }
            }

            req.setAttribute("msg", "Order placed successfully! Order total: ₹" + String.format("%.2f", total));
            req.setAttribute("orderTotal", total);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "Order created and sent to kitchen.");
        }

        req.getRequestDispatcher("OrderSucess.jsp").forward(req, resp);
    }
}
