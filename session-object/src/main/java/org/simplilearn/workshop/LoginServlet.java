package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(userName.equalsIgnoreCase("vinodh") && password.equalsIgnoreCase("simplilearn")) {
			out.println("you are successfully logged in !");
			out.println("<BR> Welcome , " + userName);
			
			HttpSession session = request.getSession();
			session.setAttribute("sname", userName);
		}else {
			out.println("sorry , username or password error");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
	}

}
