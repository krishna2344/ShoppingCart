package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetail() {
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
		/*
		Enumeration<String> params = request.getAttributeNames(); 
		while(params.hasMoreElements()){			
		 String paramName = (String)params.nextElement();
		 System.out.println("Attribute Name - "+paramName+", Value - "+ request.getAttribute(paramName));
		}*/
		response.setContentType("text/html");

		String pId = request.getParameter("ProductId");    
 		// get product by id
		model.Product theP = customTools.ProductDB.getProduct(Integer.parseInt(pId));
		request.setAttribute("product", theP);
        HttpSession session = request.getSession(true);
        String userid = (String) session.getAttribute("loginname");
		request.removeAttribute("message");
		if (userid == null || userid == "") {
			request.setAttribute("message", "You need to login first before accessing/updating Cart.");
			getServletContext().getRequestDispatcher("/login.jsp").forward(
					request, response);       	
        } else {
        	getServletContext().getRequestDispatcher("/ProductDetail.jsp").forward(request, response);	
        }
	}
}
