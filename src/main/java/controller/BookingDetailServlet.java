package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.time.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.AppointmentDAO;
import main.java.entity.VetTimeslot;

@WebServlet("/BookingDetailServlet")
public class BookingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookingDetailServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentDAO appointmentDAO = new AppointmentDAO();
			
		// Data needed to create appointment
		String petType = request.getParameter("petType");
		String appointmentType = request.getParameter("appointmentType");
		String userEmail = (String) request.getSession().getAttribute("user");
		
		try {
			ArrayList<VetTimeslot> vetTimeslots = appointmentDAO.getAvailableVetTimeslot(appointmentType);
			request.setAttribute("vetTimeslotList", vetTimeslots);
			
			for (int i = 0; i < vetTimeslots.size(); i++) {
				  System.out.println(vetTimeslots.get(i).toString());
			
				}

	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bookingDetail.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
