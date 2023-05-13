package main.java.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.AppointmentDAO;
import main.java.dao.VetDAO;
import main.java.entity.Vet;

@WebServlet("/BookingConfirmServlet")
public class BookingConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VetDAO vetDAO;
	private AppointmentDAO appointmentDAO;

    public BookingConfirmServlet() {
        super();
        this.vetDAO = VetDAO.getDAO();
        this.appointmentDAO = AppointmentDAO.getDAO();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String timeslot = request.getParameter("timeslot");
		Vet vet = vetDAO.selectId(Integer.parseInt(request.getParameter("vetId")));
		request.setAttribute("timeslot", timeslot);
		request.setAttribute("vet", vet);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bookingConfirm.jsp");
		dispatcher.forward(request,  response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String timeslot = request.getParameter("timeslot");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDate appointmentDate = LocalDate.parse(timeslot, formatter);
		LocalTime startTime = LocalTime.parse(timeslot, formatter);
		Vet vet = vetDAO.selectId(Integer.parseInt(request.getParameter("vetid")));
		appointmentDAO.bookAppointment(1, vet.getId(), appointmentDate, startTime, "Sample booking", "GENERAL", "DOG", 50.00);
		response.sendRedirect("home");
	}

}
