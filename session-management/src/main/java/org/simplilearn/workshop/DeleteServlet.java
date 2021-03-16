package org.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int recordAffected = 0;
		try {
			String id = request.getParameter("id");
			String sql = "DELETE FROM Users WHERE Id="+id;
			
			String url = "jdbc:mysql://localhost:3306/teksystem?useSSL=false";
			String user = "root";
			String pass = "admin";

			//  obtain a connection
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("got connection");
			
			Statement s = con.createStatement();
			recordAffected=s.executeUpdate(sql);
			s.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Deleting A Record </TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<CENTER>");
		
		if (recordAffected == 1) {
			out.println("<P>Record deleted</P>");
		}
		else {
			out.println("<P>Error deleting record.</P>");
		}
		out.println("<A HREF=search>Go back </A> to the search page.");
	}

}
