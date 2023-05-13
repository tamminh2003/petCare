package main.java.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.time.*;
import main.java.util.DateTime;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		if(session.getAttribute("userId") == null) {
//			request.getRequestDispatcher("/login?loginRequired").include(request, response);
//		};
		Integer displayWeek = 
			Integer.parseInt(
				request.getParameter("displayWeek") == null ? "0" : request.getParameter("displayWeek")
			); 
		LocalDate[] datesOfWeek = DateTime.getDatesOfWeek(displayWeek);
		LocalTime[] timeslotsTemplate = DateTime.getTimeslotsTemplate();
		
		request.setAttribute("timeslotsTemplate", timeslotsTemplate);
		request.setAttribute("datesOfWeek", datesOfWeek);
		request.setAttribute("displayWeek", displayWeek);
		request.setAttribute("petType", request.getParameter("petType"));
		request.setAttribute("petTypeList", new String[] {"dog", "cat", "bird"});
		request.setAttribute("appointmentType", request.getParameter("appointmentType"));
		request.setAttribute("appointmentTypeList", new String[] {"general", "surgery", "dentistry"});

		RequestDispatcher dispatcher = request.getRequestDispatcher("/booking.jsp");
		dispatcher.forward(request,  response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
