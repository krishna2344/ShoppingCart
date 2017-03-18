package business;

import java.io.Serializable;
import java.math.BigDecimal;

public class TheProduct {

		private long id;

		private String description;

		private String name;

		private String pic;

		private BigDecimal unitprice;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPic() {
			return pic;
		}

		public void setPic(String pic) {
			this.pic = pic;
		}

		public BigDecimal getUnitprice() {
			return unitprice;
		}

		public void setUnitprice(BigDecimal unitprice) {
			this.unitprice = unitprice;
		}


}
