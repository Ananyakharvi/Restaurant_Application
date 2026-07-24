package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.Menu_itemDao;
import com.restaurant.dao.Impl.Menu_itemsDaoImpl;
import com.restaurant.dto.Menu_item;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addmenu")
public class AddMenuervlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        Menu_itemDao mdao = new Menu_itemsDaoImpl();

        Menu_item menu = new Menu_item();

        menu.setFood_name(req.getParameter("food_name"));
        menu.setCategory(req.getParameter("category"));
        menu.setDescription(req.getParameter("description"));
        menu.setPrice(Double.parseDouble(req.getParameter("price")));
        menu.setImage(req.getParameter("image"));
        menu.setIs_available(Boolean.parseBoolean(req.getParameter("is_available")));

        mdao.addMenu_item(menu);

        req.setAttribute("success", "Menu Added Successfully!");

        req.getRequestDispatcher("admin.jsp").forward(req, resp);
	} 
}
