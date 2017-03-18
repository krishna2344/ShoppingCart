package business;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

//import customTools.*;
import model.*;

public class Cart {
	private static  LinkedList<ALineitem> theCart = new LinkedList<ALineitem>();
	
	public Cart() {
	}

	public static LinkedList<ALineitem> getTheCart() {
		return theCart;
	}

	public static void setTheCart(LinkedList<ALineitem> myCart) {
		theCart = myCart;
	}
	
	public static void addToCart(ALineitem aLineitem) {
		theCart.add(aLineitem);
	}
	
	public static void removeFromCart(ALineitem aLineitem) {
		for (ALineitem anItem : theCart){
			if ((anItem.getProduct().getId() == aLineitem.getProduct().getId()) &&
				(anItem.getShopper().getId() == aLineitem.getShopper().getId()))
				theCart.remove(anItem);
		}
	}
}
