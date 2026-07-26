package com.restaurant.servlet;

import java.io.IOException;
import java.util.List;

import com.restaurant.dao.Restaurant_tableDao;
import com.restaurant.dao.Impl.RestaurantTableDaoImpl;
import com.restaurant.dto.Restaurant_table;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewtable")
public class ViewTable extends HttpServlet {
	

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        Restaurant_tableDao dao = new RestaurantTableDaoImpl();

	        List<Restaurant_table> tableList = dao.getAllRestaurant_table();

	        req.setAttribute("tableList", tableList);

	        req.getRequestDispatcher("viewTable.jsp").forward(req, resp);
	    }
}
