package com.restaurant.servlet;

import java.io.IOException;
import java.util.List;

import com.restaurant.dao.Menu_itemDao;
import com.restaurant.dao.Impl.Menu_itemsDaoImpl;
import com.restaurant.dto.Menu_item;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Menu_itemDao menuDao = new Menu_itemsDaoImpl();
        List<Menu_item> menuList = menuDao.getAllMenu_item();

        req.setAttribute("menuList", menuList);
        req.getRequestDispatcher("Menu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
