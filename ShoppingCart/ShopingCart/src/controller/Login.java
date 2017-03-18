package controller;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import customTools.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
        HttpSession session = request.getSession(true);
        double grandTotal = 0.0;
        String userid = (String) session.getAttribute("loginname");
        boolean shopperIsMember = false;
        if (userid == null) {
        	 userid = request.getParameter("loginname"); 
        	 shopperIsMember = ShopperDB.checktUser(userid);
     		if (shopperIsMember) {        	 
     			session.setAttribute("loginname", userid);
     			session.setAttribute("GrandTotal",  grandTotal);
 	        	getServletContext().getRequestDispatcher("/ListProducts").forward(request, response);	
     		} else {
     			// You are not a memeber yet, please register first
    	        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);					     			
     		}
        } else {
        	//you have logged in already
        }
	}
}
