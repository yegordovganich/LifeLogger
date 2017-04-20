package lifelogger.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAFactory extends UnicastRemoteObject {
	protected JPAFactory() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3918695468328912752L;
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lifelogger.jpa");
	
	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
