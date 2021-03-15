package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sendLoginForm(response, false);
	}

	private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage)
			throws SecurityException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Login</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");

		if (withErrorMessage) {
			out.println("Login Failed . Please try  again. <BR>");
		}

		out.println("<BR>");
		out.println("<BR>Please enter your user name and password.");
		out.println("<BR> <FORM METHOD=POST>");
		out.println("<BR>User Name: <INPUT TYPE=TEXT NAME=userName>");
		out.println("<BR>Password : <INPUT TYPE=PASSWORD NAME=password>");
		out.println("<BR> <INPUT TYPE=SUBMIT VALUE=Submit>");
		out.println("</FORM>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (userName != null && password != null && userName.equals("vinodh") && password.equals("simplilearn")) {
			// forward the control to WelcomeServet
			RequestDispatcher dispatcher = request.getRequestDispatcher("WelcomeServlet");
			dispatcher.forward(request, response);
		}else {
			sendLoginForm(response, true);
		}
	}

}
