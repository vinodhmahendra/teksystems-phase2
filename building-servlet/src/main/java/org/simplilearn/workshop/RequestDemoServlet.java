package org.simplilearn.workshop;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/RequestDemoServlet")
public class RequestDemoServlet implements Servlet {
	
	
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("Server Port : " + request.getServerPort());
		System.out.println("Server Name : " + request.getServerName());
		System.out.println("Protocol    : " + request.getProtocol());
		System.out.println("Character Encoding : "+request.getCharacterEncoding());
		System.out.println("Content Type : " + request.getContentType());
		System.out.println("Content Length : " + request.getContentLength());
		System.out.println("Remote Address : " +request.getRemoteAddr());
		System.out.println("Remote Host : " + request.getRemoteHost());
		System.out.println("Scheme : " + request.getScheme());
		
		Enumeration<String> parameters = request.getParameterNames();
		while ( parameters.hasMoreElements()) {
			String parameterName = parameters.nextElement();
			System.out.println("Parameter Name : " +parameterName);
			System.out.println("Parameter Value : " + request.getParameter(parameterName));
		}
		
		Enumeration<String> attributes = request.getAttributeNames();
		while ( attributes.hasMoreElements()) {
			String attribute = attributes.nextElement();
			System.out.println("Attribute Name : " +attribute);
			System.out.println("Attribute Value : " + request.getAttribute(attribute));
			
		}
		
	}
 

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	public void destroy() {
		
	}

	public ServletConfig getServletConfig() {
		
		return null;
	}

	
	public String getServletInfo() {
		
		return null; 
	}

	


}
