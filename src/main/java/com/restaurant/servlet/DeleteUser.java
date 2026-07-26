package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.UserDao;
import com.restaurant.dao.Impl.UserDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		UserDao udao=new UserDaoImpl();
		int user_id=Integer.parseInt(req.getParameter("user_id"));
		
		udao.deleteUser(user_id);
		
		req.setAttribute("success", "User Deleted Successfully!");
		
		req.getRequestDispatcher("admin.jsp").forward(req, resp);
		
	}

}
