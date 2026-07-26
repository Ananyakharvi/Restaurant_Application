package com.restaurant.servlet;

import java.io.IOException;
import java.util.List;

import com.restaurant.dao.CartDao;
import com.restaurant.dao.Impl.CartDaoImpl;
import com.restaurant.dto.User;
import com.restaurant.dto.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/cart", "/CartServlet"})
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            req.setAttribute("msg", "Please login to view your cart.");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            return;
        }

        CartDao cartDao = new CartDaoImpl();
        List<cart> userCartList = cartDao.getAllCart();

        req.setAttribute("cartList", userCartList);
        req.getRequestDispatcher("OrderSucess.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            req.setAttribute("msg", "Please login to add items to your cart.");
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            return;
        }

        String menuIdStr = req.getParameter("menuId");
        String qtyStr = req.getParameter("qty");

        try {
            int menuId = Integer.parseInt(menuIdStr);
            int qty = Integer.parseInt(qtyStr);

            cart c = new cart();
            c.setUser_id(user.getUser_id() != null ? user.getUser_id() : 1);
            c.setMenu_id(menuId);
            c.setQuantity(qty);

            CartDao cartDao = new CartDaoImpl();
            cartDao.addCart(c);

            req.setAttribute("msg", "Item added to cart successfully!");
        } catch (Exception e) {
            req.setAttribute("msg", "Failed to add item to cart.");
            e.printStackTrace();
        }

        resp.sendRedirect("OrderSucess.jsp");
    }
}
