package com.restaurant.servlet;

import java.io.IOException;
import java.util.List;

import com.restaurant.dao.ChefDao;
import com.restaurant.dao.UserDao;
import com.restaurant.dao.Impl.ChefDaoImpl;
import com.restaurant.dao.Impl.UserDaoImpl;
import com.restaurant.dto.Chef;
import com.restaurant.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("Register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            UserDao udao = new UserDaoImpl();
            ChefDao cdao = new ChefDaoImpl();

            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            String phone = req.getParameter("phone");

            if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                req.setAttribute("msg", "Please fill in all required fields.");
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
                return;
            }

            email = email.trim();
            password = password.trim();

            User existingUser = udao.getByEmail(email);
            if (existingUser != null) {
                req.setAttribute("msg", "An account with this email address already exists.");
                req.getRequestDispatcher("Register.jsp").forward(req, resp);
                return;
            }

            List<Chef> existingChefs = cdao.getAllChef();

            // First registration in database -> Grant Admin / Chef Privileges!
            if (existingChefs == null || existingChefs.isEmpty()) {
                Chef chef = new Chef();
                chef.setChef_name(name);
                chef.setCh_email(email);
                chef.setCh_pswd(password);
                try {
                    chef.setCh_phone(Long.parseLong(phone));
                } catch (Exception ex) {
                    chef.setCh_phone(9876543210L);
                }
                cdao.addChef(chef);

                // Also register in user table
                User u = new User();
                u.setFull_name(name);
                u.setEmail(email);
                u.setPassword(password);
                u.setPhone(phone);
                udao.addUser(u);

                req.setAttribute("msg", "Registration Successful! As the first registered user, your account has been assigned Admin & Executive Chef privileges. Please log in.");
            } else {
                // Subsequent registrations -> Customer / User account
                User u = new User();
                u.setFull_name(name);
                u.setEmail(email);
                u.setPassword(password);
                u.setPhone(phone);
                udao.addUser(u);

                req.setAttribute("msg", "Registration Successful! Welcome to ADPS Restaurant. Please log in.");
            }

            req.getRequestDispatcher("Login.jsp").forward(req, resp);
            return;

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("msg", "Registration Error: Please ensure database is connected.");
        }

        req.getRequestDispatcher("Register.jsp").forward(req, resp);
    }
}