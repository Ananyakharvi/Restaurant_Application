package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.UserDao;
import com.restaurant.dao.Impl.UserDaoImpl;
import com.restaurant.dto.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao udao=new UserDaoImpl();
		User u=new User();
		
		User alreadyExist=udao.getByEmail("email");
		if(alreadyExist==null) {
		u.setFull_name(req.getParameter("name"));
		u.setEmail(req.getParameter("email"));
		u.setPassword(req.getParameter("password"));

		
		udao.addUser(u);
		
		req.setAttribute("RegistrationSuccess","User Account Created");
		RequestDispatcher rd=req.getRequestDispatcher("Registration.jsp");
		rd.forward(req, resp);
		
		}
		else {
			req.setAttribute("RegistrationError","User Failed to Register");
			RequestDispatcher rd=req.getRequestDispatcher("Registration.jsp");
			rd.forward(req, resp);
			
			
		}
		
		
	}
}
