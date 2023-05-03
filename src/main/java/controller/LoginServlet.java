package main.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.dao.CustomerDAO;
import main.java.entity.Customer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public LoginServlet() {
        super();
        this.customerDAO = CustomerDAO.getDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request,  response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		Customer customer = null;
		
		try {
			customer = customerDAO.selectLogIn(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (customer != null) {
			request.getSession().setAttribute("user", customer.getEmail());
			request.getSession().setAttribute("firstname", customer.getFirstname());
			response.sendRedirect("home");
		} else {
			String error = "Incorrect user or password";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request,  response);		
		}
	}

}
