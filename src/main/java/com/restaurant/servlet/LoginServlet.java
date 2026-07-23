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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao udao=new UserDaoImpl();
		User login=udao.getByEmailAndPassword(req.getParameter("mail"), req.getParameter("password"));
		HttpSession session=req.getSession();
		
		if(login!=null) {
			
			session.setAttribute("user", login);
			
			if(login.getUser_id()==1) {
				req.setAttribute("success", "Login successfull! Welcome to admin");
				RequestDispatcher rd=req.getRequestDispatcher("admin.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("success", "Login Successfull..");
				RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
				rd.forward(req,resp);
			}
		}
		
		else {
			req.setAttribute("error", "Failed to login!");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
