package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Obtaining the Query String

@WebServlet("/HttpRequestDemoServlet")
public class HttpRequestDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Obtaining the Query String</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("Query  String : " + request.getQueryString() + "<BR>");
		
		out.println("<FORM METHOD = GET>");
		out.println("<BR>First Name : <INPUT TYPE=TEXT NAME=FirstName>");
		out.println("<BR>Last Name : <INPUT TYPE=TEXT NAME=LastName>");
		out.println("<BR><INPUT TYPE=SUBMIT VALUE=Submit >");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
