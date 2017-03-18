package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the LINEITEM database table.
 * 
 */
@Entity
@Table(name="LINEITEM", schema="testuserdb")
@NamedQuery(name="Lineitem.findAll", query="SELECT l FROM Lineitem l")
public class Lineitem implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "LINEITEM_SEQ1", sequenceName = "LINEITEM_SEQ1", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "LINEITEM_SEQ1" )
	 private long id;

	  private int quantity;
		private BigDecimal total;
		private java.sql.Date purchaseDate = null;

		//bi-directional many-to-one association to Product
		@ManyToOne
		private Product product;

		//bi-directional many-to-one association to Shopper
		@ManyToOne
		private Shopper shopper;

		public Lineitem() {
		}

		public java.sql.Date getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(java.sql.Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

		public long getId() {
			return this.id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public int getQuantity() {
			return this.quantity;
		}

		public void setQuantity(int quanty) {
			this.quantity = quanty;
		}

		public Product getProduct() {
			return this.product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Shopper getShopper() {
			return this.shopper;
		}

		public void setShopper(Shopper shopper) {
			this.shopper = shopper;
		}

		public BigDecimal getTotal() {
			return total;
		}

		public void setTotal(BigDecimal total) {
			this.total = total;
		}

	}
