import javax.persistence.EntityManager;
import customTools.DBUtil;

public class grabShopper {

	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.Shopper cust = em.find(model.Shopper.class, (long) 1);
			System.out.println(cust.getName());		
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("cerrado!");
		}
	}

}
