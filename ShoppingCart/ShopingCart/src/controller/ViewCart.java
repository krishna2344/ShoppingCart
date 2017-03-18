package controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.ShopperDB;
import model.Lineitem;
import business.ALineitem;
import business.Cart;

/**
 * Servlet implementation class ViewCart
 */
@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        HttpSession session = request.getSession(true);
        String userid = (String) session.getAttribute("loginname");
		request.removeAttribute("message");
		if (userid == null || userid == "") {
			request.setAttribute("message", "You need to login first before accessing/updating Cart.");
			getServletContext().getRequestDispatcher("/login.jsp").forward(
					request, response);
		} else {
			LinkedList<ALineitem> myCart = Cart.getTheCart();
			for (ALineitem anItem : myCart){
				if (String.valueOf(anItem.getShopper().getId()) == request.getParameter("ShopperId"))
					myCart.remove(anItem);
				request.setAttribute("MyCart", myCart);
				
				getServletContext().getRequestDispatcher("/ShowCart.jsp").forward(request, response);	
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
