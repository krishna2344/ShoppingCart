package controller;


import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.ALineitem;
import business.Cart;
import customTools.DBUtil;
import customTools.LineItemDB;
import customTools.ProductDB;
import customTools.ShopperDB;
import model.Lineitem;
import model.Product;
import model.Shopper;

/**
 * Servlet implementation class CheckOut
 */
@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOut() {
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
        String formattedDate = "";
        java.util.Date utilDate = null;
        HttpSession session = request.getSession(true);
		String userid = (String) session.getAttribute("loginname");
		LinkedList<ALineitem> myCart = null;
		LinkedList<ALineitem> theCart = null;
		if (userid == null || userid == "") {
			getServletContext().getRequestDispatcher("/Login.jsp").forward(
					request, response);
		} else {
			double grandTotal = (double) session.getAttribute("GrandTotal");
			Date today = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-YYYY");
	        formattedDate = sdf.format(today);
			try {
				utilDate = sdf.parse(formattedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			theCart = Cart.getTheCart();
			myCart = (LinkedList<ALineitem>) session.getAttribute("MyCart");
			for (ALineitem anItem : myCart) {
				Lineitem dbItem = LineItemDB.dbCopy(anItem);
				dbItem.setPurchaseDate(LineItemDB.currentSqlDate());
				LineItemDB.insert(dbItem);
				theCart.remove(anItem);
			}
		}
		request.setAttribute("tempCart", myCart);
		session.setAttribute("MyCart",  null);
		request.setAttribute("PurchaseDate", formattedDate);
		getServletContext().getRequestDispatcher("/PurchaseSummary.jsp").forward(
				request, response);

	}

}