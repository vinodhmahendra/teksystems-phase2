package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeUser extends HttpServlet {

	public WelcomeUser() {
		System.out.println("constructor is called --- > {}");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init method called ---> {}");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy method called --> {}");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read the request parameter
		String firstName = request.getParameter("fname");

		// set the MIME type
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println("<h1> Welcome ! <font color='blue'>" + firstName + " </font></h1>");
		
		ServletConfig config = getServletConfig();
		
		String userName = config.getInitParameter("username");
		
		out.println("<h1> Welcome ! <font color='blue'>" + userName + " </font></h1>");
		
		out.close();

	}

}
