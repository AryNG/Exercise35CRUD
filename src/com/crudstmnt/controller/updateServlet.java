package com.crudstmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import com.crudstmnt.model.Products;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Aranza
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//txtIdProduct
	//txtNameProduct
	//txtPriceProduct
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Front parameters
		response.setContentType("text/html charset='utf-8'");
		PrintWriter output =  response.getWriter();
		/*String nombreProducto = request.getParameter("txtNameProduct");
		int idConsult = Integer.parseInt(request.getParameter("txtIdProduct"));
		double precioProdcuto= Double.parseDouble(request.getParameter("txtPriceProduct"));*/
		
		//Variables
		Products myProduct = new Products();
		myProduct.setIdProduct(Integer.parseInt(request.getParameter("txtIdProduct")));
		myProduct.setNameProduct(request.getParameter("txtNameProduct"));
		myProduct.setPriceProduct(Double.parseDouble(request.getParameter("txtPriceProduct")));
		
		String urlServer = "jdbc:mysql://localhost:3306/tienda?useSSL=false&serverTimezone=UTC";
		String userName="root";
		String password="admin"; 
		String SQLvalstm = "select * from productos where idProducto =" + myProduct.getIdProduct();
		String SQLstm = ("update productos set nombreProducto = '" +myProduct.getNameProduct()+ "', precioProdcuto =" +myProduct.getPriceProduct()+ "where idProducto in(" +myProduct.getIdProduct()+ ")");
		
		/*String SQLstm = ("update productos set nombreProducto = '" +nombreProducto+ "', precioProdcuto =" +precioProdcuto+ "where idProducto in(" +idConsult+ ")");*/
		
		int rowsAffected=0; //to set a message confirming update
		
		//Objects
		Connection conn = null;
		Statement stm = null;
		
		//Driver
		try {
		Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();

		//Connection
		conn= DriverManager.getConnection(urlServer,userName,password);
				
		//Statement
		stm = conn.createStatement();
				
		//Execute SQLstatement
		rowsAffected=stm.executeUpdate(SQLstm);
						
		//Data Process
				if(rowsAffected!=0) {
					output.append("You updated a new product");
					output.append("<br>");
					output.append("<a href='update.jsp'>Return</a>");
					
					output.append("<br>");
					output.append("<a href='index.jsp'>Return Home</a>");
				}
				else
				{
					output.append("Error; Nothing added");
					output.append("<br>");
					output.append("<a href='update.jsp'>Return</a>");
					
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
