package com.restaurant.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import com.restaurant.dao.ReserveDao;
import com.restaurant.dao.Impl.ReserveDaoImpl;
import com.restaurant.dto.Reserve;
import com.restaurant.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({"/reservation", "/ReservationServlet"})
public class ReservationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("Reservation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        String dateStr = req.getParameter("date");
        String timeStr = req.getParameter("time");
        String guestsStr = req.getParameter("guests");

        try {
            Date date = Date.valueOf(dateStr);
            Time time = Time.valueOf(timeStr.length() == 5 ? timeStr + ":00" : timeStr);
            int guests = Integer.parseInt(guestsStr);

            Reserve reserve = new Reserve();
            reserve.setUser_id(user != null && user.getUser_id() != null ? user.getUser_id() : 1);
            reserve.setT_id(1); // Default table assignment
            reserve.setReserved_date(date);
            reserve.setReserved_time(time);
            reserve.setGuests(guests);
            reserve.setStatus("CONFIRMED");

            ReserveDao reserveDao = new ReserveDaoImpl();
            reserveDao.addReserve(reserve);

            req.setAttribute("msg", "Table reserved successfully for " + guests + " guests on " + dateStr + " at " + timeStr + "!");
        } catch (Exception e) {
            req.setAttribute("msg", "Error reserving table. Please check input formats.");
            e.printStackTrace();
        }

        req.getRequestDispatcher("Reservation.jsp").forward(req, resp);
    }
}
