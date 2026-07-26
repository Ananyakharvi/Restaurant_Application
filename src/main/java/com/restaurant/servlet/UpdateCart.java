package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.CartDao;
import com.restaurant.dao.Impl.CartDaoImpl;
import com.restaurant.dto.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updatecart")
public class UpdateCart extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 CartDao dao = new CartDaoImpl();

	        Cart c = new Cart();

	        c.setCart_id(Integer.parseInt(req.getParameter("cart_id")));
	        c.setUser_id(Integer.parseInt(req.getParameter("user_id")));
	        c.setMenu_id(Integer.parseInt(req.getParameter("menu_id")));
	        c.setQuantity(Integer.parseInt(req.getParameter("quantity")));

	        dao.updateCart(c);

	        req.setAttribute("success", "Cart Updated Successfully!");

	        req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

}
