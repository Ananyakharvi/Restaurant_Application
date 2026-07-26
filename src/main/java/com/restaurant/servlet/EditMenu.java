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

@WebServlet("/editmenu")
public class EditMenu extends HttpServlet{
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	        Menu_itemDao mdao = new Menu_itemsDaoImpl();

	        int menuId = Integer.parseInt(req.getParameter("menu_id"));

	        Menu_item menu = mdao.getById(menuId);

	        req.setAttribute("menu", menu);

	        req.getRequestDispatcher("updateMenu.jsp").forward(req, resp);
}
}