package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.simplilearn.workshop.util.StringUtil;


public class DataViewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC driver loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Display All Users </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		out.println("<BR><H2>Displaying All Users </H2>");
		out.println("<BR>");
		out.println("<BR>");
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("<TH>First Name </TH>");
		out.println("<TH>Last Name</TH>");
		out.println("<TH>User Name</TH>");
		out.println("<TH>Password</TH>");
		out.println("</TR>");
		String sql = "SELECT FirstName, LastName, UserName, Password FROM Users";
		
		try {

			String url = "jdbc:mysql://localhost:3306/teksystem?useSSL=false";
			String user = "root";
			String pass = "admin";

			// step 2: obtain a connection
			Connection connection = DriverManager.getConnection(url, user, pass);
			System.out.println("got connection");
			
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				out.println("<TR>");
				out.println("<TD>"+StringUtil.encodeHtmlTag(rs.getString(1)) + "</TD>");
				out.println("<TD>"+StringUtil.encodeHtmlTag(rs.getString(2)) + "</TD>");
				out.println("<TD>"+StringUtil.encodeHtmlTag(rs.getString(3)) + "</TD>");
				out.println("<TD>"+StringUtil.encodeHtmlTag(rs.getString(4)) + "</TD>");
				out.println("</TR>");
			}
			rs.close();
			s.close();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("</TABLE>");
		out.println("</CENTER>");
		out.println("</BODY>");
		out.println("</HTML>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
