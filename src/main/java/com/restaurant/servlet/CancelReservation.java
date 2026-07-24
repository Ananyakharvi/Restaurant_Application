package com.restaurant.servlet;

import java.io.IOException;

import com.restaurant.dao.ReserveDao;
import com.restaurant.dao.Impl.ReserveDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancelreservation")
public class CancelReservation extends HttpServlet {

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        ReserveDao dao = new ReserveDaoImpl();

	        int reserveId = Integer.parseInt(req.getParameter("reserve_id"));

	        dao.deleteReserve(reserveId);

	        req.setAttribute("success", "Reservation Cancelled Successfully");

	        req.getRequestDispatcher("customer.jsp").forward(req, resp);
	    }
}
