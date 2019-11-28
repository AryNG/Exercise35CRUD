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

import com.crudstmnt.model.Products;

/**
 * @author Aranza
 */
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Front Parameter
		response.setContentType("text/html charset='utf-8'");
		PrintWriter output = response.getWriter();
		/*int idSelected = Integer.parseInt(request.getParameter("txtIdProduct"));*/
				
		//Variables
		Products myProduct = new Products();
		myProduct.setIdProduct(Integer.parseInt(request.getParameter("txtIdProduct")));
		String urlServer = "jdbc:mysql://localhost:3306/tienda?useSSL=false&serverTimezone=UTC";		
		String userName="root";
		String password="admin"; 		
		String SQLvalstm = "select * from productos where idProducto =" + myProduct.getIdProduct(); //idSelected;
		String SQLstm = "delete from productos where idProducto =" + myProduct.getIdProduct(); //idSelected;
		int rowsAffected=0; //to set a message confirming update
				
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
		rs =  stm.executeQuery(SQLvalstm);
		if (rs.next()) {
			rowsAffected=stm.executeUpdate(SQLstm);
			
			//Data Process
			if(rowsAffected!=0) {
				output.append("You deleted a product");
				output.append("<br>");
				output.append("<a href='delete.jsp'>Return</a>");
				
				output.append("<br>");
				output.append("<a href='index.jsp'>Return Home</a>");
			}
			else
			{
			output.append("Error; Nothing deleted");
			output.append("<br>");
			output.append("<a href='delete.jsp'>Return</a>");
			
			output.append("<br>");
			output.append("<a href='index.jsp'>Return Home</a>");
			}
		}
		else
		{
		output.append("Error; id doesn't exist");
		output.append("<br>");
		output.append("<a href='delete.jsp'>Return</a>");
		
		output.append("<br>");
		output.append("<a href='index.jsp'>Return Home</a>");
		}
							
		//Close Connection
		stm.close();
		conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
