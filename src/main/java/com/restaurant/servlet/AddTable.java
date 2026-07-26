package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.Restaurant_tableDao;
import com.restaurant.dao.Impl.RestaurantTableDaoImpl;
import com.restaurant.dto.Restaurant_table;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addtable")
public class AddTable extends HttpServlet {
	
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Restaurant_tableDao dao = new RestaurantTableDaoImpl();

	        Restaurant_table table = new Restaurant_table();

	        table.setTable_number(Integer.parseInt(req.getParameter("table_number")));
	        table.setCapacity(Integer.parseInt(req.getParameter("capacity")));
	        table.setStatus(req.getParameter("status"));

	        dao.addReseve(table);

	        req.setAttribute("success", "Table Added Successfully!");

	        req.getRequestDispatcher("admin.jsp").forward(req, resp);
}
}