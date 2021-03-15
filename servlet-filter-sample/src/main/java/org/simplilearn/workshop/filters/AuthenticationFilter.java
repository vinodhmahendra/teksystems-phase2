package org.simplilearn.workshop.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");

		PrintWriter out = response.getWriter();

		if (userName.equals("vinodh") && passWord.equals("simplilearn")) {
			chain.doFilter(request, response); // invokes a welcome servlet
		} else {
			out.println("<h1> Username and Password are incorrect!!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
