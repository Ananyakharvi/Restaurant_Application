package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.Restaurant_tableDao;
import com.restaurant.dao.Impl.RestaurantTableDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletetable")
public class DeleteTable extends HttpServlet {
	
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Restaurant_tableDao dao = new RestaurantTableDaoImpl();

	        int t_id = Integer.parseInt(req.getParameter("t_id"));

	        dao.deleteRestaurant_table(t_id);

	        req.setAttribute("success", "Table Deleted Successfully!");

	        req.getRequestDispatcher("admin.jsp").forward(req, resp);
	    }
}
