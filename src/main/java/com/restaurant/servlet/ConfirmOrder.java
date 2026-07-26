package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.OrderDao;
import com.restaurant.dao.Impl.OrderDaoImpl;
import com.restaurant.dto.OrdersDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/confirmorder")
public class ConfirmOrder extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OrderDao dao = new OrderDaoImpl();

        OrdersDTO order = new OrdersDTO();

        order.setTableNo(Integer.parseInt(req.getParameter("tableNo")));
        order.setItemsCount(Integer.parseInt(req.getParameter("itemsCount")));
        order.setStatus(req.getParameter("status"));
        order.setTime(req.getParameter("time"));

        dao.addOrders(order);

        req.setAttribute("success", "Order Confirmed Successfully!");

        req.getRequestDispatcher("orders.jsp").forward(req, resp);
	}

}
