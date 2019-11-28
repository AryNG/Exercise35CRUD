package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.crudstmnt.model.Products;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Aranza
 *
 */
@WebServlet("/readIndividualServlet")
public class readIndividualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html charset='utf-8'");
		PrintWriter output =  response.getWriter();
		//int idConsult = Integer.parseInt(request.getParameter("txtIdProductC")); //Parse from String to type of id  in database 

		
		//Variables
		Products myProduct = new Products();
		myProduct.setIdProduct(Integer.parseInt(request.getParameter("txtIdProductC")));
		
		String urlServer="jdbc:mysql://localhost:3306/tienda?useSSL=false&serverTimezone=UTC";
		String userName="root";
		String password="admin"; 
		String SQLstm = "select * from productos where idProducto =" + myProduct.getIdProduct(); //idConsult; // change so it selects products by id
		
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
		rs.next();
			
			output.append("<p>");

			output.append("idProducto:  "+rs.getInt(1));
			
			output.append("<br>");
			output.append("Product Name:  "+rs.getString("nombreProducto"));
			
			output.append("</p>");
			output.append("Price product:  "+rs.getDouble("precioProdcuto"));
			
			output.append("<br>");
			output.append("<a href='readIndividual.jsp'>Return</a>");
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
				stm.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
