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

@WebServlet("/viewmenu")
public class ViewMenu extends HttpServlet {

	@Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Menu_itemDao mdao = new Menu_itemsDaoImpl();

	        List<Menu_item> menuList = mdao.getAllMenu_item();

	        req.setAttribute("menuList", menuList);

	        req.getRequestDispatcher("viewMenu.jsp").forward(req, resp);
	    
	}
}
