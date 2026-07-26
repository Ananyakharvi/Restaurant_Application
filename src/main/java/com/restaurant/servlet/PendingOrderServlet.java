package com.restaurant.servlet;

import java.io.IOException;
import java.util.List;

import com.restaurant.dao.OrderDao;
import com.restaurant.dao.Impl.OrderDaoImpl;
import com.restaurant.dto.OrdersDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pendingOrder")
public class PendingOrderServlet extends HttpServlet {
	
	private OrderDao odao=new OrderDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
	}
		
	}


