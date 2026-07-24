package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.ChefDao;
import com.restaurant.dao.Impl.ChefDaoImpl;
import com.restaurant.dto.Chef;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addChef")
public class AddChef extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		ChefDao cdao=new ChefDaoImpl();
		Chef chef=new Chef();
		
		chef.setChef_id(Integer.parseInt(req.getParameter("chef_id")));
		chef.setChef_name(req.getParameter("chef_name"));
		chef.setCh_phone(Long.parseLong(req.getParameter("ch_phone")));
		chef.setCh_email(req.getParameter("ch_email"));
		chef.setCh_pswd(req.getParameter("ch_pswd"));
		
		cdao.addChef(chef);
		
		req.setAttribute("success", "Chef Added Successfully!");
		
		req.getRequestDispatcher("admin.jsp").forward(req, resp);
		
	}

}
