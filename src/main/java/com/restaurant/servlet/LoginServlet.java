package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.ChefDao;
import com.restaurant.dao.UserDao;
import com.restaurant.dao.Impl.ChefDaoImpl;
import com.restaurant.dao.Impl.UserDaoImpl;
import com.restaurant.dto.Chef;
import com.restaurant.dto.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                req.setAttribute("msg", "Please fill in all fields.");
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
                return;
            }

            email = email.trim();
            password = password.trim();

            // First check if user is a Chef / Admin
            ChefDao cdao = new ChefDaoImpl();
            Chef chef = cdao.getByEmailAndPassword(email, password);

            if (chef != null) {
                HttpSession session = req.getSession();
                session.setAttribute("chef", chef);
                resp.sendRedirect("admin");
                return;
            }

            // Next check if user is a Customer / User
            UserDao udao = new UserDaoImpl();
            User user = udao.getByEmailAndPassword(email, password);

            if (user != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("User.jsp");
                return;
            }

            req.setAttribute("msg", "Invalid Email or Password");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "Database Error: Unable to connect to MySQL database on localhost:3306.");
        }

        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }
}