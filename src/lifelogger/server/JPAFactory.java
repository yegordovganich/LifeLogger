package lifelogger.server;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAFactory {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lifelogger.jpa");
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
