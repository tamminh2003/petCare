package main.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.CustomerDAO;
import main.java.dao.exception.CustomerDAOException;
import main.java.entity.Customer;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO;

    public SignupServlet() {
        super();
        customerDAO = CustomerDAO.getDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/signup.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phoneNumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			Customer customer = new Customer(-1, firstname, lastname, email, phoneNumber, password);
			customerDAO.insert(customer);
			response.sendRedirect("login");
		} catch (CustomerDAOException e) {
			System.out.println("Failed to insert customer.");
			String error = "There was a problem creating new user, please try again.";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			dispatcher.forward(request,  response);		
		}
	}

}
