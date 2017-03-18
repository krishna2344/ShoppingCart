package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the SHOPPER database table.
 * 
 */
@Entity
@Table(name="SHOPPER", schema="testuserdb")
@NamedQuery(name="Shopper.findAll", query="SELECT s FROM Shopper s")
public class Shopper implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "SHOPPER_SEQ", sequenceName = "SHOPPER_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SHOPPER_SEQ" )
	private long id;

	private String name;

	//bi-directional many-to-one association to Lineitem
	@OneToMany(mappedBy="shopper")
	private List<Lineitem> lineitems;

	public Shopper() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Lineitem> getLineitems() {
		return this.lineitems;
	}

	public void setLineitems(List<Lineitem> lineitems) {
		this.lineitems = lineitems;
	}

	public Lineitem addLineitem(Lineitem lineitem) {
		getLineitems().add(lineitem);
		lineitem.setShopper(this);

		return lineitem;
	}

	public Lineitem removeLineitem(Lineitem lineitem) {
		getLineitems().remove(lineitem);
		lineitem.setShopper(null);

		return lineitem;
	}

}