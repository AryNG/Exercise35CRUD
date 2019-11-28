package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 
 * @author Aranza 
 * @version 1.0
 *<p>List of all products on the database</p>
 */
@WebServlet("/readGeneralServlet")
public class readGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * doPost method that generates a list of products using MIME Type (text/html)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter output = response.getWriter();
		//Variables
		String urlServer="jdbc:mysql://localhost:3306/tienda?useSSL=false&serverTimezone=UTC";
		String userName="root";
		String password="admin"; 
		String SQLstm = "select * from productos";
		
		//Objects
		Connection conn = null;
		Statement stm = null;
		ResultSet rs= null;
		
		//Driver
		try {		
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		
		
		//Connection
		conn= DriverManager.getConnection(urlServer,userName,password);
		
		//Statement
		stm = conn.createStatement();
		
		//Execute SQLstatement
		rs = stm.executeQuery(SQLstm);
		
		//Output
		while(rs.next())
		{
			
			output.append("<p>");

			output.append("idProducto  "+rs.getInt(1));
			
			output.append("<br>");
			output.append("Product Name  "+rs.getString("nombreProducto"));
			
			output.append("<br>");
			output.append("Price product  "+rs.getDouble("precioProdcuto"));
			
			output.append("</p>");
			
			
		}
		output.append("<br>");
		output.append("<a href='readGeneral.jsp'>Return</a>");
		output.append("<br>");
		output.append("<a href='index.jsp'>Return Home</a>");
		
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			//Close Connection
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
