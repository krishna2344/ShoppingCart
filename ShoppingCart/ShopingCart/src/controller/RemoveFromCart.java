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
 * Servlet implementation class RemoveFromCart
 */
@WebServlet("/RemoveFromCart")
public class RemoveFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		String pId = request.getParameter("ProductId");
		String sId = request.getParameter("ShopperId");
		LinkedList<ALineitem> myCart = (LinkedList<ALineitem>) session.getAttribute("MyCart");
		LinkedList<ALineitem> theCart = Cart.getTheCart();	
		for (ALineitem anItem : myCart) {
			String itemSid = String.valueOf(anItem.getShopper().getId());
			String itemPid = String.valueOf(anItem.getProduct().getId());	
			if (itemPid.equals(pId) && itemSid.equals(sId)) {
				myCart.remove(anItem);
				theCart.remove(anItem);
			}
		}
//		Cart.setTheCart(myCart);
		session.setAttribute("MyCart", myCart);
		getServletContext().getRequestDispatcher("/ShowCart.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
