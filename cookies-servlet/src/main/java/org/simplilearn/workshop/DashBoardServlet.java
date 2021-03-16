package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DashBoardServlet
 */
@WebServlet("/dashboard")
public class DashBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			String userName = cookies[0].getValue();
			if(!userName.equals("") || userName!= null) {
				out.println("<B>Welcome to dashboard");
				out.println("<BR> Welcome , " + userName);
			}}
		else {
				out.println("Please login first");
				request.getRequestDispatcher("/login.html").include(request, response);
			}
		
		out.close();
	}

}
