package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/dateServlet")
public class DateServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		LocalDate today = LocalDate.now();
		out.println("<h1>Today's Date <font color='blue'>" +today+ " </font></h1>");
	}

}
