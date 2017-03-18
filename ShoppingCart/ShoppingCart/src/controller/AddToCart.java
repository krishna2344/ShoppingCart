package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import customTools.*;
import model.*;
import business.*;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		String userid = (String) session.getAttribute("loginname");
		double grandTotal = 0.0; 
		if (session.getAttribute("GrandTotal") != null) grandTotal = (double) session.getAttribute("GrandTotal");
		request.removeAttribute("message");
		if (userid == null || userid == "") {
			request.setAttribute("message", "You need to login first before accessing/updating Cart.");
			getServletContext().getRequestDispatcher("/login.jsp").forward(
					request, response);
		} else {
			// getUserByName
			Shopper aShopper = customTools.ShopperDB.getUserByName(userid);
			int quanty = Integer.parseInt(request.getParameter("qty"));
			String pId = request.getParameter("prodid");
			// get product by id
			model.Product theP = customTools.ProductDB.getProduct(Integer
					.parseInt(pId));
			BigDecimal total = theP.getUnitprice().multiply(
					new BigDecimal(quanty));
			business.ALineitem aLineitem = new business.ALineitem();
			aLineitem.setProduct(ProductDB.internalCopy(theP));
			aLineitem.setQuantity(quanty);
			aLineitem.setTotal(total);
			aLineitem.setShopper(ShopperDB.internalCopy(aShopper));
			Cart.addToCart(aLineitem);
			grandTotal = grandTotal + total.doubleValue();
			LinkedList<ALineitem> myCart = new LinkedList<ALineitem>();
			for (ALineitem anItem : Cart.getTheCart()) {
				if (anItem.getShopper().getId() == aShopper.getId())
					myCart.add(anItem);
			}
			session.setAttribute("shoppername", userid);
			session.setAttribute("GrandTotal", grandTotal);
			session.setAttribute("MyCart", myCart);
		}
		getServletContext().getRequestDispatcher("/ShowCart.jsp").forward(
				request, response);
	}
}
