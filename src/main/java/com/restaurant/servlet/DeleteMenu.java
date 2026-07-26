package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.Menu_itemDao;
import com.restaurant.dao.Impl.Menu_itemsDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletemenu")
public class DeleteMenu extends HttpServlet {
	
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Menu_itemDao mdao = new Menu_itemsDaoImpl();

	        int menuId = Integer.parseInt(req.getParameter("menu_id"));

	        mdao.deleteMenu_item(menuId);

	        req.setAttribute("success", "Menu Deleted Successfully!");

	        req.getRequestDispatcher("admin.jsp").forward(req, resp);
	    }
}
