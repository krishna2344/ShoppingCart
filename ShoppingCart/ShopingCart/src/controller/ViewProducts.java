package controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.ProductDB;
import model.*;

/**
 * Servlet implementation class ListTs
 */
@WebServlet("/ViewProducts")
public class ViewProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ArrayList<model.Product> postList = ProductDB.selectAll();
		request.setAttribute("products", postList);
       String productView = "";

       for (model.Product aPost : postList) {     
    	   productView = productView + "	<div class=\"row\"><br><div class=\"col-md-4\">"+aPost.getName()+"</div>" +
					"<div class=\"col-md-4\">"+aPost.getDescription()+"</div>" + 
					"<div class=\"col-md-4\">"+String.valueOf(aPost.getUnitprice())+"</div>" + 					
					"</div>";			
		}
        request.setAttribute("productView", productView);   
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);		
        }
}