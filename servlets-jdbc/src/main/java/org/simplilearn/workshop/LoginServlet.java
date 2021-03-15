package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.simplilearn.workshop.util.StringUtil.*;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		sendLoginForm(response,false);
	}

	private void sendLoginForm(HttpServletResponse response, boolean withErrorMessage) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Login</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		
		if(withErrorMessage) {
			out.println("Login failed , Please try again . <BR>");
		}
		
		out.println("<BR>");
		out.println("<BR><H2>Login Page</H2>");
		out.println("<BR>");
		out.println("<BR> <FORM METHOD=POST>");
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("<TD>User Name :</TD>");
		out.println("<TD><INPUT TYPE=TEXT NAME=userName></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD>Password : </TD>");
		out.println("<TD><INPUT TYPE=PASSWORD NAME=password></TD>");
		out.println("</TR>");
		out.println("<TR>");
		out.println("<TD ALIGN=RIGHT COLSPAN=2>");
		out.println("<INPUT TYPE=SUBMIT VALUE=Login></TD>");
		out.println("</TR>");
		out.println("</TABLE>");
		out.println("</FORM>");
		out.println("</CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		if(login(userName,password)) {
			RequestDispatcher rd = request.getRequestDispatcher("AnotherServlet");
			rd.forward(request, response);
		}else {
			sendLoginForm(response,true);
		}
		
	}

	private boolean login(String userName, String password) {
		
		try {
			//step 1:load a driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/teksystem?useSSL=false";
			String user ="root";
			String pass="admin";
			
			//step 2: obtain a connection
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println("got connection");
			
			String sql = "SELECT UserName FROM  Users WHERE UserName='"+fixSqlFieldValue(userName)+"'"+
					" AND Password='"+fixSqlFieldValue(password)+ "'";
			
			//step 3: obtain a Statement
			Statement s = connection.createStatement();
			
			//step 4: Execute the query
			ResultSet rs = s.executeQuery(sql);
			
			if (rs.next()) {
				rs.close();
				s.close();
				connection.close();
				return true;
			}
			rs.close();
			s.close();
			connection
			.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
