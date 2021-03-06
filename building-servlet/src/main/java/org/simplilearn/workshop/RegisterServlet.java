package org.simplilearn.workshop;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		Enumeration<String> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String header = enumeration.nextElement();
			out.println(header + " : " + request.getHeader(header) + "<BR>");
		}
		
//		out.println("<HTML>");
//		out.println("<HEAD>");
//		out.println("<TITLE> The Get Method </TITLE>");
//		out.println("</HEAD>");
//		out.println("<BODY>");
//		out.println("<H2>The servlet has received a GET. Now, click the button bellow.</H2>");
//		out.println("<FORM METHOD=POST>");
//		out.println("<INPUT TYPE = SUBMIT VALUE = Submit>");
//		out.println("</FORM>");
//		out.println("</BODY>");
//		out.println("</HTML>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> The POST Method </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H2>The servlet has received a POST. Thank you.</H2>");
		
		out.println("</BODY>");
		out.println("</HTML>");
		
	}

}
