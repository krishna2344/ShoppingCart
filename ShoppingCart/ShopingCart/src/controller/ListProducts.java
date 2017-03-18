package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProducts() {
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
/*		request.setAttribute("productName", postList.get(0));
		request.setAttribute("productDesc", postList.get(1));
		request.setAttribute("productId", postList.get(2));
       String message = "";

       for (model.Product aPost : postList) {     
			message = message + "	<div class=\"row\"><br><div class=\"col-md-4\">"+aPost.getName()+"</div>" +
					"<div class=\"col-md-4\">"+aPost.getDescription()+"</div>" + 
					"<div class=\"col-md-4\">"+String.valueOf(aPost.getUnitprice())+"</div>" + 					
					"<div class=\"col-md-4\"><button type=\"submit\" class=\"btn btn-success\">"+aPost.getId()+"</button></div></div>";			
		}
//        request.setAttribute("message", message);   
 		System.out.println(message);	*/
		getServletContext().getRequestDispatcher("/ListProducts.jsp").forward(request, response);		
        }
}