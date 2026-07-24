package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.UserDao;
import com.restaurant.dao.Impl.UserDaoImpl;
import com.restaurant.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateuser")
public class UpdateUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao udao=new UserDaoImpl();
		
		User user=new User();
		
		user.setUser_id(Integer.parseInt(req.getParameter("user_id")));
		user.setFull_name(req.getParameter("full_name"));
		user.setPhone(Long.parseLong(req.getParameter("phone")));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		
		udao.updateUser(user);
		
		req.setAttribute("success", "User Updated Successfully!");
		
		req.getRequestDispatcher("admin.jsp").forward(req, resp);
		
		
	}

}
