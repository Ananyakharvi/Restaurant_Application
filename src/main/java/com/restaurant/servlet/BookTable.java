package com.restaurant.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import com.restaurant.dao.ReserveDao;
import com.restaurant.dao.Impl.ReserveDaoImpl;
import com.restaurant.dto.Reserve;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/booktable")
public class BookTable extends HttpServlet {

	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        ReserveDao dao = new ReserveDaoImpl();

	        Reserve reserve = new Reserve();

	        reserve.setUser_id(Integer.parseInt(req.getParameter("user_id")));
	        reserve.setT_id(Integer.parseInt(req.getParameter("t_id")));
	        reserve.setReserved_date(Date.valueOf(req.getParameter("reserved_date")));
	        reserve.setReserved_time(Time.valueOf(req.getParameter("reserved_time")));
	        reserve.setGuests(Integer.parseInt(req.getParameter("guests")));
	        reserve.setStatus(req.getParameter("status"));

	        dao.addReseve(reserve);

	        req.setAttribute("success", "Table Booked Successfully");

	        req.getRequestDispatcher("customer.jsp").forward(req, resp);
	    
	    }
}
