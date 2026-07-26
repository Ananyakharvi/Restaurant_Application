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

@WebServlet("/orderstatus")
public class OrderStatus extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OrderDao dao = new OrderDaoImpl();

        OrdersDTO order = dao.getById(
                Integer.parseInt(req.getParameter("orderId")));

        if (order != null) {

            order.setStatus(req.getParameter("status"));

            dao.updateOrder(order);

            req.setAttribute("success", "Order Status Updated Successfully!");
        } else {
            req.setAttribute("error", "Order Not Found!");
        }

        req.getRequestDispatcher("orders.jsp").forward(req, resp);
	}

}
