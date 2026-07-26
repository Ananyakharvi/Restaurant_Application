package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.CartDao;
import com.restaurant.dao.Impl.CartDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCart extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

        CartDao dao = new CartDaoImpl();

        int cart_id = Integer.parseInt(req.getParameter("cart_id"));

        dao.deleteCart(cart_id);

        req.setAttribute("success", "Item Removed from Cart Successfully!");

        req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

}
