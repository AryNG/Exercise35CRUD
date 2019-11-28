package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet used to register a product
 * @author Aranza Negrete
 * @since 1.0 
 * @see <a href="https://stackoverflow.com/questions/2906582/how-to-create-an-html-button-that-acts-like-a-link"></a>
 *
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Method that catches post requests
	 * @author Aranza Negrete
	 * @param request catches costumer data
	 * @param response send data to the costumer
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html charset='utf-8'");
		//response.setContentType("application/json charset='utf-8'"); //
		PrintWriter output =  response.getWriter();
		String  nombreProducto = request.getParameter("txtNameProduct");
		double precioProdcuto= Double.parseDouble(request.getParameter("txtPriceProduct")); 
		
		//Variables
		String urlServer="jdbc:mysql://localhost:3306/tienda?useSSL=false&serverTimezone=UTC";
		String userName="root";
		String password="admin"; 
		int rowsAffected=0;
		
		/*//Declare Objects 
		Connection connection=null;
		Statement stm = null;
		ResultSet rs=null; */
		
		//Starting Driver
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		
		
		//Open Connection
		Connection connection=DriverManager.getConnection(urlServer,userName,password);
		Statement stm = connection.createStatement();
		
		
		//Execute sql 
		rowsAffected = stm.executeUpdate("INSERT INTO productos(nombreProducto, precioProdcuto) VALUES('"+nombreProducto+"',"+precioProdcuto+")");
		
		
		//Data Process
		if(rowsAffected!=0) {
			output.append("You Added a new product");
			output.append("<br>");
			output.append("<a href='create.jsp'>Return</a>");
			
			output.append("<br>");
			output.append("<a href='index.jsp'>Return Home</a>");
		}
		else
		{
			output.append("Error; Nothing added");
			output.append("<br>");
			output.append("<a href='create.jsp'>Return</a>");
			
			output.append("<br>");
			output.append("<a href='index.jsp'>Return Home</a>");
		}
		
		
		
		//Close Connection 
		stm.close();
		connection.close();
		
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}		
		output.close();
	}
}
