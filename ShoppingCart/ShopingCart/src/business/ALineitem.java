package business;

import java.math.BigDecimal;

public class ALineitem {
	  private long id;
	  private int quantity;
	  private BigDecimal total;
	  private TheProduct product;
	 private TheShopper shopper;
		
	  public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public TheProduct getProduct() {
		return product;
	}
	public void setProduct(TheProduct product) {
		this.product = product;
	}
	public TheShopper getShopper() {
		return shopper;
	}
	public void setShopper(TheShopper shopper) {
		this.shopper = shopper;
	}
}
