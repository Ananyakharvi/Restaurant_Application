package com.restaurant.servlet;

import java.io.IOException;
import java.util.List;

import com.restaurant.dao.ReserveDao;
import com.restaurant.dao.Impl.ReserveDaoImpl;
import com.restaurant.dto.Reserve;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewreservation")
public class ViewReservation extends HttpServlet {
	
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        ReserveDao dao = new ReserveDaoImpl();

	        List<Reserve> reserveList = dao.getAllReserve();

	        req.setAttribute("reserveList", reserveList);

	        req.getRequestDispatcher("viewReservation.jsp").forward(req, resp);
	    }
}
