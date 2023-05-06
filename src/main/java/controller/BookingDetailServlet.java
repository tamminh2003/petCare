package main.java.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.AppointmentDAO;
import main.java.dao.CustomerDAO;
import main.java.entity.Customer;
import main.java.entity.VetTimeslot;

/**
 * Servlet implementation class BookingDetailServlet
 */
@WebServlet("/BookingDetailServlet")
public class BookingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingDetailServlet() {
        super();
 
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppointmentDAO appointmentDAO = new AppointmentDAO();
			
		// Data needed to create appointment
		String petType = request.getParameter("petType");
		String appointmentType = request.getParameter("appointmentType");
		String userEmail = (String) request.getSession().getAttribute("user");
		
		try {
			ArrayList<VetTimeslot> vetTimeslots = appointmentDAO.getAvailableVetTimeslot(appointmentType);
			System.out.println(vetTimeslots.size());
			System.out.println(vetTimeslots);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bookingDetail.jsp");
		dispatcher.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
