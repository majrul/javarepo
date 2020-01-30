package com.lti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.model.RegisterM;
import com.lti.register.RegisterDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register.lti")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//reading form data and storing in object
		RegisterM rm =new RegisterM();
		rm.setName(request.getParameter("name"));
		rm.setEmail(request.getParameter("email"));
		rm.setPass(request.getParameter("password"));
		rm.setCity(request.getParameter("city"));
		
		
		RegisterDao dao = new RegisterDao();
		
		boolean done = dao.insert(rm);
		
		if(done)
			response.sendRedirect("confirmation.html");
		else
			response.sendRedirect("error.html");
	}

}
